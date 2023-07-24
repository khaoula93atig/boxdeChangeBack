package com.tta.boxchange.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tta.boxchange.dao.PropositionInterface;
import com.tta.boxchange.entities.Notification;
import com.tta.boxchange.entities.Proposition;
import com.tta.boxchange.entities.User;
import com.tta.boxchange.repositories.PropositionRepository;
import com.tta.boxchange.repositories.UserRepository;
import com.tta.boxchange.response.BasicResponse;

@Service
public class PropositionService implements PropositionInterface {
	
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/
	
	@Autowired
	private PropositionRepository propositionRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Proposition> getPropositionByUserAndEnchere(Long user, String enchere) {
		/*String req ="select * from proposition where id_user=? and id_enchere=? ;";
		return jdbcTemplate.query(req, new Object[] { user , enchere }, new Propo)*/
		return propositionRepository.findAllByUser_IdAndEnchere_IdEnchere(user,enchere);
		
	}

	@Override
	public List<Proposition> getPropositionOfBank(Long user, String enchere) {
		// TODO Auto-generated method stub
		User userProposition=userRepository.findById(user).get();
		List<Proposition> prop = propositionRepository.findAllByUser_BankAndEnchere_IdEnchere(userProposition.getBank(),enchere);
		System.out.println(prop);
		return prop;
	}

	@Override
	public BasicResponse modifierProposition(Proposition proposition) {
		//check if employee exist in database
    	Proposition prop = propositionRepository.findById(proposition.getIdProposition()).get();

        if (prop != null) {
        	propositionRepository.save(proposition);
            return new BasicResponse("ok", HttpStatus.OK);
            
        }

        return new BasicResponse("error", HttpStatus.NOT_FOUND);
	}

}
