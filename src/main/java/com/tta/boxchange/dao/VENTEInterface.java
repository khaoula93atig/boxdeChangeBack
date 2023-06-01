package com.tta.boxchange.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.tta.boxchange.entities.Vente;
import com.tta.boxchange.response.BasicResponse;

public interface VENTEInterface {
	List<Vente> findAll();
	List<Vente> findLasts();
	Vente findMAX(String currency);
	List<Vente> getbyId(int id);
	
	
	BasicResponse save(Vente vente);
	BasicResponse update(Vente vente);
	
	List<Vente> modification(String nomBanque);
	
	//verification si deja la ligne existe ou non 
	List<Vente> verification(String Bank);
	
	//modification de la ligne de vente en cas de changement
	BasicResponse updateVente(Vente ancienneVente,Vente nouveauVente);
	
	//List<VENTE> getALL();
	Vente findMIN(String currency);
	Vente findMAX(String currency, String date);
	Vente findMIN(String currency, String date);
	
	//min and max valeur de vente par jour et devise (daily)  
	Float maxVenteCeJour(String devise);
	Float minVenteCeJour(String devise);
	
	
	
	
}
