package com.yuntian.mybatisplus.sys.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuntian.mybatisplus.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
*
* <p>
*  后台系统-用户角色关系表
* </p>
* @author yuntian
* @since 2019-07-06
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_operator_role")
public class OperatorRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
    * 用户id
    */
    private Long userId;

    /**
    * 角色id
    */
    private Long roleId;


}
