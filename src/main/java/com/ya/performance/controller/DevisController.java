package com.ya.performance.controller;

import java.text.DecimalFormat;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ya.performance.dto.DevisDto;
import com.ya.performance.entities.Devis;
import com.ya.performance.service.DevisService;
import com.ya.performance.service.ProspectAppelDirectService;
import com.ya.performance.service.ProspectService;
import com.ya.performance.service.SimulationService;
import com.ya.performance.service.SocieteService;

@Controller
public class DevisController {

	@Autowired
	ProspectService prospectService;

	@Autowired
	SocieteService societeService;

	@Autowired
	SimulationService simulationService;

	@Autowired
	DevisService devisService;

	
	@RequestMapping(value = "devis/devis/{id}", method = RequestMethod.GET)
	public String getDevis(Model model, @PathVariable("id") Integer id) {

		Devis devis = devisService.getDevisById(id);
		
		Integer totalHt = devis.getPrixMainOeuvre() + devis.getPrixMateriel();
		Double totalTva = totalHt * (1 + (devis.getTvaMainOeuvre()/100));
		Double tva = totalTva - totalHt;
		
		model.addAttribute("totalHt", totalHt);
		model.addAttribute("totalTva", totalTva);
		model.addAttribute("tva", tva);
		model.addAttribute("devis", devis);

		return "devis/devis";
	}
	
	@RequestMapping(value = "devis/test", method = RequestMethod.GET)
	public String test(Model model) {

	

		return "devis/test";
	}

	


}
