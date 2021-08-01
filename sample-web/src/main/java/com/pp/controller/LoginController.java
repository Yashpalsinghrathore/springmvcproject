package com.pp.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pp.model.Product;
import com.pp.model.UserDto;
import com.pp.service.LoginService;
import com.pp.service.ProductService;
import com.pp.validator.LoginValidator;
import com.pp.validator.RegistrationValidator;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ProductService productService;
	

	@Autowired
	private LoginValidator loginValidator;
	
/*	@RequestMapping("/welcome")
	public String showWelcomePage(ModelMap model)
	{
		
		System.out.println("inside login controller");
		
		UserDto user = new UserDto();
		
		//map.put("UserDto",user);
		
		model.addAttribute("UserDto",user);
		
		
		return "login";
		
	}*/
	/*@RequestMapping(value = "/submitLogin",method = RequestMethod.POST)
	public String submitLogin(@ModelAttribute("UserDto") UserDto userDto, BindingResult result,Map<String, Object> map,HttpServletRequest request)
	{
			loginValidator.validate(userDto, result);
		
			if(result.hasErrors())
			{
				System.out.println("inside error");
			
			
				return "login";
			}
		
			else
			{
			
				
		
				System.out.println("inside submitLogin controller");
		
				System.out.println(userDto.getEmail());
				System.out.println(userDto.getPassword());
		
				
				 UserDto checkUser = loginService.userSignIn(userDto);
				  
				  System.out.println(checkUser.getFirstName()+"hello controller");
				  
				  
				HttpSession session = request.getSession();
				session.setAttribute("login",checkUser);
				UserDto login = (UserDto) request.getSession().getAttribute("login");
				System.out.println(login);
				return "redirect:/product.do";
				  
					
			}
				
		
		
				Product product = new Product();
		
				map.put("Product",product);
		
				List<Product> productList = productService.getAllProduct();
		
				Iterator itr = productList.iterator();
		
				while(itr.hasNext())
				{
			
						Product p = (Product) itr.next();
						System.out.println(p.getId());
						System.out.println(p.getProductName());
				}
		
				System.out.println("size is"+productList.size());
	
				map.put("listProduct", productList);
		
				return "product";
				  
			
	
	}*/
	
	@RequestMapping(value = "/welcome",method = {RequestMethod.GET,RequestMethod.POST})
	public String mergeLogin( @ModelAttribute("UserDto") UserDto userDto, BindingResult result,ModelMap model,HttpServletRequest request,RedirectAttributes models){
		
		String method = request.getMethod();
		System.out.println("method is "+method);
		model.addAttribute("UserDto",userDto);
		if(("GET").equals(method))
		{
			System.out.println("inside mergelogin controller if section");
			return "login";
			
		}
		else
		{
			loginValidator.validate(userDto, result);
			
			if(result.hasErrors())
			{
				System.out.println("inside error");
			
			
				return "login";
			}
		
			else
			{
			
				
		
				System.out.println("inside mergeLogin controller else section submit part");
		
				System.out.println(userDto.getEmail());
				System.out.println(userDto.getPassword());
		
				
				 UserDto checkUser = loginService.userSignIn(userDto);
				  
				  System.out.println(checkUser.getFirstName()+"hello controller");
				  
				  
				HttpSession session = request.getSession();
				session.setAttribute("login",checkUser);
				UserDto login = (UserDto) request.getSession().getAttribute("login");
				System.out.println(login);
				
				models.addFlashAttribute("name","yash");
				
				
				return "redirect:/product.do";
				  
					
			}
				
			
		}
		
		
	}
	
	
	
}
