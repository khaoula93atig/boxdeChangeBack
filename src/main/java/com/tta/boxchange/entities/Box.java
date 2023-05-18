package com.tta.boxchange.entities;

import java.util.Date;

public class Box {
	
	
	
	private String  idbox ;
	private String  libelle ;
	private String  adresse ;
	private String  username ;
	private String  emaiil ;
	private String  telephone ;
	private String  passsword ;
	public String getIdbox() {
		return idbox;
	}
	public void setIdbox(String idbox) {
		this.idbox = idbox;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmaiil() {
		return emaiil;
	}
	public void setEmaiil(String emaiil) {
		this.emaiil = emaiil;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPasssword() {
		return passsword;
	}
	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
	@Override
	public String toString() {
		return "Box [idbox=" + idbox + ", libelle=" + libelle + ", adresse=" + adresse + ", username=" + username
				+ ", emaiil=" + emaiil + ", telephone=" + telephone + ", passsword=" + passsword + "]";
	}


	


}
