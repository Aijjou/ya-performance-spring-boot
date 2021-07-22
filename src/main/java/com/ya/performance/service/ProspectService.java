package com.ya.performance.service;

import org.springframework.http.ResponseEntity;

import com.ya.performance.entities.Prospect;

public interface ProspectService {
	
	public Iterable<Prospect> getAllProspects();
	
	
	public Prospect createOrSaveProspect(Prospect p);
	
	public Prospect getProspectById(Integer id);
	
	public Prospect updateProspect(Prospect updatedPros, Integer id) ;
	
	public ResponseEntity<?> deleteProspect(Integer id);
	
	
	
	
	
}
