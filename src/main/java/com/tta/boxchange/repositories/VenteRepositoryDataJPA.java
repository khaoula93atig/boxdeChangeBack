package com.tta.boxchange.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tta.boxchange.entities.VENTE;

public interface VenteRepositoryDataJPA extends JpaRepository<VENTE, Integer> {
	
	@Query(value = "FROM VENTE", nativeQuery = false)
	List<VENTE> findAllLatest();
	
}
