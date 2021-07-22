package com.ya.performance.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Simulation 
 */


@Entity
@Table(name="Simulation", catalog = "yaperf")
public class Simulation implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "sim_id")
	private Integer id;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="adresse_adr_id", nullable=false)
	private Adresse adresse;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="prospect_pros_id", nullable=false)
	private Prospect prospect;
	
	@Column(name = "sim_logement")
	private String simLogement;
	
	@Column(name = "sim_annee_const")
	private String simAnneeConst;
	
	@Column(name = "sim_surface")
	private Integer simSurface;
	
	@Column(name = "sim_surf_iso")
	private Integer simSurfIso;
	
	@Column(name = "sim_equipe_chauffage")
	private String simEquipeChauffage;
	
	@Column(name = "sim_energie")
	private String simEnergie;
	
	@Column(name = "sim_conso")
	private Integer simConso;
	
	@Column(name = "sim_mat_souhaite")
	private String simMatSouhaite;
	
	@Column(name = "sim_montant_mat")
	private String simMontantMat;
	
	@Column(name = "sim_montant_pose")
	private String simMontantPose;
	
	@Column(name = "sim_benef_travaux")
	private String simBenefTravaux;
	
	@Transient
	@OneToOne(mappedBy= "simulation")
	private Devis devis;

	public Simulation() {
	}

	public Simulation(Integer id, Adresse adresse, Prospect prospect) {
		this.id = id;
		this.adresse = adresse;
		this.prospect = prospect;
	}

	public Simulation(Integer id, Adresse adresse, Prospect prospect, 
			String simLogement, String simAnneeConst,
			Integer simSurface, Integer simSurfIso, 
			String simEquipeChauffage, String simEnergie,
			Integer simConso,
			String simMatSouhaite, String simMontantMat, 
			String simMontantPose, String simBenefTravaux) {
		this.id = id;
		this.adresse = adresse;
		this.prospect = prospect;
		this.simLogement = simLogement;
		this.simAnneeConst = simAnneeConst;
		this.simSurface = simSurface;
		this.simSurfIso = simSurfIso;
		this.simEquipeChauffage = simEquipeChauffage;
		this.simEnergie = simEnergie;
		this.simConso = simConso;
		this.simMatSouhaite = simMatSouhaite;
		this.simMontantMat = simMontantMat;
		this.simMontantPose = simMontantPose;
		this.simBenefTravaux = simBenefTravaux;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Prospect getProspect() {
		return this.prospect;
	}

	public void setProspect(Prospect prospect) {
		this.prospect = prospect;
	}

	public String getSimLogement() {
		return this.simLogement;
	}

	public void setSimLogement(String simLogement) {
		this.simLogement = simLogement;
	}

	public String getSimAnneeConst() {
		return this.simAnneeConst;
	}

	public void setSimAnneeConst(String simAnneeConst) {
		this.simAnneeConst = simAnneeConst;
	}

	public Integer getSimSurface() {
		return this.simSurface;
	}

	public void setSimSurface(Integer simSurface) {
		this.simSurface = simSurface;
	}

	public Integer getSimSurfIso() {
		return this.simSurfIso;
	}

	public void setSimSurfIso(Integer simSurfIso) {
		this.simSurfIso = simSurfIso;
	}

	public String getSimEquipeChauffage() {
		return this.simEquipeChauffage;
	}

	public void setSimEquipeChauffage(String simEquipeChauffage) {
		this.simEquipeChauffage = simEquipeChauffage;
	}

	public String getSimEnergie() {
		return this.simEnergie;
	}

	public void setSimEnergie(String simEnergie) {
		this.simEnergie = simEnergie;
	}

	public Integer getSimConso() {
		return this.simConso;
	}

	public void setSimConso(Integer simConso) {
		this.simConso = simConso;
	}

	public String getSimMatSouhaite() {
		return this.simMatSouhaite;
	}

	public void setSimMatSouhaite(String simMatSouhaite) {
		this.simMatSouhaite = simMatSouhaite;
	}

	public String getSimMontantMat() {
		return this.simMontantMat;
	}

	public void setSimMontantMat(String simMontantMat) {
		this.simMontantMat = simMontantMat;
	}

	public String getSimMontantPose() {
		return this.simMontantPose;
	}

	public void setSimMontantPose(String simMontantPose) {
		this.simMontantPose = simMontantPose;
	}

	public String getSimBenefTravaux() {
		return this.simBenefTravaux;
	}

	public void setSimBenefTravaux(String simBenefTravaux) {
		this.simBenefTravaux = simBenefTravaux;
	}

	@Override
	public String toString() {
		return "Simulation [id=" + id + ", adresse=" + adresse + ", prospect=" + prospect + ", simLogement="
				+ simLogement + ", simAnneeConst=" + simAnneeConst + ", simSurface=" + simSurface + ", simSurfIso="
				+ simSurfIso + ", simEquipeChauffage=" + simEquipeChauffage + ", simEnergie=" + simEnergie
				+ ", simConso=" + simConso + ", simMatSouhaite=" + simMatSouhaite + ", simMontantMat=" + simMontantMat
				+ ", simMontantPose=" + simMontantPose + ", simBenefTravaux=" + simBenefTravaux + "]";
	}
	
	

}
