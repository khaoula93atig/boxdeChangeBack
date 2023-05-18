package com.tta.boxchange.job;

import java.io.IOException;
import java.time.LocalDate;

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
import com.tta.boxchange.dao.STBInterface;
import com.tta.boxchange.dao.UIBInterface;
import com.tta.boxchange.dao.VENTEInterface;
import com.tta.boxchange.entities.ATT;
import com.tta.boxchange.entities.VENTE;
import com.tta.boxchange.services.ScrapingService;

@Component
public class ScrappingTask {
	
	@Autowired
	ScrapingController controller;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Scheduled(cron = "0 01 12 * * *")
	   public void cronJobSch() {
		System.err.print("begin scrapping");
		try {
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
		jdbcTemplate.execute("INSERT INTO averagefiras (deviseSAR, deviseCAD, deviseDKK, deviseUSD, deviseGBP, deviseJPY, deviseNOK, deviseSEK, deviseCHF, deviseKWD, deviseAED, deviseEUR, deviseLYD, deviseBHD, deviseQAR, deviseCNY, datedevise)\r\n"
				+ "SELECT\r\n"
				+ "CAST(AVG(NULLIF(\"deviseSAR\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseCAD\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseDKK\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseUSD\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseGBP\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseJPY\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseNOK\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseSEK\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseCHF\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseKWD\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseAED\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseEUR\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseLYD\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseBHD\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseQAR\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "CAST(AVG(NULLIF(\"deviseCNY\"::numeric, 0)) AS numeric(10,4)),\r\n"
				+ "'" + LocalDate.now() + "'\r\n"
				+ "FROM public.\"VENTE\";");
		System.err.print("end scrapping");
	   }

}
