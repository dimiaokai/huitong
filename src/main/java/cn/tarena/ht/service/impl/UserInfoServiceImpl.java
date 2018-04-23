package cn.tarena.ht.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.service.UserInfoService;
@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	
	@Override
	public List<UserInfo> findManagerList() {
	
		return userInfoMapper.findManagerList();
	}

}
