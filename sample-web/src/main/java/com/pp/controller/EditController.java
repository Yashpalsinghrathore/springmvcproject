package com.pp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pp.model.Product;
import com.pp.service.EditService;

@Controller
public class EditController {

	@Autowired
	private EditService editService;
	
	@RequestMapping(method=RequestMethod.PUT,value="/editproduct/{id}")
	@ResponseBody
	public Product updateEmployee(@PathVariable int id) 
	{
	
			System.out.println("in webservice edit");
		
			System.out.println(id);
		
			
			Product p = editService.editpoduct(id);
			
			System.out.println(p.getPrice());
		
			return p;
			
	}
	
}
