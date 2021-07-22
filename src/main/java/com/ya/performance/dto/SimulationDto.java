package com.ya.performance.dto;

import com.ya.performance.entities.Adresse;

public class SimulationDto {

	Integer id;
	String typeLogement;
	String anneeConstruction;
	Integer surface;
	Integer surfaceIsolation;
	String equipeChauffage;
	String energie;
	Integer conso;
	String materielSouhaite;
	String montantEstimeMat;
	String montantEstimePose;
	String beneficiaireTravaux;

	public SimulationDto() {

	}

	public SimulationDto(Integer id, String typeLogement, String anneeConstruction, Integer surface,
			Integer surfaceIsolation, String equipeChauffage, String energie, Integer conso, Adresse adresseTravaux,
			String materielSouhaite, String montantEstimeMat, String montantEstimePose, String beneficiaireTravaux,
			ProspectDto prospectDto) {
		super();
		this.id = id;
		this.typeLogement = typeLogement;
		this.anneeConstruction = anneeConstruction;
		this.surface = surface;
		this.surfaceIsolation = surfaceIsolation;
		this.equipeChauffage = equipeChauffage;
		this.energie = energie;
		this.conso = conso;

		this.materielSouhaite = materielSouhaite;
		this.montantEstimeMat = montantEstimeMat;
		this.montantEstimePose = montantEstimePose;
		this.beneficiaireTravaux = beneficiaireTravaux;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeLogement() {
		return typeLogement;
	}

	public void setTypeLogement(String typeLogement) {
		this.typeLogement = typeLogement;
	}

	public String getAnneeConstruction() {
		return anneeConstruction;
	}

	public void setAnneeConstruction(String anneeConstruction) {
		this.anneeConstruction = anneeConstruction;
	}

	public Integer getSurface() {
		return surface;
	}

	public void setSurface(Integer surface) {
		this.surface = surface;
	}

	public Integer getSurfaceIsolation() {
		return surfaceIsolation;
	}

	public void setSurfaceIsolation(Integer surfaceIsolation) {
		this.surfaceIsolation = surfaceIsolation;
	}

	public String getEquipeChauffage() {
		return equipeChauffage;
	}

	public void setEquipeChauffage(String equipeChauffage) {
		this.equipeChauffage = equipeChauffage;
	}

	public String getEnergie() {
		return energie;
	}

	public void setEnergie(String energie) {
		this.energie = energie;
	}

	public Integer getConso() {
		return conso;
	}

	public void setConso(Integer conso) {
		this.conso = conso;
	}

	public String getMaterielSouhaite() {
		return materielSouhaite;
	}

	public void setMaterielSouhaite(String materielSouhaite) {
		this.materielSouhaite = materielSouhaite;
	}

	public String getMontantEstimeMat() {
		return montantEstimeMat;
	}

	public void setMontantEstimeMat(String montantEstimeMat) {
		this.montantEstimeMat = montantEstimeMat;
	}

	public String getMontantEstimePose() {
		return montantEstimePose;
	}

	public void setMontantEstimePose(String montantEstimePose) {
		this.montantEstimePose = montantEstimePose;
	}

	public String getBeneficiaireTravaux() {
		return beneficiaireTravaux;
	}

	public void setBeneficiaireTravaux(String beneficiaireTravaux) {
		this.beneficiaireTravaux = beneficiaireTravaux;
	}

	@Override
	public String toString() {
		return "SimulationDto [id=" + id + ", typeLogement=" + typeLogement + ", anneeConstruction=" + anneeConstruction
				+ ", surface=" + surface + ", surfaceIsolation=" + surfaceIsolation + ", equipeChauffage="
				+ equipeChauffage + ", energie=" + energie + ", conso=" + conso + ", materielSouhaite="
				+ materielSouhaite + ", montantEstimeMat=" + montantEstimeMat + ", montantEstimePose="
				+ montantEstimePose + ", beneficiaireTravaux=" + beneficiaireTravaux + "]";
	}

}
