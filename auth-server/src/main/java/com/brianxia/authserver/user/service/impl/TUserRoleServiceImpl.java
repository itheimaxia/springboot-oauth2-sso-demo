package com.brianxia.authserver.user.service.impl;

import com.brianxia.authserver.user.entity.TUserRole;
import com.brianxia.authserver.user.mapper.TUserRoleMapper;
import com.brianxia.authserver.user.service.ITUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author brianxia
 * @since 2020-11-22
 */
@Service
public class TUserRoleServiceImpl extends ServiceImpl<TUserRoleMapper, TUserRole> implements ITUserRoleService {

}
