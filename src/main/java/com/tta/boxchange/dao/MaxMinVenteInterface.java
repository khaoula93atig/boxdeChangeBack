package com.tta.boxchange.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tta.boxchange.dto.MinMaxResult;
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
		MinMaxResult maxVenteSemaine(String devise);
		MinMaxResult minVenteSemaine(String devise);
		
		//min and max valeur de vente par mois et devise (monthly)  
		MinMaxResult maxVenteMois(String devise);
		MinMaxResult minVenteMois(String devise);
		
		//min and max valeur de vente par ans et devise (annual)  
		MinMaxResult maxVenteAns(String devise);
		MinMaxResult minVenteAns(String devise);
		

}
