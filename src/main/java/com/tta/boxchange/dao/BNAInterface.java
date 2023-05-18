package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.BNA;
import com.tta.boxchange.response.BasicResponse;

public interface BNAInterface {
	List<BNA> findAll();
	List<BNA> getbyId(int id);
	//List<STB> getNewstb(String status);
	BasicResponse save(BNA bna);
	BasicResponse update(BNA bna);
	List<BNA> modification(String codeDevise);
	//BasicResponse delete(STB stb);
}
