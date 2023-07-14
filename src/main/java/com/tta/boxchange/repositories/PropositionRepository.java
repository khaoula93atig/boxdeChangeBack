package com.tta.boxchange.repositories;

import com.tta.boxchange.entities.Bank;
import com.tta.boxchange.entities.Proposition;
import com.tta.boxchange.entities.User;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface PropositionRepository extends JpaRepository<Proposition, Long> {

	  List<Proposition> findAllByEnchere_IdEnchere(String id);
	  
	 /* @Query(value="select * from proposition where id_user= ?1 and id_enchere= ?2", nativeQuery = true)
		List<Proposition> getPropositionByUserAndEnchere(@Param("user") Long user , @Param("enchere") String enchere );

	List<Proposition> findAllByUser_IdUserAndEnchere_IdEnchere(Long user, String enchere);*/

	List<Proposition> findAllByUser_IdAndEnchere_IdEnchere(Long user, String enchere);

	List<Proposition> findAllByUser_Bank_IdBankAndEnchere_IdEnchere(Bank bank, String enchere);
	

	

}
