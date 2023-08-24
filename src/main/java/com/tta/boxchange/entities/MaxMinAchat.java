package com.tta.boxchange.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaxMinAchat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMaxMinAchat;
	
	private float maxSAR;
	private float minSAR;
	private float maxCAD;
	private float minCAD;
	private float maxDKK;
	private float minDKK;
	private float maxUSD;
	private float minUSD;
	private float maxGBP;
	private float minGBP;
	private float maxJPY;
	private float minJPY;
	private float maxNOK;
	private float minNOK;
	private float maxSEK;
	private float minSEK;
	private float maxCHF;
	private float minCHF;
	private float maxKWD;
	private float minKWD;
	private float maxAED;
	private float minAED;
	private float maxEUR;
	private float minEUR;
	private float maxLYD;
	private float minLYD;
	private float maxBHD;
	private float minBHD;
	private float maxQAR;
	private float minQAR;
	private float maxCNY;
	private float minCNY;
	private Date MinMaxdate;
	public int getIdMaxMinAchat() {
		return idMaxMinAchat;
	}
	public void setIdMaxMinAchat(int idMaxMinAchat) {
		this.idMaxMinAchat = idMaxMinAchat;
	}
	public float getMaxSAR() {
		return maxSAR;
	}
	public void setMaxSAR(float maxSAR) {
		this.maxSAR = maxSAR;
	}
	public float getMinSAR() {
		return minSAR;
	}
	public void setMinSAR(float minSAR) {
		this.minSAR = minSAR;
	}
	public float getMaxCAD() {
		return maxCAD;
	}
	public void setMaxCAD(float maxCAD) {
		this.maxCAD = maxCAD;
	}
	public float getMinCAD() {
		return minCAD;
	}
	public void setMinCAD(float minCAD) {
		this.minCAD = minCAD;
	}
	public float getMaxDKK() {
		return maxDKK;
	}
	public void setMaxDKK(float maxDKK) {
		this.maxDKK = maxDKK;
	}
	public float getMinDKK() {
		return minDKK;
	}
	public void setMinDKK(float minDKK) {
		this.minDKK = minDKK;
	}
	public float getMaxUSD() {
		return maxUSD;
	}
	public void setMaxUSD(float maxUSD) {
		this.maxUSD = maxUSD;
	}
	public float getMinUSD() {
		return minUSD;
	}
	public void setMinUSD(float minUSD) {
		this.minUSD = minUSD;
	}
	public float getMaxGBP() {
		return maxGBP;
	}
	public void setMaxGBP(float maxGBP) {
		this.maxGBP = maxGBP;
	}
	public float getMinGBP() {
		return minGBP;
	}
	public void setMinGBP(float minGBP) {
		this.minGBP = minGBP;
	}
	public float getMaxJPY() {
		return maxJPY;
	}
	public void setMaxJPY(float maxJPY) {
		this.maxJPY = maxJPY;
	}
	public float getMinJPY() {
		return minJPY;
	}
	public void setMinJPY(float minJPY) {
		this.minJPY = minJPY;
	}
	public float getMaxNOK() {
		return maxNOK;
	}
	public void setMaxNOK(float maxNOK) {
		this.maxNOK = maxNOK;
	}
	public float getMinNOK() {
		return minNOK;
	}
	public void setMinNOK(float minNOK) {
		this.minNOK = minNOK;
	}
	public float getMaxSEK() {
		return maxSEK;
	}
	public void setMaxSEK(float maxSEK) {
		this.maxSEK = maxSEK;
	}
	public float getMinSEK() {
		return minSEK;
	}
	public void setMinSEK(float minSEK) {
		this.minSEK = minSEK;
	}
	public float getMaxCHF() {
		return maxCHF;
	}
	public void setMaxCHF(float maxCHF) {
		this.maxCHF = maxCHF;
	}
	public float getMinCHF() {
		return minCHF;
	}
	public void setMinCHF(float minCHF) {
		this.minCHF = minCHF;
	}
	public float getMaxKWD() {
		return maxKWD;
	}
	public void setMaxKWD(float maxKWD) {
		this.maxKWD = maxKWD;
	}
	public float getMinKWD() {
		return minKWD;
	}
	public void setMinKWD(float minKWD) {
		this.minKWD = minKWD;
	}
	public float getMaxAED() {
		return maxAED;
	}
	public void setMaxAED(float maxAED) {
		this.maxAED = maxAED;
	}
	public float getMinAED() {
		return minAED;
	}
	public void setMinAED(float minAED) {
		this.minAED = minAED;
	}
	public float getMaxEUR() {
		return maxEUR;
	}
	public void setMaxEUR(float maxEUR) {
		this.maxEUR = maxEUR;
	}
	public float getMinEUR() {
		return minEUR;
	}
	public void setMinEUR(float minEUR) {
		this.minEUR = minEUR;
	}
	public float getMaxLYD() {
		return maxLYD;
	}
	public void setMaxLYD(float maxLYD) {
		this.maxLYD = maxLYD;
	}
	public float getMinLYD() {
		return minLYD;
	}
	public void setMinLYD(float minLYD) {
		this.minLYD = minLYD;
	}
	public float getMaxBHD() {
		return maxBHD;
	}
	public void setMaxBHD(float maxBHD) {
		this.maxBHD = maxBHD;
	}
	public float getMinBHD() {
		return minBHD;
	}
	public void setMinBHD(float minBHD) {
		this.minBHD = minBHD;
	}
	public float getMaxQAR() {
		return maxQAR;
	}
	public void setMaxQAR(float maxQAR) {
		this.maxQAR = maxQAR;
	}
	public float getMinQAR() {
		return minQAR;
	}
	public void setMinQAR(float minQAR) {
		this.minQAR = minQAR;
	}
	public float getMaxCNY() {
		return maxCNY;
	}
	public void setMaxCNY(float maxCNY) {
		this.maxCNY = maxCNY;
	}
	public float getMinCNY() {
		return minCNY;
	}
	public void setMinCNY(float minCNY) {
		this.minCNY = minCNY;
	}
	public Date getMinMaxdate() {
		return MinMaxdate;
	}
	public void setMinMaxdate(Date minMaxdate) {
		MinMaxdate = minMaxdate;
	}
	@Override
	public String toString() {
		return "MaxMinAchat [idMaxMinAchat=" + idMaxMinAchat + ", maxSAR=" + maxSAR + ", minSAR=" + minSAR + ", maxCAD="
				+ maxCAD + ", minCAD=" + minCAD + ", maxDKK=" + maxDKK + ", minDKK=" + minDKK + ", maxUSD=" + maxUSD
				+ ", minUSD=" + minUSD + ", maxGBP=" + maxGBP + ", minGBP=" + minGBP + ", maxJPY=" + maxJPY
				+ ", minJPY=" + minJPY + ", maxNOK=" + maxNOK + ", minNOK=" + minNOK + ", maxSEK=" + maxSEK
				+ ", minSEK=" + minSEK + ", maxCHF=" + maxCHF + ", minCHF=" + minCHF + ", maxKWD=" + maxKWD
				+ ", minKWD=" + minKWD + ", maxAED=" + maxAED + ", minAED=" + minAED + ", maxEUR=" + maxEUR
				+ ", minEUR=" + minEUR + ", maxLYD=" + maxLYD + ", minLYD=" + minLYD + ", maxBHD=" + maxBHD
				+ ", minBHD=" + minBHD + ", maxQAR=" + maxQAR + ", minQAR=" + minQAR + ", maxCNY=" + maxCNY
				+ ", minCNY=" + minCNY + ", MinMaxdate=" + MinMaxdate + "]";
	}
	
	
}
