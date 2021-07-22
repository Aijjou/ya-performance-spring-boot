package com.ya.performance.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lowagie.text.DocumentException;
import com.ya.performance.dto.DevisDto;
import com.ya.performance.entities.Devis;
import com.ya.performance.entities.ProspectAppelDirect;
import com.ya.performance.mail.Mail;
import com.ya.performance.mail.MailService;
import com.ya.performance.service.DevisService;
import com.ya.performance.service.ProspectAppelDirectService;
import com.ya.performance.service.ProspectService;
import com.ya.performance.service.SimulationService;
import com.ya.performance.service.SocieteService;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class ProspectAppelDirectController {

	@Autowired
	ProspectAppelDirectService prospectAppelDirectService;

	@Autowired
	ProspectService prospectService;

	@Autowired
	SocieteService societeService;

	@Autowired
	SimulationService simulationService;

	@Autowired
	MailService mailService;
	
	@Autowired
	DevisService devisService;
	
	 @Autowired
	    private org.thymeleaf.spring5.SpringTemplateEngine templateEngine;

	@RequestMapping(value = "/prospectappel", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<ProspectAppelDirect> createOrSaveSimulation(@RequestBody ProspectAppelDirect prospectAppelDirect)
			throws JsonMappingException, JsonProcessingException, MessagingException {
		System.err.println(prospectAppelDirect);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		prospectAppelDirect.setDemandeDate(date);
		ProspectAppelDirect prospectAppelDirect2 = prospectAppelDirectService.create(prospectAppelDirect);
		System.err.println("[prospectAppelDirect] : " + prospectAppelDirect2);

		Map<String, Object> maps = new HashMap<>();
		maps.put("utilisateur", prospectAppelDirect2);

		Mail mail = new Mail();
		mail.setFrom("postmaster@mg.iteacode.com");
		mail.setSubject("Demande Appel Prospect");
		mail.setTo("ya.performance59@gmail.com");
		mail.setModel(maps);
		System.err.println(mail);
		mailService.sendEmail(mail);

		return ResponseEntity.status(HttpStatus.CREATED).body(prospectAppelDirect2);
	}

	@RequestMapping(value = "/devis", method = RequestMethod.POST)
	ResponseEntity<?> createDevis(@RequestBody DevisDto devisDto, Model model) throws FileNotFoundException, IOException, DocumentException, com.lowagie.text.DocumentException {
		System.err.println(devisDto);

		Devis devis = new Devis();

		String numeroString = RandomStringUtils.randomAlphanumeric(10).toUpperCase();

		devis.setDateCreation(new Date(System.currentTimeMillis()));
		devis.setReference(numeroString);
		devis.setIntitule("Travaux de renovation energetique " + devisDto.getDesignation());
		devis.setSociete(societeService.getSociete());
		devis.setProspect(prospectService.getProspectById(devisDto.getIdProspect()));
		devis.setQuantite(1);
		devis.setPrixMateriel(devisDto.getPrixMateriel());
		devis.setPrixMainOeuvre(devisDto.getPrixMainOeuvre());
		devis.setNumeroclient(devisDto.getIdProspect());
		devis.setTvaMainOeuvre(5.5);
		devis.setTvaMateriel(5.5);
		devis.setSimulation(simulationService.findById(devisDto.getIdSimulation()));
		devis.setDesignation(devisDto.getDesignation());
		Devis devisCree = devisService.createDevis(devis);
		
//		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//		templateResolver.setSuffix(".html");
//		templateResolver.setTemplateMode("HTML");
//		 
//		TemplateEngine templateEngine = new TemplateEngine();
//		templateEngine.setTemplateResolver(templateResolver);
		
		Map<String, Object> maps = new HashMap<>();
		maps.put("devis", devis);
		
		Context context = new Context();
        context.setVariables(maps);
        String html = templateEngine.process("devis/test", context);
        
//        Document document = new Document(PageSize.LETTER);
//        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("target/html.pdf"));
//        document.open();
//        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
//          new FileInputStream(html));
//        document.close();
//        
//        
//		
//		
//
//        return ResponseEntity.ok().contentType(null).body(null);
        

 
      OutputStream outputStream = new FileOutputStream("target/devis.pdf");
      ITextRenderer renderer = new ITextRenderer();
      renderer.setDocumentFromString(html);
      renderer.layout();
      renderer.createPDF(outputStream);
   
      outputStream.close();
     
        return ResponseEntity.ok()
                .contentType(null)
                .body(null);

	}


}
