package com.ya.performance.service;

import java.util.List;

import com.ya.performance.entities.Simulation;

public interface SimulationService {

	
	
	public Simulation create(Simulation simulation);
	public Simulation findById(Integer idSimulation);
	public void deleteById(Integer idSimulation);
	public List<Simulation> findAllSimulation();
	
	
	
}


