package com.yuntian.mybatisplus.sys.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuntian.mybatisplus.sys.model.dto.MenuDTO;
import com.yuntian.mybatisplus.sys.model.entity.Menu;
import com.yuntian.mybatisplus.sys.mapper.MenuMapper;
import com.yuntian.mybatisplus.sys.service.MenuService;
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
 * 后台系统-菜单表 服务实现类
 * </p>
 *
 * @author yuntian
 * @since 2019-07-02
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public IPage<Menu> queryListByPage(MenuDTO dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        IPage<Menu> page=new Page<>(dto.getCurrent(),dto.getSize());
        return page(page);
    }


    @Override
    public Menu getById(Serializable id) {
        return super.getById(id);
    }


    @Override
    public boolean save(Menu dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        return super.save(dto);
    }


    @Override
    public void updateByDTO(Menu dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        AssertUtil.isNotNull(dto.getId(), "id不能为空");
        boolean flag = super.updateById(dto);
        if (!flag) {
            BusinessException.throwMessage("更新失败,请刷新重试");
        }
    }


    @Override
    public void deleteByDTO(Menu dto) {
        AssertUtil.isNotNull(dto, "参数不能为空");
        AssertUtil.isNotNull(dto.getId(), "id不能为空");
        boolean flag = deleteByIdWithFill(dto);
        if (!flag) {
            BusinessException.throwMessage("删除失败,请刷新重试");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveBatch(Collection<Menu> entityList) {
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateBatchById(Collection<Menu> entityList) {
        AssertUtil.isNotEmpty(entityList, "参数不能为空");
        boolean flag = updateBatchById(entityList, entityList.size());
        if (!flag) {
            BusinessException.throwMessage("批量更新失败,请刷新重试");
        }
        return flag;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteBatchByDTO(Collection<Menu> entityList) {
        AssertUtil.isNotEmpty(entityList, "参数不能为空");
        boolean flag = deleteByIdsWithFill(entityList);
        if (!flag) {
            BusinessException.throwMessage("批量更新失败,请刷新重试");
        }
    }
}
