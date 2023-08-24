package com.tta.boxchange.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.boxchange.dao.AchatInterface;
import com.tta.boxchange.dao.MinMaxAchatInterface;
import com.tta.boxchange.dto.MinMaxResult;
import com.tta.boxchange.entities.Achat;

@CrossOrigin("*")
@RequestMapping("/achat")
@RestController
public class AchatController {
	
	@Autowired
	AchatInterface achatInterface;
	
	@Autowired
	MinMaxAchatInterface maxMinInterface;
	
	@GetMapping("/LastAchat")
    public List<Achat> getLastAchat() {
	 return achatInterface.findLasts();
	} 
	//la valeur maximale de Achat de ce jour 
		@GetMapping("/maxAchatJour/{devise}")
		public Float getMaxAchatJour(@PathVariable("devise") String devise) {
			return maxMinInterface.maxJour(devise);
		}
		
		//la valeur minimale de Achat de ce jour
		@GetMapping("/minAchatJour/{devise}")
		public Float getMinAchatJour(@PathVariable("devise") String devise) {
			return maxMinInterface.minJour(devise);
		}
		
		//la valeur maximale de Achat de cette semaine 
		@GetMapping("/maxAchatSemaine/{devise}")
		public MinMaxResult getMaxAchatSemaine(@PathVariable("devise") String devise) {
			return maxMinInterface.maxAchatSemaine(devise);
		}
			
		//la valeur minimale de Achat de cette semaine
		@GetMapping("/minAchatSemaine/{devise}")
		public MinMaxResult getMinAchatSemaine(@PathVariable("devise") String devise) {
			return maxMinInterface.minAchatSemaine(devise);
		}
		
		//la valeur maximale de Achat de ce mois 
		@GetMapping("/maxAchatMois/{devise}")
		public MinMaxResult getMaxAchatMois(@PathVariable("devise") String devise) {
			return maxMinInterface.maxAchatMois(devise);
		}
				
		//la valeur minimale de Achat de ce mois
		@GetMapping("/minAchatMois/{devise}")
		public MinMaxResult getMinAchatMois(@PathVariable("devise") String devise) {
			return maxMinInterface.minAchatMois(devise);
		}
		
		//la valeur maximale de Achat de cette année 
		@GetMapping("/maxAchatAns/{devise}")
		public MinMaxResult getMaxAchatAns(@PathVariable("devise") String devise) {
			return maxMinInterface.maxAchatAns(devise);
		}
					
		//la valeur minimale de Achat de cette année
		@GetMapping("/minAchatAns/{devise}")
		public MinMaxResult getMinAchatAns(@PathVariable("devise") String devise) {
			return maxMinInterface.minAchatAns(devise);
		}

}
