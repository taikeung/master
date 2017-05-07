package com.andy.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.andy.domain.User;
import com.andy.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringTest extends AbstractJUnit4SpringContextTests{
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "redisTemplate")
	private StringRedisTemplate redisTemplate;
	
	@Test
	public void testMybatis(){
		User user = new User();
		user.setAge(20);
		user.setName("omni");
		user.setPers("1");
		
		userService.insert(user);
	}
	
	@Test
	public void testRedis(){
		redisTemplate.boundHashOps("nihao");
	}
}
