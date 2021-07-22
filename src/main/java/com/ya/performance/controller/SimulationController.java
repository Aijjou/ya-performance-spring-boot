package com.ya.performance.controller;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ya.performance.dto.AdresseDto;
import com.ya.performance.dto.ProspectDto;
import com.ya.performance.dto.SimulationDto;
import com.ya.performance.entities.Adresse;
import com.ya.performance.entities.Prospect;
import com.ya.performance.entities.Simulation;
import com.ya.performance.exception.ResourceNotFoundException;
import com.ya.performance.repository.SimulationRepository;
import com.ya.performance.service.AdresseService;
import com.ya.performance.service.ProspectService;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class SimulationController {

	@Autowired
	private SimulationRepository repository;

	public SimulationRepository getRepository() {
		return repository;
	}

	@Autowired
	private ProspectService repositoryPropsect;

	public ProspectService getRepsotorySimulation() {
		return repositoryPropsect;
	}

	@Autowired
	public AdresseService adresseService;

	@GetMapping(value = "/simulations")
	public Iterable<Simulation> getAllSimulations() {
		return repository.findAll();
	}

	@RequestMapping(value = "/simulation/{id}/creation", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<Simulation> createOrSaveSimulation(@RequestBody SimulationDto simulationDto,
			@RequestParam(value = "prospect", required = false) String pros,
			@RequestParam(value = "adresse", required = false) String adresse, @PathVariable("id") Integer idInteger)
			throws JsonMappingException, JsonProcessingException {

		ProspectDto prospectDto = new ObjectMapper().readValue(pros, ProspectDto.class);

		System.err.println("prospectDto " + prospectDto.getId());
		
		Prospect prospect = new Prospect(prospectDto.getId(), prospectDto.getCivilite(), prospectDto.getNom(),
				prospectDto.getPrenom(), prospectDto.getMail(), prospectDto.getPhone(),
				prospectDto.getSituationFamilliale(), prospectDto.getPersonneCharge(), prospectDto.getRevenuRef(),
				prospectDto.getLieuHabitation(), prospectDto.getContactConseiller(), prospectDto.getPromo(),
				prospectDto.getCondition(), prospectDto.getVille(), prospectDto.getCode());

		System.err.println("prospect Id  " + prospect.getProsId());
		
		Prospect prospect2 = repositoryPropsect.createOrSaveProspect(prospect);

		System.err.println( "prospect  " + prospect2);
		AdresseDto adresseDto = new ObjectMapper().readValue(adresse, AdresseDto.class);

		Adresse adresse1 = new Adresse(adresseDto.getIdAdresseDto(), adresseDto.getNumero(), adresseDto.getVoie(),
				adresseDto.getVille(), adresseDto.getCodePostal(), null);

		Adresse adresse2 = adresseService.create(adresse1);

		Simulation simulation = new Simulation(null, adresse2, prospect2, simulationDto.getTypeLogement(),
				simulationDto.getAnneeConstruction(), simulationDto.getSurface(), simulationDto.getSurfaceIsolation(),
				simulationDto.getEquipeChauffage(), simulationDto.getEnergie(), simulationDto.getConso(),
				simulationDto.getMaterielSouhaite(), simulationDto.getMontantEstimeMat(),
				simulationDto.getMontantEstimePose(), simulationDto.getBeneficiaireTravaux());

		Simulation simulation2 = repository.save(simulation);
		System.err.println("[prospect] : " + prospectDto);
		System.err.println("[adresse] : " + adresse1);
		System.err.println("[prospect after simul] : " + simulation2.getId());

	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(simulation2);
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
