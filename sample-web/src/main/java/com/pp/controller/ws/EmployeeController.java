package com.pp.controller.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pp.model.Product;
import com.pp.service.DeleteService;
import com.pp.service.EditService;
import com.pp.service.ProductService;
import com.pp.validator.ProductValidator;

@Controller
public class EmployeeController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductValidator productValidator;
	
	@Autowired
	private DeleteService deleteService;
	
	@Autowired
	private EditService editService;
	
	@RequestMapping(method=RequestMethod.GET,value="/employee/{id}")
	@ResponseBody
	public List getEmployee(@PathVariable String id) 
	{
		
		System.out.println("hello");
		List<Product> productList = productService.getAllProduct();
		return productList;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/employee")
	@ResponseBody
	public ResponseEntity<List<Product>> addEmployee(@RequestBody Product p) 
	{
	
		System.out.println(p.getProductName());
		System.out.println(p.getPrice());
		System.out.println(p.getDescription());
		System.out.println(p.getExpiryDate());
		
		//productService.productEntry(p);
		
		List<Product> productList = productService.getAllProduct();
		
		
		return new ResponseEntity<List<Product>>(productList,HttpStatus.BAD_REQUEST);
		
	
		
		
	}

	@RequestMapping(method=RequestMethod.PUT,value="/employee/{id}")
	@ResponseBody
	public Product updateEmployee(@PathVariable int id) 
	{
	
			System.out.println("in webservice edit");
		
			System.out.println(id);
		
			
			Product p = editService.editpoduct(id);
			
			System.out.println(p.getPrice());
		
			return p;
			
		
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employee/{id}")
	@ResponseBody
	public String deleteEmployee(@PathVariable int id) 
	{
	
			System.out.println("in webservice delete");
		
			System.out.println(id);
		
			//deleteService.deletepoduct(id);
		
		
				return "deleted";
		
		
	}
	
	
}
