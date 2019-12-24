package com.yuntian.mybatisplus.sys.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yuntian.mybatisplus.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
*
* <p>
*  后台系统-角色菜单关系表
* </p>
* @author yuntian
* @since 2019-12-19
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_role_menu")
public class RoleMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
    * 角色id
    */
    private Long roleId;

    /**
    * 菜单id
    */
    private Long menuId;


}
