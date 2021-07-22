package com.ya.performance.dto;

import java.util.Date;

public class DevisDto {

	private Integer id;
	private Date dateCreation;
	private String numeroClient;
	private String intitule;
	private String reference;
	private String societe;
	private Integer idProspect;
	private Integer idSimulation;
	private Integer quantite;
	private Integer prixMateriel;
	private Integer prixMainOeuvre;
	private String designation;
	private String tvaMateriel;
	private String tvaMainOeuvre;
	
	
	
	
	public DevisDto() {
		// TODO Auto-generated constructor stub
	}


	public DevisDto(Integer id, Date dateCreation, String numeroClient, String intitule, String reference,
			String societe, Integer idProspect, Integer idSimulation, Integer quantite, Integer prixMateriel,
			Integer prixMainOeuvre, String designation, String tvaMateriel, String tvaMainOeuvre) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
		this.numeroClient = numeroClient;
		this.intitule = intitule;
		this.reference = reference;
		this.societe = societe;
		this.idProspect = idProspect;
		this.idSimulation = idSimulation;
		this.quantite = quantite;
		this.prixMateriel = prixMateriel;
		this.prixMainOeuvre = prixMainOeuvre;
		this.designation = designation;
		this.tvaMateriel = tvaMateriel;
		this.tvaMainOeuvre = tvaMainOeuvre;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Date getDateCreation() {
		return dateCreation;
	}




	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}




	public String getNumeroClient() {
		return numeroClient;
	}




	public void setNumeroClient(String numeroClient) {
		this.numeroClient = numeroClient;
	}




	public String getIntitule() {
		return intitule;
	}




	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}




	public String getReference() {
		return reference;
	}




	public void setReference(String reference) {
		this.reference = reference;
	}




	public String getSociete() {
		return societe;
	}




	public void setSociete(String societe) {
		this.societe = societe;
	}




	public Integer getIdProspect() {
		return idProspect;
	}




	public void setIdProspect(Integer idProspect) {
		this.idProspect = idProspect;
	}




	public Integer getQuantite() {
		return quantite;
	}




	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}




	public Integer getPrixMateriel() {
		return prixMateriel;
	}




	public void setPrixMateriel(Integer prixMateriel) {
		this.prixMateriel = prixMateriel;
	}




	public Integer getPrixMainOeuvre() {
		return prixMainOeuvre;
	}




	public void setPrixMainOeuvre(Integer prixMainOeuvre) {
		this.prixMainOeuvre = prixMainOeuvre;
	}




	public String getDesignation() {
		return designation;
	}




	public void setDesignation(String designation) {
		this.designation = designation;
	}




	public String getTvaMateriel() {
		return tvaMateriel;
	}




	public void setTvaMateriel(String tvaMateriel) {
		this.tvaMateriel = tvaMateriel;
	}




	public String getTvaMainOeuvre() {
		return tvaMainOeuvre;
	}




	public void setTvaMainOeuvre(String tvaMainOeuvre) {
		this.tvaMainOeuvre = tvaMainOeuvre;
	}


	public Integer getIdSimulation() {
		return idSimulation;
	}


	public void setIdSimulation(Integer idSimulation) {
		this.idSimulation = idSimulation;
	}


	@Override
	public String toString() {
		return "DevisDto [id=" + id + ", dateCreation=" + dateCreation + ", numeroClient=" + numeroClient
				+ ", intitule=" + intitule + ", reference=" + reference + ", societe=" + societe + ", idProspect="
				+ idProspect + ", idSimulation=" + idSimulation + ", quantite=" + quantite + ", prixMateriel="
				+ prixMateriel + ", prixMainOeuvre=" + prixMainOeuvre + ", designation=" + designation
				+ ", tvaMateriel=" + tvaMateriel + ", tvaMainOeuvre=" + tvaMainOeuvre + "]";
	}




	
	
	
	

}
