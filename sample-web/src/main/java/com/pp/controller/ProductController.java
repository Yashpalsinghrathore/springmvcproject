package com.pp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pp.model.Product;
import com.pp.model.UserDto;
import com.pp.service.ProductService;
import com.pp.validator.ProductValidator;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductValidator productValidator;

/*	@RequestMapping("/product")
	public String showProductPage(Map<String, Object> map)
	{
		
		System.out.println("inside product controller");
		
		Product product = new Product();
		
		List<Product> productList = productService.getAllProduct();
		
		map.put("listProduct", productList);
		
		map.put("Product",product);
		
		return "product";
		
	}
	
	@RequestMapping(value = "/submitProduct",method = RequestMethod.POST)
	public String submitProduct(@ModelAttribute("Product") Product product,BindingResult result,Map<String, Object> map)
	{
		
		productValidator.validate(product,result);
		
		if(result.hasErrors())
		{
			System.out.println("inside product error");
			
			List<Product> productList = productService.getAllProduct();
			
			map.put("listProduct", productList);
			
			return "product";
		}
		else
		{
		
		
			System.out.println("inside submitProduct controller");
		
			
			System.out.println(product.getProductName());
			System.out.println(product.getPrice());
			System.out.println(product.getDescription());
			System.out.println(product.getExpiryDate());
		
	 
			productService.productEntry(product);
		
		
			Product product2 = new Product();
		
			map.put("Product",product2);
		
			List<Product> productList = productService.getAllProduct();
	
			map.put("listProduct", productList);
		
			return "product";
		}
		
	}*/
	
	@RequestMapping(value = "/product",method = {RequestMethod.GET,RequestMethod.POST})
	public String mergeProduct( @ModelAttribute("Product") Product product, BindingResult result,ModelMap model,HttpServletRequest request,Model models){
		
		String method = request.getMethod();
		System.out.println("method is "+method);
		
		model.addAttribute("Product",product);
		List<Product> productList = productService.getAllProduct();
		model.addAttribute("listProduct",productList);
		if(("GET").equals(method))
		{
			System.out.println("inside mergeproduct controller if section");
			System.out.println(models.asMap().get("name"));
			return "product";
			
		}
		else
		{
			productValidator.validate(product,result);
			
			if(result.hasErrors())
			{
				System.out.println("inside product error");
				
				return "product";
			}
			else
			{
			System.out.println("inside mergeproduct controller else  section");
			productService.productEntry(product);
			return "redirect:/product.do";
			}
		}
		
	}
	
	
	
	
	
	
}
