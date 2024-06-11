package com.mypack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypack.entities.User;
import com.mypack.pojo.JwtRequest;
import com.mypack.pojo.JwtResponse;
import com.mypack.pojo.UserRequest;
import com.mypack.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
		System.out.println("Request recieved in controller | request:" + request);
		return new ResponseEntity<>(userService.login(request), HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {

		System.out.println("Request recieved in controller | userRequest:" + userRequest);
		User response = userService.register(userRequest);
		System.out.println("Returning response...");
		return ResponseEntity.ok(response);
	}


}
