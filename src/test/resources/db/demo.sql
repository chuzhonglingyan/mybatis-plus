DROP TABLE IF EXISTS `backend_operater`;
CREATE TABLE `backend_operater` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_name` varchar(50) NOT NULL COMMENT '账号',
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_name` (`account_name`) COMMENT 'account_name唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台用户表';


