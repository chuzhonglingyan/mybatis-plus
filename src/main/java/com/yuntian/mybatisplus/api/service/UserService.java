package com.yuntian.mybatisplus.api.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.api.model.dto.UserDTO;
import com.yuntian.mybatisplus.api.model.entity.User;
import com.yuntian.mybatisplus.common.IBaseService;
import java.util.Collection;

/**
 * <p>
 * 前台系统-用户表 服务类
 * </p>
 *
 * @author yuntian
 * @since 2019-07-07
 */
public interface UserService extends IBaseService<User> {

   IPage<User> queryListByPage(UserDTO dto);


   void updateByDTO(User dto);


   void deleteByDTO(User dto);


   void deleteBatchByDTO(Collection<User> entityList);

}
