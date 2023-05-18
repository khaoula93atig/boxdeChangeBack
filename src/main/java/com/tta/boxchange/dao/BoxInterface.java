package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.Box;
import com.tta.boxchange.response.BasicResponse;

public interface BoxInterface {


	List<Box> findAll();
	//List<News> findByIDSpecialite(int idSpecialite);
	//List<News> findByIDService(int categorie , String idService);
	BasicResponse save(Box box);
	BasicResponse update(Box box);
	BasicResponse delete(Box box);
}
