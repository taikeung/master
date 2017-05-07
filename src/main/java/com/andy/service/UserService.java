package com.andy.service;

import java.util.List;

import com.andy.domain.Permission;
import com.andy.domain.User;

public interface UserService {
	boolean insert(User user);
	User queryByName(String name);
	List<Permission> queryPermissions(String name);
}
