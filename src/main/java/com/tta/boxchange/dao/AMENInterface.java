package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.AMEN;
import com.tta.boxchange.response.BasicResponse;

public interface AMENInterface {
	List<AMEN> findAll();
	List<AMEN> getbyId(int id);
	//List<STB> getNewstb(String status);
	BasicResponse save(AMEN amen);
	BasicResponse update(AMEN amen);
	List<AMEN> modification(String codeDevise);
	//BasicResponse delete(STB stb);
}
