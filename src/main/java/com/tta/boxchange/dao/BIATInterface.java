package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.BIAT;
import com.tta.boxchange.response.BasicResponse;

public interface BIATInterface {
	List<BIAT> findAll();
	List<BIAT> getbyId(int id);
	//List<STB> getNewstb(String status);
	BasicResponse save(BIAT biat);
	BasicResponse update(BIAT biat);
	List<BIAT> modification(String codeDevise);
	//BasicResponse delete(STB stb);
}
