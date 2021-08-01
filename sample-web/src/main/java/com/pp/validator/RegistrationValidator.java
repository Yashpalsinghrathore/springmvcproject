package com.pp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pp.model.UserDto;
import com.pp.repository.RegistrationRepository;

@Component
public class RegistrationValidator implements Validator {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	public boolean supports(Class<?> clazz) {
		return UserDto.class.isAssignableFrom(clazz);
	}
	
	

	public void validate(Object target, Errors errors) {
		
		UserDto userDto = (UserDto)target;
		
		//rule no 1 for blank statement
		
		ValidationUtils.rejectIfEmpty(errors, "firstName","error.firstName.empty");

		ValidationUtils.rejectIfEmpty(errors, "lastName","error.lastName.empty");

		ValidationUtils.rejectIfEmpty(errors, "email", "error.email.empty");

		ValidationUtils.rejectIfEmpty(errors, "password","error.password.empty");

		ValidationUtils.rejectIfEmpty(errors, "mobile","error.mobile.empty");
		
		// rule no. 2 for bussiness rule
		
		if(userDto.getEmail() !=null && userDto.getEmail().trim().length()>0)
		{
			if(userDto.getEmail().contains("@") != true)
				{
			
					errors.rejectValue("email", "error.email.first.rule");
			
				}
			else if(userDto.getEmail().contains("gmail.com") != true)
				{
			
					errors.rejectValue("email", "error.email.second.rule");
				}
		
		
			//rule 3 for data verification
			
			else if(registrationRepository.getEmailId(userDto.getEmail()).size()>0)
			{
				
				errors.rejectValue("email", "error.email.forth.rule");
				
			}
		
		
		}
		
		
		if(userDto.getFirstName() !=null && userDto.getFirstName().trim().length()>0)
		{
			
			
			if(userDto.getFirstName().matches("^[a-zA-Z]{3,15}$")!=true)
			{
				errors.rejectValue("firstName", "error.firstName.rule");
				
			}
			
			
		}
		
		if(userDto.getLastName() !=null && userDto.getLastName().trim().length()>0)
		{
			
			
			if(userDto.getFirstName().matches("^[a-zA-Z]{3,15}$")!=true)
			{
				errors.rejectValue("lastName", "error.lastName.rule");
				
			}
			
			
		}
		if(userDto.getMobile() !=null && userDto.getMobile().trim().length()>0)
		{
			
			
			if(userDto.getMobile().matches("^[6-9][0-9]{9}$")!=true)
			{
				errors.rejectValue("mobile", "error.mobile.rule");
				
			}
			
			
		}
		if(userDto.getPassword() !=null && userDto.getPassword().trim().length()>0)
		{
			
			
			if(userDto.getPassword().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})")!=true)
			{
				errors.rejectValue("password", "error.password.rule.second");
				
			}
			
			
		}
		
		
		
		
		
	
	
	
	}	
	
}
