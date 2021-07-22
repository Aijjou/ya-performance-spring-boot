package com.ya.performance.service;

import java.util.List;

import com.ya.performance.entities.Adresse;

public interface AdresseService {

	public Adresse create(Adresse adresse);

	public Adresse findById(Integer IdAdresse);

	public void deleteBydId(Integer idAdresse);

	public List<Adresse> getAllAdresse();

}
