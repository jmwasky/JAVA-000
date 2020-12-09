CREATE TABLE `t_account` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `account_name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `salt_password` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `create_time` bigint(11) NOT NULL COMMENT '创建时间',
  `amount` bigint(11) NOT NULL COMMENT '金额',
  PRIMARY KEY (`id`),
  KEY `index_name` (`account_name`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

CREATE TABLE `t_delivery` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `account_id` bigint(11) NOT NULL COMMENT '用户ID',
  `address` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '用户地址',
  `create_time` bigint(11) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户配送信息表';

CREATE TABLE `t_order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `account_id` bigint(11) NOT NULL COMMENT '用户ID',
  `product_id` bigint(11) NOT NULL COMMENT '产品ID',
  `consume_count` int(10) NOT NULL COMMENT '消费数目',
  `total_amount` bigint(11) NOT NULL COMMENT '消费总额',
  `delivery_id` bigint(11) NOT NULL COMMENT '配送信息ID',
  `status` int(5) NOT NULL COMMENT '订单支付状态：1已支付，2未支付',
  `create_time` bigint(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单表';

CREATE TABLE `t_product` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品名',
  `description` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品描述',
  `freeze_count` bigint(11) DEFAULT NULL,
  `total` bigint(11) NOT NULL COMMENT '库存总量',
  `create_time` bigint(11) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商品表';


