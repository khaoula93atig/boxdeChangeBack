package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.BH;
import com.tta.boxchange.response.BasicResponse;

public interface BHInterface {
	List<BH> findAll();
	List<BH> getbyId(int id);
	//List<STB> getNewstb(String status);
	BasicResponse save(BH bh);
	BasicResponse update(BH bh);
	List<BH> modification(String codeDevise);
	//BasicResponse delete(STB stb);
}
