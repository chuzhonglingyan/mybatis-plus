package com.yuntian.mybatisplus;

import com.yuntian.architecture.redis.config.RedisManage;
import com.yuntian.mybatisplus.api.model.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: yuntian
 * @Date: 2019/12/25 0025 00:25
 * @Description:
 */
@SpringBootTest
@Slf4j
public class TestRedis {

    @Resource
    private RedisManage  redisManage;


    @Test
    public void contextLoads() {
        User user=new User();
        user.setId(1L);
        user.setUserName("哈哈");
        user.setAge(12);
        redisManage.set("userId:1",user);
    }

}
