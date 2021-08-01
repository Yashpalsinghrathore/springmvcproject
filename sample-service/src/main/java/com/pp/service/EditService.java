package com.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.model.Product;
import com.pp.repository.EditRepo;

@Service
public class EditService {

	@Autowired
	private EditRepo editRepo;
	
	public Product editpoduct(int id)
	{
		
		System.out.println("indide edit service");
		
		return editRepo.editRepo(id);
		
		
		
	}
}
