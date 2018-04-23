package cn.tarena.ht.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.tool.MD5Hash;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		
		//跳转到登陆页面
		return "/sysadmin/login/login";
	}
	
	/**
	 * 登陆的业务逻辑
	 * 1.判断用户名密码是否为null
	 * 2.根据用户名和密码查询数据
	 * 3.如果能够查询到数据证明用户名和密码正确  跳转到系统首页
	 * 4.如果不正确 返回登陆页面 并且给用户提示.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String userName,String password,Model model,HttpSession httpSession){
		
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
			//证明用户输入的值为空
			model.addAttribute("errorInfo", "用户名或密码不能为空");
			//直接转发到页面
			return "/sysadmin/login/login";
		}
		
		
		//以Shiro的方式进行登陆操作
		
		//形成用户名和密码的令牌
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		
		//创建Subject对象      就是一个"user"
		Subject subject = SecurityUtils.getSubject();
		
		try {
			subject.login(token); //表示用户要进行登陆认证
			
			//获取真实的用户信息
			User user = (User) subject.getPrincipal();
			
			//获取session将用户信息保存到session域中
			subject.getSession().setAttribute("session_user", user);
			
			return "redirect:/home.actiom";  //表示用户名和密码正确
			
		} catch (AuthenticationException e) {
			e.printStackTrace();  //目的如果一旦报异常可以通过控制台进行展现
			model.addAttribute("errorInfo", "用户名或密码错误");
			return "/sysadmin/login/login";
		}
		
		
		
		
		
		/*//表示密码加密
		password = MD5Hash.getMd5HashPasswod(password,userName);
		
		//证明用户名和密码都不为null
		User user = userService.findUserByUP(userName,password);
		
		if(user==null){
			//用户名或密码错误
			model.addAttribute("errorInfo", "用户名或密码错误");
			return "/sysadmin/login/login";
		}else{
			//证明用户名密码正确  将用户对象存储到session域中
			httpSession.setAttribute("session_user", user);
			return "redirect:/home.actiom";
		}	*/
	}
	
	//系统的出
	@RequestMapping("/logout")
	public String logout(HttpSession httpSession){
		
		httpSession.removeAttribute("session_user");
		return "redirect:/toLogin";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
