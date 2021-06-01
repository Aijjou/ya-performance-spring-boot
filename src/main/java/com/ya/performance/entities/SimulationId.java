package com.ya.performance.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * SimulationId 
 */
@Entity
public class SimulationId implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	private int simId;
	private int prospectProsId;
	private int adresseAdrId;

	public SimulationId() {
	}

	public SimulationId(int simId, int prospectProsId, int adresseAdrId) {
		this.simId = simId;
		this.prospectProsId = prospectProsId;
		this.adresseAdrId = adresseAdrId;
	}

	public int getSimId() {
		return this.simId;
	}

	public void setSimId(int simId) {
		this.simId = simId;
	}

	public int getProspectProsId() {
		return this.prospectProsId;
	}

	public void setProspectProsId(int prospectProsId) {
		this.prospectProsId = prospectProsId;
	}

	public int getAdresseAdrId() {
		return this.adresseAdrId;
	}

	public void setAdresseAdrId(int adresseAdrId) {
		this.adresseAdrId = adresseAdrId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SimulationId))
			return false;
		SimulationId castOther = (SimulationId) other;

		return (this.getSimId() == castOther.getSimId()) && (this.getProspectProsId() == castOther.getProspectProsId())
				&& (this.getAdresseAdrId() == castOther.getAdresseAdrId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getSimId();
		result = 37 * result + this.getProspectProsId();
		result = 37 * result + this.getAdresseAdrId();
		return result;
	}

}
