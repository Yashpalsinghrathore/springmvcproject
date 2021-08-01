package com.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.model.UserDto;

import com.pp.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;


	public void userRegistration(UserDto userDto)
	{
		
		System.out.println("inside userRegistration method in LoginService class");
	
		
		System.out.println(userDto.getEmail());
		System.out.println(userDto.getPassword());
		System.out.println(userDto.getFirstName());
		System.out.println(userDto.getLastName());
		System.out.println(userDto.getMobile());
		
		
		
		
		registrationRepository.userRegistration(userDto);
		
		
		
	}	
	
	
}
