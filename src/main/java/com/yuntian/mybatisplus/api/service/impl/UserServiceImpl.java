package com.yuntian.mybatisplus.api.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuntian.mybatisplus.api.model.dto.UserDTO;
import com.yuntian.mybatisplus.api.model.entity.User;
import com.yuntian.mybatisplus.api.mapper.UserMapper;
import com.yuntian.mybatisplus.api.service.UserService;
import com.yuntian.mybatisplus.common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.yuntian.mybatisplus.util.AssertUtil;
import com.yuntian.mybatisplus.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.Objects;
import java.io.Serializable;

/**
 * <p>
 * 前台系统-用户表 服务实现类
 * </p>
 *
 * @author yuntian
 * @since 2019-07-07
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Override
    public IPage<User> queryListByPage(UserDTO dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        IPage<User> page=new Page<>(dto.getCurrent(),dto.getSize());
        return page(page);
    }


    @Override
    public User getById(Serializable id) {
        return super.getById(id);
    }


    @Override
    public boolean save(User dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        return super.save(dto);
    }


    @Override
    public void updateByDTO(User dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        AssertUtil.isNotNull(dto.getId(), "id不能为空");
        boolean flag = super.updateById(dto);
        if (!flag) {
            BusinessException.throwMessage("更新失败,请刷新重试");
        }
    }


    @Override
    public void deleteByDTO(User dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        AssertUtil.isNotNull(dto.getId(), "id不能为空");
        boolean flag = deleteByIdWithFill(dto);
        if (!flag) {
            BusinessException.throwMessage("删除失败,请刷新重试");
        }
    }



    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateBatchById(Collection<User> entityList) {
        AssertUtil.isNotEmpty(entityList, "参数不能为空");
        boolean flag = updateBatchById(entityList, entityList.size());
        if (!flag) {
            BusinessException.throwMessage("批量更新失败,请刷新重试");
        }
        return flag;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteBatchByDTO(Collection<User> entityList) {
        AssertUtil.isNotEmpty(entityList, "参数不能为空");
        boolean flag = deleteByIdsWithFill(entityList);
        if (!flag) {
            BusinessException.throwMessage("批量更新失败,请刷新重试");
        }
    }
}
