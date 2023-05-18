package com.tta.boxchange.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.boxchange.entities.Enchere;
import com.tta.boxchange.entities.Proposition;
import com.tta.boxchange.entities.User;
import com.tta.boxchange.repositories.EnchRepository;
import com.tta.boxchange.repositories.EnchereRepository;
import com.tta.boxchange.repositories.PropositionRepository;
import com.tta.boxchange.repositories.UserRepository;

@CrossOrigin("*") // open for all ports
@RestController
@RequestMapping("/proposition")

public class PropositionController {
	@Autowired
    PropositionRepository propositionRepository;
	
	@Autowired
    UserRepository userRepository;
	
	@Autowired
	EnchRepository enchereRepository;

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
    public ResponseEntity<Proposition> newEmployee(@RequestBody Proposition employee) {
    	/*User u = new User();
    	u.setId(1L);
    	employee.setUser(u);*/
    	try {
    		Optional<User> u = userRepository.findById(employee.getUser().getId());
    		if(u!=null)
    			employee.setUser(new User(u.orElseThrow().getId()));
    		Optional<Enchere> e = enchereRepository.findById(employee.getEnchere().getIdEnchere());
    		if(e!=null)
    			employee.setEnchere(/*new Enchere(e.orElseThrow().getIdEnchere())*/e.orElseThrow());
    		System.out.println("ench selectionné = "+e.orElseThrow());
    		System.out.println("add propos"+employee);
    		System.out.println("ench : "+employee.getEnchere().getIdEnchere()+"user = "+employee.getUser().getId()+"taux "+employee.getTaux_soumission());

    		Proposition newEmployee = propositionRepository
                    .saveAndFlush(employee);
            return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    	}
    	catch(Exception e) {
        	System.out.println("exception  : "+e);     

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    	}
     //   return new ResponseEntity<>(new Proposition() , HttpStatus.OK);

    	
    }

    /**
     * Update Employee record by using it's id
     *
     * @param id
     * @param employee
     * @return
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Proposition> updateEmployee(@PathVariable("id") long id, @RequestBody Proposition employee) {

        //check if employee exist in database
    	Proposition empObj = getEmpRec(id);

        if (empObj != null) {
            //empObj.setName(employee.getName());
            //empObj.setRole(employee.getRole());
            return new ResponseEntity<>(propositionRepository.save(empObj), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
}
