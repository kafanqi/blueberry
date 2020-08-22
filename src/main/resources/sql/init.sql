-- 创建用户表
CREATE TABLE `blueberry`.`user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(32) DEFAULT NULL COMMENT '昵称',
  `head_image` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机号',
  `gender` tinyint DEFAULT NULL COMMENT '性别 0：未知，1：男，2：女',
  `city` varchar(64) DEFAULT NULL COMMENT '城市',
  `province` varchar(64) DEFAULT NULL COMMENT '省份',
  `country` varchar(64) DEFAULT NULL COMMENT '国家',
  `open_id` varchar(32) DEFAULT NULL COMMENT '微信openId',
  `union_id` varchar(32) DEFAULT NULL COMMENT '微信unionId',
  `status` tinyint DEFAULT NULL COMMENT '状态 10：正常， 20：冻结',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


