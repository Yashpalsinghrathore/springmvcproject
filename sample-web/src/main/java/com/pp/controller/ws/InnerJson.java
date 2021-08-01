package com.pp.controller.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pp.model.Cars;
import com.pp.model.Vendor;

@Controller
public class InnerJson {

	@RequestMapping(method=RequestMethod.POST,value="/innerjson")
	@ResponseBody
	public Vendor addEmployee(@RequestBody Vendor v) 
	{
		
		System.out.println(v.getName());
		System.out.println(v.getAge());
		
		Cars car = v.getCar();
		
		System.out.println(car.getCar1());
		System.out.println(car.getCar2());
		System.out.println(car.getCar3());
		
		
		
		
		return v;
		
		
	}
	
}
