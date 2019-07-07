package com.yuntian.mybatisplus.common;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuntian.mybatisplus.exception.BusinessException;
import com.yuntian.mybatisplus.sys.model.entity.Operator;
import com.yuntian.mybatisplus.util.AssertUtil;

import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;

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


    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveBatch(Collection<T> entityList) {
        AssertUtil.isNotEmpty(entityList, "参数不能为空");
        entityList.forEach(entity -> {
            if (Objects.isNull(entity)) {
                BusinessException.throwMessage("插入参数有问题");
            }
        });
        boolean flag = saveBatch(entityList, entityList.size());
        if (!flag) {
            BusinessException.throwMessage("批量插入失败");
        }
        return flag;
    }

}
