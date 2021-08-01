package com.pp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pp.model.UserDto;
import com.pp.repository.LoginRepository;
import com.pp.repository.RegistrationRepository;

@Component
public class LoginValidator implements Validator {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	public boolean supports(Class<?> clazz) {
		return UserDto.class.isAssignableFrom(clazz);
	}
	

	public void validate(Object target, Errors errors) {
		
		UserDto userDto = (UserDto)target;
		
		//rule no 1 for blank statement
		

		ValidationUtils.rejectIfEmpty(errors, "email", "error.email.empty");

		
		ValidationUtils.rejectIfEmpty(errors, "password","error.password.empty");
		
		
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
			
			else if(registrationRepository.getEmailId(userDto.getEmail()).size()<1)
			{
				
				errors.rejectValue("email", "error.email.third.rule");
				
			}
		
		
		}
		
		if(registrationRepository.getEmailId(userDto.getEmail()).size()>0)
		{
			if(userDto.getPassword() !=null && userDto.getPassword().trim().length()>0)
			{
			
				//rule 3 for data verification
			
				if(loginRepository.checkEmailPassword(userDto).size()<1)
				{
				
					errors.rejectValue("password", "error.password.rule");
				
				}
			
			
			}
		}
		
	}
	
	
}
