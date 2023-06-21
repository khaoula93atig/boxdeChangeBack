package com.tta.boxchange.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Proposition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProposition;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idEnchere", nullable=false/*,insertable = false,, updatable = false*/)
	private Enchere enchere;
	
	@ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name="idUser", nullable=false/*,insertable = false, updatable = false*/)
	private User user;
	
	private double taux_soumission;
	
	@CreationTimestamp
    private Date dateCreation;

	@Override
	public String toString() {
		return "Proposition [idProposition=" + idProposition + ", enchere=" + enchere + ", user=" + user
				+ ", taux_soumission=" + taux_soumission + ", dateCreation=" + dateCreation + "]";
	}

	

	public Long getIdProposition() {
		return idProposition;
	}



	public void setIdProposition(Long idProposition) {
		this.idProposition = idProposition;
	}



	public Enchere getEnchere() {
		return enchere;
	}

	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTaux_soumission() {
		return taux_soumission;
	}

	public void setTaux_soumission(double taux_soumission) {
		this.taux_soumission = taux_soumission;
	}



	public Date getDateCreation() {
		return dateCreation;
	}



	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
}
