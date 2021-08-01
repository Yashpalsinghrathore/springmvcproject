package com.pp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.Product;

@Repository
public class DeleteRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void deleteProduct(int id)
	{
		
		System.out.println("inside delete repo");
		
		Product p = (Product) hibernateTemplate.get(Product.class, id);
		
		
		hibernateTemplate.delete(p);
		
		
	}
	
}
