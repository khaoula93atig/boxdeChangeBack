package com.tta.boxchange.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AvgAchat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAvgAchat;
	private float devisesar;
	private float devisecad;
	private float devisedkk;
	private float deviseusd;
	private float devisegbp;
	private float devisejpy;
	private float devisenok;
	private float devisesek;
	private float devisechf;
	private float devisekwd;
	private float deviseaed;
	private float deviseeur;
	
	private float deviselyd;
	private float devisebhd;
	private float deviseqar;
	private float devisecny;
	private Date datedevise;
	public int getIdAvgAchat() {
		return idAvgAchat;
	}
	public void setIdAvgAchat(int idAvgAchat) {
		this.idAvgAchat = idAvgAchat;
	}
	public float getDevisesar() {
		return devisesar;
	}
	public void setDevisesar(float devisesar) {
		this.devisesar = devisesar;
	}
	public float getDevisecad() {
		return devisecad;
	}
	public void setDevisecad(float devisecad) {
		this.devisecad = devisecad;
	}
	public float getDevisedkk() {
		return devisedkk;
	}
	public void setDevisedkk(float devisedkk) {
		this.devisedkk = devisedkk;
	}
	public float getDeviseusd() {
		return deviseusd;
	}
	public void setDeviseusd(float deviseusd) {
		this.deviseusd = deviseusd;
	}
	public float getDevisegbp() {
		return devisegbp;
	}
	public void setDevisegbp(float devisegbp) {
		this.devisegbp = devisegbp;
	}
	public float getDevisejpy() {
		return devisejpy;
	}
	public void setDevisejpy(float devisejpy) {
		this.devisejpy = devisejpy;
	}
	public float getDevisenok() {
		return devisenok;
	}
	public void setDevisenok(float devisenok) {
		this.devisenok = devisenok;
	}
	public float getDevisesek() {
		return devisesek;
	}
	public void setDevisesek(float devisesek) {
		this.devisesek = devisesek;
	}
	public float getDevisechf() {
		return devisechf;
	}
	public void setDevisechf(float devisechf) {
		this.devisechf = devisechf;
	}
	public float getDevisekwd() {
		return devisekwd;
	}
	public void setDevisekwd(float devisekwd) {
		this.devisekwd = devisekwd;
	}
	public float getDeviseaed() {
		return deviseaed;
	}
	public void setDeviseaed(float deviseaed) {
		this.deviseaed = deviseaed;
	}
	public float getDeviseeur() {
		return deviseeur;
	}
	public void setDeviseeur(float deviseeur) {
		this.deviseeur = deviseeur;
	}
	public float getDeviselyd() {
		return deviselyd;
	}
	public void setDeviselyd(float deviselyd) {
		this.deviselyd = deviselyd;
	}
	public float getDevisebhd() {
		return devisebhd;
	}
	public void setDevisebhd(float devisebhd) {
		this.devisebhd = devisebhd;
	}
	public float getDeviseqar() {
		return deviseqar;
	}
	public void setDeviseqar(float deviseqar) {
		this.deviseqar = deviseqar;
	}
	public float getDevisecny() {
		return devisecny;
	}
	public void setDevisecny(float devisecny) {
		this.devisecny = devisecny;
	}
	public Date getDatedevise() {
		return datedevise;
	}
	public void setDatedevise(Date datedevise) {
		this.datedevise = datedevise;
	}
	@Override
	public String toString() {
		return "AvgAchat [idAvgAchat=" + idAvgAchat + ", devisesar=" + devisesar + ", devisecad=" + devisecad
				+ ", devisedkk=" + devisedkk + ", deviseusd=" + deviseusd + ", devisegbp=" + devisegbp + ", devisejpy="
				+ devisejpy + ", devisenok=" + devisenok + ", devisesek=" + devisesek + ", devisechf=" + devisechf
				+ ", devisekwd=" + devisekwd + ", deviseaed=" + deviseaed + ", deviseeur=" + deviseeur + ", deviselyd="
				+ deviselyd + ", devisebhd=" + devisebhd + ", deviseqar=" + deviseqar + ", devisecny=" + devisecny
				+ ", datedevise=" + datedevise + "]";
	}
	
	
}
