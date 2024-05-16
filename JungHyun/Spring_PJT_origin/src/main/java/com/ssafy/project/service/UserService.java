package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.model.dto.Review;
import com.ssafy.project.model.dto.User;

public interface UserService {
	
	public abstract List<User> selectAll();

	public abstract User selectOne(String userId);
	
	public abstract int insertUser(User user);
}
