package com.yuntian.mybatisplus.sys.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuntian.mybatisplus.sys.model.dto.OperatorDTO;
import com.yuntian.mybatisplus.sys.model.entity.Operator;
import com.yuntian.mybatisplus.common.IBaseService;
import java.util.Collection;

/**
 * <p>
 * 后台系统-用户表 服务类
 * </p>
 *
 * @author yuntian
 * @since 2019-12-19
 */
public interface OperatorService extends IBaseService<Operator> {

   IPage<Operator> queryListByPage(OperatorDTO dto);


   void updateByDTO(Operator dto);


   void deleteByDTO(Operator dto);


   void deleteBatchByDTO(Collection<Operator> entityList);

}
