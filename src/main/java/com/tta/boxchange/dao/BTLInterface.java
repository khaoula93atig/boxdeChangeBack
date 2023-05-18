package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.BTL;
import com.tta.boxchange.response.BasicResponse;

public interface BTLInterface {
	List<BTL> findAll();
	List<BTL> getbyId(int id);
	//List<STB> getNewstb(String status);
	BasicResponse save(BTL btl);
	BasicResponse update(BTL btl);
	List<BTL> modification(String codeDevise);
	//BasicResponse delete(STB stb);
}
