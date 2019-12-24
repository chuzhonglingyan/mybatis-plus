
DROP TABLE IF EXISTS `api_user`;
CREATE TABLE `api_user`(
`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
`account` VARCHAR(20) DEFAULT NULL COMMENT '用户账号',
`pass_word` varchar(64) DEFAULT NULL COMMENT '密码',
`user_name` VARCHAR(30) DEFAULT NULL COMMENT '姓名',
`nick_name` VARCHAR(30) DEFAULT NULL COMMENT '昵称',
`age` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '年龄',
`sex` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '0-男，1-女，默认为0',
`phone` varchar(20) NOT NULL COMMENT '电话',
`email` varchar(50) DEFAULT  null COMMENT '邮箱',
`create_id` bigint(20) NOT NULL COMMENT '创建人',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_id` bigint(20) NOT NULL COMMENT '更新人',
`update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='前台系统-用户表';


