package com.tta.boxchange.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Enchere {
	
	
	
	@Id
	private String  idEnchere ;
	private String  referenceEnchere ;
	private String  sensEnchere ;
	private int  montantEnchere ;
	private String  devise ;
	private Date  date ;
	private String  tauxSoumission ;
	private Timestamp  dateDebut ;
	private Date heureFin;
	private String  description ;
	
	@ManyToOne/*(fetch = FetchType.LAZY)*///(cascade = CascadeType.ALL)
    @JoinColumn(name="idUser", nullable=false/*,insertable = false, updatable = false*/)
	private User user;
	@Override
	public String toString() {
		return "Enchere [idEnchere=" + idEnchere + ", referenceEnchere=" + referenceEnchere + ", sensEnchere="
				+ sensEnchere + ", montantEnchere=" + montantEnchere + ", devise=" + devise + ", date=" + date
				+ ", tauxSoumission=" + tauxSoumission + ", dateDebut=" + dateDebut + ", heureFin=" + heureFin
				+ ", description=" + description + ", user=" + user + "]";
	}
	public Enchere() {

	}
	public Enchere(String idEnchere) {
		this.idEnchere = idEnchere;
	}

	public Date getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}
	public String getIdEnchere() {
		return idEnchere;
	}
	public void setIdEnchere(String idEnchere) {
		this.idEnchere = idEnchere;
	}
	public String getReferenceEnchere() {
		return referenceEnchere;
	}
	public void setReferenceEnchere(String referenceEnchere) {
		this.referenceEnchere = referenceEnchere;
	}
	public String getSensEnchere() {
		return sensEnchere;
	}
	public void setSensEnchere(String sensEnchere) {
		this.sensEnchere = sensEnchere;
	}
	public int getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setDateDebut(Timestamp dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTauxSoumission() {
		return tauxSoumission;
	}
	public void setTauxSoumission(String tauxSoumission) {
		this.tauxSoumission = tauxSoumission;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

	


}