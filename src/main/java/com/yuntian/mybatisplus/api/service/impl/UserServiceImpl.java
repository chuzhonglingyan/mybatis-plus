package com.yuntian.mybatisplus.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yuntian.mybatisplus.api.model.entity.User;
import com.yuntian.mybatisplus.api.mapper.UserMapper;
import com.yuntian.mybatisplus.api.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuntian.mybatisplus.common.BaseServiceImpl;
import com.yuntian.mybatisplus.exception.BusinessException;
import com.yuntian.mybatisplus.sys.model.entity.BackendOperater;
import com.yuntian.mybatisplus.util.AssertUtil;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.jws.soap.SOAPBinding;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author yuntian
 * @since 2019-06-25
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {




    @Override
    public void deleteByDTO(User dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        AssertUtil.isNotNull(dto.getId(), "id不能为空");

        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("is_delete", 1);
        wrapper.set("update_id", dto.getUpdateId());

        User entity=new User();
        entity.setId(dto.getId());
        wrapper.setEntity(entity);
        boolean flag = update(wrapper);
        if (!flag) {
            BusinessException.throwMessage("删除失败,请刷新重试");
        }
    }



    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteBatchByDTO(Collection<User> entityList) {
        entityList.forEach(this::deleteByDTO);
    }

    @Override
    public void deleteBatch(List<User> list) {
        getBaseMapper().deleteBatch(list);
    }


}
