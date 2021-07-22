package com.ya.performance.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ya.performance.entities.Prospect;
import com.ya.performance.exception.ResourceNotFoundException;
import com.ya.performance.repository.ProspectRepository;
import com.ya.performance.service.ProspectService;

@Service
@Transactional
public class ProspectServiceImpl implements ProspectService {

	@Autowired
	ProspectRepository repository;

	public Iterable<Prospect> getAllProspects() {
		return repository.findAll();
	}

	public Prospect createOrSaveProspect(Prospect p) {
		return repository.save(p);
	}

	public Prospect getProspectById(Integer id) {
		return repository.findById(id).get();
	}

	public Prospect updateProspect(Prospect updatedPros, Integer id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Prospect ID " + id + " not found");
		}
		return repository.findById(id).map(p -> {
			p.setProsNom(updatedPros.getProsNom());
			p.setProsPrenom(updatedPros.getProsPrenom());
			p.setProsMail(updatedPros.getProsMail());
			p.setProsPhone(updatedPros.getProsPhone());
			p.setProsSitFamilial(updatedPros.getProsSitFamilial());
			p.setProsPersCharge(updatedPros.getProsPersCharge());
			p.setProsRevenuRef(updatedPros.getProsRevenuRef());
			p.setProsLieuHab(updatedPros.getProsLieuHab());
			p.setProsVille(updatedPros.getProsVille());
			p.setProsCode(updatedPros.getProsCode());

			return repository.save(p);
		}).orElseThrow(() -> new ResourceNotFoundException("Prospect ID " + id + " not found"));
	}

	public ResponseEntity<?> deleteProspect(Integer id) {
		return repository.findById(id).map(pros -> {
			repository.delete(pros);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Prospect ID " + id + " not found"));
	}

}
