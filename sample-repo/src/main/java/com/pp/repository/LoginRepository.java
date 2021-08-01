package com.pp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.pp.model.UserDto;

@Repository
public class LoginRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public UserDto userSignIn(UserDto userDto)
	{
		
		System.out.println("inside LoginRepository class");
		System.out.println(userDto.getEmail());
		System.out.println(userDto.getPassword());
		
		List<UserDto> login = hibernateTemplate.find(
				"from UserDto user where user.email= ? and user.password = ?",userDto.getEmail(),userDto.getPassword());
		
		if(login !=null && login.size()==1)
		{
		
		UserDto checkUser = login.get(0);
		
		System.out.println(checkUser.getFirstName());
		System.out.println(checkUser.getLastName());
		System.out.println(checkUser.getMobile());
		System.out.println(checkUser.getId());
		return checkUser;
		}
		
		return null;
		
		}
	
	public List<UserDto> checkEmailPassword(UserDto userDto)
	{
		

		List<UserDto> login = hibernateTemplate.find(
				"from UserDto user where user.email= ? and user.password = ?",userDto.getEmail(),userDto.getPassword());
		
		
		return login;
	}
	
	
	
	
}
