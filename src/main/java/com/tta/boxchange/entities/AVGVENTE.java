package com.tta.boxchange.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class AVGVENTE {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombanque;
	private double devisesar;
	private String devisecad;
	private String devisedkk;
	private String deviseusd;
	private String devisegbp;
	private String devisejpy;
	private String devisenok;
	private String devisesek;
	private String devisechf;
	private String devisekwd;
	private String deviseaed;
	private String deviseeur;
	
	private String deviselyd;
	private String devisebhd;
	private String deviseqar;
	private String devisecny;
	private Date datedevise;
	

	
	public void setData( String nomBanque,String deviseCAD,String deviseDKK,String deviseUSD,String deviseGBP,String deviseJPY,String deviseNOK,
			String deviseSEK,String deviseCHF,String deviseKWD,String deviseAED,String deviseEUR,String deviseLYD,String deviseBHD,
			String deviseQAR,String deviseCNY,Double deviseSAR)
    {
        this.id = id;
        this.nombanque = nombanque;
       
       this.devisecad = devisecad;
        this.devisedkk = devisedkk;
        this.deviseusd = deviseusd;
        this.devisegbp = devisegbp;
        this.devisejpy = devisejpy;
        this.devisenok = devisenok;
        this.devisesek = devisesek;
        this.devisechf = devisechf;
        this.devisekwd = devisekwd;
        this.deviseaed = deviseaed;
        this.deviseaed = deviseaed;
        this.deviselyd = deviselyd;
        this.devisebhd = devisebhd;
        this.deviseqar = deviseqar;
        this.devisecny = devisecny;
        this.devisesar = devisesar;
       // this.datedevise = datedevise
        ;
    }



	@Override
	public String toString() {
		return "AVGVENTE [id=" + id + ", nombanque=" + nombanque + ", devisesar=" + devisesar + ", devisecad="
				+ devisecad + ", devisedkk=" + devisedkk + ", deviseusd=" + deviseusd + ", devisegbp=" + devisegbp
				+ ", devisejpy=" + devisejpy + ", devisenok=" + devisenok + ", devisesek=" + devisesek + ", devisechf="
				+ devisechf + ", devisekwd=" + devisekwd + ", deviseaed=" + deviseaed + ", deviseeur=" + deviseeur
				+ ", deviselyd=" + deviselyd + ", devisebhd=" + devisebhd + ", deviseqar=" + deviseqar + ", devisecny="
				+ devisecny + ", datedevise=" + datedevise + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombanque() {
		return nombanque;
	}



	public void setNombanque(String nombanque) {
		this.nombanque = nombanque;
	}



	public double getDevisesar() {
		return devisesar;
	}



	public void setDevisesar(double devisesar) {
		this.devisesar = devisesar;
	}



	public String getDevisecad() {
		return devisecad;
	}



	public void setDevisecad(String devisecad) {
		this.devisecad = devisecad;
	}



	public String getDevisedkk() {
		return devisedkk;
	}



	public void setDevisedkk(String devisedkk) {
		this.devisedkk = devisedkk;
	}



	public String getDeviseusd() {
		return deviseusd;
	}



	public void setDeviseusd(String deviseusd) {
		this.deviseusd = deviseusd;
	}



	public String getDevisegbp() {
		return devisegbp;
	}



	public void setDevisegbp(String devisegbp) {
		this.devisegbp = devisegbp;
	}



	public String getDevisejpy() {
		return devisejpy;
	}



	public void setDevisejpy(String devisejpy) {
		this.devisejpy = devisejpy;
	}



	public String getDevisenok() {
		return devisenok;
	}



	public void setDevisenok(String devisenok) {
		this.devisenok = devisenok;
	}



	public String getDevisesek() {
		return devisesek;
	}



	public void setDevisesek(String devisesek) {
		this.devisesek = devisesek;
	}



	public String getDevisechf() {
		return devisechf;
	}



	public void setDevisechf(String devisechf) {
		this.devisechf = devisechf;
	}



	public String getDevisekwd() {
		return devisekwd;
	}



	public void setDevisekwd(String devisekwd) {
		this.devisekwd = devisekwd;
	}



	public String getDeviseaed() {
		return deviseaed;
	}



	public void setDeviseaed(String deviseaed) {
		this.deviseaed = deviseaed;
	}



	public String getDeviseeur() {
		return deviseeur;
	}



	public void setDeviseeur(String deviseeur) {
		this.deviseeur = deviseeur;
	}



	public String getDeviselyd() {
		return deviselyd;
	}



	public void setDeviselyd(String deviselyd) {
		this.deviselyd = deviselyd;
	}



	public String getDevisebhd() {
		return devisebhd;
	}



	public void setDevisebhd(String devisebhd) {
		this.devisebhd = devisebhd;
	}



	public String getDeviseqar() {
		return deviseqar;
	}



	public void setDeviseqar(String deviseqar) {
		this.deviseqar = deviseqar;
	}



	public String getDevisecny() {
		return devisecny;
	}



	public void setDevisecny(String devisecny) {
		this.devisecny = devisecny;
	}



	public Date getDatedevise() {
		return datedevise;
	}



	public void setDatedevise(Date datedevise) {
		this.datedevise = datedevise;
	}





	





	


}
