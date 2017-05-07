package com.andy.shiro;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.andy.domain.Permission;
import com.andy.domain.User;
import com.andy.service.UserService;

/**
 * @ClassName ShiroRealm
 * @Description 配置shiro realm
 * @author hdq
 * @Date 2016年7月28日 上午10:03:46
 * @version 1.0.0
 */
@Component("shiroRealm")
public class ShiroRealm extends AuthorizingRealm {

	@Resource(name = "userService")
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection p) {
		String name = p.asList().get(0).toString();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		try {
			List<Permission> pers = userService.queryPermissions(name);
			for (Permission permission :pers) {
				info.addStringPermission(permission.getPerCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {


		String name = (String) token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		User user = userService.queryByName(name);
		if (user == null) {
			throw new UnknownAccountException();
		}
		//这里写死了
		if(!password.equals("andy")){
			throw new IncorrectCredentialsException();
		}

		return new SimpleAuthenticationInfo(name, password, getName());
	}

}