package com.tta.boxchange.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tta.boxchange.entities.MaxMinVente;
import com.tta.boxchange.response.BasicResponse;

@Service
public interface MaxMinVenteInterface {
	public BasicResponse save(MaxMinVente maxMinVente );
	public List<MaxMinVente> verif();
	public BasicResponse update(MaxMinVente maxMinVente);
	public float maxJour(String devise);
	public float minJour(String devise);
	
	//min and max valeur de vente par semaine et devise (weekly)  
		Float maxVenteSemaine(String devise);
		Float minVenteSemaine(String devise);
		
		//min and max valeur de vente par mois et devise (monthly)  
		Float maxVenteMois(String devise);
		Float minVenteMois(String devise);
		
		//min and max valeur de vente par ans et devise (annual)  
		Float maxVenteAns(String devise);
		Float minVenteAns(String devise);
		

}
