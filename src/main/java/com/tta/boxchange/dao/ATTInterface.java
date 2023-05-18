package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.ATT;
import com.tta.boxchange.response.BasicResponse;

public interface ATTInterface {
	List<ATT> findAll();
	List<ATT> getbyId(String id);
	//List<STB> getNewstb(String status);
	BasicResponse save(ATT att);
	BasicResponse update(ATT att);
	
}
