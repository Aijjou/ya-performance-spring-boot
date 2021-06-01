package com.ya.performance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ya.performance.entities.Simulation;
import com.ya.performance.exception.ResourceNotFoundException;
import com.ya.performance.repository.SimulationRepository;

@RestController
@RequestMapping(value = "api/simulation-management", produces = { MediaType.APPLICATION_JSON_VALUE })
@ResponseBody
public class SimulationController {

	@Autowired
	private SimulationRepository repository;

	public SimulationRepository getRepository() {
		return repository;
	}

	public void setRepository(SimulationRepository repository) {
		this.repository = repository;
	}

	@GetMapping(value = "/simulations")
	public Iterable<Simulation> getAllSimulations() {
		return repository.findAll();
	}

	@PostMapping(value = "/simulation")
	Simulation createOrSaveSimulation(@PathVariable Simulation newSimulation) {
		return repository.save(newSimulation);
	}

	@GetMapping(value = "simualtion/{id}")
	Simulation getSimulationById(@PathVariable Integer id) {
		return repository.findById(id).get();
	}

	@PutMapping(value = "simualtion/{id}")
	Simulation updateSimulation(@RequestBody Simulation updatedSim, @PathVariable Integer id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Simulation ID " + id + " not found");
		}
		return repository.findById(id).map(p -> {
			p.setProspect(updatedSim.getProspect());
			p.setAdresse(updatedSim.getAdresse());
			p.setSimLogement(updatedSim.getSimLogement());
			p.setSimAnneeConst(updatedSim.getSimAnneeConst());
			p.setSimSurface(updatedSim.getSimSurface());
			p.setSimSurfIso(updatedSim.getSimSurfIso());
			p.setSimEquipeChauffage(updatedSim.getSimEquipeChauffage());
			p.setSimEnergie(updatedSim.getSimEnergie());
			p.setSimConso(updatedSim.getSimConso());
			p.setSimMatSouhaite(updatedSim.getSimMatSouhaite());
			p.setSimMontantMat(updatedSim.getSimMontantMat());
			p.setSimMontantPose(updatedSim.getSimMontantPose());
			p.setSimBenefTravaux(updatedSim.getSimBenefTravaux());
			return repository.save(p);
		}).orElseThrow(() -> new ResourceNotFoundException("Simulation ID " + id + " not found"));
	}

	@DeleteMapping(value = "simulation/{id}")
	ResponseEntity<?> deleteSimulation(@PathVariable Integer id) {
		return repository.findById(id).map(sim -> {
			repository.delete(sim);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Simulation ID " + id + " not found"));
	}

}
