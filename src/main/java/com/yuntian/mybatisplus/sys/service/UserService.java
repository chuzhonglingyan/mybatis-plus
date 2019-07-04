package com.yuntian.mybatisplus.sys.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.sys.model.dto.SysUserDTO;
import com.yuntian.mybatisplus.sys.model.entity.SysUser;
import com.yuntian.mybatisplus.common.IBaseService;
import java.util.Collection;

/**
 * <p>
 * 后台系统-用户表 服务类
 * </p>
 *
 * @author yuntian
 * @since 2019-07-02
 */
public interface UserService extends IBaseService<SysUser> {

   IPage<SysUser> queryListByPage(SysUserDTO dto);


   void updateByDTO(SysUser dto);


   void deleteByDTO(SysUser dto);


   void deleteBatchByDTO(Collection<SysUser> entityList);

}
