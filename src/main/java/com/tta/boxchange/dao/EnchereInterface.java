package com.tta.boxchange.dao;

import java.util.List;

import com.tta.boxchange.entities.Enchere;
import com.tta.boxchange.response.BasicResponse;

public interface EnchereInterface {


	List<Enchere> findAll();
	List<Enchere> findAllNull();
	List<Enchere> findAllNotNull();
	//List<News> findByIDSpecialite(int idSpecialite);
	//List<News> findByIDService(int categorie , String idService);
	BasicResponse save(Enchere enchere);
	BasicResponse update(Enchere enchere);
	BasicResponse delete(Enchere enchere);
	Long countEnchere(Long userId);
	List<Enchere> getByUser(Long userId);
}
