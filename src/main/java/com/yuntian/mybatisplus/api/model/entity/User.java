package com.yuntian.mybatisplus.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuntian.mybatisplus.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
*
* <p>
*  前台系统-用户表
* </p>
* @author yuntian
* @since 2019-07-07
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("api_user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
    * 用户账号
    */
    private String account;

    /**
    * 密码
    */
    private String passWord;

    /**
    * 姓名
    */
    private String userName;

    /**
    * 昵称
    */
    private String nickName;

    /**
    * 年龄
    */
    private Integer age;

    /**
    * 0-男，1-女，默认为0
    */
    private Integer sex;

    /**
    * 电话
    */
    private String phone;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 是否删除，0-未删除，1-删除，默认为0
    */
    private Integer isDelete;


}
