package com.yuntian.mybatisplus.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;

/**
 * @Auther: yuntian
 * @Date: 2019/6/30 0030 16:00
 * @Description:
 */
public interface MyBaseMapper<T>   extends BaseMapper<T> {

    int deleteByIdWithFill(T entity);

    int deleteByIdsWithFill(Collection<T> entityList);

}
