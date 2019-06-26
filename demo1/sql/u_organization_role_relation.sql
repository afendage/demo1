CREATE TABLE `u_organization_role_relation` (
  `id` int(11) NOT NULL,
  `org_id` int(11) NOT NULL COMMENT '机构id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='机构角色关联表';
