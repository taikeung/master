package com.andy.task;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.andy.domain.Permission;
import com.andy.service.PermissionService;

@Component
@EnableScheduling
public class InsertPermissionJob {
	
	@Resource(name = "permissionService")
	private PermissionService permissionService;
	
	@Scheduled(cron = "0/5 * *  * * ?")
	public void insert(){
		System.out.println("开始添加权限....");
		Permission permission = new Permission();
		permission.setPerCode("test:add");
		permissionService.add(permission);
		System.out.println("成功添加一条权限");
	}
}
