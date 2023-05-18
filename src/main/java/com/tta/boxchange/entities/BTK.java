package com.tta.boxchange.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class BTK {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBTK;
	private String codeDevise;
	private String uniteDevise;
	private String achatdevise;
	private String ventedevise;

	private Date datedevise;

	
	public void setData( String codeDevise,String uniteDevise,String achatdevise,String ventedevise)
    {
        this.idBTK = idBTK;
        this.codeDevise = codeDevise;
        this.uniteDevise = uniteDevise;
        this.achatdevise = achatdevise;
        this.ventedevise = ventedevise;
       // this.datedevise = datedevise;
    }
 
    // display() method to display
    // the student data
    public void display()
    {
        System.out.println("My BTK: " + idBTK + " "
                           
                           + codeDevise +uniteDevise+ achatdevise +ventedevise+datedevise);
        System.out.println();
    }
	

	

	@Override
	public String toString() {
		return "BTK [idBTK=" + idBTK + ", codeDevise=" + codeDevise + ", uniteDevise=" + uniteDevise + ", achatdevise="
				+ achatdevise + ", ventedevise=" + ventedevise + ", datedevise=" + datedevise + "]";
	}

	public int getIdBTK() {
		return idBTK;
	}

	public void setIdBTK(int idBTK) {
		this.idBTK = idBTK;
	}

	public String getCodeDevise() {
		return codeDevise;
	}

	public void setCodeDevise(String codeDevise) {
		this.codeDevise = codeDevise;
	}

	public String getUniteDevise() {
		return uniteDevise;
	}

	public void setUniteDevise(String uniteDevise) {
		this.uniteDevise = uniteDevise;
	}

	public String getAchatdevise() {
		return achatdevise;
	}

	public void setAchatdevise(String achatdevise) {
		this.achatdevise = achatdevise;
	}

	public String getVentedevise() {
		return ventedevise;
	}

	public void setVentedevise(String ventedevise) {
		this.ventedevise = ventedevise;
	}

	public Date getDatedevise() {
		return datedevise;
	}

	public void setDatedevise(Date datedevise) {
		this.datedevise = datedevise;
	}

	

	


}
