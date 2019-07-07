
DROP TABLE IF EXISTS `sys_operator`;
CREATE TABLE `sys_operator` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(50) NOT NULL COMMENT '账号',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `pass_word` varchar(50) NOT NULL COMMENT '密码',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `phone` varchar(20) NOT NULL COMMENT '电话',
  `is_enable` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否启用，0-禁用，1-启用，默认为0',
  `is_supper` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否超级管理员，0-否，1-是，默认为0',
  `create_id` bigint(20) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台系统-用户表';

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role` varchar(100) NOT NULL COMMENT '角色key',
  `role_name` varchar(50) NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '角色状态 0:冻结  1：开通',
  `remark` varchar(100) DEFAULT '' COMMENT '备注',
  `create_id` bigint(20) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='后台系统-角色表';

DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `pid` bigint(20) DEFAULT '0' COMMENT '父菜单id',
  `menu_name` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `menu_level` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '菜单等级 1一级菜单  2 二级菜单  3 三级菜单',
  `menu_url` varchar(500) NOT NULL DEFAULT '' COMMENT '菜单url',
  `menu_code` varchar(500) DEFAULT '' COMMENT '授权(多个用逗号分隔，如：user:list,user:add)',
  `menu_type` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '菜单类型，0：根目录,1：菜单，2：操作',
  `menu_status` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0：禁用  1：启用',
  `sort` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `create_id` bigint(20) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY (`id`),
  KEY `idx_menu_name` (`menu_name`) USING BTREE,
  KEY `idx_menu_pid` (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='后台系统-菜单表';


DROP TABLE IF EXISTS `sys_operator_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id`  bigint(20) NOT NULL COMMENT '角色id',
  `create_id` bigint(20) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='后台系统-用户角色关系表';

DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id`  bigint(20) NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单id',
  `create_id` bigint(20) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='后台系统-角色菜单关系表';

