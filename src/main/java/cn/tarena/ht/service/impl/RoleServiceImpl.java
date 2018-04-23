package cn.tarena.ht.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<Role> findAll() {
		
		return roleMapper.findAll();
	}
	
	//根据roleId删除信息
	@Override
	public void deleteRoles(String[] roleIds) {
		
		//先应该删除角色和模块的中间表数据
		roleMapper.delteRoleModuleByRoleIds(roleIds);
		roleMapper.deleteRoles(roleIds);
		
	}

	@Override
	public void saveRole(Role role) {
		//设置主键信息
		role.setRoleId(UUID.randomUUID().toString());
		role.setCreateTime(new Date());
		roleMapper.saveRole(role);
	}

	@Override
	public Role findOne(String roleId) {
		
		return roleMapper.findOne(roleId);
	}

	@Override
	public void updateRole(Role role) {
		role.setUpdateTime(new Date());
		
		roleMapper.updateRole(role);
		
	}

	@Override
	public void saveRoleModule(String roleId, String[] moduleIds) {
		//为了解决重复提交文件 先删除 后新增
		roleMapper.delteRoleModuleByRoleId(roleId);
		
		
		//循环遍历 进行插入操作
		for (String moduleId : moduleIds) {
			roleMapper.saveRoleModule(roleId,moduleId);
		}
		
		
	}

}
