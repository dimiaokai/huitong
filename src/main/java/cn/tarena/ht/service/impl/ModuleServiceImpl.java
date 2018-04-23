package cn.tarena.ht.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;
@Service
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
	private ModuleMapper moduleMapper;
	
	@Override
	public List<Module> findAll() {
		
		return moduleMapper.findAll();
	}

	@Override
	public void updateState(String[] moduleIds, int state) {
		
		moduleMapper.updateState(moduleIds,state);
		
	}

	@Override
	public void deleteModules(String[] moduleIds) {
		
		//关联删除中间表数据
		moduleMapper.deleteRoleModuleByModuleIds(moduleIds);
		moduleMapper.deleteModules(moduleIds);
		
	}

	@Override
	public void saveModule(Module module) {
		
		//为module对象准备数据
		module.setModuleId(UUID.randomUUID().toString());
		module.setCreateTime(new Date());
		
		moduleMapper.saveModule(module);
		
	}

	@Override
	public Module findOne(String moduleId) {
		
		return moduleMapper.findOne(moduleId);
	}

	@Override
	public List<Module> findParentModuleList(String moduleId) {
		
		return moduleMapper.findParentModuleList(moduleId);
	}

	@Override
	public void updateModule(Module module) {
		module.setUpdateTime(new Date());
		
		moduleMapper.updateModule(module);
	}

	@Override
	public List<String> findRoleModuleListByRoleId(String roleId) {
		
		return moduleMapper.findRoleModuleListByRoleId(roleId);
	}

}
