package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.AverageVenteDevise;
import com.tta.boxchange.entities.AvgAchat;
import com.tta.boxchange.response.BasicResponse;

public interface AvgAchatInterface {
	
	BasicResponse save(AvgAchat AvgAchat);
	BasicResponse update(AvgAchat ancienAvgAchat);
	//verification d'existance
	List<AvgAchat> verification();
	List<AverageVenteDevise> averageBydevise(String devise);

}
