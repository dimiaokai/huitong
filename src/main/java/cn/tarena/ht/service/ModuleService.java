package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Module;

public interface ModuleService {
	
	public List<Module> findAll();

	public void updateState(String[] moduleIds, int state);

	public void deleteModules(String[] moduleIds);

	public void saveModule(Module module);

	public Module findOne(String moduleId);

	public List<Module> findParentModuleList(String moduleId);

	public void updateModule(Module module);

	public List<String> findRoleModuleListByRoleId(String roleId);
}
