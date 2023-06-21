package com.tta.boxchange.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tta.boxchange.entities.Enchere;

public interface EnchRepository extends JpaRepository<Enchere, String> {

	List<Enchere> findAllByUser_Id(Long id);

	List<Enchere> findAllByOrderByDateDebutDesc();

	List<Enchere> findAllByOrderByHeureFinDesc();
}
