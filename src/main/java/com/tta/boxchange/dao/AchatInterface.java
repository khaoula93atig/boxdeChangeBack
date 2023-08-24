package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.Achat;
import com.tta.boxchange.response.BasicResponse;

public interface AchatInterface {

	List<Achat> findAll();
	List<Achat> findLasts();
	Achat findMAX(String currency);
	List<Achat> getbyId(int id);
	
	
	BasicResponse save(Achat achat);
	BasicResponse update(Achat chat);
	
	List<Achat> modification(String nomBanque);
	
	//verification si deja la ligne existe ou non 
	List<Achat> verification(String Bank);
	
	//modification de la ligne d'achat en cas de changement
	BasicResponse updateAchat(Achat ancienneVente,Achat nouveauVente);
	
	Achat findMIN(String currency);
	Achat findMAX(String currency, String date);
	Achat findMIN(String currency, String date);
	
	//min and max valeur d'achat par jour et devise (daily)  
	Float maxAchatCeJour(String devise);
	Float minAchatCeJour(String devise);
	
}
