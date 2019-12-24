package com.yuntian.mybatisplus.sys.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.sys.model.dto.RoleDTO;
import com.yuntian.mybatisplus.sys.model.entity.Role;
import com.yuntian.mybatisplus.common.IBaseService;
import java.util.Collection;

/**
 * <p>
 * 后台系统-角色表 服务类
 * </p>
 *
 * @author yuntian
 * @since 2019-12-19
 */
public interface RoleService extends IBaseService<Role> {

   IPage<Role> queryListByPage(RoleDTO dto);


   void updateByDTO(Role dto);


   void deleteByDTO(Role dto);


   void deleteBatchByDTO(Collection<Role> entityList);

}
