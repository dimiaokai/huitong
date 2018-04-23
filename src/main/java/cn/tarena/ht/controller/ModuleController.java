package cn.tarena.ht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;

@Controller
@RequestMapping("/sysadmin/module")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;
	
	
	@RequestMapping("/list")
	public String findAll(Model model){
		List<Module>  moduleList = moduleService.findAll();
		model.addAttribute("moduleList", moduleList);
		
		//跳转到列表页面中
		return "sysadmin/module/jModuleList";
	}
	
	
	//状态的改变
	@RequestMapping("start")
	public String toStart(@RequestParam(value="moduleId",required=true)String[] moduleIds){
		int state = 1; //启用
		moduleService.updateState(moduleIds,state);
		
		//跳转到列表页面
		return "redirect:/sysadmin/module/list";
	}
	
	@RequestMapping("stop")
	public String toStop(@RequestParam(value="moduleId",required=true)String[] moduleIds){
		int state = 0;  //停用
		moduleService.updateState(moduleIds,state);
		return "redirect:/sysadmin/module/list";
	}
	
	
	@RequestMapping("delete")
	public String toDelete(@RequestParam(value="moduleId",required=true)String[] moduleIds){
		
		moduleService.deleteModules(moduleIds);
		
		return "redirect:/sysadmin/module/list";
	}
	
	@RequestMapping("/tocreate")
	public String tocreate(Model model){
		
		//为页面准备上级模块列表
		List<Module> moduleList = moduleService.findAll();
		model.addAttribute("moduleList", moduleList);
		
		//跳转到模块新增页面
		return "sysadmin/module/jModuleCreate";
	}
	
	
	//模块的新增
	@RequestMapping("save")
	public String saveModule(Module module){
		
		moduleService.saveModule(module);
		
		//跳转到模块列表页面
		return "redirect:/sysadmin/module/list";
	}
	
	
	@RequestMapping("toupdate")
	public String updateModule(String moduleId,Model model){
		
		//根据模块id查询模块信息
		Module module = moduleService.findOne(moduleId);
		
		//准备上级模块列表  排除自己之外的
		List<Module> moduleList = moduleService.findParentModuleList(moduleId);
		
		model.addAttribute("module", module);
		model.addAttribute("moduleList", moduleList);
		
		//跳转到修改页面
		return "sysadmin/module/jModuleUpdate";
	}
	
	
	@RequestMapping("update")
	public String updateModule(Module module){
		
		moduleService.updateModule(module);
		
		
		return "redirect:/sysadmin/module/list";
	}
	
	
	
	
	
	
	
	
	
	
}
