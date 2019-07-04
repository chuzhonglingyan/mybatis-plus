package com.yuntian.mybatisplus.sys.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.sys.model.dto.UserRoleDTO;
import com.yuntian.mybatisplus.sys.model.entity.UserRole;
import com.yuntian.mybatisplus.common.IBaseService;
import java.util.Collection;

/**
 * <p>
 * 后台系统-用户角色关系表 服务类
 * </p>
 *
 * @author yuntian
 * @since 2019-07-02
 */
public interface UserRoleService extends IBaseService<UserRole> {

   IPage<UserRole> queryListByPage(UserRoleDTO dto);


   void updateByDTO(UserRole dto);


   void deleteByDTO(UserRole dto);


   void deleteBatchByDTO(Collection<UserRole> entityList);

}
