package cn.tarena.ht.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.tool.MD5Hash;
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private UserInfoMapper userInfoMapper;
	
	@Override
	public List<User> findAll() {
		
		return userMapper.findAll();
	}

	@Override
	public void updateState(String[] userIds, int state) {
		
		Date updateTime = new Date();
		userMapper.updateState(userIds,state,updateTime);
		
	}

	@Override
	public void deleteUser(String[] userIds) {
		
		userMapper.deleteUser(userIds);
	}

	@Override
	public User findOne(String userId) {
		
		return userMapper.findOne(userId);
	}

	@Override
	public void saveUser(User user) {
		//获取UUID
		String userId = UUID.randomUUID().toString();
		
		UserInfo info = new UserInfo();
		info = user.getUserInfo();
		
		
		//需要将明文加密
		String password = MD5Hash.getMd5HashPasswod(user.getPassword(), user.getUsername());
		//补充数据
		user.setUserId(userId);
		user.setCreateTime(new Date());
		user.setPassword(password);
		info.setUserInfoId(userId);
		info.setCreateTime(new Date());
		
		userMapper.saveUser(user);
		userInfoMapper.saveUserInfo(info);
	}

	@Override
	public void saveUserRole(String[] roleIds, String userId) {
		
		//为了防止重复的插入  先userId删除表数据
		userMapper.deleteUserRoleByUserId(userId);
		
		//循环插入数据
		for (String roleId : roleIds) {
			userMapper.saveUserRole(roleId,userId);
		}
		
		
	}

	@Override
	public List<String> findRoleIdByUserId(String userId) {
		
		return userMapper.findRoleIdByUserId(userId);
	}

	@Override
	public User findUserByUP(String userName, String password) {
		
		return userMapper.findUserByUP(userName,password);
	}

	@Override
	public User findUserByUserName(String userName) {
		
		return userMapper.findUserByUserName(userName);
	}

	
	//根据userId查询用户所管理的全部模块信息
	@Override
	public List<String> findModuleListByUserId(String userId) {
		
		
		return userMapper.findModuleListByUserId(userId);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
