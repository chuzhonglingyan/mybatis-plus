package com.yuntian.mybatisplus.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuntian.mybatisplus.user.entity.User;
import com.yuntian.mybatisplus.user.mapper.UserMapper;
import com.yuntian.mybatisplus.user.service.IUserService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author yuntian
 * @since 2019-06-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
