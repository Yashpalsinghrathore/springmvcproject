package com.pp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pp.model.UserDto;

import com.pp.service.RegistrationService;
import com.pp.validator.RegistrationValidator;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private RegistrationValidator registrationValidator;
	
	
	
	/*@RequestMapping("/registration")
	public String showRegistrationPage(Map<String, Object> map)
	{
		
		System.out.println("inside registration controller");
		
		UserDto user = new UserDto();
		
		
		
		map.put("UserDto",user);
		
		return "registration";
		
	}
	
	@RequestMapping(value = "/submitRegistration",method = RequestMethod.POST)
	public String submitRegistration(@ModelAttribute("UserDto") UserDto userDto, BindingResult result,Map<String, Object> map)
	{
		
		registrationValidator.validate(userDto, result);
		
		if(result.hasErrors())
		{
			System.out.println("inside error");
			
			
			return "registration";
		}
		
		else
		{
		
		
			System.out.println("inside submitRegistration controller");
		
			System.out.println(userDto.getEmail());
			System.out.println(userDto.getPassword());
			System.out.println(userDto.getFirstName());
			System.out.println(userDto.getLastName());
			System.out.println(userDto.getMobile());
		
			registrationService.userRegistration(userDto);
		
		
		
			return "successRegistration";
		}
		
		
	}*/
	@RequestMapping(value = "/registration",method = {RequestMethod.GET,RequestMethod.POST})
	public String mergeRegistration( @ModelAttribute("UserDto") UserDto userDto, BindingResult result,ModelMap model,HttpServletRequest request){
		
		String method = request.getMethod();
		System.out.println("method is "+method);
		model.addAttribute("UserDto",userDto);
		if(("GET").equals(method))
		{
			System.out.println("inside mergeRegistration controller if section");
			return "registration";
			
		}
		else
		{
			registrationValidator.validate(userDto, result);
			if(result.hasErrors())
			{
				System.out.println("inside registration error");
				
				
				return "registration";
			}
			
			else
			{
			
			
				System.out.println("inside mergeRegistration else section ");
			
			
				registrationService.userRegistration(userDto);
			
			
			   return "successRegistration";
			}
		}
	}




}
