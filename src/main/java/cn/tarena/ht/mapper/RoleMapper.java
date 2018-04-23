package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.tarena.ht.pojo.Role;

public interface RoleMapper {
	@Select(value="select * from role_p order by order_no")
	/*@Insert()
	@Delete()
	@Update()*/
	public List<Role> findAll();
	
	public void deleteRoles(String[] roleIds);
	
	public void saveRole(Role role);
	
	@Select("select * from role_p where role_id = #{roleId}")
	public Role findOne(String roleId);
	public void updateRole(Role role);
	
	@Insert("insert into role_module_p(role_id,module_id) values(#{roleId},#{moduleId})")
	public void saveRoleModule(@Param("roleId") String roleId,@Param("moduleId")String moduleId);
	
	@Delete("delete from role_module_p where role_id = #{roleId}")
	public void delteRoleModuleByRoleId(String roleId);
	
	public void delteRoleModuleByRoleIds(String[] roleIds);
}
