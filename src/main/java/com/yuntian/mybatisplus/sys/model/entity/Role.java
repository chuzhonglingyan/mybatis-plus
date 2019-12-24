package com.yuntian.mybatisplus.sys.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuntian.mybatisplus.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
*
* <p>
*  后台系统-角色表
* </p>
* @author yuntian
* @since 2019-12-19
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_role")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
    * 角色key
    */
    private String role;

    /**
    * 角色名称
    */
    private String roleName;

    /**
    * 角色状态 0:冻结  1：开通
    */
    private Integer roleStatus;

    /**
    * 备注
    */
    private String remark;

    /**
    * 是否删除，0-未删除，1-删除，默认为0
    */
    private Integer isDelete;


}
