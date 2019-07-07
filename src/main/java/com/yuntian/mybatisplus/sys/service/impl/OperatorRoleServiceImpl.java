package com.yuntian.mybatisplus.sys.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuntian.mybatisplus.sys.model.dto.OperatorRoleDTO;
import com.yuntian.mybatisplus.sys.model.entity.OperatorRole;
import com.yuntian.mybatisplus.sys.mapper.OperatorRoleMapper;
import com.yuntian.mybatisplus.sys.service.OperatorRoleService;
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
 * 后台系统-用户角色关系表 服务实现类
 * </p>
 *
 * @author yuntian
 * @since 2019-07-06
 */
@Service
public class OperatorRoleServiceImpl extends BaseServiceImpl<OperatorRoleMapper, OperatorRole> implements OperatorRoleService {

    @Override
    public IPage<OperatorRole> queryListByPage(OperatorRoleDTO dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        IPage<OperatorRole> page=new Page<>(dto.getCurrent(),dto.getSize());
        return page(page);
    }


    @Override
    public OperatorRole getById(Serializable id) {
        return super.getById(id);
    }


    @Override
    public boolean save(OperatorRole dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        return super.save(dto);
    }


    @Override
    public void updateByDTO(OperatorRole dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        AssertUtil.isNotNull(dto.getId(), "id不能为空");
        boolean flag = super.updateById(dto);
        if (!flag) {
            BusinessException.throwMessage("更新失败,请刷新重试");
        }
    }


    @Override
    public void deleteByDTO(OperatorRole dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        AssertUtil.isNotNull(dto.getId(), "id不能为空");
        boolean flag = deleteByIdWithFill(dto);
        if (!flag) {
            BusinessException.throwMessage("删除失败,请刷新重试");
        }
    }



    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateBatchById(Collection<OperatorRole> entityList) {
        AssertUtil.isNotEmpty(entityList, "参数不能为空");
        boolean flag = updateBatchById(entityList, entityList.size());
        if (!flag) {
            BusinessException.throwMessage("批量更新失败,请刷新重试");
        }
        return flag;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteBatchByDTO(Collection<OperatorRole> entityList) {
        AssertUtil.isNotEmpty(entityList, "参数不能为空");
        boolean flag = deleteByIdsWithFill(entityList);
        if (!flag) {
            BusinessException.throwMessage("批量更新失败,请刷新重试");
        }
    }
}