package com.tta.boxchange.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Box {
	
	
	@Id
	private String  idbox ;
	
	private String  boxName ;
	private String  adresse ;
	private String  boxTelephone ;
	private String  boxEmail ;
	private String  nomResponsable ;
	private String  prenomResponsable ;
	private String  emailResponsable ;
	private String  telephoneResponsable ;
	private String  contrat ;
	private Date  dateDebutContrat ;
	private String status;
	
    @Basic(optional = false)
    @CreationTimestamp
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();
	
	
	public String getIdbox() {
		return idbox;
	}
	public void setIdbox(String idbox) {
		this.idbox = idbox;
	}
	public String getBoxName() {
		return boxName;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getBoxTelephone() {
		return boxTelephone;
	}
	public void setBoxTelephone(String boxTelephone) {
		this.boxTelephone = boxTelephone;
	}
	public String getBoxEmail() {
		return boxEmail;
	}
	public void setBoxEmail(String boxEmail) {
		this.boxEmail = boxEmail;
	}
	public String getNomResponsable() {
		return nomResponsable;
	}
	public void setNomResponsable(String nomResponsable) {
		this.nomResponsable = nomResponsable;
	}
	public String getPrenomResponsable() {
		return prenomResponsable;
	}
	public void setPrenomResponsable(String prenomResponsable) {
		this.prenomResponsable = prenomResponsable;
	}
	public String getEmailResponsable() {
		return emailResponsable;
	}
	public void setEmailResponsable(String emailResponsable) {
		this.emailResponsable = emailResponsable;
	}
	public String getTelephoneResponsable() {
		return telephoneResponsable;
	}
	public void setTelephoneResponsable(String telephoneResponsable) {
		this.telephoneResponsable = telephoneResponsable;
	}
	public String getContrat() {
		return contrat;
	}
	public void setContrat(String contrat) {
		this.contrat = contrat;
	}
	
	
	public Date getDateDebutContrat() {
		return dateDebutContrat;
	}
	public void setDateDebutContrat(Date dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Box [idbox=" + idbox + ", boxName=" + boxName + ", adresse=" + adresse + ", boxTelephone="
				+ boxTelephone + ", boxEmail=" + boxEmail + ", nomResponsable=" + nomResponsable
				+ ", prenomResponsable=" + prenomResponsable + ", emailResponsable=" + emailResponsable
				+ ", telephoneResponsable=" + telephoneResponsable + ", contrat=" + contrat + ", dateDebutContrat="
				+ dateDebutContrat + ", status=" + status + ", createdAt=" + createdAt + "]";
	}
	
	
	


	


}
