package com.pp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.Product;

@Repository
public class EditRepo {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Product editRepo(int id)
	{
		System.out.println("inside edit repo");
		
		Product p = (Product) hibernateTemplate.get(Product.class, id);
		
		return p;
		
		
	}
}
