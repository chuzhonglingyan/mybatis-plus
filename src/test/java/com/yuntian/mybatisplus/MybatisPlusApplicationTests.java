package com.yuntian.mybatisplus;

import com.yuntian.mybatisplus.user.entity.User;
import com.yuntian.mybatisplus.user.service.IUserService;
import com.yuntian.mybatisplus.user.vo.UserVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MybatisPlusApplicationTests {


    @Resource
    private IUserService userService;


    @Test
    public void contextLoads() {
        UserVO user=new UserVO();
        user.setUserName("哈哈");
        user.setCreateId(1L);
        user.setUpdateId(1L);
        boolean flag=userService.save(user);

        log.info("插入看结果:"+flag+","+user.getId());
    }

}
