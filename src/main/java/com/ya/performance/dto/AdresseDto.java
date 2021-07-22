package com.ya.performance.dto;

public class AdresseDto {

	Integer idAdresseDto;
	String numero;
	String rue;
	String voie;
	String ville;
	String codePostal;

	public AdresseDto() {

	}

	public AdresseDto(String numero,String voie, String ville, String codePostal) {
		super();
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public AdresseDto(Integer idadresseDto, String numero, String voie, String ville, String codePostal) {
		super();
		this.idAdresseDto = idadresseDto;
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	
	

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Integer getIdAdresseDto() {
		return idAdresseDto;
	}

	public void setIdAdresseDto(Integer idAdresseDto) {
		this.idAdresseDto = idAdresseDto;
	}

	@Override
	public String toString() {
		return "AdresseDto [idAdresseDto=" + idAdresseDto + ", numero=" + numero + ", rue=" + rue + ", voie=" + voie
				+ ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}

	
	
	

}
