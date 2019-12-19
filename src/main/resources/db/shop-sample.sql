DROP TABLE IF EXISTS `pms_product`;
CREATE TABLE `pms_product` (
  `id`   bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `product_code` varchar(64) DEFAULT ''  COMMENT '商品编号',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '商品名称',
  `sub_title` varchar(200) DEFAULT '' COMMENT '商品副标题',
  `main_image` varchar(500) DEFAULT '' COMMENT '产品主图,url地址',
  `sub_images` text DEFAULT '' COMMENT '图片地址,json格式,扩展用',
  `description` text DEFAULT '' COMMENT '商品描述',
  `price` decimal(12,2)  DEFAULT '0' COMMENT '价格,单位-元,保留两位小数',
  `sale` int(11)  DEFAULT '0' COMMENT '销量',
  `publish_status` tinyint(4) '0' COMMENT '上架状态：0->下架；1->上架',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='产品表';


DROP TABLE IF EXISTS `pms_sku_stock`;
CREATE TABLE `pms_sku_stock` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `product_id` bigint(20) NOT NULL COMMENT '产品id',
  `sku_code` varchar(64) NOT NULL COMMENT  'sku编码',
  `price` decimal(10,2) DEFAULT '0' COMMENT '单品价格',
  `stock` int(11)    DEFAULT '0' COMMENT '库存',
  `low_stock` int(11) DEFAULT '0' COMMENT '预警库存',
  `lock_stock` int(11) DEFAULT '0' COMMENT '锁定库存',
  `sp1` varchar(64) DEFAULT '' COMMENT '销售属性1',
  `sp2` varchar(64) DEFAULT '',
  `sp3` varchar(64) DEFAULT '',
  `pic` varchar(255) DEFAULT '' COMMENT '展示图片',
  `sale` int(11) DEFAULT NULL COMMENT '销量',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='sku的库存';

DROP TABLE IF EXISTS `pms_product_attribute`;
CREATE TABLE `pms_product_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT '',
  `type` int(1) DEFAULT NULL COMMENT '属性的类型；0->规格；1->参数',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品属性参数表';

DROP TABLE IF EXISTS `pms_product_attribute_value`;
CREATE TABLE `pms_product_attribute_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL  COMMENT '产品id',
  `product_attribute_id` bigint(20) NOT NULL COMMENT '产品属性id',
  `value` varchar(64) DEFAULT NULL COMMENT '手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='存储产品参数信息的表';


DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_code` varchar(64) NOT NULL COMMENT '订单号',
  `user_id`   bigint(20)  NOT NULL  COMMENT '用户id',
  `user_name` varchar(50)  NOT NULL DEFAULT '' COMMENT '用户',
  `total_money` decimal(14,2) NOT NULL DEFAULT '0'  COMMENT '订单金额',
  `pay_money` decimal(14,2) NOT NULL DEFAULT '0'  COMMENT '支付金额',
  `order_status` tinyint(4)  NOT NULL DEFAULT '0'  COMMENT '订单状态 0:待付款,1:待发货,2:已发货,3:已完成 5:已取消,6:部分发货,7:退款中 ',
  `pay_method` tinyint(4) NOT NULL COMMENT '支付方式：1现金，2余额，3网银，4支付宝，5微信',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
  `source_type` tinyint(3) DEFAULT '0' COMMENT '订单来源：0->PC订单；1->app订单',
  `order_type` tinyint(3) DEFAULT '0' COMMENT '订单类型：0->正常订单；1->秒杀订单',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单表';

DROP TABLE IF EXISTS `oms_order_item`;
CREATE TABLE `oms_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `order_code` varchar(64) NOT NULL COMMENT '订单编号',
  `product_id` bigint(20) NOT NULL COMMENT '商品id',
  `product_code` varchar(64) DEFAULT ''  COMMENT '商品编号',
  `product_pic` varchar(500) DEFAULT '' COMMENT '商品图片',
  `product_name` varchar(200) DEFAULT '' COMMENT '商品名称',
  `product_price` decimal(12,2) DEFAULT '' COMMENT '销售价格',
  `product_quantity` int(12) DEFAULT '0' COMMENT '购买数量',
  `product_sku_id` bigint(20) NOT NULL COMMENT '商品sku编号',
  `product_sku_code` varchar(50) NOT NULL COMMENT '商品sku条码',
  `sp1` varchar(100) DEFAULT '' COMMENT '商品的销售属性',
  `sp2` varchar(100) DEFAULT '',
  `sp3` varchar(100) DEFAULT '',
  `product_attr` varchar(500) DEFAULT NULL COMMENT '商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单详情表';


DROP TABLE IF EXISTS `pay_info`;
CREATE TABLE `pay_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '支付id',
  `order_code` varchar(30) NOT NULL COMMENT '订单号',
  `pay_platform` tinyint(4)  NOT NULL DEFAULT '0' COMMENT '支付平台:0-其他平台,1-支付宝,2-微信',
  `pay_number` varchar(200) DEFAULT NULL COMMENT '支付流水号',
  `pay_status` varchar(20) DEFAULT NULL COMMENT '支付状态  0-支付失败,1-支付成功',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='支付表';
