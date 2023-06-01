package com.tta.boxchange.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.boxchange.dao.EnchereInterface;
import com.tta.boxchange.dao.UserService;
import com.tta.boxchange.entities.ERole;
import com.tta.boxchange.entities.Enchere;
import com.tta.boxchange.entities.Notification;
import com.tta.boxchange.entities.Proposition;
import com.tta.boxchange.entities.Role;
import com.tta.boxchange.entities.User;
import com.tta.boxchange.repositories.EnchRepository;
import com.tta.boxchange.repositories.EnchereRepository;
import com.tta.boxchange.repositories.RoleRepository;
import com.tta.boxchange.repositories.UserRepository;
import com.tta.boxchange.response.BasicResponse;

@CrossOrigin("*")
@RestController
@RequestMapping("/enchere")
public class EnchereController {
	@Autowired
	EnchereInterface enchereInterface;
	
	@Autowired
	EnchRepository enchereRepository;

	@Autowired
    UserRepository userRepository;
	
	@Autowired
	EnchereRepository enchereRepo;
	
	@Autowired
	NotificationController notificationController;
	
	
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping
	public List<Enchere> findAll() {

		return enchereInterface.findAll();
	}
	@GetMapping("/null")
	public List<Enchere> findAllNull() {
		return enchereRepository.findAll();
	}
	@GetMapping("/notnull")
	public List<Enchere> findAllNotNull() {

		return enchereRepository.findAll();
	}
	
	@GetMapping("/getUser/{id}")
    public ResponseEntity<List<Enchere>> getPropositionById(@PathVariable("id") long id) {
        try {
            //check if employee exist in database
        	List<Enchere> list = enchereRepository.findAllByUser_Id(id);

            if (list != null) {
                return new ResponseEntity<>(list, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
	
	@PostMapping("/save")
	public Enchere save(@RequestBody Enchere enchere,Pageable pageable) {
		Optional<User> u = userRepository.findById(enchere.getUser().getId());
		
		//get users by role bank
		List<User> users = new ArrayList<>();
		Optional<Role> roleOptional = roleRepository.findByName(ERole.ROLE_BANK);
		  if (roleOptional.isPresent()) {
			    Role adminRole = roleOptional.get();
			    users = userRepository.findByRolesIn(Collections.singleton(adminRole),pageable);
			} else {
				users=new ArrayList<>();
			}
		  
		  
		  //add enchere
		if(u!=null) {
		enchere.setUser(new User(u.orElseThrow().getId()));
		enchere.setIdEnchere(UUID.randomUUID().toString().replace("-", ""));
		enchere.setReferenceEnchere((u.orElseThrow().getUsername())+"-"+(enchereInterface.countEnchere(u.orElseThrow().getId())));
		System.out.println(enchere);
		
		//add notification pour chaque user de bank 
		 for(User us : users) {
		Notification notification  = new Notification( );
		notification.setChannel(us.getId().toString());
		notification.setSender( u.orElseThrow().getUsername());
		notification.setTitre(enchere.getReferenceEnchere());
		notification.setContent(enchere.getDevise());
		notification.setType("enchere");
		
		notificationController.handleNotif(notification);
		 }
		}

		return enchereRepository.saveAndFlush(enchere);
	}
	


	@PutMapping("/update")
	public BasicResponse update(@RequestBody Enchere enchere) {
		
		//update enchere 
		return enchereInterface.update(enchere);
	}
	

}
