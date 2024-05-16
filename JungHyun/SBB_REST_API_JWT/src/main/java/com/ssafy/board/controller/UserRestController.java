package com.ssafy.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.util.JwtUtil;

@RestController
@RequestMapping("/api-user")
public class UserRestController {
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private JwtUtil jwtUtil;
	
	//UserService 우리 없어요 ㅠ
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user){
		
		HttpStatus status = null;
		Map<String, Object> result = new HashMap<>();
		System.out.println(user);
		//서비스 -> 다오 -> DB 
		//엄청난 검증을 끝내고 온거다.
		if(user.getId() != null) {
			//토큰 만들어서 줘야되는데?
			result.put("message", SUCCESS);
			result.put("access-token", jwtUtil.createToken(user.getId()));
			//id도 같이 넘겨주면 번거로운 작업을 할 필요는 없어
			status = HttpStatus.ACCEPTED;
		}else {
			result.put("message", FAIL);
			status = HttpStatus.NO_CONTENT;
		}
		
		return new ResponseEntity<>(result, status);
	}

}
