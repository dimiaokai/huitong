package cn.tarena.ht.shiro;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.org.apache.xerces.internal.xs.StringList;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

public class AuthRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;
	
	//权限认证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		//准备用户的真实的模块信息
		List<String> moduleList = userService.findModuleListByUserId(user.getUserId());
		
		//权限认证的对象
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		//将用户的权限信息 提交给Shiro安全管理器
		info.addStringPermissions(moduleList);
		return info;
	}
	
	/*

	 * 登陆认证(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 * 通过自定义的realm将用户真实的信息返给安全管理器

	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//将token进行格式转化
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		String userName = loginToken.getUsername();
		
		//根据用户名查询用户的真实信息
		User user = userService.findUserByUserName(userName);
		/**
		 * principal 真实的用户对象
		 * credentials  真实的密码
		 */
		
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		
		return info; //通过info对象返回给安全管理器
	}
	
	

	
}
