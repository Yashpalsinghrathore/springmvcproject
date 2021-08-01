package com.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.model.UserDto;
import com.pp.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	public UserDto userSignIn(UserDto userDto)
	{
		
		System.out.println("inside LoginService class");
		System.out.println(userDto.getEmail());
		System.out.println(userDto.getPassword());
		
		UserDto checkUser = loginRepository.userSignIn(userDto);
		
		return checkUser;
		
	}

	
}
