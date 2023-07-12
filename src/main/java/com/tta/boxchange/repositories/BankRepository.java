package com.tta.boxchange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tta.boxchange.entities.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank,String> {

}
