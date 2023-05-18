package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.AVGVENTE;
import com.tta.boxchange.response.BasicResponse;

public interface AVGVENTEInterface {
	List<AVGVENTE> findAll();
	List<AVGVENTE> getbyId(int id);
	//List<STB> getNewstb(String status);
	BasicResponse save(AVGVENTE avgvente);
//	BasicResponse update(AVGVENTE avgvente);
	List<AVGVENTE> modification(String codeDevise);
	//BasicResponse delete(STB stb);
}
