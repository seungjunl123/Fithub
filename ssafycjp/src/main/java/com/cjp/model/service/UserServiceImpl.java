package com.cjp.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjp.model.dao.UserDao;
import com.cjp.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public void signup(User user) {
		userDao.insertUser(user);
	}

//	@Override
//	public User login(String id, String password) {
//		Map<String, String> info = new HashMap<>();
//		info.put("id", id);
//		info.put("password", password);
//		return userDao.selectOne(info);
//	}
	
	// selectOne으로 user 정보를 불러온 뒤 
	// 로그인 시에는 비밀번호를 대조하고 search시에는 정보를 불러오면 안되나
	@Override
	public User login(String id) {
		return userDao.selectOne(id);
	}

	@Override
	public User search(String id) {
		return userDao.selectOne(id);
	}

	@Override
	public void modifyUserInfo(User user) {
		userDao.updateUserInfo(user);
	}


}
