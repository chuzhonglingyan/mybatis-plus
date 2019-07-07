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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MybatisPlusApplicationTests {


    @Resource
    private UserService userService;


    @Test
    public void saveBatch() {
        User user1 = new User();
        user1.setUserName("test1");
        user1.setCreateId(1L);
        user1.setUpdateId(1L);

        User user2 = new User();
        user2.setUserName("test2");
        user2.setCreateId(1L);
        user2.setUpdateId(1L);

        List<User> list = new ArrayList<>();

        list.add(user1);
        list.add(user2);

        boolean flag = userService.saveBatch(list, list.size());

        log.info("插入看结果:" + flag + ",");
    }


    @Test
    public void save() {
        User user = new User();
        user.setUserName("哈哈");
        user.setCreateId(1L);
        user.setUpdateId(1L);
        boolean flag = userService.save(user);

        log.info("插入看结果:" + flag + "," + user.getId());
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1L);
        user.setUserName("test5");
        user.setUpdateId(2L);
        boolean flag = userService.updateById(user);
        log.info("更新结果:" + flag + "," + user.getId());
    }

    @Test
    public void removeById() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("is_delete", 1);
        wrapper.set("update_id", 2L);

        User user = new User();
        user.setId(1140986407699906561L);
        wrapper.setEntity(user);

        boolean flag = userService.update(wrapper);

        log.info("删除结果:" + flag + "," + user.getId());
    }

    @Test
    public void deleteByIdWithFill() {
        User user = new User();
        user.setId(1140996259222433797L);
        user.setUpdateId(5L);
        boolean result = userService.deleteByIdWithFill(user);
        log.info("删除结果:" + result);
    }


    @Test
    public void removeByIds() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("is_delete", 1);
        wrapper.set("update_id", 2L);

        List<User> list = new ArrayList<>();

        User user1 = new User();
        user1.setId(1140986407699906561L);
        user1.setUpdateId(3L);
        user1.setIsDelete(1);

        User user2 = new User();
        user2.setId(1140986488234815489L);
        user2.setUpdateId(3L);
        user2.setIsDelete(1);

        list.add(user1);
        list.add(user2);


        boolean flag = userService.updateBatchById(list);

        log.info("删除结果:" + flag + ",");
    }

    @Test
    public void deleteBatchByDTO() {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setId(1140986407699906561L);
        user1.setUpdateId(2L);
        user1.setIsDelete(1);

        User user2 = new User();
        user2.setId(1140986488234815489L);
        user2.setUpdateId(2L);
        user2.setIsDelete(1);

        list.add(user1);
        list.add(user2);
        userService.deleteBatchByDTO(list);
    }

    @Test
    public void deleteBatch() {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setId(1140986407699906561L);
        user1.setUpdateId(5L);

        User user2 = new User();
        user2.setId(1140986488234815489L);
        user2.setUpdateId(5L);

        list.add(user1);
        list.add(user2);
        userService.deleteBatchByDTO(list);

    }


    @Test
    public void deleteByIdsWithFill() {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setId(1140986407699906561L);
        user1.setUpdateId(5L);

        User user2 = new User();
        user2.setId(1140986488234815489L);
        user2.setUpdateId(5L);

        list.add(user1);
        list.add(user2);
        boolean flag=userService.deleteByIdsWithFill(list);
        log.info("删除结果:" + flag + ",");
    }


    @Test
    public void page() {
//        SELECT * from `user` LIMIT 0,10  （0,10]
        IPage<User> page = new Page<>(1, 10);
        IPage<User> list = userService.page(page);
        log.info("查询结果:" + JSON.toJSONString(list));
    }


}
