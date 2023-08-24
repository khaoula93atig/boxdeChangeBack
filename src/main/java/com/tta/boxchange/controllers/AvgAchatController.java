package com.tta.boxchange.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.boxchange.entities.AVGVENTE;
import com.tta.boxchange.entities.AverageVenteDevise;
import com.tta.boxchange.entities.AvgAchat;
import com.tta.boxchange.repositories.AVGVENTERepository;
import com.tta.boxchange.repositories.AvgAchatRepository;
import com.tta.boxchange.response.BasicResponse;

@CrossOrigin("*")
@RequestMapping("/avgAchat")
@RestController
public class AvgAchatController {
	@Autowired
	AvgAchatRepository avgAchatRepository;
	
	@PostMapping("/save")
	public BasicResponse save(@RequestBody AvgAchat avgAchat) {
		return avgAchatRepository.save(avgAchat);
	}
	
	@GetMapping("/getByDevise/{devise}")
	public List<AverageVenteDevise> getByDevise(@PathVariable ("devise") String devise){
		return avgAchatRepository.averageBydevise(devise);
	}
	
	@GetMapping("/getAvgDaily")
	public List<AvgAchat> getAvgDaily(){
		return avgAchatRepository.verification();
	}

}
