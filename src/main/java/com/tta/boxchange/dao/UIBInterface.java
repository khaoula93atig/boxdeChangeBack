package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.UIB;
import com.tta.boxchange.response.BasicResponse;

public interface UIBInterface {
	List<UIB> findAll();
	List<UIB> getbyId(int id);
	//List<STB> getNewstb(String status);
	BasicResponse save(UIB uib);
	BasicResponse update(UIB uib);
	List<UIB> modification(String codeDevise);
	//BasicResponse delete(STB stb);
}
