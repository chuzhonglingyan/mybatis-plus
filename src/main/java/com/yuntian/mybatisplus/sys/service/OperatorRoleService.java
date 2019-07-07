package com.yuntian.mybatisplus.sys.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.sys.model.dto.OperatorRoleDTO;
import com.yuntian.mybatisplus.sys.model.entity.OperatorRole;
import com.yuntian.mybatisplus.common.IBaseService;
import java.util.Collection;

/**
 * <p>
 * 后台系统-用户角色关系表 服务类
 * </p>
 *
 * @author yuntian
 * @since 2019-07-06
 */
public interface OperatorRoleService extends IBaseService<OperatorRole> {

   IPage<OperatorRole> queryListByPage(OperatorRoleDTO dto);


   void updateByDTO(OperatorRole dto);


   void deleteByDTO(OperatorRole dto);


   void deleteBatchByDTO(Collection<OperatorRole> entityList);

}
