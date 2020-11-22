package com.brianxia.authserver.user.service.impl;

import com.brianxia.authserver.user.entity.TPermission;
import com.brianxia.authserver.user.mapper.TPermissionMapper;
import com.brianxia.authserver.user.service.ITPermissionService;
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
public class TPermissionServiceImpl extends ServiceImpl<TPermissionMapper, TPermission> implements ITPermissionService {

}
