package com.tta.boxchange.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tta.boxchange.entities.Proposition;
import com.tta.boxchange.response.BasicResponse;

public interface PropositionInterface {
	
	List<Proposition> getPropositionByUserAndEnchere(Long user,String enchere);
	List<Proposition> getPropositionOfBank(Long user , String enchere);
	BasicResponse modifierProposition(Proposition proposition);

}
