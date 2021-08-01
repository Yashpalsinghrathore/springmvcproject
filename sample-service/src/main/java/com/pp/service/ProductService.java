package com.pp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.model.Product;
import com.pp.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public void productEntry(Product product)
	{
		
		System.out.println("inside productEntry method in productService class");
	
		
		System.out.println(product.getProductName());
		System.out.println(product.getPrice());
		System.out.println(product.getDescription());
		System.out.println(product.getExpiryDate());
		
		
		productRepository.productEntry(product);
		
		
		
		
	}
	public List getAllProduct()
	{
		
		List l = productRepository.getAllProduct();
		
		
		
		return l;
		
	}
	
}
