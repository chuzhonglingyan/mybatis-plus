DROP TABLE IF EXISTS `pms_product_category`;
CREATE TABLE `pms_product_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) NOT NULL COMMENT '分类名称',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类表';

DROP TABLE IF EXISTS `pms_product_brand`;
CREATE TABLE `pms_product_brand` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(50) NOT NULL COMMENT '品牌名称',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品牌表';

DROP TABLE IF EXISTS `pms_product_spu`;
CREATE TABLE `pms_product_spu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `product_code` varchar(64) NOT NULL COMMENT '商品编号，唯一',
  `product_name` varchar(50) NOT NULL COMMENT '商品名称',
  `low_price` decimal(10,2) NOT NULL COMMENT '最低售价',
  `category_id` bigint(20) NOT NULL COMMENT '分类id',
  `brand_id` bigint(20) NOT NULL COMMENT '品牌id',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `un_product_code` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品spu表';


DROP TABLE IF EXISTS `pms_product_spec`;
CREATE TABLE `pms_product_spec` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spec_code` varchar(64) NOT NULL COMMENT '规格编号',
  `spec_name` varchar(50) NOT NULL COMMENT '规格名称',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品规格表';



-- 规格表和规格值表是一对多的关系   颜色：黄色,白色
DROP TABLE IF EXISTS `pms_product_spec_value`;
CREATE TABLE `pms_product_spec_value` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spec_id` bigint(20) NOT NULL COMMENT '规格id',
  `spec_value` varchar(50) NOT NULL COMMENT '规格值',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品规格值表';


-- spu和规格表和表是一对多的关系
DROP TABLE IF EXISTS `pms_product_spu_spec`;
CREATE TABLE `pms_product_spu_spec` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20) NOT NULL COMMENT 'spu_id',
  `spec_id` bigint(20) NOT NULL COMMENT 'spec_id',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品spu-规格表关联表';



-- spu和sku和表是一对多的关系
DROP TABLE IF EXISTS `pms_product_sku`;
CREATE TABLE `pms_product_sku` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sku_code` varchar(50) NOT NULL COMMENT 'sku编号,唯一',
  `sku_name` varchar(50) NOT NULL COMMENT 'sku名称(冗余spu_name)',
  `spu_id` bigint(20) NOT NULL COMMENT 'spu_id',
  `price` decimal(10,2) NOT NULL COMMENT '售价',
  `stock` int(11) NOT NULL COMMENT '库存',
  `shop_id` bigint(20) NOT NULL COMMENT '商铺id,为0表示自营',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `un_sku_code` (`sku_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品sku表';

-- sku和规格值和表是一对多的关系
DROP TABLE IF EXISTS `pms_product_sku_spec_value`;
CREATE TABLE `pms_product_sku_spec_value` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sku_id` bigint(20) NOT NULL COMMENT 'sku_id',
  `spec_value_id` bigint(20) NOT NULL COMMENT '规格值id',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品sku-规格值关联表';

DROP TABLE IF EXISTS `pms_product_shop_info`;
CREATE TABLE `pms_product_shop_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(50) NOT NULL COMMENT '店铺名称',
  `create_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除，0-未删除，1-删除，默认为0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺表';


