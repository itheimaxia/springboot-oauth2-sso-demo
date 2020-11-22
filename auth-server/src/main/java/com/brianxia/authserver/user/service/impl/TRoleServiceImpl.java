package com.brianxia.authserver.user.service.impl;

import com.brianxia.authserver.user.entity.TRole;
import com.brianxia.authserver.user.mapper.TRoleMapper;
import com.brianxia.authserver.user.service.ITRoleService;
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
public class TRoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements ITRoleService {

}
