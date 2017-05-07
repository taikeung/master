package com.andy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.andy.domain.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import net.sf.json.JSONObject;

@Api(value = "User控制器")
@Controller
@RequestMapping("/user")
public class SwaggerController {
	
		@ApiOperation(value = "根据用户id查询用户信息", httpMethod = "GET", produces = "application/json")
		@ApiResponse(code = 200, message = "success", response = JSONObject.class)
		@ResponseBody
		@RequestMapping(value = "/queryUserById", method = RequestMethod.GET, produces = "application/json")
		public User queryUserById(
				@ApiParam(name = "userId", required = true, value = "用户Id")
				@RequestParam("userId") int userId, HttpServletRequest request) {
			User user = new User();
			user.setAge(25);
			user.setName("andy");
			return user;
		}
}
