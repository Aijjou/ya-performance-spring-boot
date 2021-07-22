package com.ya.performance.entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prospect_appel_direct", catalog = "yaperf")
public class ProspectAppelDirect {

	private Integer id;
	private String civilite;
	private String nom;
	private String telephone;
	private Boolean isChaudiere;
	private Boolean isSolaire;
	private Boolean isDivers;
	private Boolean isIsolation;
	private Boolean isAppel;
	private Boolean isMessagerie;
	private Boolean isRdv;
	private Boolean isPasInteresse;
	private Date demandeDate;

	public ProspectAppelDirect() {
	}

	public ProspectAppelDirect(Integer id, String nom, String telephone, Boolean isChaudiere, Boolean isSolaire,
			Boolean isDivers, Boolean isIsolation, Boolean isAppel, Boolean isMessagerie, Boolean isRdv,
			Boolean isPasInteresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.telephone = telephone;
		this.isChaudiere = isChaudiere;
		this.isSolaire = isSolaire;
		this.isDivers = isDivers;
		this.isIsolation = isIsolation;
		this.isAppel = isAppel;
		this.isMessagerie = isMessagerie;
		this.isRdv = isRdv;
		this.isPasInteresse = isPasInteresse;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prospect_appel_direct")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nom")
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "telephone")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "is_chaudiere")
	public Boolean getIsChaudiere() {
		return isChaudiere;
	}

	public void setIsChaudiere(Boolean isChaudiere) {
		this.isChaudiere = isChaudiere;
	}

	@Column(name = "is_solaire")
	public Boolean getIsSolaire() {
		return isSolaire;
	}

	public void setIsSolaire(Boolean isSolaire) {
		this.isSolaire = isSolaire;
	}

	@Column(name = "is_divers")
	public Boolean getIsDivers() {
		return isDivers;
	}

	public void setIsDivers(Boolean isDivers) {
		this.isDivers = isDivers;
	}

	@Column(name = "is_isolation")
	public Boolean getIsIsolation() {
		return isIsolation;
	}

	public void setIsIsolation(Boolean isIsolation) {
		this.isIsolation = isIsolation;
	}

	@Column(name = "is_appel")
	public Boolean getIsAppel() {
		return isAppel;
	}

	public void setIsAppel(Boolean isAppel) {
		this.isAppel = isAppel;
	}

	@Column(name = "is_messagerie")
	public Boolean getIsMessagerie() {
		return isMessagerie;
	}

	public void setIsMessagerie(Boolean isMessagerie) {
		this.isMessagerie = isMessagerie;
	}

	@Column(name = "is_rdv")
	public Boolean getIsRdv() {
		return isRdv;
	}

	public void setIsRdv(Boolean isRdv) {
		this.isRdv = isRdv;
	}

	@Column(name = "is_pas_interesse")
	public Boolean getIsPasInteresse() {
		return isPasInteresse;
	}

	public void setIsPasInteresse(Boolean isPasInteresse) {
		this.isPasInteresse = isPasInteresse;
	}
	
	@Column(name = "date_demande")
	public Date getDemandeDate() {
		return demandeDate;
	}

	public void setDemandeDate(Date date) {
		this.demandeDate = date;
	}
	
	@Column(name = "civilite")
	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	@Override
	public String toString() {
		return "ProspectAppelDirect [id=" + id + ", nom=" + nom + ", telephone=" + telephone + ", isChaudiere="
				+ isChaudiere + ", isSolaire=" + isSolaire + ", isDivers=" + isDivers + ", isIsolation=" + isIsolation
				+ ", isAppel=" + isAppel + ", isMessagerie=" + isMessagerie + ", isRdv=" + isRdv + ", isPasInteresse="
				+ isPasInteresse + "]";
	}

}
