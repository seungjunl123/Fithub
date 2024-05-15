package com.ssafy.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.model.dto.User;
import com.ssafy.project.model.dto.Video;
import com.ssafy.project.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ssafit/user")
@Tag(name="UserController", description = "SSAFIT CRUD")
public class UserControler {
	   private static final long serialVersionUID = 1L;

	   @Autowired
	    private UserService Uservice;
	
	   // 유저 등록
	   @PostMapping("/")
	   public ResponseEntity<?> regist(@RequestBody User user){
	      Uservice.insertUser(user);
	      return new ResponseEntity<User>(HttpStatus.CREATED);
	   }

	   // 유저 로그인
	   @PostMapping("/login")
	   public ResponseEntity<?> login(@RequestBody User user){
	      User loginUser = Uservice.selectOne(user.getUserId());
	      if(loginUser!=null && user.getPassword().equals(loginUser.getPassword())) {
	         return new ResponseEntity<User>(loginUser, HttpStatus.OK);
	      } 
	      return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	   }
}
