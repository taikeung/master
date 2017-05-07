package com.andy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.andy.domain.Permission;
import com.andy.mapper.PermissionMapper;
import com.andy.service.PermissionService;
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	@Resource(name = "permissionMapper")
	private PermissionMapper permissionMapper;
	
	@Override
	public Permission query(Long id) {
		Permission permission = permissionMapper.selectByPrimaryKey(id);
		return permission;
	}

}
