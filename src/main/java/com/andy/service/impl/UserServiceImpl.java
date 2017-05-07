package com.andy.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andy.domain.Permission;
import com.andy.domain.User;
import com.andy.mapper.PermissionMapper;
import com.andy.mapper.UserMapper;
import com.andy.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name = "userMapper")
	private UserMapper userMapper;
	
	@Resource(name = "permissionMapper")
	private PermissionMapper permissionMapper;
	
	@Override
	public User queryByName(String name) {
		User user = userMapper.queryByName(name);
		return user;
	}

	@Override
	public List<Permission> queryPermissions(String name) {
		List<Permission> permissions = new ArrayList<>();
		User user = userMapper.queryByName(name);
		String pers = user.getPers();
		if(pers != null && !pers.equals("")){
			String[] perIdStrs = pers.split(",");
			for(String perIdStr : perIdStrs){
				long perId = Long.parseLong(perIdStr);
				Permission permission = permissionMapper.selectByPrimaryKey(perId);
				permissions.add(permission);
			}
		}
		return permissions;
	}

	@Override
	@Transactional
	public boolean insert(User user) {
		int affected = userMapper.insert(user);
		return affected>0;
	}

}
