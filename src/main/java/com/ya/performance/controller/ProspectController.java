package com.ya.performance.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ya.performance.dto.ProspectDto;
import com.ya.performance.entities.Prospect;
import com.ya.performance.service.ProspectService;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class ProspectController {

	@Autowired
	private ProspectService repository;

	public ProspectService getRepository() {
		return repository;
	}

	public void setRepository(ProspectService repository) {
		this.repository = repository;
	}

	@RequestMapping(value = "/prospects", method = RequestMethod.GET)
	public List<Prospect> getAllPropsects() {
		List<Prospect> prospects = new ArrayList<>();
		Iterable<Prospect> allProspects = repository.getAllProspects();
		for (Prospect p : allProspects) {
			prospects.add(p);
		}
		System.out.println(prospects);
		return prospects;
	}

	@RequestMapping(value = "/prospect/{id}/formulaire", method = RequestMethod.POST)
	ProspectDto createOrSaveProspect(@RequestBody ProspectDto prospectDto, @PathVariable("id") Integer idInteger) {

		System.out.println("prospect " + prospectDto);

		Prospect prospect = new Prospect(prospectDto.getCivilite(), prospectDto.getNom(), prospectDto.getPrenom(),
				prospectDto.getMail(), prospectDto.getPhone(), null, null, null, null,
				prospectDto.getContactConseiller(), prospectDto.getPromo(), prospectDto.getCondition(),
				prospectDto.getVille(), prospectDto.getCode());

		Prospect prospect2 = repository.createOrSaveProspect(prospect);
		prospectDto.setId(prospect2.getProsId());
		System.err.println("prospectDto  " + prospectDto);
		System.err.println("prospect2  " + prospect2);

		return prospectDto;

	}

	@GetMapping(value = "/prospect/{id}")
	Prospect getProspectById(@PathVariable Integer id) {
		return repository.getProspectById(id);
	}

	@PutMapping(value = "/prospect/{id}")
	Prospect updateProspect(@RequestBody Prospect updatedPros, @PathVariable Integer id) {
		return repository.updateProspect(updatedPros, id);
	}

	@DeleteMapping(value = "/prospect/{id}")
	ResponseEntity<?> deleteProspect(@PathVariable Integer id) {
		return repository.deleteProspect(id);
	}

}
