package com.tta.boxchange.repositories;

import com.tta.boxchange.entities.Proposition;
import com.tta.boxchange.entities.User;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PropositionRepository extends JpaRepository<Proposition, Long> {

	  List<Proposition> findAllByEnchere_IdEnchere(String id);
	

	

}
