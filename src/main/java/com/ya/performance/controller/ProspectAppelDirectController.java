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
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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
	ResponseEntity<?> createDevis(@RequestBody DevisDto devisDto, Model model)
			throws FileNotFoundException, IOException, DocumentException, com.lowagie.text.DocumentException {
		System.err.println(devisDto);
		String target = "target/devis.pdf";
		String mailDestinataire = prospectService.getProspectById(devisDto.getIdProspect()).getProsMail();

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
		
		Integer totalHt = devis.getPrixMainOeuvre() + devis.getPrixMateriel();
		Double totalTva = totalHt * (1 + (devis.getTvaMainOeuvre()/100));
		Double tva = totalTva - totalHt;
		
		
		Devis devisCree = devisService.createDevis(devis);

		Map<String, Object> maps = new HashMap<>();
		maps.put("devis", devis);
		maps.put("tva", tva);
		maps.put("totalHt", totalHt);
		maps.put("totalTva", totalTva);

		Context context = new Context();
		context.setVariables(maps);
		String html = templateEngine.process("devis/test", context);

		OutputStream outputStream = new FileOutputStream(target);
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(html);
		renderer.layout();
		renderer.createPDF(outputStream);

		outputStream.close();

		SendAttachmentInEmail(target,mailDestinataire);
		
		
		return ResponseEntity.ok().contentType(null).body(null);

	}

	public void SendAttachmentInEmail(String target, String mail) {

		// Recipient's email ID needs to be mentioned.
		String to = mail;

		// Sender's email ID needs to be mentioned
		String from = "ya.performance59@gmail.com";

		final String username = "ya.performance59@gmail.com";// change accordingly
		final String password = "@yaperformance59";// change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Testing Subject");

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setText("This is message body");

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			String filename = target;
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
