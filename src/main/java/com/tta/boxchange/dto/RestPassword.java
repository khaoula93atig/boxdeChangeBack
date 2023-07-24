package com.tta.boxchange.dto;

public class RestPassword {
	private String token;
	private String password;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "RestPassword [token=" + token + ", password=" + password + "]";
	}
	
	

}