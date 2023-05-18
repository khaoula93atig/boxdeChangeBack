package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.BTE;
import com.tta.boxchange.response.BasicResponse;

public interface BTEInterface {
	List<BTE> findAll();
	List<BTE> getbyId(int id);
	//List<STB> getNewstb(String status);
	BasicResponse save(BTE bte);
	BasicResponse update(BTE bte);
	List<BTE> modification(String codeDevise);
	//BasicResponse delete(STB stb);
}
