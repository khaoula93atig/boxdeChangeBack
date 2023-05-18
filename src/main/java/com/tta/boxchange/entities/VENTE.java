package com.tta.boxchange.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class VENTE {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVENTE;
	private String nomBanque;
	private String deviseSAR;
	private String deviseCAD;
	private String deviseDKK;
	private String deviseUSD;
	private String deviseGBP;
	private String deviseJPY;
	private String deviseNOK;
	private String deviseSEK;
	private String deviseCHF;
	private String deviseKWD;
	private String deviseAED;
	private String deviseEUR;
	
	private String deviseLYD;
	private String deviseBHD;
	private String deviseQAR;
	private String deviseCNY;
	private Date datedevise;
	
	 @ManyToOne
	  private AVERAGEVENTE average;
	
	public void setData( String nomBanque,String deviseCAD,String deviseDKK,String deviseUSD,String deviseGBP,String deviseJPY,String deviseNOK,
			String deviseSEK,String deviseCHF,String deviseKWD,String deviseAED,String deviseEUR,String deviseLYD,String deviseBHD,
			String deviseQAR,String deviseCNY,String deviseSAR)
    {
        this.idVENTE = idVENTE;
        this.nomBanque = nomBanque;
        this.deviseSAR = deviseSAR;
        this.deviseCAD = deviseCAD;
        this.deviseDKK = deviseDKK;
        this.deviseUSD = deviseUSD;
        this.deviseGBP = deviseGBP;
        this.deviseJPY = deviseJPY;
        this.deviseNOK = deviseNOK;
        this.deviseSEK = deviseSEK;
        this.deviseCHF = deviseCHF;
        this.deviseKWD = deviseKWD;
        this.deviseAED = deviseAED;
        this.deviseEUR = deviseEUR;
        this.deviseLYD = deviseLYD;
        this.deviseBHD = deviseBHD;
        this.deviseQAR = deviseQAR;
        this.deviseCNY = deviseCNY;
        this.deviseSAR = deviseSAR;
       // this.datedevise = datedevise
        ;
    }










	public AVERAGEVENTE getAverage() {
		return average;
	}






	public void setAverage(AVERAGEVENTE average) {
		this.average = average;
	}











	@Override
	public String toString() {
		return "VENTE [idVENTE=" + idVENTE + ", nomBanque=" + nomBanque + ", deviseSAR=" + deviseSAR + ", deviseCAD="
				+ deviseCAD + ", deviseDKK=" + deviseDKK + ", deviseUSD=" + deviseUSD + ", deviseGBP=" + deviseGBP
				+ ", deviseJPY=" + deviseJPY + ", deviseNOK=" + deviseNOK + ", deviseSEK=" + deviseSEK + ", deviseCHF="
				+ deviseCHF + ", deviseKWD=" + deviseKWD + ", deviseAED=" + deviseAED + ", deviseEUR=" + deviseEUR
				+ ", deviseLYD=" + deviseLYD + ", deviseBHD=" + deviseBHD + ", deviseQAR=" + deviseQAR + ", deviseCNY="
				+ deviseCNY + ", datedevise=" + datedevise + ", average=" + average + "]";
	}










	public String getDeviseSAR() {
		return deviseSAR;
	}










	public void setDeviseSAR(String deviseSAR) {
		this.deviseSAR = deviseSAR;
	}










	public int getIdVENTE() {
		return idVENTE;
	}


	public void setIdVENTE(int idVENTE) {
		this.idVENTE = idVENTE;
	}


	public String getNomBanque() {
		return nomBanque;
	}




	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}





	public String getDeviseCAD() {
		return deviseCAD;
	}


	public void setDeviseCAD(String deviseCAD) {
		this.deviseCAD = deviseCAD;
	}


	public String getDeviseDKK() {
		return deviseDKK;
	}


	public void setDeviseDKK(String deviseDKK) {
		this.deviseDKK = deviseDKK;
	}


	public String getDeviseUSD() {
		return deviseUSD;
	}


	public void setDeviseUSD(String deviseUSD) {
		this.deviseUSD = deviseUSD;
	}


	public String getDeviseGBP() {
		return deviseGBP;
	}


	public void setDeviseGBP(String deviseGBP) {
		this.deviseGBP = deviseGBP;
	}


	public String getDeviseJPY() {
		return deviseJPY;
	}


	public void setDeviseJPY(String deviseJPY) {
		this.deviseJPY = deviseJPY;
	}


	public String getDeviseNOK() {
		return deviseNOK;
	}


	public void setDeviseNOK(String deviseNOK) {
		this.deviseNOK = deviseNOK;
	}


	public String getDeviseSEK() {
		return deviseSEK;
	}


	public void setDeviseSEK(String deviseSEK) {
		this.deviseSEK = deviseSEK;
	}


	public String getDeviseCHF() {
		return deviseCHF;
	}


	public void setDeviseCHF(String deviseCHF) {
		this.deviseCHF = deviseCHF;
	}


	public String getDeviseKWD() {
		return deviseKWD;
	}


	public void setDeviseKWD(String deviseKWD) {
		this.deviseKWD = deviseKWD;
	}


	public String getDeviseAED() {
		return deviseAED;
	}


	public void setDeviseAED(String deviseAED) {
		this.deviseAED = deviseAED;
	}


	public String getDeviseEUR() {
		return deviseEUR;
	}


	public void setDeviseEUR(String deviseEUR) {
		this.deviseEUR = deviseEUR;
	}


	public String getDeviseLYD() {
		return deviseLYD;
	}


	public void setDeviseLYD(String deviseLYD) {
		this.deviseLYD = deviseLYD;
	}


	public String getDeviseBHD() {
		return deviseBHD;
	}


	public void setDeviseBHD(String deviseBHD) {
		this.deviseBHD = deviseBHD;
	}


	public String getDeviseQAR() {
		return deviseQAR;
	}


	public void setDeviseQAR(String deviseQAR) {
		this.deviseQAR = deviseQAR;
	}


	public String getDeviseCNY() {
		return deviseCNY;
	}


	public void setDeviseCNY(String deviseCNY) {
		this.deviseCNY = deviseCNY;
	}


	public Date getDatedevise() {
		return datedevise;
	}


	public void setDatedevise(Date datedevise) {
		this.datedevise = datedevise;
	}
 
    // display() method to display
    // the student data
   /* public void display()
    {
        System.out.println("My VENTE: " + idBIAT + " "
                           
                           + codeDevise +uniteDevise+ achatdevise +ventedevise+datedevise);
        System.out.println();
    }
	
*/


	
	

	


}
