package com.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.repository.DeleteRepository;

@Service
public class DeleteService {

	@Autowired
	private DeleteRepository deleteRepository;
	
	public void deletepoduct(int id)
	{
		
		System.out.println("indide delete service");
		deleteRepository.deleteProduct(id);
		
		
		
	}
	
	
}
