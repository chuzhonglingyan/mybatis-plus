package com.yuntian.mybatisplus.sys.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.sys.model.dto.BackendOperaterDTO;
import com.yuntian.mybatisplus.sys.model.entity.BackendOperater;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author yuntian
 * @since 2019-06-26
 */
public interface BackendOperaterService extends IService<BackendOperater> {

   IPage<BackendOperater> queryListByPage(BackendOperaterDTO dto);
}
