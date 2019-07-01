package com.yuntian.mybatisplus.api.mapper;

import com.yuntian.mybatisplus.api.model.entity.User;
import com.yuntian.mybatisplus.common.MyBaseMapper;

import java.util.List;

/**
 * <p>
 * 测试表 Mapper 接口
 * </p>
 *
 * @author yuntian
 * @since 2019-06-25
 */
public interface TestUserMapper extends MyBaseMapper<User> {


    void deleteBatch(List<User> list);

    void updateBatch(List<User> list);

}
