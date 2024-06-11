package com.mypack.service;

import com.mypack.entities.User;
import com.mypack.pojo.JwtRequest;
import com.mypack.pojo.JwtResponse;
import com.mypack.pojo.UserRequest;

public interface UserService {

	public JwtResponse login(JwtRequest jwtRequest);
	
	public User register(UserRequest userRequest);
}
