package com.pramod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramod.dto.LoginRequest;
import com.pramod.dto.Response;
import com.pramod.entity.User;
import com.pramod.service.impl.UserService;
import com.pramod.service.interfac.IUserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private IUserService userService;
	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody User user){
		
		Response response=userService.register(user);
		return ResponseEntity.status(response.getStatusCode()).body(response);
		
	}
	@PostMapping("/login")
public ResponseEntity<Response> login(@RequestBody LoginRequest loginReq){
		
		Response response=userService.login(loginReq);
		return ResponseEntity.status(response.getStatusCode()).body(response);
		
	}

}