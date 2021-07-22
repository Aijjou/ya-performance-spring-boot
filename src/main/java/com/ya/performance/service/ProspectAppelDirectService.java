package com.ya.performance.service;

import java.util.List;

import com.ya.performance.entities.ProspectAppelDirect;

public interface ProspectAppelDirectService {
	
	
	
	public ProspectAppelDirect create(ProspectAppelDirect prospectAppelDirect);
	public List<ProspectAppelDirect> findAll();
	public void deleteByid(Integer idProspectAppelDirect);


}
