package com.ya.performance.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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

@Entity
@Table(name = "Devis", catalog = "yaperf")
public class Devis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date dateCreation;
	private Integer numeroclient;
	private String intitule;
	private String reference;
	private Societe societe;
	private Prospect prospect;
	private Simulation simulation;
	private Integer quantite;
	private Integer prixMateriel;
	private Integer prixMainOeuvre;
	private String designation;
	private Double tvaMateriel;
	private Double tvaMainOeuvre;

	public Devis() {
		// TODO Auto-generated constructor stub
	}

	public Devis(Integer id, Date dateCreation, Integer numeroclient, String intitule, String reference,
			Societe societe, Prospect prospect, Simulation simulation, Integer quantite, Integer prixMateriel,
			Integer prixMainOeuvre, String designation, Double tvaMateriel, Double tvaMainOeuvre) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
		this.numeroclient = numeroclient;
		this.intitule = intitule;
		this.reference = reference;
		this.societe = societe;
		this.prospect = prospect;
		this.simulation = simulation;
		this.quantite = quantite;
		this.prixMateriel = prixMateriel;
		this.prixMainOeuvre = prixMainOeuvre;
		this.designation = designation;
		this.tvaMateriel = tvaMateriel;
		this.tvaMainOeuvre = tvaMainOeuvre;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "date_creation")
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Column(name = "numero_client")
	public Integer getNumeroclient() {
		return numeroclient;
	}

	public void setNumeroclient(Integer numeroclient) {
		this.numeroclient = numeroclient;
	}

	@Column(name = "intitule")
	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	@Column(name = "reference")
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_societe", referencedColumnName = "id")
	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_prospect", nullable = true)
	public Prospect getProspect() {
		return prospect;
	}

	public void setProspect(Prospect prospect) {
		this.prospect = prospect;
	}


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_simulation", referencedColumnName = "sim_id")
	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}
	
	@Column(name = "quantite")
	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	@Column(name = "prix_materiel")
	public Integer getPrixMateriel() {
		return prixMateriel;
	}

	public void setPrixMateriel(Integer prixMateriel) {
		this.prixMateriel = prixMateriel;
	}

	@Column(name = "prix_main_oeuvre")
	public Integer getPrixMainOeuvre() {
		return prixMainOeuvre;
	}

	public void setPrixMainOeuvre(Integer prixMainOeuvre) {
		this.prixMainOeuvre = prixMainOeuvre;
	}

	@Column(name = "designation")
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name = "tva_materiel")
	public Double getTvaMateriel() {
		return tvaMateriel;
	}

	public void setTvaMateriel(Double tvaMateriel) {
		this.tvaMateriel = tvaMateriel;
	}

	@Column(name = "tva_main_oeuvre")
	public Double getTvaMainOeuvre() {
		return tvaMainOeuvre;
	}

	public void setTvaMainOeuvre(Double tvaMainOeuvre) {
		this.tvaMainOeuvre = tvaMainOeuvre;
	}

	

	@Override
	public String toString() {
		return "Devis [id=" + id + ", dateCreation=" + dateCreation + ", numeroclient=" + numeroclient + ", intitule="
				+ intitule + ", reference=" + reference + ", societe=" + societe + ", prospect=" + prospect
				+  ", quantite=" + quantite + ", prixMateriel=" + prixMateriel
				+ ", prixMainOeuvre=" + prixMainOeuvre + ", designation=" + designation + ", tvaMateriel=" + tvaMateriel
				+ ", tvaMainOeuvre=" + tvaMainOeuvre + "]";
	}

}
