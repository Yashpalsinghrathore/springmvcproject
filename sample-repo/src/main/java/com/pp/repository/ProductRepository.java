package com.pp.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.Product;

@Repository
public class ProductRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	
	public void productEntry(Product product)
	{
		
		System.out.println("inside productEntry method in productRepository class");
	
		
		System.out.println(product.getProductName());
		System.out.println(product.getPrice());
		System.out.println(product.getDescription());
		System.out.println(product.getExpiryDate());
		
		
		// hibernateTemplate.save(product);
		 hibernateTemplate.saveOrUpdate(product);
		 
			List<Product> l = hibernateTemplate.find("from Product p");
		 
			Iterator itr = l.iterator();
			
			while(itr.hasNext())
			{
				Product p = (Product) itr.next();
				System.out.println(p.getId());
				System.out.println(p.getProductName());
				
			}
			
			
			
		 
		 
		}
	
	public List getAllProduct()
	{
		

		List<Product> l = hibernateTemplate.find("from Product p");
		
		
		return l;
		
	}
	
	  
	
	
}



