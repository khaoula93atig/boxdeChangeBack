package com.tta.boxchange.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.boxchange.dao.MaxMinVenteInterface;
import com.tta.boxchange.dao.VENTEInterface;
import com.tta.boxchange.dto.MinMaxResult;
import com.tta.boxchange.entities.Vente;

@CrossOrigin("*")
@RequestMapping("/vente")
@RestController
public class VenteController {
	
	@Autowired
	VENTEInterface venteInterface;
	
	@Autowired
	MaxMinVenteInterface maxMinInterface;
	
	//list des ventes actuelles
	@GetMapping("/LastVentes")
    public List<Vente> getLastVentes() {
	 return venteInterface.findLasts();
	} 
	
	//la valeur maximale de vente de ce jour 
	@GetMapping("/maxVenteJour/{devise}")
	public Float getMaxVenteJour(@PathVariable("devise") String devise) {
		return maxMinInterface.maxJour(devise);
	}
	
	//la valeur minimale de vente de ce jour
	@GetMapping("/minVenteJour/{devise}")
	public Float getMinVenteJour(@PathVariable("devise") String devise) {
		return maxMinInterface.minJour(devise);
	}
	
	//la valeur maximale de vente de cette semaine 
	@GetMapping("/maxVenteSemaine/{devise}")
	public MinMaxResult getMaxVenteSemaine(@PathVariable("devise") String devise) {
		return maxMinInterface.maxVenteSemaine(devise);
	}
		
	//la valeur minimale de vente de cette semaine
	@GetMapping("/minVenteSemaine/{devise}")
	public MinMaxResult getMinVenteSemaine(@PathVariable("devise") String devise) {
		return maxMinInterface.minVenteSemaine(devise);
	}
	
	//la valeur maximale de vente de ce mois 
	@GetMapping("/maxVenteMois/{devise}")
	public MinMaxResult getMaxVenteMois(@PathVariable("devise") String devise) {
		return maxMinInterface.maxVenteMois(devise);
	}
			
	//la valeur minimale de vente de ce mois
	@GetMapping("/minVenteMois/{devise}")
	public MinMaxResult getMinVenteMois(@PathVariable("devise") String devise) {
		return maxMinInterface.minVenteMois(devise);
	}
	
	//la valeur maximale de vente de cette année 
	@GetMapping("/maxVenteAns/{devise}")
	public MinMaxResult getMaxVenteAns(@PathVariable("devise") String devise) {
		return maxMinInterface.maxVenteAns(devise);
	}
				
	//la valeur minimale de vente de cette année
	@GetMapping("/minVenteAns/{devise}")
	public MinMaxResult getMinVenteAns(@PathVariable("devise") String devise) {
		return maxMinInterface.minVenteAns(devise);
	}
	
	
	

}
