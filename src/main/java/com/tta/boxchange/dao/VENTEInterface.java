package com.tta.boxchange.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.tta.boxchange.entities.VENTE;
import com.tta.boxchange.response.BasicResponse;

public interface VENTEInterface {
	List<VENTE> findAll();
	VENTE findMAX(String currency);
	List<VENTE> getbyId(int id);
	//List<STB> getNewstb(String status);
	BasicResponse save(VENTE vente);
	BasicResponse update(VENTE vente);
	List<VENTE> modification(String nomBanque);
	//BasicResponse delete(STB stb);
	//List<VENTE> getALL();
	VENTE findMIN(String currency);
	VENTE findMAX(String currency, String date);
	VENTE findMIN(String currency, String date);
}
