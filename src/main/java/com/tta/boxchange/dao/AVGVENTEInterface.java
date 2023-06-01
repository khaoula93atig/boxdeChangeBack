package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.AVGVENTE;
import com.tta.boxchange.entities.AverageVenteDevise;
import com.tta.boxchange.response.BasicResponse;

public interface AVGVENTEInterface {
	List<AVGVENTE> findAll();
	List<AVGVENTE> getbyId(int id);
	BasicResponse save(AVGVENTE avgvente);
	BasicResponse update(AVGVENTE ancienAvgvente);
	List<AVGVENTE> modification(String codeDevise);
	//verification d'existance
	List<AVGVENTE> verification();
	List<AverageVenteDevise> averageBydevise(String devise);
}
