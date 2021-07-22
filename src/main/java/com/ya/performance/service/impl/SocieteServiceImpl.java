package com.ya.performance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ya.performance.entities.Societe;
import com.ya.performance.repository.SocieteRepository;
import com.ya.performance.service.SocieteService;

@Service
public class SocieteServiceImpl implements SocieteService{

	@Autowired
	SocieteRepository societeRepository;
	
	
	@Override
	public Societe getSociete() {
		
		return societeRepository.findById(1).get();
	}

}
