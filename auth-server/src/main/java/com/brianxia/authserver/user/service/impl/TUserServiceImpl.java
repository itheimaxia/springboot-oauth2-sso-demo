package com.brianxia.authserver.user.service.impl;

import com.brianxia.authserver.user.entity.TUser;
import com.brianxia.authserver.user.mapper.TUserMapper;
import com.brianxia.authserver.user.service.ITUserService;
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
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
