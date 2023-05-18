package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.ATB;
import com.tta.boxchange.response.BasicResponse;

public interface ATBInterface {
	List<ATB> findAll();
	List<ATB> getbyId(int id);
	//List<STB> getNewstb(String status);
	BasicResponse save(ATB atb);
	BasicResponse update(ATB atb);
	List<ATB> modification(String codeDevise);
	//BasicResponse delete(STB stb);
}
