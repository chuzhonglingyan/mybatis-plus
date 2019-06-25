package com.yuntian.mybatisplus;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuntian.mybatisplus.api.model.entity.User;
import com.yuntian.mybatisplus.api.service.UserService;

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
    private UserService userService;


    @Test
    public void save() {
        User user=new User();
        user.setUserName("哈哈");
        user.setCreateId(1L);
        user.setUpdateId(1L);
        boolean flag=userService.save(user);

        log.info("插入看结果:"+flag+","+user.getId());
    }

    @Test
    public void update() {
        User user=new User();
        user.setId(1L);
        user.setUserName("test5");
        user.setUpdateId(2L);
        boolean flag=userService.updateById(user);
        log.info("更新结果:"+flag+","+user.getId());
    }

    @Test
    public void removeById() {
        UpdateWrapper<User> wrapper=new UpdateWrapper<>();
        wrapper.set("is_delete",1);
        wrapper.set("update_id",2L);

        User user=new User();
        user.setId(1140986407699906561L);
        wrapper.setEntity(user);
        boolean flag=userService.update(wrapper);
        log.info("删除结果:"+flag+","+user.getId());
    }

    @Test
    public void page() {
        IPage<User> page=new Page<>(1,10);
        IPage<User>  list=userService.page(page);
        log.info("查询结果:"+ JSON.toJSONString(list));
    }


}
