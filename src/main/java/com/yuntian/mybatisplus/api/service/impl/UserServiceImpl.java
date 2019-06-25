package com.yuntian.mybatisplus.api.service.impl;

import com.yuntian.mybatisplus.api.model.entity.User;
import com.yuntian.mybatisplus.api.mapper.UserMapper;
import com.yuntian.mybatisplus.api.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author yuntian
 * @since 2019-06-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
