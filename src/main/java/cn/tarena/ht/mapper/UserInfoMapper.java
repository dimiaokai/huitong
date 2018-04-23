package cn.tarena.ht.mapper;

import java.util.List;

import cn.tarena.ht.pojo.UserInfo;

public interface UserInfoMapper {
	public List<UserInfo> findManagerList();

	public void saveUserInfo(UserInfo info);
}
