package com.tta.boxchange.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tta.boxchange.entities.Vente;



public interface VenteRepositoryDataJPA extends JpaRepository<Vente, Integer> {
	
	/*@Query(value = "FROM vente", nativeQuery = false)
	List<Vente> findAllLatest();*/
	
}
