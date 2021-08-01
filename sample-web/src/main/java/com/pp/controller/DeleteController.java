package com.pp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pp.service.DeleteService;

@Controller
public class DeleteController {

	@Autowired
	private DeleteService deleteService;
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deleteproduct/{id}")
	@ResponseBody
	public String deleteEmployee(@PathVariable int id) 
	{
	
			System.out.println("in webservice delete");
		
			System.out.println(id);
		
			//deleteService.deletepoduct(id);
		
		
				return "deleted";
		
		
	}
	
	
}
