package com.yuntian.mybatisplus.sys.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuntian.mybatisplus.sys.model.dto.BackendOperaterDTO;
import com.yuntian.mybatisplus.sys.model.entity.BackendOperater;
import com.yuntian.mybatisplus.sys.mapper.BackendOperaterMapper;
import com.yuntian.mybatisplus.sys.service.BackendOperaterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author yuntian
 * @since 2019-06-26
 */
@Service
public class BackendOperaterServiceImpl extends ServiceImpl<BackendOperaterMapper, BackendOperater> implements BackendOperaterService {

    @Override
    public IPage<BackendOperater> queryListByPage(BackendOperaterDTO dto) {
        IPage<BackendOperater> page=new Page<>(dto.getCurrent(),dto.getSize());
        IPage<BackendOperater> list=page(page);
        return list;
    }


}
