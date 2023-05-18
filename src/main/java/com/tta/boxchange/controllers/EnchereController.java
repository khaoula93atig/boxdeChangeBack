package com.tta.boxchange.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.tta.boxchange.entities.Enchere;
import com.tta.boxchange.entities.Notification;
import com.tta.boxchange.entities.Proposition;
import com.tta.boxchange.entities.User;
import com.tta.boxchange.repositories.EnchRepository;
import com.tta.boxchange.repositories.EnchereRepository;
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
	
	
/*
	@GetMapping("/specialite/{id}")
	public List<News> findByIDSpecialite(@PathVariable("id") int idSpecialite) {

		return newsInterface.findByIDSpecialite(idSpecialite);
	}
*/
	@PostMapping("/save/{channel}")
	public Enchere save(@RequestBody Enchere enchere,@PathVariable("channel") String channel) {
		Optional<User> u = userRepository.findById(enchere.getUser().getId());
		if(u!=null) {
		enchere.setUser(new User(u.orElseThrow().getId()));
		enchere.setIdEnchere(UUID.randomUUID().toString().replace("-", ""));
		enchere.setReferenceEnchere((u.orElseThrow().getUsername())+"-"+(enchereInterface.countEnchere(u.orElseThrow().getId())));
		System.out.println(enchere);
		Notification notification  = new Notification( );
		notification.setChannel(channel);
		notification.setSender( u.orElseThrow().getUsername());
		notification.setTitre(enchere.getReferenceEnchere());
		notification.setContent(enchere.getDevise());
		
		notificationController.handleNotif(notification);
		}

		return enchereRepository.saveAndFlush(enchere);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody Enchere enchere) {
		return enchereInterface.update(enchere);
	}
	/*
	// categorie 1 ou 2 ou 3 idSpecialite exemple "9ef9bb4a9aff49259acf95306f42886b"
	@GetMapping("/service/{categorie}/{idSpecialite}")
	public List<News> findByIDService(@PathVariable("categorie") int categorie,@PathVariable("idSpecialite") String idSpecialite) {

		return newsInterface.findByIDService(categorie,idSpecialite);
	}
*/

}
