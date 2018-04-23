package cn.tarena.ht.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import cn.tarena.ht.pojo.User;

public interface UserMapper {
	public List<User> findAll();

	public void updateState(@Param("userIds")String[] userIds,@Param("state")int state, @Param("updateTime")Date updateTime);

	public void deleteUser(String[] userIds);

	public User findOne(String userId);
	
	public void saveUser(User user);
	
	@Insert("insert into role_user_p(role_id,user_id) values(#{roleId},#{userId})")
	public void saveUserRole(@Param("roleId")String roleId,@Param("userId")String userId);
	
	@Delete("delete from role_user_p where user_id = #{userId}")
	public void deleteUserRoleByUserId(String userId);
	
	@Select("select role_id from role_user_p where user_id = #{userId}")
	public List<String> findRoleIdByUserId(String userId);
	
	public User findUserByUP(@Param("userName")String userName,@Param("password")String password);
	
	
	//为页面的session中的数据作准备 使用配置为文件查询
	public User findUserByUserName(String userName);
	
	
	public List<String> findModuleListByUserId(String userId);
	
	
}
