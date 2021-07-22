package com.ya.performance.dto;

public class ProspectDto {

	Integer id;
	String civilite;
	String nom;
	String prenom;
	String mail;
	String phone;
	String ville;
	String code;
	String situationFamilliale;
	String personneCharge;
	String revenuRef;
	String lieuHabitation;
	Boolean contactConseiller;
	Boolean promo;
	Boolean condition;
	
	
	public ProspectDto() {
		
	}


	public ProspectDto(Integer id, String civilite, String nom, String prenom, String mail, String phone, String ville,
			String code, String situationFamilliale, String personneCharge, String revenuRef, String lieuHabitation,
			Boolean contactConseiller, Boolean promo, Boolean condition) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.phone = phone;
		this.ville = ville;
		this.code = code;
		this.situationFamilliale = situationFamilliale;
		this.personneCharge = personneCharge;
		this.revenuRef = revenuRef;
		this.lieuHabitation = lieuHabitation;
		this.contactConseiller = contactConseiller;
		this.promo = promo;
		this.condition = condition;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCivilite() {
		return civilite;
	}


	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getSituationFamilliale() {
		return situationFamilliale;
	}


	public void setSituationFamilliale(String situationFamilliale) {
		this.situationFamilliale = situationFamilliale;
	}


	public String getPersonneCharge() {
		return personneCharge;
	}


	public void setPersonneCharge(String personneCharge) {
		this.personneCharge = personneCharge;
	}


	public String getRevenuRef() {
		return revenuRef;
	}


	public void setRevenuRef(String revenuRef) {
		this.revenuRef = revenuRef;
	}


	public String getLieuHabitation() {
		return lieuHabitation;
	}


	public void setLieuHabitation(String lieuHabitation) {
		this.lieuHabitation = lieuHabitation;
	}


	public Boolean getContactConseiller() {
		return contactConseiller;
	}


	public void setContactConseiller(Boolean contactConseiller) {
		this.contactConseiller = contactConseiller;
	}


	public Boolean getPromo() {
		return promo;
	}


	public void setPromo(Boolean promo) {
		this.promo = promo;
	}


	public Boolean getCondition() {
		return condition;
	}


	public void setCondition(Boolean condition) {
		this.condition = condition;
	}


	@Override
	public String toString() {
		return "ProspectDto [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", mail="
				+ mail + ", phone=" + phone + ", ville=" + ville + ", code=" + code + ", situationFamilliale="
				+ situationFamilliale + ", personneCharge=" + personneCharge + ", revenuRef=" + revenuRef
				+ ", lieuHabitation=" + lieuHabitation + ", contactConseiller=" + contactConseiller + ", promo=" + promo
				+ ", condition=" + condition + "]";
	}
	
	
	
	

}
