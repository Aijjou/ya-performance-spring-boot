package com.ya.performance.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Prospect
 */

@Entity
@Table(name = "Prospect", catalog = "yaperf")
public class Prospect implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pros_id")
	private Integer prosId;

	@Column(name = "pros_civilite")
	private String prosCivilite;

	@Column(name = "pros_nom")
	private String prosNom;

	@Column(name = "pros_prenom")
	private String prosPrenom;

	@Column(name = "pros_mail")
	private String prosMail;

	@Column(name = "pros_phone")
	private String prosPhone;

	@Column(name = "pros_sit_familial")
	private String prosSitFamilial;

	@Column(name = "pros_pers_charge")
	private String prosPersCharge;

	@Column(name = "pros_revenu_ref")
	private String prosRevenuRef;

	@Column(name = "pros_lieu_hab")
	private String prosLieuHab;

	@Column(name = "pros_contact", columnDefinition = "TINYINT(1)")
	private Boolean prosContact;

	@Column(name = "pros_promo", columnDefinition = "TINYINT(1)")
	private Boolean prosPromo;

	@Column(name = "pros_condition", columnDefinition = "TINYINT(1)")
	private Boolean prosCondition;

	@Column(name = "pros_ville")
	private String prosVille;

	@Column(name = "pros_code")
	private String prosCode;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "prospect")
	private List<Simulation> simulations;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "prospect")
	private List<Devis> devis;

	public Prospect() {
	}

	public Prospect(String prosCivilite, String prosNom, String prosPrenom, String prosMail, String prosPhone,
			String prosSitFamilial, String prosPersCharge, String prosRevenuRef, String prosLieuHab,
			Boolean prosContact, Boolean prosPromo, Boolean prosCondition, String prosVille, String prosCode) {
		this.prosCivilite = prosCivilite;
		this.prosNom = prosNom;
		this.prosPrenom = prosPrenom;
		this.prosMail = prosMail;
		this.prosPhone = prosPhone;
		this.prosSitFamilial = prosSitFamilial;
		this.prosPersCharge = prosPersCharge;
		this.prosRevenuRef = prosRevenuRef;
		this.prosLieuHab = prosLieuHab;
		this.prosContact = prosContact;
		this.prosPromo = prosPromo;
		this.prosCondition = prosCondition;
		this.prosVille = prosVille;
		this.prosCode = prosCode;

	}

	public Prospect(Integer prosInteger, String prosCivilite, String prosNom, String prosPrenom, String prosMail,
			String prosPhone, String prosSitFamilial, String prosPersCharge, String prosRevenuRef, String prosLieuHab,
			Boolean prosContact, Boolean prosPromo, Boolean prosCondition, String prosVille, String prosCode) {
		this.prosId = prosInteger;
		this.prosCivilite = prosCivilite;
		this.prosNom = prosNom;
		this.prosPrenom = prosPrenom;
		this.prosMail = prosMail;
		this.prosPhone = prosPhone;
		this.prosSitFamilial = prosSitFamilial;
		this.prosPersCharge = prosPersCharge;
		this.prosRevenuRef = prosRevenuRef;
		this.prosLieuHab = prosLieuHab;
		this.prosContact = prosContact;
		this.prosPromo = prosPromo;
		this.prosCondition = prosCondition;
		this.prosVille = prosVille;
		this.prosCode = prosCode;

	}

	public Integer getProsId() {
		return this.prosId;
	}

	public void setProsId(Integer prosId) {
		this.prosId = prosId;
	}

	public String getProsCivilite() {
		return this.prosCivilite;
	}

	public void setProsCivilite(String prosCivilite) {
		this.prosCivilite = prosCivilite;
	}

	public String getProsNom() {
		return this.prosNom;
	}

	public void setProsNom(String prosNom) {
		this.prosNom = prosNom;
	}

	public String getProsPrenom() {
		return this.prosPrenom;
	}

	public void setProsPrenom(String prosPrenom) {
		this.prosPrenom = prosPrenom;
	}

	public String getProsMail() {
		return this.prosMail;
	}

	public void setProsMail(String prosMail) {
		this.prosMail = prosMail;
	}

	public String getProsPhone() {
		return this.prosPhone;
	}

	public void setProsPhone(String prosPhone) {
		this.prosPhone = prosPhone;
	}

	public String getProsSitFamilial() {
		return this.prosSitFamilial;
	}

	public void setProsSitFamilial(String prosSitFamilial) {
		this.prosSitFamilial = prosSitFamilial;
	}

	public String getProsPersCharge() {
		return this.prosPersCharge;
	}

	public void setProsPersCharge(String prosPersCharge) {
		this.prosPersCharge = prosPersCharge;
	}

	public String getProsRevenuRef() {
		return this.prosRevenuRef;
	}

	public void setProsRevenuRef(String prosRevenuRef) {
		this.prosRevenuRef = prosRevenuRef;
	}

	public String getProsLieuHab() {
		return this.prosLieuHab;
	}

	public void setProsLieuHab(String prosLieuHab) {
		this.prosLieuHab = prosLieuHab;
	}

	public Boolean getProsContact() {
		return this.prosContact;
	}

	public void setProsContact(Boolean prosContact) {
		this.prosContact = prosContact;
	}

	public Boolean getProsPromo() {
		return this.prosPromo;
	}

	public void setProsPromo(Boolean prosPromo) {
		this.prosPromo = prosPromo;
	}

	public Boolean getProsCondition() {
		return this.prosCondition;
	}

	public void setProsCondition(Boolean prosCondition) {
		this.prosCondition = prosCondition;
	}

	public String getProsVille() {
		return this.prosVille;
	}

	public void setProsVille(String prosVille) {
		this.prosVille = prosVille;
	}

	public String getProsCode() {
		return this.prosCode;
	}

	public void setProsCode(String prosCode) {
		this.prosCode = prosCode;
	}

	public List<Simulation> getSimulations() {
		return this.simulations;
	}

	public void setSimulations(List<Simulation> simulations) {
		this.simulations = simulations;
	}

	@Override
	public String toString() {
		return "Prospect [prosId=" + prosId + ", prosCivilite=" + prosCivilite + ", prosNom=" + prosNom
				+ ", prosPrenom=" + prosPrenom + ", prosMail=" + prosMail + ", prosPhone=" + prosPhone
				+ ", prosSitFamilial=" + prosSitFamilial + ", prosPersCharge=" + prosPersCharge + ", prosRevenuRef="
				+ prosRevenuRef + ", prosLieuHab=" + prosLieuHab + ", prosContact=" + prosContact + ", prosPromo="
				+ prosPromo + ", prosCondition=" + prosCondition + ", prosVille=" + prosVille + ", prosCode=" + prosCode
				+ ", simulations=" + simulations + "]";
	}

}
