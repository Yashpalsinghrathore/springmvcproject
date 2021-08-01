package com.pp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pp.model.UserDto;
import com.pp.repository.LoginRepository;
import com.pp.repository.RegistrationRepository;

@Component
public class WebServiceAuthInterceptor extends HandlerInterceptorAdapter {


	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	private static final Logger logger = Logger.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		System.out.println("in the interceptor");
		UserDto user = new UserDto();
		user.setEmail(request.getHeader("email"));
		user.setPassword(request.getHeader("password"));
		
		if(loginRepository.checkEmailPassword(user).size()>0)
		{
			return true;
			
		}
		
		
		return false;
		
	
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		System.out.println("inside post handle method");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("inside after comletion method");
	}

	
}
