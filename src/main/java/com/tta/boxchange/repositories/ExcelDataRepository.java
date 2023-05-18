package com.tta.boxchange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.tta.boxchange.entities.ExcelData;

@EnableJpaRepositories
@Repository
public interface ExcelDataRepository extends JpaRepository<ExcelData, Long> {
	

}
