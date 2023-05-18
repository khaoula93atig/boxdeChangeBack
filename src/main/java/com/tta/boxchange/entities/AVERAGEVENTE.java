package com.tta.boxchange.entities;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class AVERAGEVENTE {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAVERAGEVENTE;
	private String devise;
	private String average;
	private Date dateAVERAGEVENTE;
	
	 @OneToMany(mappedBy = "average")
	  private List<VENTE> ventes;

	@Override
	public String toString() {
		return "AVERAGEVENTE [idAVERAGEVENTE=" + idAVERAGEVENTE + ", devise=" + devise + ", average=" + average
				+ ", dateAVERAGEVENTE=" + dateAVERAGEVENTE + ", ventes=" + ventes + "]";
	}

	public int getIdAVERAGEVENTE() {
		return idAVERAGEVENTE;
	}

	public void setIdAVERAGEVENTE(int idAVERAGEVENTE) {
		this.idAVERAGEVENTE = idAVERAGEVENTE;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public String getAverage() {
		return average;
	}

	public void setAverage(String average) {
		this.average = average;
	}

	public Date getDateAVERAGEVENTE() {
		return dateAVERAGEVENTE;
	}

	public void setDateAVERAGEVENTE(Date dateAVERAGEVENTE) {
		this.dateAVERAGEVENTE = dateAVERAGEVENTE;
	}

	public List<VENTE> getVentes() {
		return ventes;
	}

	public void setVentes(List<VENTE> ventes) {
		this.ventes = ventes;
	}
	


}
