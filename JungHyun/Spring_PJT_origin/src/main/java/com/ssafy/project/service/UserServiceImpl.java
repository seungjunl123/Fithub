package com.ssafy.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.project.dao.UserDao;
import com.ssafy.project.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public User selectOne(String userId) {
		return userDao.selectOne(userId);
	}

	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

}
