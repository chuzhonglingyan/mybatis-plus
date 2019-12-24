package com.yuntian.mybatisplus.oms.model.dto;

import com.yuntian.mybatisplus.common.BaseDTO;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
*
* <p>
    *  支付表
    * </p>
* @author yuntian
* @since 2019-12-19
*/
@EqualsAndHashCode(callSuper = true)
@Data
public class PayOrderInfoDTO extends BaseDTO implements Serializable{


    private String orderCode;


}
