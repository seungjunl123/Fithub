package com.cjp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cjp.model.dao.UserDao;
import com.cjp.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private final UserDao userDao;
	
	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

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
	
	@Override
	public User login(String id, String password) {
		// DB에서 입력받은 id 에 해당하는 유저 정보를 가져와 user 변수에 저장.
		User user = userDao.selectOne(id);
		
		// 입력받은 비밀번호와 user 의 비밀번호가 일치하는지 확인
//		if (user != null && passwordEncoder.matches(password, user.getPassword())) {
//            // 일치하면 user 데이터 반환
//			return user;
//        }
		
		// 일지하지 않으면 null 반환
		return null;
	}
	
	// selectOne으로 user 정보를 불러온 뒤 
	// 로그인 시에는 비밀번호를 대조하고 search시에는 정보를 불러오면 안되나
//	@Override
//	public User login(String id) {
//		return userDao.selectOne(id);
//	}

	@Override
	public User search(String id) {
		return userDao.selectOne(id);
	}

	@Override
	public void modifyUserInfo(User user) {
		userDao.updateUserInfo(user);
	}


}