package com.tta.boxchange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tta.boxchange.entities.Box;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxRepository extends JpaRepository<Box,String>{
	
}
