package com.pp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pp.model.Product;

@Component
public class ProductValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}
	
public void validate(Object target, Errors errors) {
		
		Product product = (Product)target;
		
		//rule no 1 for blank statement
		
		ValidationUtils.rejectIfEmpty(errors, "productName","error.productName.empty");
		ValidationUtils.rejectIfEmpty(errors, "price","error.price.empty");
		ValidationUtils.rejectIfEmpty(errors, "description","error.description.empty");
		ValidationUtils.rejectIfEmpty(errors, "expiryDate","error.expiryDate.empty");
		
		if(product.getProductName() !=null && product.getProductName().trim().length()>0)
		{
			
			
			if(product.getProductName().matches("^[a-zA-Z]{3,15}$")!=true)
			{
				errors.rejectValue("productName", "error.productName.rule");
				
			}
			
			
		}
		if(product.getDescription() !=null && product.getDescription().trim().length()>0)
		{
			
			
			if(product.getDescription().matches("^[a-zA-Z0-9]{3,20}$")!=true)
			{
				errors.rejectValue("description", "error.description.rule");
				
			}
			
			
		}
		if(product.getPrice() !=null && product.getPrice().trim().length()>0)
		{
			
			
			if(product.getPrice().matches("^[0-9 .]{1,99}$")!=true)
			{
				errors.rejectValue("price", "error.price.rule");
				
			}
			
			
		}
		if(product.getExpiryDate() !=null && product.getExpiryDate().trim().length()>0)
		{
			
			
			if(product.getExpiryDate().matches("((?=.*\\d)(?=.*[/]).{10})")!=true)
			{
				errors.rejectValue("expiryDate", "error.expiryDate.rule");
				
			}
			
			
		}
		
}
	
}
