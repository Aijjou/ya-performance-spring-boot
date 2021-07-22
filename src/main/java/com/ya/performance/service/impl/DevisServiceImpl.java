package com.ya.performance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ya.performance.entities.Devis;
import com.ya.performance.repository.DevisRepository;
import com.ya.performance.service.DevisService;

@Service
public class DevisServiceImpl implements DevisService {

	
	
	
	@Autowired
	DevisRepository devisRepository;
	
	
	@Override
	public Devis createDevis(Devis devis) {
		
		return devisRepository.save(devis);
	}


	@Override
	public Devis getDevisById(Integer id) {
		
		return devisRepository.findById(id).get();
	}

}
