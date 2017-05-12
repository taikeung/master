package com.andy.service;

import com.andy.domain.Permission;

public interface PermissionService {
	Permission query(Long id);
	void add(Permission permission);
}
