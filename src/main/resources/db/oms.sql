

DROP TABLE IF EXISTS `oms_order_cart`;
CREATE TABLE `oms_order_cart`(
 `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '购物车id',
 `user_id` bigint(20)   NOT NULL COMMENT '用户id',
 `product_id` bigint(20)   NOT NULL COMMENT '商品id',
 `product_sku_id`   bigint(20)   NOT NULL COMMENT '商品sku的id',
 `product_sku_num` int(11) NOT NULL DEFAULT '0' COMMENT '加入购物车商品数量',
 `price` decimal(14,2) NOT NULL DEFAULT '0' COMMENT '商品价格',
 `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
 `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
 `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
 `is_delete` tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='购物车表';


DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_code` varchar(64) NOT NULL COMMENT '订单号',
  `user_id`   bigint(20)  NOT NULL  COMMENT '用户id',
  `user_name` varchar(50)  NOT NULL DEFAULT '' COMMENT '用户名',
  `total_money` decimal(14,2) NOT NULL DEFAULT '0'  COMMENT '订单金额',
  `pay_money` decimal(12,2) NOT NULL DEFAULT '0'  COMMENT '支付金额',
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
  `product_name` varchar(200) DEFAULT '' COMMENT '商品名称',
  `product_brand` varchar(200) DEFAULT '' COMMENT '商品品牌',
  `product_price` decimal(10,2) DEFAULT '0' COMMENT '销售价格',
  `product_quantity` int(12) DEFAULT '0' COMMENT '购买数量',
  `product_sku_id` bigint(20) NOT NULL COMMENT '商品sku编号',
  `product_sku_code` varchar(50) NOT NULL COMMENT '商品sku条码',
  `product_category_id` bigint(20) NOT NULL COMMENT '商品分类id',
  `product_category_name` varchar(50) DEFAULT '' COMMENT '商品分类名称',
  `product_attr` varchar(500) DEFAULT '' COMMENT '商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单详情表';


DROP TABLE IF EXISTS `oms_pay_info`;
CREATE TABLE `oms_pay_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '支付id',
  `order_code` varchar(64) NOT NULL COMMENT '订单号',
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
