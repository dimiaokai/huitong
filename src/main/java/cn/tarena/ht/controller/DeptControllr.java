package cn.tarena.ht.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;

@Controller
@RequestMapping("/sysadmin/dept/")
public class DeptControllr {
	
	@Resource
	private DeptService deptService;
	
	@RequestMapping("list")
	public String findList(Model model){
		List<Dept> deptList = deptService.findAll();
		model.addAttribute("deptList", deptList);
		
		//跳转到部门列表页面
		return "sysadmin/dept/jDeptList";
	}
	
	
	
	
	//状态的改变
	@RequestMapping("stop")
	public String toStop(@RequestParam(value="deptId",required=true) String[] deptIds){
		
		int state = 0;  //表示状态停用
		deptService.updateState(deptIds,state);
		
		//重定向到部门列表页面
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("start")
	public String toStart(@RequestParam(value="deptId",required=true) String[] deptIds){
		int state = 1;  //表示状态停用
		deptService.updateState(deptIds,state);
		
		//重定向到部门列表页面
		return "redirect:/sysadmin/dept/list";
	}
	
	//部门删除
	@RequestMapping("delete")
	public String toDelete(@RequestParam(value="deptId",required=true)String[] deptIds){
		
		deptService.deleteDepts(deptIds);
		
		return "redirect:/sysadmin/dept/list";
	}
	
	
	//跳转部门新增页面
	@RequestMapping("tocreate")
	public String toCreate(Model model){
		
		//查询部门全部列表数据
		List<Dept> parentDeptList = deptService.findAll();
		model.addAttribute("parentDeptList", parentDeptList);
		
		return "sysadmin/dept/jDeptCreate";
	}
	
	@RequestMapping("save")
	public String saveDept(Dept dept){
		
		deptService.saveDept(dept);
		
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("toupdate")
	public String updateDept(String deptId,Model model){
		
		//准备修改数据
		Dept dept = deptService.findOne(deptId);
		
		//准备上级部门的下拉列表
		List<Dept> parentList = deptService.findAll();
		model.addAttribute("dept", dept);
		model.addAttribute("parentList", parentList);
		
		return "sysadmin/dept/jDeptUpdate";
	}
	
	@RequestMapping("update")
	public String updateDept(Dept dept){
		
		deptService.updateDept(dept);
		
		return "redirect:/sysadmin/dept/list";
	}
	
	
	//部门查看
	@RequestMapping("toview")
	public String toView(String deptId,Model model){
		
		Dept dept = deptService.findOne(deptId);
		model.addAttribute("dept", dept);
		
		//跳转到查看页面
		return "sysadmin/dept/jDeptView";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
