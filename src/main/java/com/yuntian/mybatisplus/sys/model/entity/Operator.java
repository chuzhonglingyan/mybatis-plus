package com.yuntian.mybatisplus.sys.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuntian.mybatisplus.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
*
* <p>
*  后台系统-用户表
* </p>
* @author yuntian
* @since 2019-12-19
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_operator")
public class Operator extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
    * 账号
    */
    private String account;

    /**
    * 用户名
    */
    private String userName;

    /**
    * 密码
    */
    private String passWord;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 电话
    */
    private String phone;

    /**
    * 是否启用，0-禁用，1-启用，默认为0
    */
    private Integer isEnable;

    /**
    * 是否超级管理员，0-否，1-是，默认为0
    */
    private Integer isSupper;

    /**
    * 是否删除，0-未删除，1-删除，默认为0
    */
    private Integer isDelete;


}
