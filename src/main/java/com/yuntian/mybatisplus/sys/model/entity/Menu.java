package com.yuntian.mybatisplus.sys.model.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yuntian.mybatisplus.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
*
* <p>
*  后台系统-菜单表
* </p>
* @author yuntian
* @since 2019-07-02
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_menu")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
    * 父菜单id
    */
    private Long pid;

    /**
    * 菜单名称
    */
    private String menuName;

    /**
    * 菜单等级 1一级菜单  2 二级菜单  3 三级菜单
    */
    private Integer menuLevel;

    /**
    * 菜单url
    */
    private String menuUrl;

    /**
    * 授权(多个用逗号分隔，如：user:list,user:add)
    */
    private String menuCode;

    /**
    * 菜单类型，0：根目录,1：菜单，2：操作
    */
    private Integer menuType;

    /**
    * 0：禁用  1：启用
    */
    private Integer menuStatus;

    /**
    * 排序
    */
    private Integer sort;

    /**
    * 是否删除，0-未删除，1-删除，默认为0
    */
    @TableLogic
    private Integer isDelete;


}
