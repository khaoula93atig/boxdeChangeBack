package com.tta.boxchange.job;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tta.boxchange.controllers.ScrapingController;
import com.tta.boxchange.dao.AMENInterface;
import com.tta.boxchange.dao.ATBInterface;
import com.tta.boxchange.dao.ATTInterface;
import com.tta.boxchange.dao.AVGVENTEInterface;
import com.tta.boxchange.dao.BHInterface;
import com.tta.boxchange.dao.BIATInterface;
import com.tta.boxchange.dao.BNAInterface;
import com.tta.boxchange.dao.BTEInterface;
import com.tta.boxchange.dao.BTInterface;
import com.tta.boxchange.dao.BTKInterface;
import com.tta.boxchange.dao.BTLInterface;
import com.tta.boxchange.dao.MaxMinVenteInterface;
import com.tta.boxchange.dao.STBInterface;
import com.tta.boxchange.dao.UIBInterface;
import com.tta.boxchange.dao.VENTEInterface;
import com.tta.boxchange.entities.ATT;
import com.tta.boxchange.entities.AVGVENTE;
import com.tta.boxchange.entities.MaxMinVente;
import com.tta.boxchange.entities.Vente;
import com.tta.boxchange.services.ScrapingService;

@Component
public class ScrappingTask {
	
	@Autowired
	ScrapingController controller;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	AVGVENTEInterface avgVenteInterface;
	
	@Autowired
	MaxMinVenteInterface maxminInterface;
	
	@Scheduled(cron = "0 0 0 * * *")
	   public void viderVente() {
		
		System.out.println("test");
		
		jdbcTemplate.update("DELETE FROM public.vente where datedevise::DATE != NOW()::DATE;");
		
	}
	
	@Scheduled(fixedRate = 1800000) // Exécution toutes les 30 minute
	   public void cronJobSch() {
		System.err.print("begin scrapping");
		try {
			jdbcTemplate.update("DELETE FROM public.vente where datedevise::DATE != NOW()::DATE;");	
			controller.scrapeWebsiteBIAT();
			controller.scrapeWebsiteATB();
			controller.scrapeWebsiteBH();
			controller.scrapeWebsiteAmen();
			controller.scrapeWebsiteBNA();
			controller.scrapeWebsiteBT();
			controller.scrapeWebsiteBTE();
			controller.scrapeWebsiteBTK();
			controller.scrapeWebsiteBTL();
			controller.scrapeWebsiteSTB();
			controller.scrapeWebsiteUIB();
			controller.scrapeWebsiteATTIJARI();
			controller.scrapeWebsiteQNB();
			controller.scrapeWebsiteZITOUNA();
			controller.scrapeWebsiteWIFAK();
			controller.scrapeWebsiteBaraka();
			controller.scrapeWebsiteTSB();
		} catch(IOException ex) {
	
		}
		
		//calcul avrage
		AVGVENTE avg = new AVGVENTE();
		List<AVGVENTE> avgList = avgVenteInterface.verification();
		if(avgList.isEmpty()==true) {
			avgVenteInterface.save(avg);
		}
		else {
			avgVenteInterface.update(avgList.get(0));
		}
		
		//min max job
		MaxMinVente maxMin= new MaxMinVente();
		List<MaxMinVente> maxList=maxminInterface.verif();
		if(maxList.isEmpty()==true) {
			maxminInterface.save(maxMin);
		}
		else {
			maxminInterface.update(maxList.get(0));
		}
		
		System.err.print("end scrapping");
	   }
	
	
	
}
