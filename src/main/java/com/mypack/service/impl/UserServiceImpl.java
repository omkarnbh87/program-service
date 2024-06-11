package com.mypack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mypack.entities.User;
import com.mypack.pojo.JwtRequest;
import com.mypack.pojo.JwtResponse;
import com.mypack.pojo.UserRequest;
import com.mypack.repository.UserRepository;
import com.mypack.security.JwtHelper;
import com.mypack.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired 
	private JwtHelper jwtHelper;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository repository;

	@Override
	public JwtResponse login(JwtRequest jwtRequest) {

		System.out.println("UserServiceImpl.login invoked");
		doAuthenticate(jwtRequest.getEmail(), jwtRequest.getPassword());

		UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getEmail());
		String token = jwtHelper.generateToken(userDetails);
		System.out.println("token generated | token:" + token);

		JwtResponse response = JwtResponse.builder()
				.jwtToken(token)
				.username(userDetails.getUsername())
				.build();
		System.out.println("returning response:" + response);
		return response;
	}

	@Override
	public User register(UserRequest userRequest) {

		System.out.println("UserServiceImpl.login register");
		User user = User.builder()
				.name(userRequest.getName())
				.email(userRequest.getEmail())
				.password(encoder.encode(userRequest.getPassword()))
				.build();
		return repository.save(user);
	}


	private void doAuthenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			manager.authenticate(authentication);

		} catch (BadCredentialsException e) {
			System.out.println("Exception occurred BadCredentialsException | e:" + e);
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}

	}

}
