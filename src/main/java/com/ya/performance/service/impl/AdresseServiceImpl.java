package com.ya.performance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ya.performance.entities.Adresse;
import com.ya.performance.repository.AdresseRepository;
import com.ya.performance.service.AdresseService;

@Service
public class AdresseServiceImpl implements AdresseService {

	@Autowired
	AdresseRepository adresseRepository;

	@Override
	public Adresse create(Adresse adresse) {

		return adresseRepository.save(adresse);
	}

	@Override
	public Adresse findById(Integer idAdresse) {

		return adresseRepository.findById(idAdresse).get();
	}

	@Override
	public void deleteBydId(Integer idAdresse) {
		adresseRepository.deleteById(idAdresse);

	}

	@Override
	public List<Adresse> getAllAdresse() {
		
		return (List<Adresse>) adresseRepository.findAll();
	}

}
