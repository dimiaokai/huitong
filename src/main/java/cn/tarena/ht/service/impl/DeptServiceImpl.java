package cn.tarena.ht.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;
@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public List<Dept> findAll() {
		
		return deptMapper.findAll();
	}

	@Override
	public void updateState(String[] deptIds, int state) {
		
		deptMapper.updateState(deptIds,state);
	}

	@Override
	public void deleteDepts(String[] deptIds) {
		
		deptMapper.deleteDepts(deptIds);
		
	}

	@Override
	public void saveDept(Dept dept) {
		
		dept.setCreateTime(new Date());  //添加新增日期
		deptMapper.saveDept(dept);
		
	}

	@Override
	public Dept findOne(String deptId) {
		
		return deptMapper.findOne(deptId);
	}

	@Override
	public void updateDept(Dept dept) {
		dept.setUpdateTime(new Date());
		deptMapper.updateDept(dept);
		
	}

}
