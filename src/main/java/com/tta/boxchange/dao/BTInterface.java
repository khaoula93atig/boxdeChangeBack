package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.BT;
import com.tta.boxchange.response.BasicResponse;

public interface BTInterface {
	List<BT> findAll();
	List<BT> getbyId(int id);
	//List<STB> getNewstb(String status);
	BasicResponse save(BT bt);
	BasicResponse update(BT bt);
	List<BT> modification(String codeDevise);
	//BasicResponse delete(STB stb);
}
