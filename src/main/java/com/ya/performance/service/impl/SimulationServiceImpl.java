package com.ya.performance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ya.performance.entities.Simulation;
import com.ya.performance.repository.SimulationRepository;
import com.ya.performance.service.SimulationService;

@Service
public class SimulationServiceImpl implements SimulationService {

	@Autowired
	SimulationRepository simulationReposotory;

	@Override
	public Simulation create(Simulation simulation) {

		return simulationReposotory.save(simulation);
	}

	@Override
	public Simulation findById(Integer idSimulation) {

		return simulationReposotory.findById(idSimulation).get();
	}

	@Override
	public void deleteById(Integer idSimulation) {
		simulationReposotory.deleteById(idSimulation);

	}

	public List<Simulation> findAllSimulation() {
		
		return (List<Simulation>) simulationReposotory.findAll();
	}

}
