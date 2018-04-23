package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.User;

public interface UserService {
	public List<User> findAll();
	
	public void updateState(String[] userIds, int state);
	
	//数据库问题
	public void deleteUser(String[] userIds);

	public User findOne(String userId);

	public void saveUser(User user);
	
	public void saveUserRole(String[] roleIds, String userId);

	public List<String> findRoleIdByUserId(String userId);
	
	public User findUserByUP(String userName, String password);

	public User findUserByUserName(String userName);
	
	public List<String> findModuleListByUserId(String userId);

}
