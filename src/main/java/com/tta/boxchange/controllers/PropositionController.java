package com.tta.boxchange.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.boxchange.dao.PropositionInterface;
import com.tta.boxchange.entities.Enchere;
import com.tta.boxchange.entities.Notification;
import com.tta.boxchange.entities.Proposition;
import com.tta.boxchange.entities.User;
import com.tta.boxchange.repositories.EnchRepository;
import com.tta.boxchange.repositories.EnchereRepository;
import com.tta.boxchange.repositories.PropositionRepository;
import com.tta.boxchange.repositories.UserRepository;
import com.tta.boxchange.response.BasicResponse;

@CrossOrigin("*") // open for all ports
@RestController
@RequestMapping("/proposition")
@Controller

public class PropositionController {
	@Autowired
    PropositionRepository propositionRepository;
	
	@Autowired
    UserRepository userRepository;
	
	@Autowired
	EnchRepository enchereRepository;
	
	@Autowired
	NotificationController notificationController;
	
	@Autowired
	PropositionInterface propositionInterface;

    /**
     * Get all the employees
     *
     * @return ResponseEntity
     */
    @GetMapping("/list")
    public ResponseEntity<List<Proposition>> getPropositions() {
        try {
            return new ResponseEntity<>(propositionRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get the employee by id
     *
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/getById/{id}")
    public ResponseEntity<Proposition> getPropositionById(@PathVariable("id") long id) {
        try {
            //check if employee exist in database
        	Proposition empObj = getEmpRec(id);

            if (empObj != null) {
                return new ResponseEntity<>(empObj, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

   
    @PostMapping("/add")
    public ResponseEntity<Proposition> addProposition(@RequestBody Proposition proposition) {
    	try {
    		Proposition newPropostion = new Proposition();
    		Optional<User> u = userRepository.findById(proposition.getUser().getId());
    		if(u!=null) {
    			proposition.setUser(new User(u.orElseThrow().getId()));
    		Optional<Enchere> enchere = enchereRepository.findById(proposition.getEnchere().getIdEnchere());
    		if(enchere!=null) {
    			proposition.setEnchere(enchere.orElseThrow());
    		System.out.println("ench selectionné = "+enchere.orElseThrow());
    		System.out.println("add propos"+proposition);
    		System.out.println("ench : "+proposition.getEnchere().getIdEnchere()+"user = "+proposition.getUser().getId()+"taux "+proposition.getTaux_soumission());

    		newPropostion = propositionRepository.saveAndFlush(proposition);
    		
    		Notification notification  = new Notification( );
    		notification.setChannel(proposition.getEnchere().getUser().getId().toString());
    		notification.setSender( u.orElseThrow().getUsername());
    		notification.setTitre(proposition.getEnchere().getReferenceEnchere());
    		notification.setContent(proposition.getEnchere().getDevise());
    		notification.setType("proposition");
    		
    		notificationController.handleNotif(notification);
           
    		}
    		}
    		 return new ResponseEntity<>(newPropostion, HttpStatus.OK);
    	}
    	catch(Exception e) {
        	System.out.println("exception  : "+e);     

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    	}

    	
    }

    
    @PutMapping("/update")
    public BasicResponse updateEmployee( @RequestBody Proposition proposition) {
    	
    	
    	
    	Notification notification  = new Notification( );
		notification.setChannel(proposition.getEnchere().getUser().getId().toString());
		notification.setSender( proposition.getUser().getUsername());
		notification.setTitre(proposition.getEnchere().getReferenceEnchere());
		notification.setContent(proposition.getEnchere().getDevise());
		notification.setType("proposition");
		
		notificationController.handleNotif(notification);
		return propositionInterface.modifierProposition(proposition);

        
    }

    /**
     * Delete Employee by Id
     *
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("id") long id) {
        try {
            //check if employee exist in database
        	Proposition emp = getEmpRec(id);

            if (emp != null) {
                propositionRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Delete all employees
     *
     * @return ResponseEntity
     */
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteAllEmployees() {
        try {
            propositionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Method to get the employee record by id
     *
     * @param id
     * @return Employee
     */
    private Proposition getEmpRec(long id) {
        Optional<Proposition> empObj = propositionRepository.findById(id);

        if (empObj.isPresent()) {
            return empObj.get();
        }
        return null;
    }
    
    @GetMapping("/getByEnchereId/{id}")
    public ResponseEntity<List<Proposition>> getPropositionByEnchereId(@PathVariable("id") String id) {
        try {
            //check if employee exist in database
        	List<Proposition> propositions = propositionRepository.findAllByEnchere_IdEnchere(id);

            if (propositions != null) {
                return new ResponseEntity<>(propositions, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    
    //get proposition by enchere and user
    @GetMapping("/getByUserAndEnchere/{user}/{enchere}")
    public List<Proposition> getPropositionByUserAndEnchere(@PathVariable("user") Long user, @PathVariable("enchere") String enchere) {
    	return propositionInterface.getPropositionByUserAndEnchere(user, enchere);
    }
    
  //get proposition of bank
    @GetMapping("/getOfBank/{user}/{enchere}")
    public List<Proposition> getPropositionofBank(@PathVariable("user") Long user, @PathVariable("enchere") String enchere) {
    	return propositionInterface.getPropositionOfBank(user, enchere);
    }
    
    
}
