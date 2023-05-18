package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.STB;
import com.tta.boxchange.response.BasicResponse;

public interface STBInterface {
	List<STB> findAll();
	List<STB> getbyId(int id);
	//List<STB> getNewstb(String status);
	BasicResponse save(STB stb);
	BasicResponse update(STB stb);
	List<STB> modification(String codeDevise);
	//BasicResponse delete(STB stb);
}
