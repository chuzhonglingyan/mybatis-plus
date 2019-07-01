package com.yuntian.mybatisplus.sys.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.sys.model.dto.BackendOperaterDTO;
import com.yuntian.mybatisplus.sys.model.entity.BackendOperater;
import com.yuntian.mybatisplus.common.IBaseService;
import java.util.Collection;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author yuntian
 * @since 2019-07-02
 */
public interface BackendOperaterService extends IBaseService<BackendOperater> {

   IPage<BackendOperater> queryListByPage(BackendOperaterDTO dto);


   void updateByDTO(BackendOperater dto);


   void deleteByDTO(BackendOperater dto);


   void deleteBatchByDTO(Collection<BackendOperater> entityList);

}
