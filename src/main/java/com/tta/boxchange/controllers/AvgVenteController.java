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
import com.tta.boxchange.repositories.AVGVENTERepository;
import com.tta.boxchange.response.BasicResponse;

@CrossOrigin("*")
@RequestMapping("/avg")
@RestController
public class AvgVenteController {
	
	@Autowired
	AVGVENTERepository avgventeRepository;
	
	@PostMapping("/save")
	public BasicResponse save(@RequestBody AVGVENTE avgvente) {
		return avgventeRepository.save(avgvente);
	}
	
	@GetMapping("/getByDevise/{devise}")
	public List<AverageVenteDevise> getByDevise(@PathVariable ("devise") String devise){
		return avgventeRepository.averageBydevise(devise);
	}

}
