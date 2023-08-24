package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.dto.MinMaxResult;
import com.tta.boxchange.entities.MaxMinAchat;
import com.tta.boxchange.response.BasicResponse;

public interface MinMaxAchatInterface {

	public BasicResponse save(MaxMinAchat maxMinAchat );
	public List<MaxMinAchat> verif();
	public BasicResponse update(MaxMinAchat maxMinAchat);
	public float maxJour(String devise);
	public float minJour(String devise);
	
	//min and max valeur de Achat par semaine et devise (weekly)  
		MinMaxResult maxAchatSemaine(String devise);
		MinMaxResult minAchatSemaine(String devise);
		
		//min and max valeur de Achat par mois et devise (monthly)  
		MinMaxResult maxAchatMois(String devise);
		MinMaxResult minAchatMois(String devise);
		
		//min and max valeur de Achat par ans et devise (annual)  
		MinMaxResult maxAchatAns(String devise);
		MinMaxResult minAchatAns(String devise);
}
