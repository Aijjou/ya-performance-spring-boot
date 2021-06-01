package com.ya.performance.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.ya.performance.entities.Prospect;
import com.ya.performance.service.ProspectService;

@RestController
@RequestMapping(value = "api/prospect-management", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProspectController {

	@Autowired
	private ProspectService repository;

	public ProspectService getRepository() {
		return repository;
	}

	public void setRepository(ProspectService repository) {
		this.repository = repository;
	}

	@GetMapping(value = "/prospects")
	@ResponseBody
	public List<Prospect> getAllPropsects() {
		List<Prospect> prospects = new ArrayList<>();
		Iterable<Prospect> allProspects = repository.getAllProspects();
		for(Prospect p : allProspects) {
			prospects.add(p);
		}
		System.out.println(prospects);
		return prospects;
	}

	@PostMapping(value = "/prospect")
	@ResponseBody
	Prospect createOrSaveProspect(@RequestBody Prospect newProspect) {
		return repository.createOrSaveProspect(newProspect);
	}

	@GetMapping(value = "/prospect/{id}")
	@ResponseBody
	Prospect getProspectById(@PathVariable Integer id) {
		return repository.getProspectById(id);
	}
	
	@PutMapping(value = "/prospect/{id}")
	@ResponseBody
	Prospect updateProspect(@RequestBody Prospect updatedPros, @PathVariable Integer id) {
		return repository.updateProspect(updatedPros, id);
	}
	
	
	@DeleteMapping(value = "/prospect/{id}")
	@ResponseBody
	ResponseEntity<?> deleteProspect(@PathVariable Integer id) {
		return repository.deleteProspect(id);
	}

}
