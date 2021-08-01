package com.pp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TimeInterceptor extends HandlerInterceptorAdapter {

	private Long startTime;
	private Long totalTime;
	
	private static final Logger logger = Logger.getLogger(TimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		 System.out.println("inside time pre handle method");
		 
		 
		 startTime = System.currentTimeMillis();
	      System.out.println(startTime);
		 
		 
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		System.out.println("inside time post handle method");
		
		 String url = request.getRequestURL().toString();
	       System.out.println(url);
		
		 totalTime = System.currentTimeMillis()-startTime;
	      System.out.println(totalTime+" millisecond time was taken by this "+url);
		
		

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("inside time after comletion method");
	}

	
}