package com.yuntian.mybatisplus;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuntian.mybatisplus.user.entity.User;
import com.yuntian.mybatisplus.user.mapper.UserMapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertThat;

/**
 * @Auther: yuntian
 * @Date: 2019/6/25 0025 21:24
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaginationTest {

    @Resource
    private UserMapper mapper;

    @Test
    public void lambdaPagination() {
        Page<User> page = new Page<>(1, 3);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().ge(User::getUserName, 1);
        IPage<User> result = mapper.selectPage(page, wrapper);
        System.out.println(result.getTotal());
        Assert.assertTrue(result.getTotal() > 3);
        Assert.assertEquals(3, result.getRecords().size());
    }


}
