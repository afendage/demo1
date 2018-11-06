CREATE TABLE `u_operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作名称',
  `code` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作编码',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '拦截的 url',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `createuser` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建用户',
  `updatetime` datetime DEFAULT NULL COMMENT '修改时间',
  `updateuser` datetime DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='功能操作表';

desc `u_operation`;