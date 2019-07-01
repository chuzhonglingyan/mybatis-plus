package com.yuntian.mybatisplus.common;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.Collection;

/**
 * @Auther: yuntian
 * @Date: 2019/6/30 0030 17:57
 * @Description:
 */
public class BaseServiceImpl<M extends MyBaseMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {


    @Override
    public boolean deleteByIdWithFill(T entity) {
        return getBaseMapper().deleteByIdWithFill(entity)==1;
    }

    @Override
    public boolean deleteByIdsWithFill(Collection<T> entityList) {
        return getBaseMapper().deleteByIdsWithFill(entityList)==entityList.size();
    }

}
