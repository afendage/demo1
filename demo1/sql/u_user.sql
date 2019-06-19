CREATE TABLE `u_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别 0 未知，1 男， 2 女',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `createuser` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建用户',
  `updatetime` datetime DEFAULT NULL COMMENT '修改时间',
  `updateuser` datetime DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

desc `u_user`;