package com.yuntian.mybatisplus.api.service;

import com.yuntian.mybatisplus.api.model.entity.User;
import com.yuntian.mybatisplus.common.IBaseService;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 测试表 服务类
 * </p>
 *
 * @author yuntian
 * @since 2019-06-25
 */
public interface UserService extends IBaseService<User> {


       void deleteByDTO(User dto) ;

       void deleteBatchByDTO(Collection<User> dto) ;


       void deleteBatch(List<User> list);
}
