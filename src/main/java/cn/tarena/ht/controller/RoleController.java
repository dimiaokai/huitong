package cn.tarena.ht.controller;

import java.util.List;

import javax.management.relation.RoleList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.ModuleService;
import cn.tarena.ht.service.RoleService;

@Controller
@RequestMapping("/sysadmin/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ModuleService moduleService;
	
	
	@RequestMapping("/list")
	public String findAll(Model model){
		
		List<Role> roleList = roleService.findAll();
		model.addAttribute("roleList", roleList);
		
		return "sysadmin/role/jRoleList";
	}
	
	@RequestMapping("/delete")
	public String toDelete( @RequestParam(value="roleId",required=true)String[] roleIds){
		
		roleService.deleteRoles(roleIds);
		
		//页面跳转到角色列表页面
		return "redirect:/sysadmin/role/list";
	}
	
	
	//角色新增
	@RequestMapping("tocreate")
	public String toCreate(){
		return "sysadmin/role/jRoleCreate";
	}
	
	
	//角色的新增
	@RequestMapping("/save")
	public String saveRole(Role role){
	
		roleService.saveRole(role);
		
		return "redirect:/sysadmin/role/list";
		
	}
	
	@RequestMapping("/toview")
	public String toview(String roleId,Model model){
		
		Role role = roleService.findOne(roleId);
		model.addAttribute("role", role);
		//转向查看页面
		return "sysadmin/role/jRoleView";
	}
	
	
	@RequestMapping("/toupdate")
	public String toUpdate(@RequestParam(required=true)String roleId,Model model){
		
		Role role = roleService.findOne(roleId);
		model.addAttribute("role", role);
		
		//转向到角色修改页面
		return "sysadmin/role/jRoleUpdate";
	}
	
	//角色的修改
	@RequestMapping("update")
	public String update(Role role){
		
		roleService.updateRole(role);
		
		return "redirect:/sysadmin/role/list";
	}
	
	
	//为用户跳转到角色模块页面
	@RequestMapping("toRoleModule")
	public String toRoleModule(String roleId,Model model) throws JsonProcessingException{
		
		
		//根据roleId查询全部的模块信息
		List<String> roleModuleList = moduleService.findRoleModuleListByRoleId(roleId);
		
		//查询全部的模块信息
		List<Module> moduleList = moduleService.findAll();		
		
		//数据的回显
		for (Module module : moduleList) {
			if(roleModuleList.contains(module.getModuleId())){
				module.setChecked(true);
			}
		}

		//通过调用对象身上的getxxx()获取属性和属性值
		String zTreeJSON = new ObjectMapper().writeValueAsString(moduleList);
		model.addAttribute("zTreeJSON", zTreeJSON);
		model.addAttribute("roleId", roleId);
		
		return "sysadmin/role/jRoleModule";
	}
	
	
	
	//角色模块的入口操作
	@RequestMapping("saveRoleModule")
	public String saveRoleModule(String roleId,String[] moduleIds){
		
		roleService.saveRoleModule(roleId,moduleIds);
		
		return "redirect:/sysadmin/role/list";
	}
	
	
	
	
	
	
	
	
	
	
}
