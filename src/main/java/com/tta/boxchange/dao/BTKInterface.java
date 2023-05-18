package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.BTK;
import com.tta.boxchange.response.BasicResponse;

public interface BTKInterface {
	List<BTK> findAll();
	List<BTK> getbyId(int id);
	//List<STB> getNewstb(String status);
	BasicResponse save(BTK btk);
	BasicResponse update(BTK btk);
	List<BTK> modification(String codeDevise);
	//BasicResponse delete(STB stb);
}
