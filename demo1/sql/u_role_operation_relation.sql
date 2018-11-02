CREATE TABLE `u_role_operation_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) NOT NULL COMMENT '角色id',
  `operationid` int(11) NOT NULL COMMENT '操作id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色与操作关联表';

desc `u_role_operation_relation`;