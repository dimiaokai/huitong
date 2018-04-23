package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.UserInfo;

public interface UserInfoService {
	
	//查询上级列表信息
	public List<UserInfo> findManagerList();
}	
