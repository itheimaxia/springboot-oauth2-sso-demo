package com.brianxia.authserver.component;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.brianxia.authserver.domain.AuthUser;
import com.brianxia.authserver.user.entity.*;
import com.brianxia.authserver.user.mapper.*;
import com.brianxia.authserver.user.service.ITUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author brianxia
 * @version 1.0
 * @date 2020/11/22 15:12
 */
@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    //为了快速出效果，直接进行查询
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private TPermissionMapper permissionMapper;
    @Autowired
    private TRoleMapper roleMapper;
    @Autowired
    private TUserRoleMapper userRoleMapper;
    @Autowired
    private TRolePermissionMapper rolePermissionMapper;

    private List<SimpleGrantedAuthority> getAuthorities(Integer id){
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        //先查询roles
        List<TUserRole> tUserRoles = userRoleMapper.selectList(Wrappers.<TUserRole>lambdaQuery().eq(TUserRole::getUserId, id));
        //获取role ids
        List<Integer> collect = tUserRoles.stream().map(m -> m.getRoleId()).collect(Collectors.toList());
        //获取roles
        List<TRole> tRoles = roleMapper.selectBatchIds(collect);
        if(!CollectionUtils.isEmpty(tRoles)){
            tRoles.forEach(r -> {
                authorityList.add(new SimpleGrantedAuthority(r.getKeyword()));
                //根据角色获取权限
                List<TRolePermission> rolePermissions = rolePermissionMapper.selectList(Wrappers.<TRolePermission>lambdaQuery().eq(TRolePermission::getRoleId, r.getId()));
                //权限 ids
                List<Integer> pIds = rolePermissions.stream().map(m -> m.getPermissionId()).collect(Collectors.toList());
                //获取permission
                List<TPermission> permissions = permissionMapper.selectBatchIds(pIds);
                if(!CollectionUtils.isEmpty(permissions)){
                    permissions.forEach(p -> {
                        authorityList.add(new SimpleGrantedAuthority(p.getKeyword()));
                    });
                }
            });
        }

        return authorityList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TUser sysUser = userMapper.selectOne
                (Wrappers.<TUser>lambdaQuery().eq(TUser::getUsername,username));
        if (null == sysUser) {
            log.warn("用户{}不存在", username);
            throw new UsernameNotFoundException(username);
        }


         AuthUser myUser = new AuthUser(sysUser.getUsername(), sysUser.getPassword(), getAuthorities(sysUser.getId()));
        myUser.setId(sysUser.getId());
        return myUser;
    }

}
