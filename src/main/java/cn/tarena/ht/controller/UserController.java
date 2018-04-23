package cn.tarena.ht.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserInfoService;
import cn.tarena.ht.service.UserService;

@Controller
@RequestMapping("/sysadmin/user/")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("list")
	public String toUserList(Model model){
		
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		
		return "sysadmin/user/jUserList";
	}
	
	//状态的启用
	@RequestMapping("start")
	public String toStart(@RequestParam(value="userId",required=true)String[] userIds){
		
		int state = 1;
		userService.updateState(userIds,state);
		
		//重定向到用户列表页面
		return "redirect:/sysadmin/user/list";
		
		
	}
	
	//状态的停用
	@RequestMapping("stop")
	public String toStop(@RequestParam(value="userId",required=true)String[] userIds){
		
		int state = 0;
		userService.updateState(userIds,state);
		
		//重定向到用户列表页面
		return "redirect:/sysadmin/user/list";

	}
	
	//用户删除
	@RequestMapping("delete")
	public String toDelete(@RequestParam(value="userId",required=true)String[] userIds){
		
		userService.deleteUser(userIds);
		
		return "redirect:/sysadmin/user/list";
	}
	
	
	//用户查看
	@RequestMapping("toview")
	public String toview(@RequestParam(required=true)String userId,Model model){
		
		User user = userService.findOne(userId);
		model.addAttribute("user", user);
		//转向用户的查看页面
		return "sysadmin/user/jUserView";
		
	}
	
	
	//用户新增页面跳转
	@RequestMapping("tocreate")
	public String tocreate(Model model){
		//1 准备部门列表信息
		List<Dept> deptList = deptService.findAll();
		
		//2.准备上级领导
		List<UserInfo> managerList = userInfoService.findManagerList();
		
		
		model.addAttribute("deptList", deptList);
		model.addAttribute("managerList", managerList);
		return "sysadmin/user/jUserCreate";
		
	}
	
	@RequestMapping("save")
	public String saveUser(User user){
		
		//多表操作时 需要保证事务的一致性
		userService.saveUser(user);
		
		
		//页面应该重定向到list页面
		return "redirect:/sysadmin/user/list";
	}
	
	//修改用户
	@RequestMapping("toupdate")
	public String toupdate(String userId,Model model){
		User user = userService.findOne(userId);   //查询用户信息
		
		//准备下拉列表
		List<Dept> deptList = deptService.findAll();
		List<UserInfo> managerList = userInfoService.findManagerList();
		model.addAttribute("user", user);
		model.addAttribute("deptList", deptList);
		model.addAttribute("managerList", managerList);
		
		//为了页面快速获取上级领导的Id
		String managerId = null;   
		if(user.getUserInfo().getManager() !=null){
			managerId =  user.getUserInfo().getManager().getUserInfoId();
		}
		
		model.addAttribute("mId",managerId);
		return "sysadmin/user/jUserUpdate";
		
	}
	
	
	//转向用户角色页面
	/**
	 * 	1.根据userId查询用户的角色信息(userRoleList)
		2.查询全部的角色信息
		3.用户的信息与角色的全部进行做匹配,如果roleId一致,则为Role对象中添加属性checked,并设置为true.
	 * @param userId
	 * @param model
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("userRole")
	public String touserRole(@RequestParam(required=true)String userId,Model model) throws JsonProcessingException{
		
		//根userId查询角色信息
		List<String> userRoleList = userService.findRoleIdByUserId(userId);
		
		//准备角色信息
		List<Role> roleList = roleService.findAll();
		
		
		//循环遍历roleList 设置checked属性
		for (Role role : roleList) {
			if(userRoleList.contains(role.getRoleId())){
				//证明用户由此权限
				role.setChecked(true);
			}
		}
		
		
		
		//将roleList转化为JSON串
		String zTreeJSON = new ObjectMapper().writeValueAsString(roleList);
		System.out.println(zTreeJSON);
		
		model.addAttribute("zTreeJSON", zTreeJSON);
		
		//将用户的userid 传递到页面中,方便以后插件时使用
		model.addAttribute("userId", userId);
		//转向分配页面
		return "/sysadmin/user/jUserRole";
		
	}
	
	
	//用户角色分配的保存
	
	@RequestMapping("saveUserRole")
	public String saveUserRole(String[] roleIds,String userId){
		
		userService.saveUserRole(roleIds,userId);
		//System.out.println(Arrays.toString(roleIds));
		
		return "redirect:/sysadmin/user/list";
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
