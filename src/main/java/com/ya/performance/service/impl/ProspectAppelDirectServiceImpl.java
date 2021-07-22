package com.ya.performance.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ya.performance.entities.ProspectAppelDirect;
import com.ya.performance.repository.ProspectAppelDirectRespository;
import com.ya.performance.service.ProspectAppelDirectService;

@Service
@Transactional
public class ProspectAppelDirectServiceImpl implements ProspectAppelDirectService {

	@Autowired
	ProspectAppelDirectRespository prospectAppelDirectRepository;

	@Override
	public ProspectAppelDirect create(ProspectAppelDirect prospectAppelDirect) {

		return prospectAppelDirectRepository.save(prospectAppelDirect);
	}

	@Override
	public List<ProspectAppelDirect> findAll() {

		return (List<ProspectAppelDirect>) prospectAppelDirectRepository.findAll();
	}

	@Override
	public void deleteByid(Integer idProspectAppelDirect) {
		prospectAppelDirectRepository.deleteById(idProspectAppelDirect);

	}

}
