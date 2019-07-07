package com.yuntian.mybatisplus.sys.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.sys.model.dto.RoleMenuDTO;
import com.yuntian.mybatisplus.sys.model.entity.RoleMenu;
import com.yuntian.mybatisplus.common.IBaseService;
import java.util.Collection;

/**
 * <p>
 * 后台系统-角色菜单关系表 服务类
 * </p>
 *
 * @author yuntian
 * @since 2019-07-06
 */
public interface RoleMenuService extends IBaseService<RoleMenu> {

   IPage<RoleMenu> queryListByPage(RoleMenuDTO dto);


   void updateByDTO(RoleMenu dto);


   void deleteByDTO(RoleMenu dto);


   void deleteBatchByDTO(Collection<RoleMenu> entityList);

}
