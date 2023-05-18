package com.tta.boxchange.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

public class ExcelData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bankname;
	private String devisename;
	public String getDevisename() {
		return devisename;
	}
	public ExcelData() {

	}
	public void setDevisename(String devisename) {
		this.devisename = devisename;
	}
	private String data;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ExcelData [id=" + id + ", bankname=" + bankname + ", devisename=" + devisename + ", data=" + data + "]";
	}
	public ExcelData(String bankname, String devisename, String data) {
		super();
		this.bankname = bankname;
		this.devisename = devisename;
		this.data = data;
	}
	
	}
