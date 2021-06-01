package com.ya.performance.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Adresse
 */

@Entity
@Table(name = "Adresse", catalog = "yaperf")
public class Adresse implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "adr_id")
	private Integer adrId;
	
	@Column(name = "adr_num")
	private String adrNum;
	
	@Column(name = "adr_rue")
	private String adrRue;
	
	@Column(name = "adr_voie")
	private String adrVoie;
	
	@Column(name = "adr_ville")
	private String adrVille;
	
	@Column(name = "adr_cp")
	private String adrCp;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="adresse")
	private List<Simulation> simulations = new ArrayList<Simulation>();

	public Adresse() {
	}

	public Adresse(String adrNum, String adrRue, String adrVoie, String adrVille, String adrCp, List<Simulation> simulations) {
		this.adrNum = adrNum;
		this.adrRue = adrRue;
		this.adrVoie = adrVoie;
		this.adrVille = adrVille;
		this.adrCp = adrCp;
		this.simulations = simulations;
	}

	public Integer getAdrId() {
		return this.adrId;
	}

	public void setAdrId(Integer adrId) {
		this.adrId = adrId;
	}

	public String getAdrNum() {
		return this.adrNum;
	}

	public void setAdrNum(String adrNum) {
		this.adrNum = adrNum;
	}

	public String getAdrRue() {
		return this.adrRue;
	}

	public void setAdrRue(String adrRue) {
		this.adrRue = adrRue;
	}

	public String getAdrVoie() {
		return this.adrVoie;
	}

	public void setAdrVoie(String adrVoie) {
		this.adrVoie = adrVoie;
	}

	public String getAdrVille() {
		return this.adrVille;
	}

	public void setAdrVille(String adrVille) {
		this.adrVille = adrVille;
	}

	public String getAdrCp() {
		return this.adrCp;
	}

	public void setAdrCp(String adrCp) {
		this.adrCp = adrCp;
	}

	
	public List<Simulation> getSimulations() {
		return this.simulations;
	}

	public void setSimulations(List<Simulation> simulations) {
		this.simulations = simulations;
	}

}
