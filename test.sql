CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) NOT NULL UNIQUE COMMENT '姓名',
  `age` int(4) NOT NULL COMMENT '年龄',
  `pers` varchar(100) DEFAULT NULL COMMENT '用户权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `per_code` varchar(20) NOT NULL COMMENT '权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;