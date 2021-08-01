package com.pp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.UserDto;

@Repository
public class RegistrationRepository {


	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void userRegistration(UserDto userDto)
	{
		
		System.out.println("inside userRegistraton methid in loginRepository class");
		
		System.out.println(userDto.getEmail());
		System.out.println(userDto.getPassword());
		System.out.println(userDto.getFirstName());
		System.out.println(userDto.getLastName());
		System.out.println(userDto.getMobile());
		
		
		hibernateTemplate.save(userDto);
		
		
		
	}
	public List getEmailId(String email)
	{
		

		
		    List l =  hibernateTemplate.find(
				"select userDto.email from UserDto userDto where userDto.email=? ",email);
		    
		 
		
		    return l;
		
		}
	


}
