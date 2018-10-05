package com.xiaowu.service.impl;

import com.xiaowu.entity.User;
import com.xiaowu.mapper.UserMapper;
import com.xiaowu.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AutoCode
 * @since 2018-10-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
