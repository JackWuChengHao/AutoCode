package com.baomidou.ant.service.impl;

import com.baomidou.ant.entity.User;
import com.baomidou.ant.mapper.UserMapper;
import com.baomidou.ant.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaowu
 * @since 2018-10-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
