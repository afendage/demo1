CREATE TABLE `u_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '名称',
  `parentid` int(11) DEFAULT NULL COMMENT '父级id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '描述',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `createuser` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建用户',
  `updatetime` datetime DEFAULT NULL COMMENT '修改时间',
  `updateuser` datetime DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户组表';

desc `u_group`;