package com.tta.boxchange.controllers;

import java.io.IOException;
import com.tta.boxchange.dao.STBInterface;
import com.tta.boxchange.dao.BIATInterface;
import com.tta.boxchange.dao.BHInterface;
import com.tta.boxchange.dao.AMENInterface;
import com.tta.boxchange.dao.UIBInterface;
import com.tta.boxchange.dao.AVGVENTEInterface;
import com.tta.boxchange.dao.AchatInterface;
import com.tta.boxchange.dao.VENTEInterface;
import com.tta.boxchange.dto.ChartDto;
import com.tta.boxchange.dao.ATTInterface;
import com.tta.boxchange.dao.ATBInterface;
import com.tta.boxchange.dao.BTLInterface;
import com.tta.boxchange.dao.BTKInterface;
import com.tta.boxchange.dao.BTEInterface;
import com.tta.boxchange.dao.BTInterface;
import com.tta.boxchange.dao.BNAInterface;
import com.tta.boxchange.dao.BoxInterface;
import org.springframework.web.bind.annotation.PutMapping;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tta.boxchange.entities.STB;
import com.tta.boxchange.entities.BIAT;
import com.tta.boxchange.entities.BH;
import com.tta.boxchange.entities.AMEN;
import com.tta.boxchange.entities.BNA;
import com.tta.boxchange.entities.UIB;
import com.tta.boxchange.entities.Vente;
import com.tta.boxchange.entities.ATT;
import com.tta.boxchange.entities.ATB;
import com.tta.boxchange.entities.BTL;
import com.tta.boxchange.entities.AVGVENTE;
import com.tta.boxchange.entities.Achat;
import com.tta.boxchange.entities.BTK;
import com.tta.boxchange.entities.BTE;
import com.tta.boxchange.entities.BT;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tta.boxchange.entities.Box;
import com.tta.boxchange.response.BasicResponse;
import com.tta.boxchange.services.ScrapingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")

@RestController
public class ScrapingController {

	@Autowired
	STBInterface stbInterface;
	@Autowired
	BIATInterface biatInterface;
	@Autowired
	BHInterface bhInterface;
	@Autowired
	AMENInterface amenInterface;
	@Autowired
	BNAInterface bnaInterface;
	@Autowired
	UIBInterface uibInterface;
	@Autowired
	ATTInterface attInterface;
	@Autowired
	ATBInterface atbInterface;
	@Autowired
	BTLInterface btlInterface;
	@Autowired
	BTKInterface btkInterface;
	@Autowired
	BTEInterface bteInterface;
	@Autowired
	BTInterface btInterface;
	@Autowired
	AVGVENTEInterface avgventeInterface;
	@Autowired
	VENTEInterface venteInterface;
	@Autowired
	AchatInterface achatInterface;
	@Autowired
	ScrapingService scrapingService;
	
    @GetMapping("/scrapeSTB1")
    public String scrapeSTB() throws Exception {
        String url = "https://www.stb.com.tn/fr/site/bourse-change/cours-de-change/";
        Document document = Jsoup.connect(url).get();
        String html = document.html();
        return html;
    }
    
    @GetMapping("/scrapeSTB")
    public ResponseEntity<String> getMyJsonData1() throws IOException  {
        String url = "https://www.stb.com.tn/fr/site/bourse-change/cours-de-change/";
        Document document = Jsoup.connect(url).get();
        String firstLine0 = document.html().split("\n")[223];
        String firstLine1 = document.html().split("\n")[224];
        String firstLine2 = document.html().split("\n")[225];
        String firstLine3 = document.html().split("\n")[226];
        String firstLine4 = document.html().split("\n")[227];
        String firstLine01 = document.html().split("\n")[230];
        String firstLine11 = document.html().split("\n")[231];
        String firstLine21 = document.html().split("\n")[232];
        String firstLine31 = document.html().split("\n")[233];
        String firstLine41 = document.html().split("\n")[234];
        String firstLine02 = document.html().split("\n")[237];
        String firstLine12 = document.html().split("\n")[238];
        String firstLine22 = document.html().split("\n")[239];
        String firstLine32 = document.html().split("\n")[240];
        String firstLine42 = document.html().split("\n")[241];
        String firstLine03 = document.html().split("\n")[244];
        String firstLine13 = document.html().split("\n")[245];
        String firstLine23 = document.html().split("\n")[246];
        String firstLine33 = document.html().split("\n")[247];
        String firstLine43 = document.html().split("\n")[248];
        String html = document.html();
        String partOfLine0 = firstLine0.substring(38,41);
        String partOfLine1 = firstLine1.substring(38,40);
        String partOfLine2 = firstLine2.substring(39,44);
        String partOfLine3 = firstLine3.substring(39,44);
        String partOfLine4 = firstLine4.substring(38,46);
        String partOfLine01 = firstLine01.substring(38,41);
        String partOfLine11 = firstLine11.substring(38,39);
        String partOfLine21 = firstLine21.substring(39,44);
        String partOfLine31 = firstLine31.substring(39,44);
        String partOfLine41 = firstLine41.substring(38,46);
        String partOfLine02 = firstLine02.substring(38,41);
        String partOfLine12 = firstLine12.substring(38,39);
        String partOfLine22 = firstLine22.substring(39,44);
        String partOfLine32 = firstLine32.substring(39,44);
        String partOfLine42 = firstLine42.substring(38,46);
        String partOfLine03 = firstLine03.substring(38,41);
        String partOfLine13 = firstLine13.substring(38,40);
        String partOfLine23 = firstLine23.substring(39,45);
        String partOfLine33 = firstLine33.substring(39,45);
        String partOfLine43 = firstLine43.substring(38,46);
        String multipleStrings = partOfLine0 + "  " + partOfLine1+ "  " + partOfLine2+ "  " + partOfLine3+ "  " + partOfLine4
        		+ " \n " +partOfLine01 + "  " + partOfLine11+ "  " + partOfLine21+ "  " + partOfLine31+ "  " + partOfLine41+
        		" \n " +partOfLine02 + "  " + partOfLine12+ "  " + partOfLine22+ "  " + partOfLine32+ "  " + partOfLine42+
        		" \n " +partOfLine03 + "  " + partOfLine13+ "  " + partOfLine23+ "  " + partOfLine33+ "  " + partOfLine43
        		
        		
        		;
        return ResponseEntity.ok(multipleStrings);
    }
    @GetMapping("/scrapeBH")
    public String scrapeBH() throws Exception {
        String url = "https://www.bh.com.tn/les-cours-de-change";
        Document document = Jsoup.connect(url).get();
        String html = document.html();
        return html;
    }
    @GetMapping("/scrapeAmen")
    public String scrapeAmen() throws Exception {
        String url = "https://www.dinartunisien.com/fr/banque/amen-banque";
        Document document = Jsoup.connect(url).get();
        String html = document.html();
        return html;
    }
    
    @GetMapping("/my-json-data")
    public ResponseEntity<String> getMyJsonData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL("http://www.bhinvest.com.tn/actualites?_format=json");
        JsonNode jsonNode = mapper.readTree(url);

        // Get the content of line 100 as a String
        String line100Content = jsonNode.get(99).toString();

        // Return the response with the content of line 100
        return ResponseEntity.ok(line100Content);
    }
    
    @GetMapping("/scrapeee")
    public Map<String, String> scrapeWebsite() throws IOException {
        String url = "https://example.com";
        Document doc = Jsoup.connect(url).get();
        String title = doc.title();
        String description = doc.select("meta[name=description]").attr("content");
        Map<String, String> data = new HashMap<>();
        data.put("title", title);
        data.put("description", description);
        System.out.println(title);
        System.out.println(description);
        return data;
    }
    
   
  
    @GetMapping("/scrapeBIATT")
    public String scrapeWebsiteBIAT() throws IOException {
   	 // need http protocol
   	try {
   	Document doc;
       doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/biat").get();
      
       // get page title
       String title = doc.title();
       System.out.println("title6 : " + title);
       
     
     Element AED = doc.select("td.text-uppercase").get(0);
     String nomdevise0 = AED.text();
     System.out.println("title 0 : " + nomdevise0);
       Element UniteSAR = doc.select("td.font-weight-bold").get(0);
       String achatDevise0 = UniteSAR.text();
       System.out.println("achat 0 : " + achatDevise0);
       Element td1 = doc.select("td.font-weight-bold").get(1);
       String venteDevise0 = td1.text();
       System.out.println("vente 0 : " + venteDevise0);
       Element td0 = doc.select("td.text-center").get(2);
       String uniteDevise0 = td0.text();
       System.out.println("unite0 : " + uniteDevise0);
      // System.out.println("title4 : " + VenteDevise0);
       
       Element CNY = doc.select("td.text-uppercase").get(1);
       String nomdevise5 = CNY.text();
       System.out.println("title : " + nomdevise5);
       Element UniteCNY = doc.select("td.font-weight-bold").get(2);
       String achatDevise5 = UniteCNY.text();
       System.out.println("unite 1 : " + achatDevise5);
       Element td10 = doc.select("td.font-weight-bold").get(3);
       String venteDevise5 = td10.text();
       System.out.println("achat 1 : " + venteDevise5);
       Element td11 = doc.select("td.text-center").get(7);
       String uniteDevise5 = td11.text();
       System.out.println("vente2 : " + uniteDevise5);
       
       Element GBP = doc.select("td.text-uppercase").get(2);
       String nomdevise14 = GBP.text();
       Element achatGBP = doc.select("td.font-weight-bold").get(4);
       String achatDevise14 = achatGBP.text();
      
       Element td28 = doc.select("td.font-weight-bold").get(5);
       String venteDevise14 = td28.text();
       Element td29 = doc.select("td.text-center").get(12);
       String uniteDevise14 = td29.text();
       
       Element DKK = doc.select("td.text-uppercase").get(3);
       String nomdevise2 = DKK.text();
       Element achatDKK = doc.select("td.font-weight-bold").get(6);
       String achatDevise2 = achatDKK.text();
       Element td4 = doc.select("td.font-weight-bold").get(7);
       String venteDevise2 = td4.text();
       Element td5 = doc.select("td.text-center").get(17);
       String uniteDevise2 = td5.text();

       Element USD = doc.select("td.text-uppercase").get(4);
       String nomdevise4 = USD.text();
       Element achatUSD = doc.select("td.font-weight-bold").get(8);
       String achatDevise4 = achatUSD.text();
       Element td8 = doc.select("td.font-weight-bold").get(9);
       String venteDevise4 = td8.text();
       Element td9 = doc.select("td.text-center").get(22);
       String uniteDevise4 = td9.text();
       
       Element JPY = doc.select("td.text-uppercase").get(5);
       String nomdevise6 = JPY.text();
       Element achatJPY = doc.select("td.font-weight-bold").get(10);
       String achatDevise6 = achatJPY.text();
       Element td12 = doc.select("td.font-weight-bold").get(11);
       String venteDevise6 = td12.text();
       Element td13 = doc.select("td.text-center").get(27);
       String uniteDevise6 = td13.text();
       
       Element EUR = doc.select("td.text-uppercase").get(6);
       String nomdevise12 = EUR.text();
       Element achatEUR = doc.select("td.font-weight-bold").get(12);
       String achatDevise12 = achatEUR.text();
       Element td24 = doc.select("td.font-weight-bold").get(13);
       String venteDevise12 = td24.text();
       Element td25 = doc.select("td.text-center").get(32);
       String uniteDevise12 = td25.text();
 
    
       Element CAD = doc.select("td.text-uppercase").get(7);
       String nomdevise1 = CAD.text();
       Element achatCAD = doc.select("td.font-weight-bold").get(14);
       String achatDevise1 = achatCAD.text();
       Element td2 = doc.select("td.font-weight-bold").get(15);
       String venteDevise1 = td2.text();
       Element td3 = doc.select("td.text-center").get(37);
       String uniteDevise1 = td3.text();
      
     
     
     
       Element ggg = doc.select("td.text-uppercase").get(8);
       String nomdevise3 = ggg.text();
       Element achatggg = doc.select("td.font-weight-bold").get(16);
       String achatDevise3 = achatggg.text();
       Element td6 = doc.select("td.font-weight-bold").get(17);
       String venteDevise3 = td6.text();
       Element td7 = doc.select("td.text-center").get(42);
       String uniteDevise3 = td7.text();
     
       
     
       
     
     
       Element KWD = doc.select("td.text-uppercase").get(9);
       String nomdevise7 = KWD.text();
       Element achatKWD = doc.select("td.font-weight-bold").get(18);
       String achatDevise7 = achatKWD.text();
       Element td14 = doc.select("td.font-weight-bold").get(19);
       String venteDevise7 = td14.text();
       Element td15 = doc.select("td.text-center").get(47);
       String uniteDevise7 = td15.text();
     
       Element NOK = doc.select("td.text-uppercase").get(10);
       String nomdevise8 = NOK.text();
       Element achatNOK = doc.select("td.font-weight-bold").get(20);
       String achatDevise8 = achatNOK.text();
       Element td16 = doc.select("td.font-weight-bold").get(21);
       String venteDevise8 = td16.text();
       Element td17 = doc.select("td.text-center").get(52);
       String uniteDevise8 = td17.text();
     
       Element QAR = doc.select("td.text-uppercase").get(11);
       String nomdevise9 = QAR.text();
       Element achatQAR = doc.select("td.font-weight-bold").get(22);
       String achatDevise9 = achatQAR.text();
       Element td18 = doc.select("td.font-weight-bold").get(23);
       String venteDevise9 = td18.text();
       Element td19 = doc.select("td.text-center").get(57);
       String uniteDevise9 = td19.text();
     
       Element SEK = doc.select("td.text-uppercase").get(12);
       String nomdevise10 = SEK.text();
       Element achatSEK = doc.select("td.font-weight-bold").get(24);
       String achatDevise10 = achatSEK.text();
       Element td20 = doc.select("td.font-weight-bold").get(25);
       String venteDevise10 = td20.text();
       Element td21 = doc.select("td.text-center").get(62);
       String uniteDevise10 = td21.text();
     
       Element CHF = doc.select("td.text-uppercase").get(13);
       String nomdevise11 = CHF.text();
       Element achatCHF = doc.select("td.font-weight-bold").get(26);
       String achatDevise11 = achatCHF.text();
       Element td22 = doc.select("td.font-weight-bold").get(27);
       String venteDevise11 = td22.text();
       Element td23 = doc.select("td.text-center").get(67);
       String uniteDevise11 = td23.text();

      
     
       Element BHD = doc.select("td.text-uppercase").get(14);
       String nomdevise13 = BHD.text();
       Element achatBHD = doc.select("td.font-weight-bold").get(28);
       String achatDevise13 = achatBHD.text();
       System.out.println("unite 5 : " + achatDevise13);
       Element td26 = doc.select("td.font-weight-bold").get(29);
       String venteDevise13 = td26.text();
       Element td27 = doc.select("td.text-center").get(72);
       String uniteDevise13 = td27.text();
     
      
       

       Achat achat = new Achat();
       achat.setData("biat", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
    		   achatDevise12,achatDevise1,  achatDevise3, 
    		   achatDevise7, achatDevise8, achatDevise9,"0",achatDevise10,
    		   achatDevise11,  achatDevise13,  achatDevise0);
     //verfication 
       List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
       
       if(verfAchat.isEmpty()) {
    	   //ajout
    	   achatInterface.save(achat);
       }
       else  {
    	   //update
    	   achatInterface.updateAchat(verfAchat.get(0), achat);
       }
       
       Vente v = new Vente();
       v.setData("biat", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
    		   venteDevise12,venteDevise1,  venteDevise3, 
    		   venteDevise7,venteDevise8, venteDevise9,"0",venteDevise10,
    		   venteDevise11,  venteDevise13,  venteDevise0);
       //verfication 
       List<Vente> verf = venteInterface.verification(v.getNomBanque());
       
       if(verf.isEmpty()) {
    	   //ajout
    	   venteInterface.save(v);
       }
       else  {
    	   //update
    	   venteInterface.updateVente(verf.get(0), v);
       }
       return("ok");
       
       
     
       
      	}catch (Exception e) {
  			return("no"+e);
  		}
             
      
  
       
   }
    @GetMapping("/scrapeZITOUNAA")
    public String scrapeWebsiteZITOUNA() throws IOException {
   	 // need http protocol
   	try {
   	Document doc;
       doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/zitouna").get();
      
       // get page title
       String title = doc.title();
       System.out.println("title6 : " + title);
      
       
     
       Element AED = doc.select("td.text-uppercase").get(0);
       String nomdevise0 = AED.text();
       System.out.println("title 0 : " + nomdevise0);
         Element UniteSAR = doc.select("td.font-weight-bold").get(0);
         String achatDevise0 = UniteSAR.text();
         System.out.println("achat 0 : " + achatDevise0);
         Element td1 = doc.select("td.font-weight-bold").get(1);
         String venteDevise0 = td1.text();
         System.out.println("vente 0 : " + venteDevise0);
         Element td0 = doc.select("td.text-center").get(2);
         String uniteDevise0 = td0.text();
         System.out.println("unite0 : " + uniteDevise0);
        // System.out.println("title4 : " + VenteDevise0);
         
         Element CNY = doc.select("td.text-uppercase").get(1);
         String nomdevise5 = CNY.text();
         System.out.println("title : " + nomdevise5);
         Element UniteCNY = doc.select("td.font-weight-bold").get(2);
         String achatDevise5 = UniteCNY.text();
         System.out.println("unite 1 : " + achatDevise5);
         Element td10 = doc.select("td.font-weight-bold").get(3);
         String venteDevise5 = td10.text();
         System.out.println("achat 1 : " + venteDevise5);
         Element td11 = doc.select("td.text-center").get(7);
         String uniteDevise5 = td11.text();
         System.out.println("vente2 : " + uniteDevise5);
         
         Element GBP = doc.select("td.text-uppercase").get(2);
         String nomdevise14 = GBP.text();
         Element achatGBP = doc.select("td.font-weight-bold").get(4);
         String achatDevise14 = achatGBP.text();
        
         Element td28 = doc.select("td.font-weight-bold").get(5);
         String venteDevise14 = td28.text();
         Element td29 = doc.select("td.text-center").get(12);
         String uniteDevise14 = td29.text();
         
         Element DKK = doc.select("td.text-uppercase").get(3);
         String nomdevise2 = DKK.text();
         Element achatDKK = doc.select("td.font-weight-bold").get(6);
         String achatDevise2 = achatDKK.text();
         Element td4 = doc.select("td.font-weight-bold").get(7);
         String venteDevise2 = td4.text();
         Element td5 = doc.select("td.text-center").get(17);
         String uniteDevise2 = td5.text();

         Element USD = doc.select("td.text-uppercase").get(4);
         String nomdevise4 = USD.text();
         Element achatUSD = doc.select("td.font-weight-bold").get(8);
         String achatDevise4 = achatUSD.text();
         Element td8 = doc.select("td.font-weight-bold").get(9);
         String venteDevise4 = td8.text();
         Element td9 = doc.select("td.text-center").get(22);
         String uniteDevise4 = td9.text();
         
         Element JPY = doc.select("td.text-uppercase").get(5);
         String nomdevise6 = JPY.text();
         Element achatJPY = doc.select("td.font-weight-bold").get(10);
         String achatDevise6 = achatJPY.text();
         Element td12 = doc.select("td.font-weight-bold").get(11);
         String venteDevise6 = td12.text();
         Element td13 = doc.select("td.text-center").get(27);
         String uniteDevise6 = td13.text();
         
         Element EUR = doc.select("td.text-uppercase").get(6);
         String nomdevise12 = EUR.text();
         Element achatEUR = doc.select("td.font-weight-bold").get(12);
         String achatDevise12 = achatEUR.text();
         Element td24 = doc.select("td.font-weight-bold").get(13);
         String venteDevise12 = td24.text();
         Element td25 = doc.select("td.text-center").get(32);
         String uniteDevise12 = td25.text();
   
      
         Element CAD = doc.select("td.text-uppercase").get(7);
         String nomdevise1 = CAD.text();
         Element achatCAD = doc.select("td.font-weight-bold").get(14);
         String achatDevise1 = achatCAD.text();
         Element td2 = doc.select("td.font-weight-bold").get(15);
         String venteDevise1 = td2.text();
         Element td3 = doc.select("td.text-center").get(37);
         String uniteDevise1 = td3.text();
        
       
       
       
         Element ggg = doc.select("td.text-uppercase").get(8);
         String nomdevise3 = ggg.text();
         Element achatggg = doc.select("td.font-weight-bold").get(16);
         String achatDevise3 = achatggg.text();
         Element td6 = doc.select("td.font-weight-bold").get(17);
         String venteDevise3 = td6.text();
         Element td7 = doc.select("td.text-center").get(42);
         String uniteDevise3 = td7.text();
       
         
       
         
       
       
         Element KWD = doc.select("td.text-uppercase").get(9);
         String nomdevise7 = KWD.text();
         Element achatKWD = doc.select("td.font-weight-bold").get(18);
         String achatDevise7 = achatKWD.text();
         Element td14 = doc.select("td.font-weight-bold").get(19);
         String venteDevise7 = td14.text();
         Element td15 = doc.select("td.text-center").get(47);
         String uniteDevise7 = td15.text();
       
         Element NOK = doc.select("td.text-uppercase").get(10);
         String nomdevise8 = NOK.text();
         Element achatNOK = doc.select("td.font-weight-bold").get(20);
         String achatDevise8 = achatNOK.text();
         Element td16 = doc.select("td.font-weight-bold").get(21);
         String venteDevise8 = td16.text();
         Element td17 = doc.select("td.text-center").get(52);
         String uniteDevise8 = td17.text();
       
         Element QAR = doc.select("td.text-uppercase").get(11);
         String nomdevise9 = QAR.text();
         Element achatQAR = doc.select("td.font-weight-bold").get(22);
         String achatDevise9 = achatQAR.text();
         Element td18 = doc.select("td.font-weight-bold").get(23);
         String venteDevise9 = td18.text();
         Element td19 = doc.select("td.text-center").get(57);
         String uniteDevise9 = td19.text();
       
         Element SEK = doc.select("td.text-uppercase").get(12);
         String nomdevise10 = SEK.text();
         Element achatSEK = doc.select("td.font-weight-bold").get(24);
         String achatDevise10 = achatSEK.text();
         Element td20 = doc.select("td.font-weight-bold").get(25);
         String venteDevise10 = td20.text();
         Element td21 = doc.select("td.text-center").get(62);
         String uniteDevise10 = td21.text();
       
         Element CHF = doc.select("td.text-uppercase").get(13);
         String nomdevise11 = CHF.text();
         Element achatCHF = doc.select("td.font-weight-bold").get(26);
         String achatDevise11 = achatCHF.text();
         Element td22 = doc.select("td.font-weight-bold").get(27);
         String venteDevise11 = td22.text();
         Element td23 = doc.select("td.text-center").get(67);
         String uniteDevise11 = td23.text();

        
       
         Element BHD = doc.select("td.text-uppercase").get(14);
         String nomdevise13 = BHD.text();
         Element achatBHD = doc.select("td.font-weight-bold").get(28);
         String achatDevise13 = achatBHD.text();
         System.out.println("unite 5 : " + achatDevise13);
         Element td26 = doc.select("td.font-weight-bold").get(29);
         String venteDevise13 = td26.text();
         Element td27 = doc.select("td.text-center").get(72);
         String uniteDevise13 = td27.text();
       
        
         

         Achat achat = new Achat();
         achat.setData("zitouna", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
      		   achatDevise12,achatDevise1,  achatDevise3, 
      		   achatDevise7, achatDevise8, achatDevise9,"0",achatDevise10,
      		   achatDevise11,  achatDevise13,  achatDevise0);
       //verfication 
         List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
         
         if(verfAchat.isEmpty()) {
      	   //ajout
      	   achatInterface.save(achat);
         }
         else  {
      	   //update
      	   achatInterface.updateAchat(verfAchat.get(0), achat);
         }
         
         Vente v = new Vente();
         v.setData("zitouna", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
      		   venteDevise12,venteDevise1,  venteDevise3, 
      		   venteDevise7,venteDevise8, venteDevise9,"0",venteDevise10,
      		   venteDevise11,  venteDevise13,  venteDevise0);
         //verfication 
         List<Vente> verf = venteInterface.verification(v.getNomBanque());
         
         if(verf.isEmpty()) {
      	   //ajout
      	   venteInterface.save(v);
         }
         else  {
      	   //update
      	   venteInterface.updateVente(verf.get(0), v);
         }
       
              return("ok");
      	}catch (Exception e) {
  			return("no"+e);
  		}
             
      
  
       
   }
    
    @GetMapping("/scrapeWIFAKK")
    public String scrapeWebsiteWIFAK() throws IOException {
   	 // need http protocol
   	try {
   	Document doc;
       doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/wifak-bank").get();
      
       // get page title
       String title = doc.title();
       System.out.println("title6 : " + title);
       
       
     
       Element AED = doc.select("td.text-uppercase").get(0);
       String nomdevise0 = AED.text();
       System.out.println("title 0 : " + nomdevise0);
         Element UniteSAR = doc.select("td.font-weight-bold").get(0);
         String achatDevise0 = UniteSAR.text();
         System.out.println("achat 0 : " + achatDevise0);
         Element td1 = doc.select("td.font-weight-bold").get(1);
         String venteDevise0 = td1.text();
         System.out.println("vente 0 : " + venteDevise0);
         Element td0 = doc.select("td.text-center").get(2);
         String uniteDevise0 = td0.text();
         System.out.println("unite0 : " + uniteDevise0);
        // System.out.println("title4 : " + VenteDevise0);
         
         Element CNY = doc.select("td.text-uppercase").get(1);
         String nomdevise5 = CNY.text();
         System.out.println("title : " + nomdevise5);
         Element UniteCNY = doc.select("td.font-weight-bold").get(2);
         String achatDevise5 = UniteCNY.text();
         System.out.println("unite 1 : " + achatDevise5);
         Element td10 = doc.select("td.font-weight-bold").get(3);
         String venteDevise5 = td10.text();
         System.out.println("achat 1 : " + venteDevise5);
         Element td11 = doc.select("td.text-center").get(7);
         String uniteDevise5 = td11.text();
         System.out.println("vente2 : " + uniteDevise5);
         
         Element GBP = doc.select("td.text-uppercase").get(2);
         String nomdevise14 = GBP.text();
         Element achatGBP = doc.select("td.font-weight-bold").get(4);
         String achatDevise14 = achatGBP.text();
        
         Element td28 = doc.select("td.font-weight-bold").get(5);
         String venteDevise14 = td28.text();
         Element td29 = doc.select("td.text-center").get(12);
         String uniteDevise14 = td29.text();
         
         Element DKK = doc.select("td.text-uppercase").get(3);
         String nomdevise2 = DKK.text();
         Element achatDKK = doc.select("td.font-weight-bold").get(6);
         String achatDevise2 = achatDKK.text();
         Element td4 = doc.select("td.font-weight-bold").get(7);
         String venteDevise2 = td4.text();
         Element td5 = doc.select("td.text-center").get(17);
         String uniteDevise2 = td5.text();

         Element USD = doc.select("td.text-uppercase").get(4);
         String nomdevise4 = USD.text();
         Element achatUSD = doc.select("td.font-weight-bold").get(8);
         String achatDevise4 = achatUSD.text();
         Element td8 = doc.select("td.font-weight-bold").get(9);
         String venteDevise4 = td8.text();
         Element td9 = doc.select("td.text-center").get(22);
         String uniteDevise4 = td9.text();
         
         Element JPY = doc.select("td.text-uppercase").get(5);
         String nomdevise6 = JPY.text();
         Element achatJPY = doc.select("td.font-weight-bold").get(10);
         String achatDevise6 = achatJPY.text();
         Element td12 = doc.select("td.font-weight-bold").get(11);
         String venteDevise6 = td12.text();
         Element td13 = doc.select("td.text-center").get(27);
         String uniteDevise6 = td13.text();
         
         Element EUR = doc.select("td.text-uppercase").get(6);
         String nomdevise12 = EUR.text();
         Element achatEUR = doc.select("td.font-weight-bold").get(12);
         String achatDevise12 = achatEUR.text();
         Element td24 = doc.select("td.font-weight-bold").get(13);
         String venteDevise12 = td24.text();
         Element td25 = doc.select("td.text-center").get(32);
         String uniteDevise12 = td25.text();
   
      
         Element CAD = doc.select("td.text-uppercase").get(7);
         String nomdevise1 = CAD.text();
         Element achatCAD = doc.select("td.font-weight-bold").get(14);
         String achatDevise1 = achatCAD.text();
         Element td2 = doc.select("td.font-weight-bold").get(15);
         String venteDevise1 = td2.text();
         Element td3 = doc.select("td.text-center").get(37);
         String uniteDevise1 = td3.text();
        
       
       
       
         Element ggg = doc.select("td.text-uppercase").get(8);
         String nomdevise3 = ggg.text();
         Element achatggg = doc.select("td.font-weight-bold").get(16);
         String achatDevise3 = achatggg.text();
         Element td6 = doc.select("td.font-weight-bold").get(17);
         String venteDevise3 = td6.text();
         Element td7 = doc.select("td.text-center").get(42);
         String uniteDevise3 = td7.text();
       
         
       
         
       
       
         Element KWD = doc.select("td.text-uppercase").get(9);
         String nomdevise7 = KWD.text();
         Element achatKWD = doc.select("td.font-weight-bold").get(18);
         String achatDevise7 = achatKWD.text();
         Element td14 = doc.select("td.font-weight-bold").get(19);
         String venteDevise7 = td14.text();
         Element td15 = doc.select("td.text-center").get(47);
         String uniteDevise7 = td15.text();
       
         Element NOK = doc.select("td.text-uppercase").get(10);
         String nomdevise8 = NOK.text();
         Element achatNOK = doc.select("td.font-weight-bold").get(20);
         String achatDevise8 = achatNOK.text();
         Element td16 = doc.select("td.font-weight-bold").get(21);
         String venteDevise8 = td16.text();
         Element td17 = doc.select("td.text-center").get(52);
         String uniteDevise8 = td17.text();
       
         Element QAR = doc.select("td.text-uppercase").get(11);
         String nomdevise9 = QAR.text();
         Element achatQAR = doc.select("td.font-weight-bold").get(22);
         String achatDevise9 = achatQAR.text();
         Element td18 = doc.select("td.font-weight-bold").get(23);
         String venteDevise9 = td18.text();
         Element td19 = doc.select("td.text-center").get(57);
         String uniteDevise9 = td19.text();
       
         Element SEK = doc.select("td.text-uppercase").get(12);
         String nomdevise10 = SEK.text();
         Element achatSEK = doc.select("td.font-weight-bold").get(24);
         String achatDevise10 = achatSEK.text();
         Element td20 = doc.select("td.font-weight-bold").get(25);
         String venteDevise10 = td20.text();
         Element td21 = doc.select("td.text-center").get(62);
         String uniteDevise10 = td21.text();
       
         Element CHF = doc.select("td.text-uppercase").get(13);
         String nomdevise11 = CHF.text();
         Element achatCHF = doc.select("td.font-weight-bold").get(26);
         String achatDevise11 = achatCHF.text();
         Element td22 = doc.select("td.font-weight-bold").get(27);
         String venteDevise11 = td22.text();
         Element td23 = doc.select("td.text-center").get(67);
         String uniteDevise11 = td23.text();

        
       
         Element BHD = doc.select("td.text-uppercase").get(14);
         String nomdevise13 = BHD.text();
         Element achatBHD = doc.select("td.font-weight-bold").get(28);
         String achatDevise13 = achatBHD.text();
         System.out.println("unite 5 : " + achatDevise13);
         Element td26 = doc.select("td.font-weight-bold").get(29);
         String venteDevise13 = td26.text();
         Element td27 = doc.select("td.text-center").get(72);
         String uniteDevise13 = td27.text();
       
        
         

         Achat achat = new Achat();
         achat.setData("wifak", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
      		   achatDevise12,achatDevise1,  achatDevise3, 
      		   achatDevise7, achatDevise8, achatDevise9,"0",achatDevise10,
      		   achatDevise11,  achatDevise13,  achatDevise0);
       //verfication 
         List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
         
         if(verfAchat.isEmpty()) {
      	   //ajout
      	   achatInterface.save(achat);
         }
         else  {
      	   //update
      	   achatInterface.updateAchat(verfAchat.get(0), achat);
         }
         
         Vente v = new Vente();
         v.setData("wifak", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
      		   venteDevise12,venteDevise1,  venteDevise3, 
      		   venteDevise7,venteDevise8, venteDevise9,"0",venteDevise10,
      		   venteDevise11,  venteDevise13,  venteDevise0);
         //verfication 
         List<Vente> verf = venteInterface.verification(v.getNomBanque());
         
         if(verf.isEmpty()) {
      	   //ajout
      	   venteInterface.save(v);
         }
         else  {
      	   //update
      	   venteInterface.updateVente(verf.get(0), v);
         }
       
       return("ok");
      	}catch (Exception e) {
  			return("no"+e);
  		}
             
      
  
       
   }
    @GetMapping("/scrapeBARAKAA")
    public String scrapeWebsiteBaraka() throws IOException {
   	 // need http protocol
   	try {
   	Document doc;
       doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/al-baraka").get();
      
       // get page title
       String title = doc.title();
       System.out.println("title6 : " + title);
       
       
     
     Element AED = doc.select("td.text-uppercase").get(0);
     String nomdevise0 = AED.text();
     System.out.println("title 0 : " + nomdevise0);
       Element achatSAR = doc.select("td.font-weight-bold").get(0);
       String achatDevise0 = achatSAR.text();
       System.out.println("achat 0 : " + achatDevise0);
       Element td1 = doc.select("td.font-weight-bold").get(1);
       String venteDevise0 = td1.text();
       System.out.println("vente 0 : " + venteDevise0);
       Element td0 = doc.select("td.text-center").get(2);
       String uniteDevise0 = td0.text();
       System.out.println("unite0 : " + uniteDevise0);
      // System.out.println("title4 : " + VenteDevise0);
       
       Element CNY = doc.select("td.text-uppercase").get(1);
       String nomdevise5 = CNY.text();
       System.out.println("title : " + nomdevise5);
       Element achatCNY = doc.select("td.font-weight-bold").get(2);
       String achatDevise5 = achatCNY.text();
       System.out.println("achat 1 : " + achatDevise5);
       Element td10 = doc.select("td.font-weight-bold").get(3);
       String venteDevise5 = td10.text();
       System.out.println("achat 1 : " + venteDevise5);
       Element td11 = doc.select("td.text-center").get(7);
       String uniteDevise5 = td11.text();
       System.out.println("vente2 : " +uniteDevise5);
       
       Element GBP = doc.select("td.text-uppercase").get(2);
       String nomdevise14 = GBP.text();
       Element achatGBP = doc.select("td.font-weight-bold").get(4);
       String achatDevise14 = achatGBP.text();
      
       Element td28 = doc.select("td.font-weight-bold").get(5);
       String venteDevise14 = td28.text();
       Element td29 = doc.select("td.text-center").get(12);
       String uniteDevise14 = td29.text();
       
       Element DKK = doc.select("td.text-uppercase").get(3);
       String nomdevise2 = DKK.text();
       Element achatDKK = doc.select("td.font-weight-bold").get(6);
       String achatDevise2 = achatDKK.text();
       Element td4 = doc.select("td.font-weight-bold").get(7);
       String venteDevise2 = td4.text();
       Element td5 = doc.select("td.text-center").get(17);
       String uniteDevise2 = td5.text();

       Element USD = doc.select("td.text-uppercase").get(4);
       String nomdevise4 = USD.text();
       Element achatUSD = doc.select("td.font-weight-bold").get(8);
       String achatDevise4 = achatUSD.text();
       Element td8 = doc.select("td.font-weight-bold").get(9);
       String venteDevise4 = td8.text();
       Element td9 = doc.select("td.text-center").get(22);
       String uniteDevise4 = td9.text();
       
       Element JPY = doc.select("td.text-uppercase").get(5);
       String nomdevise6 = JPY.text();
       Element achatJPY = doc.select("td.font-weight-bold").get(10);
       String achatDevise6 = achatJPY.text();
       Element td12 = doc.select("td.font-weight-bold").get(11);
       String venteDevise6 = td12.text();
       Element td13 = doc.select("td.text-center").get(27);
       String uniteDevise6 = td13.text();
       
       Element EUR = doc.select("td.text-uppercase").get(6);
       String nomdevise12 = EUR.text();
       Element achatEUR = doc.select("td.font-weight-bold").get(12);
       String achatDevise12 = achatEUR.text();
       Element td24 = doc.select("td.font-weight-bold").get(13);
       String venteDevise12 = td24.text();
       Element td25 = doc.select("td.text-center").get(32);
       String uniteDevise12 = td25.text();
 
    
       Element CAD = doc.select("td.text-uppercase").get(7);
       String nomdevise1 = CAD.text();
       Element achatCAD = doc.select("td.font-weight-bold").get(14);
       String achatDevise1 = achatCAD.text();
       Element td2 = doc.select("td.font-weight-bold").get(15);
       String venteDevise1 = td2.text();
       Element td3 = doc.select("td.text-center").get(37);
       String uniteDevise1 = td3.text();
      
     
     
     
       Element ggg = doc.select("td.text-uppercase").get(8);
       String nomdevise3 = ggg.text();
       Element achatggg = doc.select("td.font-weight-bold").get(16);
       String achatDevise3 = achatggg.text();
       Element td6 = doc.select("td.font-weight-bold").get(17);
       String venteDevise3 = td6.text();
       Element td7 = doc.select("td.text-center").get(42);
       String uniteDevise3 = td7.text();
     
       
     
       
     
     
       Element KWD = doc.select("td.text-uppercase").get(9);
       String nomdevise7 = KWD.text();
       Element achatKWD = doc.select("td.font-weight-bold").get(18);
       String achatDevise7 = achatKWD.text();
       Element td14 = doc.select("td.font-weight-bold").get(19);
       String venteDevise7 = td14.text();
       Element td15 = doc.select("td.text-center").get(47);
       String uniteDevise7 = td15.text();
     
       Element NOK = doc.select("td.text-uppercase").get(10);
       String nomdevise8 = NOK.text();
       Element achatNOK = doc.select("td.font-weight-bold").get(20);
       String achatDevise8 = achatNOK.text();
       Element td16 = doc.select("td.font-weight-bold").get(21);
       String venteDevise8 = td16.text();
       Element td17 = doc.select("td.text-center").get(52);
       String uniteDevise8 = td17.text();
     
       Element QAR = doc.select("td.text-uppercase").get(11);
       String nomdevise9 = QAR.text();
       Element achatQAR = doc.select("td.font-weight-bold").get(22);
       String achatDevise9 = achatQAR.text();
       Element td18 = doc.select("td.font-weight-bold").get(23);
       String venteDevise9 = td18.text();
       Element td19 = doc.select("td.text-center").get(57);
       String uniteDevise9 = td19.text();
     
      
       Achat achat = new Achat();
       achat.setData("al baraka", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
    		   achatDevise12,achatDevise1,  achatDevise3, 
    		   achatDevise7, achatDevise8, achatDevise9,"0","0",
       		"0",  "0",  achatDevise0);
     //verfication 
       List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
       
       if(verfAchat.isEmpty()) {
    	   //ajout
    	   achatInterface.save(achat);
       }
       else  {
    	   //update
    	   achatInterface.updateAchat(verfAchat.get(0), achat);
       }
       
       Vente v = new Vente();
       v.setData("al baraka", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
    		   venteDevise12,venteDevise1,  venteDevise3, 
    		   venteDevise7, venteDevise8, venteDevise9,"0","0",
       		"0",  "0",  venteDevise0);
     //verfication 
       List<Vente> verf = venteInterface.verification(v.getNomBanque());
       
       if(verf.isEmpty()) {
    	   //ajout
    	   venteInterface.save(v);
       }
       else  {
    	   //update
    	   venteInterface.updateVente(verf.get(0), v);
       }
       return("ok");
      	}catch (Exception e) {
  			return("no"+e);
  		}
             
      
  
       
   }
    @GetMapping("/scrapeBHH")
    public String scrapeWebsiteBH() throws IOException {
   	 // need http protocol
   	try {
   	Document doc;
       doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/bh").get();
      
       // get page title
       String title = doc.title();
       System.out.println("title6 : " + title);
       
       
     
     Element AED = doc.select("td.text-uppercase").get(0);
     String nomdevise0 = AED.text();
     System.out.println("title 0 : " + nomdevise0);
       Element achatSAR = doc.select("td.font-weight-bold").get(0);
       String achatDevise0 = achatSAR.text();
       System.out.println("achat 0 : " + achatDevise0);
       Element td1 = doc.select("td.font-weight-bold").get(1);
       String venteDevise0 = td1.text();
       System.out.println("vente 0 : " + venteDevise0);
       Element td0 = doc.select("td.text-center").get(2);
       String uniteDevise0 = td0.text();
       System.out.println("vente0 : " + uniteDevise0);
      // System.out.println("title4 : " + VenteDevise0);
       
       Element CNY = doc.select("td.text-uppercase").get(1);
       String nomdevise5 = CNY.text();
       System.out.println("title : " + nomdevise5);
       Element achatCNY = doc.select("td.font-weight-bold").get(2);
       String achatDevise5 = achatCNY.text();
       System.out.println("unite 1 : " + achatDevise5);
       Element td10 = doc.select("td.font-weight-bold").get(3);
       String venteDevise5 = td10.text();
       System.out.println("vente 1 : " + venteDevise5);
       Element td11 = doc.select("td.text-center").get(7);
       String uniteDevise5 = td11.text();
       System.out.println("vente2 : " + uniteDevise5);
       
       Element GBP = doc.select("td.text-uppercase").get(2);
       String nomdevise14 = GBP.text();
       Element achatGBP = doc.select("td.font-weight-bold").get(4);
       String achatDevise14 = achatGBP.text();
      
       Element td28 = doc.select("td.font-weight-bold").get(5);
       String venteDevise14 = td28.text();
       Element td29 = doc.select("td.text-center").get(12);
       String uniteDevise14 = td29.text();
       
       Element DKK = doc.select("td.text-uppercase").get(3);
       String nomdevise2 = DKK.text();
       Element achatDKK = doc.select("td.font-weight-bold").get(6);
       String achatDevise2 = achatDKK.text();
       Element td4 = doc.select("td.font-weight-bold").get(7);
       String venteDevise2 = td4.text();
       Element td5 = doc.select("td.text-center").get(17);
       String uniteDevise2 = td5.text();

       Element USD = doc.select("td.text-uppercase").get(4);
       String nomdevise4 = USD.text();
       Element achatUSD = doc.select("td.font-weight-bold").get(8);
       String achatDevise4 = achatUSD.text();
       Element td8 = doc.select("td.font-weight-bold").get(9);
       String venteDevise4 = td8.text();
       Element td9 = doc.select("td.text-center").get(22);
       String uniteDevise4 = td9.text();
       
       Element JPY = doc.select("td.text-uppercase").get(5);
       String nomdevise6 = JPY.text();
       Element achatJPY = doc.select("td.font-weight-bold").get(10);
       String achatDevise6 = achatJPY.text();
       Element td12 = doc.select("td.font-weight-bold").get(11);
       String venteDevise6 = td12.text();
       Element td13 = doc.select("td.text-center").get(27);
       String uniteDevise6 = td13.text();
       
       Element EUR = doc.select("td.text-uppercase").get(6);
       String nomdevise12 = EUR.text();
       Element achatEUR = doc.select("td.font-weight-bold").get(12);
       String achatDevise12 = achatEUR.text();
       Element td24 = doc.select("td.font-weight-bold").get(13);
       String venteDevise12 = td24.text();
       Element td25 = doc.select("td.text-center").get(32);
       String uniteDevise12 = td25.text();
 
    
       Element CAD = doc.select("td.text-uppercase").get(7);
       String nomdevise1 = CAD.text();
       Element achatCAD = doc.select("td.font-weight-bold").get(14);
       String achatDevise1 = achatCAD.text();
       Element td2 = doc.select("td.font-weight-bold").get(15);
       String venteDevise1 = td2.text();
       Element td3 = doc.select("td.text-center").get(37);
       String uniteDevise1 = td3.text();
      
     
     
     
       Element ggg = doc.select("td.text-uppercase").get(8);
       String nomdevise3 = ggg.text();
       Element achatggg = doc.select("td.font-weight-bold").get(16);
       String achatDevise3 = achatggg.text();
       Element td6 = doc.select("td.font-weight-bold").get(17);
       String venteDevise3 = td6.text();
       Element td7 = doc.select("td.text-center").get(42);
       String uniteDevise3 = td7.text();
     
       
     
       
     
     
       Element KWD = doc.select("td.text-uppercase").get(9);
       String nomdevise7 = KWD.text();
       Element achatKWD = doc.select("td.font-weight-bold").get(18);
       String achatDevise7 = achatKWD.text();
       Element td14 = doc.select("td.font-weight-bold").get(19);
       String venteDevise7 = td14.text();
       Element td15 = doc.select("td.text-center").get(47);
       String uniteDevise7 = td15.text();
     
       Element NOK = doc.select("td.text-uppercase").get(10);
       String nomdevise8 = NOK.text();
       Element achatNOK = doc.select("td.font-weight-bold").get(20);
       String achatDevise8 = achatNOK.text();
       Element td16 = doc.select("td.font-weight-bold").get(21);
       String venteDevise8 = td16.text();
       Element td17 = doc.select("td.text-center").get(52);
       String uniteDevise8 = td17.text();
     
       Element QAR = doc.select("td.text-uppercase").get(11);
       String nomdevise9 = QAR.text();
       Element achatQAR = doc.select("td.font-weight-bold").get(22);
       String achatDevise9 = achatQAR.text();
       Element td18 = doc.select("td.font-weight-bold").get(23);
       String venteDevise9 = td18.text();
       Element td19 = doc.select("td.text-center").get(57);
       String uniteDevise9 = td19.text();
     
       Element SEK = doc.select("td.text-uppercase").get(12);
       String nomdevise10 = SEK.text();
       Element achatSEK = doc.select("td.font-weight-bold").get(24);
       String achatDevise10 = achatSEK.text();
       Element td20 = doc.select("td.font-weight-bold").get(25);
       String venteDevise10 = td20.text();
       Element td21 = doc.select("td.text-center").get(62);
       String uniteDevise10 = td21.text();
     
       Element CHF = doc.select("td.text-uppercase").get(13);
       String nomdevise11 = CHF.text();
       Element achatCHF = doc.select("td.font-weight-bold").get(26);
       String achatDevise11 = achatCHF.text();
       Element td22 = doc.select("td.font-weight-bold").get(27);
       String venteDevise11 = td22.text();
       Element td23 = doc.select("td.text-center").get(67);
       String uniteDevise11 = td23.text();

      
     
       Element BHD = doc.select("td.text-uppercase").get(14);
       String nomdevise13 = BHD.text();
       Element achatBHD = doc.select("td.font-weight-bold").get(28);
       String achatDevise13 = achatBHD.text();
       System.out.println("unite 5 : " + achatDevise13);
       Element td26 = doc.select("td.font-weight-bold").get(29);
       String venteDevise13 = td26.text();
       Element td27 = doc.select("td.text-center").get(72);
       String uniteDevise13 = td27.text();
     
       Element CNYY= doc.select("td.text-uppercase").get(15);
       String nomdevise16 = CNYY.text();
       Element achatCNYY = doc.select("td.font-weight-bold").get(30);
       String achatDevise16 = achatCNYY.text();
       System.out.println("unite 5 : " + achatDevise13);
       Element td50 = doc.select("td.font-weight-bold").get(31);
       String venteDevise16 = td50.text();
       Element td51 = doc.select("td.text-center").get(77);
       String uniteDevise16 = td51.text();
     
       
       
       Vente v = new Vente();
       v.setData("bh", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
    		   venteDevise12,venteDevise1,  venteDevise3, 
    		   venteDevise7, venteDevise8, venteDevise9,venteDevise10,
    		   venteDevise11,  venteDevise13, venteDevise16, venteDevise0);
       System.out.println(v);
     //verfication 
       List<Vente> verf = venteInterface.verification(v.getNomBanque());
       
       if(verf.isEmpty()) {
    	   //ajout
    	   venteInterface.save(v);
       }
       else  {
    	   //update
    	   venteInterface.updateVente(verf.get(0), v);
       }
       
       Achat achat = new Achat();
       achat.setData("bh", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
    		   achatDevise12,achatDevise1,  achatDevise3, 
    		   achatDevise7, achatDevise8, achatDevise9,achatDevise10,
    		   achatDevise11,  achatDevise13, achatDevise16, achatDevise0);
       System.out.println(achat);
     //verfication 
       List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
       
       if(verfAchat.isEmpty()) {
    	   //ajout
    	   achatInterface.save(achat);
       }
       else  {
    	   //update
    	   achatInterface.updateAchat(verfAchat.get(0), achat);
       }
       return("ok");
      	}catch (Exception e) {
  			return("no"+e);
  		}
             
      
  
       
   }
    
    @GetMapping("/scrapeQNBB")
    public String scrapeWebsiteQNB() throws IOException {
   	 // need http protocol
   	try {
   	Document doc;
       doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/qnb").get();
      
       // get page title
       String title = doc.title();
       System.out.println("title6 : " + title);
       
       
     
       Element AED = doc.select("td.text-uppercase").get(0);
       String nomdevise0 = AED.text();
       System.out.println("title 0 : " + nomdevise0);
         Element achatSAR = doc.select("td.font-weight-bold").get(0);
         String achatDevise0 = achatSAR.text();
         System.out.println("achat 0 : " + achatDevise0);
         Element td1 = doc.select("td.font-weight-bold").get(1);
         String venteDevise0 = td1.text();
         System.out.println("vente 0 : " + venteDevise0);
         Element td0 = doc.select("td.text-center").get(2);
         String uniteDevise0 = td0.text();
         System.out.println("vente0 : " + uniteDevise0);
        // System.out.println("title4 : " + VenteDevise0);
         
         Element CNY = doc.select("td.text-uppercase").get(1);
         String nomdevise5 = CNY.text();
         System.out.println("title : " + nomdevise5);
         Element achatCNY = doc.select("td.font-weight-bold").get(2);
         String achatDevise5 = achatCNY.text();
         System.out.println("unite 1 : " + achatDevise5);
         Element td10 = doc.select("td.font-weight-bold").get(3);
         String venteDevise5 = td10.text();
         System.out.println("vente 1 : " + venteDevise5);
         Element td11 = doc.select("td.text-center").get(7);
         String uniteDevise5 = td11.text();
         System.out.println("vente2 : " + uniteDevise5);
         
         Element GBP = doc.select("td.text-uppercase").get(2);
         String nomdevise14 = GBP.text();
         Element achatGBP = doc.select("td.font-weight-bold").get(4);
         String achatDevise14 = achatGBP.text();
        
         Element td28 = doc.select("td.font-weight-bold").get(5);
         String venteDevise14 = td28.text();
         Element td29 = doc.select("td.text-center").get(12);
         String uniteDevise14 = td29.text();
         
         Element DKK = doc.select("td.text-uppercase").get(3);
         String nomdevise2 = DKK.text();
         Element achatDKK = doc.select("td.font-weight-bold").get(6);
         String achatDevise2 = achatDKK.text();
         Element td4 = doc.select("td.font-weight-bold").get(7);
         String venteDevise2 = td4.text();
         Element td5 = doc.select("td.text-center").get(17);
         String uniteDevise2 = td5.text();

         Element USD = doc.select("td.text-uppercase").get(4);
         String nomdevise4 = USD.text();
         Element achatUSD = doc.select("td.font-weight-bold").get(8);
         String achatDevise4 = achatUSD.text();
         Element td8 = doc.select("td.font-weight-bold").get(9);
         String venteDevise4 = td8.text();
         Element td9 = doc.select("td.text-center").get(22);
         String uniteDevise4 = td9.text();
         
         Element JPY = doc.select("td.text-uppercase").get(5);
         String nomdevise6 = JPY.text();
         Element achatJPY = doc.select("td.font-weight-bold").get(10);
         String achatDevise6 = achatJPY.text();
         Element td12 = doc.select("td.font-weight-bold").get(11);
         String venteDevise6 = td12.text();
         Element td13 = doc.select("td.text-center").get(27);
         String uniteDevise6 = td13.text();
         
         Element EUR = doc.select("td.text-uppercase").get(6);
         String nomdevise12 = EUR.text();
         Element achatEUR = doc.select("td.font-weight-bold").get(12);
         String achatDevise12 = achatEUR.text();
         Element td24 = doc.select("td.font-weight-bold").get(13);
         String venteDevise12 = td24.text();
         Element td25 = doc.select("td.text-center").get(32);
         String uniteDevise12 = td25.text();
   
      
         Element CAD = doc.select("td.text-uppercase").get(7);
         String nomdevise1 = CAD.text();
         Element achatCAD = doc.select("td.font-weight-bold").get(14);
         String achatDevise1 = achatCAD.text();
         Element td2 = doc.select("td.font-weight-bold").get(15);
         String venteDevise1 = td2.text();
         Element td3 = doc.select("td.text-center").get(37);
         String uniteDevise1 = td3.text();
        
       
       
       
         Element ggg = doc.select("td.text-uppercase").get(8);
         String nomdevise3 = ggg.text();
         Element achatggg = doc.select("td.font-weight-bold").get(16);
         String achatDevise3 = achatggg.text();
         Element td6 = doc.select("td.font-weight-bold").get(17);
         String venteDevise3 = td6.text();
         Element td7 = doc.select("td.text-center").get(42);
         String uniteDevise3 = td7.text();
       
         
       
         
       
       
         Element KWD = doc.select("td.text-uppercase").get(9);
         String nomdevise7 = KWD.text();
         Element achatKWD = doc.select("td.font-weight-bold").get(18);
         String achatDevise7 = achatKWD.text();
         Element td14 = doc.select("td.font-weight-bold").get(19);
         String venteDevise7 = td14.text();
         Element td15 = doc.select("td.text-center").get(47);
         String uniteDevise7 = td15.text();
       
         Element NOK = doc.select("td.text-uppercase").get(10);
         String nomdevise8 = NOK.text();
         Element achatNOK = doc.select("td.font-weight-bold").get(20);
         String achatDevise8 = achatNOK.text();
         Element td16 = doc.select("td.font-weight-bold").get(21);
         String venteDevise8 = td16.text();
         Element td17 = doc.select("td.text-center").get(52);
         String uniteDevise8 = td17.text();
       
         Element QAR = doc.select("td.text-uppercase").get(11);
         String nomdevise9 = QAR.text();
         Element achatQAR = doc.select("td.font-weight-bold").get(22);
         String achatDevise9 = achatQAR.text();
         Element td18 = doc.select("td.font-weight-bold").get(23);
         String venteDevise9 = td18.text();
         Element td19 = doc.select("td.text-center").get(57);
         String uniteDevise9 = td19.text();
       
         Element SEK = doc.select("td.text-uppercase").get(12);
         String nomdevise10 = SEK.text();
         Element achatSEK = doc.select("td.font-weight-bold").get(24);
         String achatDevise10 = achatSEK.text();
         Element td20 = doc.select("td.font-weight-bold").get(25);
         String venteDevise10 = td20.text();
         Element td21 = doc.select("td.text-center").get(62);
         String uniteDevise10 = td21.text();
       
         Element CHF = doc.select("td.text-uppercase").get(13);
         String nomdevise11 = CHF.text();
         Element achatCHF = doc.select("td.font-weight-bold").get(26);
         String achatDevise11 = achatCHF.text();
         Element td22 = doc.select("td.font-weight-bold").get(27);
         String venteDevise11 = td22.text();
         Element td23 = doc.select("td.text-center").get(67);
         String uniteDevise11 = td23.text();

        
       
         Element BHD = doc.select("td.text-uppercase").get(14);
         String nomdevise13 = BHD.text();
         Element achatBHD = doc.select("td.font-weight-bold").get(28);
         String achatDevise13 = achatBHD.text();
         System.out.println("unite 5 : " + achatDevise13);
         Element td26 = doc.select("td.font-weight-bold").get(29);
         String venteDevise13 = td26.text();
         Element td27 = doc.select("td.text-center").get(72);
         String uniteDevise13 = td27.text();
       
         Element CNYY= doc.select("td.text-uppercase").get(15);
         String nomdevise16 = CNYY.text();
         Element achatCNYY = doc.select("td.font-weight-bold").get(30);
         String achatDevise16 = achatCNYY.text();
         System.out.println("unite 5 : " + achatDevise13);
         Element td50 = doc.select("td.font-weight-bold").get(31);
         String venteDevise16 = td50.text();
         Element td51 = doc.select("td.text-center").get(77);
         String uniteDevise16 = td51.text();
       
         
         
         Vente v = new Vente();
         v.setData("qnb", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
      		   venteDevise12,venteDevise1,  venteDevise3, 
      		   venteDevise7, venteDevise8, venteDevise9,venteDevise10,
      		   venteDevise11,  venteDevise13, venteDevise16, venteDevise0);
         System.out.println(v);
       //verfication 
         List<Vente> verf = venteInterface.verification(v.getNomBanque());
         
         if(verf.isEmpty()) {
      	   //ajout
      	   venteInterface.save(v);
         }
         else  {
      	   //update
      	   venteInterface.updateVente(verf.get(0), v);
         }
         
         Achat achat = new Achat();
         achat.setData("qnb", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
      		   achatDevise12,achatDevise1,  achatDevise3, 
      		   achatDevise7, achatDevise8, achatDevise9,achatDevise10,
      		   achatDevise11,  achatDevise13, achatDevise16, achatDevise0);
         System.out.println(achat);
       //verfication 
         List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
         
         if(verfAchat.isEmpty()) {
      	   //ajout
      	   achatInterface.save(achat);
         }
         else  {
      	   //update
      	   achatInterface.updateAchat(verfAchat.get(0), achat);
         }
       return("ok");
      	}catch (Exception e) {
  			return("no"+e);
  		}
             
      
  
       
   }
    @GetMapping("/scrapeATTIJARII")
    public String scrapeWebsiteATTIJARI() throws IOException {
   	 // need http protocol
   	try {
   	Document doc;
       doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/attijari-bank").get();
      
       // get page title
       String title = doc.title();
       System.out.println("title6 : " + title);
       
       
     
       Element AED = doc.select("td.text-uppercase").get(0);
       String nomdevise0 = AED.text();
       System.out.println("title 0 : " + nomdevise0);
         Element achatSAR = doc.select("td.font-weight-bold").get(0);
         String achatDevise0 = achatSAR.text();
         System.out.println("achat 0 : " + achatDevise0);
         Element td1 = doc.select("td.font-weight-bold").get(1);
         String venteDevise0 = td1.text();
         System.out.println("vente 0 : " + venteDevise0);
         Element td0 = doc.select("td.text-center").get(2);
         String uniteDevise0 = td0.text();
         System.out.println("vente0 : " + uniteDevise0);
        // System.out.println("title4 : " + VenteDevise0);
         
         Element CNY = doc.select("td.text-uppercase").get(1);
         String nomdevise5 = CNY.text();
         System.out.println("title : " + nomdevise5);
         Element achatCNY = doc.select("td.font-weight-bold").get(2);
         String achatDevise5 = achatCNY.text();
         System.out.println("unite 1 : " + achatDevise5);
         Element td10 = doc.select("td.font-weight-bold").get(3);
         String venteDevise5 = td10.text();
         System.out.println("vente 1 : " + venteDevise5);
         Element td11 = doc.select("td.text-center").get(7);
         String uniteDevise5 = td11.text();
         System.out.println("vente2 : " + uniteDevise5);
         
         Element GBP = doc.select("td.text-uppercase").get(2);
         String nomdevise14 = GBP.text();
         Element achatGBP = doc.select("td.font-weight-bold").get(4);
         String achatDevise14 = achatGBP.text();
        
         Element td28 = doc.select("td.font-weight-bold").get(5);
         String venteDevise14 = td28.text();
         Element td29 = doc.select("td.text-center").get(12);
         String uniteDevise14 = td29.text();
         
         Element DKK = doc.select("td.text-uppercase").get(3);
         String nomdevise2 = DKK.text();
         Element achatDKK = doc.select("td.font-weight-bold").get(6);
         String achatDevise2 = achatDKK.text();
         Element td4 = doc.select("td.font-weight-bold").get(7);
         String venteDevise2 = td4.text();
         Element td5 = doc.select("td.text-center").get(17);
         String uniteDevise2 = td5.text();

         Element USD = doc.select("td.text-uppercase").get(4);
         String nomdevise4 = USD.text();
         Element achatUSD = doc.select("td.font-weight-bold").get(8);
         String achatDevise4 = achatUSD.text();
         Element td8 = doc.select("td.font-weight-bold").get(9);
         String venteDevise4 = td8.text();
         Element td9 = doc.select("td.text-center").get(22);
         String uniteDevise4 = td9.text();
         
         Element JPY = doc.select("td.text-uppercase").get(5);
         String nomdevise6 = JPY.text();
         Element achatJPY = doc.select("td.font-weight-bold").get(10);
         String achatDevise6 = achatJPY.text();
         Element td12 = doc.select("td.font-weight-bold").get(11);
         String venteDevise6 = td12.text();
         Element td13 = doc.select("td.text-center").get(27);
         String uniteDevise6 = td13.text();
         
         Element EUR = doc.select("td.text-uppercase").get(6);
         String nomdevise12 = EUR.text();
         Element achatEUR = doc.select("td.font-weight-bold").get(12);
         String achatDevise12 = achatEUR.text();
         Element td24 = doc.select("td.font-weight-bold").get(13);
         String venteDevise12 = td24.text();
         Element td25 = doc.select("td.text-center").get(32);
         String uniteDevise12 = td25.text();
   
      
         Element CAD = doc.select("td.text-uppercase").get(7);
         String nomdevise1 = CAD.text();
         Element achatCAD = doc.select("td.font-weight-bold").get(14);
         String achatDevise1 = achatCAD.text();
         Element td2 = doc.select("td.font-weight-bold").get(15);
         String venteDevise1 = td2.text();
         Element td3 = doc.select("td.text-center").get(37);
         String uniteDevise1 = td3.text();
        
       
       
       
         Element ggg = doc.select("td.text-uppercase").get(8);
         String nomdevise3 = ggg.text();
         Element achatggg = doc.select("td.font-weight-bold").get(16);
         String achatDevise3 = achatggg.text();
         Element td6 = doc.select("td.font-weight-bold").get(17);
         String venteDevise3 = td6.text();
         Element td7 = doc.select("td.text-center").get(42);
         String uniteDevise3 = td7.text();
       
         
       
         
       
       
         Element KWD = doc.select("td.text-uppercase").get(9);
         String nomdevise7 = KWD.text();
         Element achatKWD = doc.select("td.font-weight-bold").get(18);
         String achatDevise7 = achatKWD.text();
         Element td14 = doc.select("td.font-weight-bold").get(19);
         String venteDevise7 = td14.text();
         Element td15 = doc.select("td.text-center").get(47);
         String uniteDevise7 = td15.text();
       
         Element NOK = doc.select("td.text-uppercase").get(10);
         String nomdevise8 = NOK.text();
         Element achatNOK = doc.select("td.font-weight-bold").get(20);
         String achatDevise8 = achatNOK.text();
         Element td16 = doc.select("td.font-weight-bold").get(21);
         String venteDevise8 = td16.text();
         Element td17 = doc.select("td.text-center").get(52);
         String uniteDevise8 = td17.text();
       
         Element QAR = doc.select("td.text-uppercase").get(11);
         String nomdevise9 = QAR.text();
         Element achatQAR = doc.select("td.font-weight-bold").get(22);
         String achatDevise9 = achatQAR.text();
         Element td18 = doc.select("td.font-weight-bold").get(23);
         String venteDevise9 = td18.text();
         Element td19 = doc.select("td.text-center").get(57);
         String uniteDevise9 = td19.text();
       
         Element SEK = doc.select("td.text-uppercase").get(12);
         String nomdevise10 = SEK.text();
         Element achatSEK = doc.select("td.font-weight-bold").get(24);
         String achatDevise10 = achatSEK.text();
         Element td20 = doc.select("td.font-weight-bold").get(25);
         String venteDevise10 = td20.text();
         Element td21 = doc.select("td.text-center").get(62);
         String uniteDevise10 = td21.text();
       
         Element CHF = doc.select("td.text-uppercase").get(13);
         String nomdevise11 = CHF.text();
         Element achatCHF = doc.select("td.font-weight-bold").get(26);
         String achatDevise11 = achatCHF.text();
         Element td22 = doc.select("td.font-weight-bold").get(27);
         String venteDevise11 = td22.text();
         Element td23 = doc.select("td.text-center").get(67);
         String uniteDevise11 = td23.text();

        
       
         Element BHD = doc.select("td.text-uppercase").get(14);
         String nomdevise13 = BHD.text();
         Element achatBHD = doc.select("td.font-weight-bold").get(28);
         String achatDevise13 = achatBHD.text();
         System.out.println("unite 5 : " + achatDevise13);
         Element td26 = doc.select("td.font-weight-bold").get(29);
         String venteDevise13 = td26.text();
         Element td27 = doc.select("td.text-center").get(72);
         String uniteDevise13 = td27.text();
       
         Element CNYY= doc.select("td.text-uppercase").get(15);
         String nomdevise16 = CNYY.text();
         Element achatCNYY = doc.select("td.font-weight-bold").get(30);
         String achatDevise16 = achatCNYY.text();
         System.out.println("unite 5 : " + achatDevise13);
         Element td50 = doc.select("td.font-weight-bold").get(31);
         String venteDevise16 = td50.text();
         Element td51 = doc.select("td.text-center").get(77);
         String uniteDevise16 = td51.text();
       
         
         
         Vente v = new Vente();
         v.setData("attijari", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
      		   venteDevise12,venteDevise1,  venteDevise3, 
      		   venteDevise7, venteDevise8, venteDevise9,venteDevise10,
      		   venteDevise11,  venteDevise13, venteDevise16, venteDevise0);
         System.out.println(v);
       //verfication 
         List<Vente> verf = venteInterface.verification(v.getNomBanque());
         
         if(verf.isEmpty()) {
      	   //ajout
      	   venteInterface.save(v);
         }
         else  {
      	   //update
      	   venteInterface.updateVente(verf.get(0), v);
         }
         
         Achat achat = new Achat();
         achat.setData("attijari", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
      		   achatDevise12,achatDevise1,  achatDevise3, 
      		   achatDevise7, achatDevise8, achatDevise9,achatDevise10,
      		   achatDevise11,  achatDevise13, achatDevise16, achatDevise0);
         System.out.println(achat);
       //verfication 
         List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
         
         if(verfAchat.isEmpty()) {
      	   //ajout
      	   achatInterface.save(achat);
         }
         else  {
      	   //update
      	   achatInterface.updateAchat(verfAchat.get(0), achat);
         }
       return("ok");
      	}catch (Exception e) {
  			return("no"+e);
  		}
             
      
  
       
   }
    @GetMapping("/scrapeAMENN")
    public String scrapeWebsiteAmen() throws IOException {
      	 // need http protocol
      	try {
      	Document doc;
          doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/amen-banque").get();
         
          // get page title
          String title = doc.title();
          System.out.println("title6 : " + title);
          
          
        
          Element AED = doc.select("td.text-uppercase").get(0);
          String nomdevise0 = AED.text();
          System.out.println("title 0 : " + nomdevise0);
            Element UniteSAR = doc.select("td.font-weight-bold").get(0);
            String achatDevise0 = UniteSAR.text();
            System.out.println("achat 0 : " + achatDevise0);
            Element td1 = doc.select("td.font-weight-bold").get(1);
            String venteDevise0 = td1.text();
            System.out.println("vente 0 : " + venteDevise0);
            Element td0 = doc.select("td.text-center").get(2);
            String uniteDevise0 = td0.text();
            System.out.println("unite0 : " + uniteDevise0);
           // System.out.println("title4 : " + VenteDevise0);
            
            Element CNY = doc.select("td.text-uppercase").get(1);
            String nomdevise5 = CNY.text();
            System.out.println("title : " + nomdevise5);
            Element UniteCNY = doc.select("td.font-weight-bold").get(2);
            String achatDevise5 = UniteCNY.text();
            System.out.println("unite 1 : " + achatDevise5);
            Element td10 = doc.select("td.font-weight-bold").get(3);
            String venteDevise5 = td10.text();
            System.out.println("achat 1 : " + venteDevise5);
            Element td11 = doc.select("td.text-center").get(7);
            String uniteDevise5 = td11.text();
            System.out.println("vente2 : " + uniteDevise5);
            
            Element GBP = doc.select("td.text-uppercase").get(2);
            String nomdevise14 = GBP.text();
            Element achatGBP = doc.select("td.font-weight-bold").get(4);
            String achatDevise14 = achatGBP.text();
           
            Element td28 = doc.select("td.font-weight-bold").get(5);
            String venteDevise14 = td28.text();
            Element td29 = doc.select("td.text-center").get(12);
            String uniteDevise14 = td29.text();
            
            Element DKK = doc.select("td.text-uppercase").get(3);
            String nomdevise2 = DKK.text();
            Element achatDKK = doc.select("td.font-weight-bold").get(6);
            String achatDevise2 = achatDKK.text();
            Element td4 = doc.select("td.font-weight-bold").get(7);
            String venteDevise2 = td4.text();
            Element td5 = doc.select("td.text-center").get(17);
            String uniteDevise2 = td5.text();

            Element USD = doc.select("td.text-uppercase").get(4);
            String nomdevise4 = USD.text();
            Element achatUSD = doc.select("td.font-weight-bold").get(8);
            String achatDevise4 = achatUSD.text();
            Element td8 = doc.select("td.font-weight-bold").get(9);
            String venteDevise4 = td8.text();
            Element td9 = doc.select("td.text-center").get(22);
            String uniteDevise4 = td9.text();
            
            Element JPY = doc.select("td.text-uppercase").get(5);
            String nomdevise6 = JPY.text();
            Element achatJPY = doc.select("td.font-weight-bold").get(10);
            String achatDevise6 = achatJPY.text();
            Element td12 = doc.select("td.font-weight-bold").get(11);
            String venteDevise6 = td12.text();
            Element td13 = doc.select("td.text-center").get(27);
            String uniteDevise6 = td13.text();
            
            Element EUR = doc.select("td.text-uppercase").get(6);
            String nomdevise12 = EUR.text();
            Element achatEUR = doc.select("td.font-weight-bold").get(12);
            String achatDevise12 = achatEUR.text();
            Element td24 = doc.select("td.font-weight-bold").get(13);
            String venteDevise12 = td24.text();
            Element td25 = doc.select("td.text-center").get(32);
            String uniteDevise12 = td25.text();
      
         
            Element CAD = doc.select("td.text-uppercase").get(7);
            String nomdevise1 = CAD.text();
            Element achatCAD = doc.select("td.font-weight-bold").get(14);
            String achatDevise1 = achatCAD.text();
            Element td2 = doc.select("td.font-weight-bold").get(15);
            String venteDevise1 = td2.text();
            Element td3 = doc.select("td.text-center").get(37);
            String uniteDevise1 = td3.text();
           
          
          
          
            Element ggg = doc.select("td.text-uppercase").get(8);
            String nomdevise3 = ggg.text();
            Element achatggg = doc.select("td.font-weight-bold").get(16);
            String achatDevise3 = achatggg.text();
            Element td6 = doc.select("td.font-weight-bold").get(17);
            String venteDevise3 = td6.text();
            Element td7 = doc.select("td.text-center").get(42);
            String uniteDevise3 = td7.text();
          
            
          
            
          
          
            Element KWD = doc.select("td.text-uppercase").get(9);
            String nomdevise7 = KWD.text();
            Element achatKWD = doc.select("td.font-weight-bold").get(18);
            String achatDevise7 = achatKWD.text();
            Element td14 = doc.select("td.font-weight-bold").get(19);
            String venteDevise7 = td14.text();
            Element td15 = doc.select("td.text-center").get(47);
            String uniteDevise7 = td15.text();
          
            Element NOK = doc.select("td.text-uppercase").get(10);
            String nomdevise8 = NOK.text();
            Element achatNOK = doc.select("td.font-weight-bold").get(20);
            String achatDevise8 = achatNOK.text();
            Element td16 = doc.select("td.font-weight-bold").get(21);
            String venteDevise8 = td16.text();
            Element td17 = doc.select("td.text-center").get(52);
            String uniteDevise8 = td17.text();
          
            Element QAR = doc.select("td.text-uppercase").get(11);
            String nomdevise9 = QAR.text();
            Element achatQAR = doc.select("td.font-weight-bold").get(22);
            String achatDevise9 = achatQAR.text();
            Element td18 = doc.select("td.font-weight-bold").get(23);
            String venteDevise9 = td18.text();
            Element td19 = doc.select("td.text-center").get(57);
            String uniteDevise9 = td19.text();
          
            Element SEK = doc.select("td.text-uppercase").get(12);
            String nomdevise10 = SEK.text();
            Element achatSEK = doc.select("td.font-weight-bold").get(24);
            String achatDevise10 = achatSEK.text();
            Element td20 = doc.select("td.font-weight-bold").get(25);
            String venteDevise10 = td20.text();
            Element td21 = doc.select("td.text-center").get(62);
            String uniteDevise10 = td21.text();
          
            Element CHF = doc.select("td.text-uppercase").get(13);
            String nomdevise11 = CHF.text();
            Element achatCHF = doc.select("td.font-weight-bold").get(26);
            String achatDevise11 = achatCHF.text();
            Element td22 = doc.select("td.font-weight-bold").get(27);
            String venteDevise11 = td22.text();
            Element td23 = doc.select("td.text-center").get(67);
            String uniteDevise11 = td23.text();

           
          
            Element BHD = doc.select("td.text-uppercase").get(14);
            String nomdevise13 = BHD.text();
            Element achatBHD = doc.select("td.font-weight-bold").get(28);
            String achatDevise13 = achatBHD.text();
            System.out.println("unite 5 : " + achatDevise13);
            Element td26 = doc.select("td.font-weight-bold").get(29);
            String venteDevise13 = td26.text();
            Element td27 = doc.select("td.text-center").get(72);
            String uniteDevise13 = td27.text();
          
           
            

            Achat achat = new Achat();
            achat.setData("amen", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
         		   achatDevise12,achatDevise1,  achatDevise3, 
         		   achatDevise7, achatDevise8, achatDevise9,"0",achatDevise10,
         		   achatDevise11,  achatDevise13,  achatDevise0);
          //verfication 
            List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
            
            if(verfAchat.isEmpty()) {
         	   //ajout
         	   achatInterface.save(achat);
            }
            else  {
         	   //update
         	   achatInterface.updateAchat(verfAchat.get(0), achat);
            }
            
            Vente v = new Vente();
            v.setData("amen", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
         		   venteDevise12,venteDevise1,  venteDevise3, 
         		   venteDevise7,venteDevise8, venteDevise9,"0",venteDevise10,
         		   venteDevise11,  venteDevise13,  venteDevise0);
            //verfication 
            List<Vente> verf = venteInterface.verification(v.getNomBanque());
            
            if(verf.isEmpty()) {
         	   //ajout
         	   venteInterface.save(v);
            }
            else  {
         	   //update
         	   venteInterface.updateVente(verf.get(0), v);
            }
          return("ok");
         	}catch (Exception e) {
     			return("no"+e);
     		}
                
         
     
          
      }
    @GetMapping("/scrapeUIBB")
    public String scrapeWebsiteUIB() throws IOException {
    	 // need http protocol
    	try {
    	Document doc;
        doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/uib").get();
       
        // get page title
        String title = doc.title();
        System.out.println("title6 : " + title);
        
        
      
        Element AED = doc.select("td.text-uppercase").get(0);
        String nomdevise0 = AED.text();
        System.out.println("title 0 : " + nomdevise0);
          Element achatSAR = doc.select("td.font-weight-bold").get(0);
          String achatDevise0 = achatSAR.text();
          System.out.println("achat 0 : " + achatDevise0);
          Element td1 = doc.select("td.font-weight-bold").get(1);
          String venteDevise0 = td1.text();
          System.out.println("vente 0 : " + venteDevise0);
          Element td0 = doc.select("td.text-center").get(2);
          String uniteDevise0 = td0.text();
          System.out.println("vente0 : " + uniteDevise0);
         // System.out.println("title4 : " + VenteDevise0);
          
          Element CNY = doc.select("td.text-uppercase").get(1);
          String nomdevise5 = CNY.text();
          System.out.println("title : " + nomdevise5);
          Element achatCNY = doc.select("td.font-weight-bold").get(2);
          String achatDevise5 = achatCNY.text();
          System.out.println("unite 1 : " + achatDevise5);
          Element td10 = doc.select("td.font-weight-bold").get(3);
          String venteDevise5 = td10.text();
          System.out.println("vente 1 : " + venteDevise5);
          Element td11 = doc.select("td.text-center").get(7);
          String uniteDevise5 = td11.text();
          System.out.println("vente2 : " + uniteDevise5);
          
          Element GBP = doc.select("td.text-uppercase").get(2);
          String nomdevise14 = GBP.text();
          Element achatGBP = doc.select("td.font-weight-bold").get(4);
          String achatDevise14 = achatGBP.text();
         
          Element td28 = doc.select("td.font-weight-bold").get(5);
          String venteDevise14 = td28.text();
          Element td29 = doc.select("td.text-center").get(12);
          String uniteDevise14 = td29.text();
          
          Element DKK = doc.select("td.text-uppercase").get(3);
          String nomdevise2 = DKK.text();
          Element achatDKK = doc.select("td.font-weight-bold").get(6);
          String achatDevise2 = achatDKK.text();
          Element td4 = doc.select("td.font-weight-bold").get(7);
          String venteDevise2 = td4.text();
          Element td5 = doc.select("td.text-center").get(17);
          String uniteDevise2 = td5.text();

          Element USD = doc.select("td.text-uppercase").get(4);
          String nomdevise4 = USD.text();
          Element achatUSD = doc.select("td.font-weight-bold").get(8);
          String achatDevise4 = achatUSD.text();
          Element td8 = doc.select("td.font-weight-bold").get(9);
          String venteDevise4 = td8.text();
          Element td9 = doc.select("td.text-center").get(22);
          String uniteDevise4 = td9.text();
          
          Element JPY = doc.select("td.text-uppercase").get(5);
          String nomdevise6 = JPY.text();
          Element achatJPY = doc.select("td.font-weight-bold").get(10);
          String achatDevise6 = achatJPY.text();
          Element td12 = doc.select("td.font-weight-bold").get(11);
          String venteDevise6 = td12.text();
          Element td13 = doc.select("td.text-center").get(27);
          String uniteDevise6 = td13.text();
          
          Element EUR = doc.select("td.text-uppercase").get(6);
          String nomdevise12 = EUR.text();
          Element achatEUR = doc.select("td.font-weight-bold").get(12);
          String achatDevise12 = achatEUR.text();
          Element td24 = doc.select("td.font-weight-bold").get(13);
          String venteDevise12 = td24.text();
          Element td25 = doc.select("td.text-center").get(32);
          String uniteDevise12 = td25.text();
    
       
          Element CAD = doc.select("td.text-uppercase").get(7);
          String nomdevise1 = CAD.text();
          Element achatCAD = doc.select("td.font-weight-bold").get(14);
          String achatDevise1 = achatCAD.text();
          Element td2 = doc.select("td.font-weight-bold").get(15);
          String venteDevise1 = td2.text();
          Element td3 = doc.select("td.text-center").get(37);
          String uniteDevise1 = td3.text();
         
        
        
        
          Element ggg = doc.select("td.text-uppercase").get(8);
          String nomdevise3 = ggg.text();
          Element achatggg = doc.select("td.font-weight-bold").get(16);
          String achatDevise3 = achatggg.text();
          Element td6 = doc.select("td.font-weight-bold").get(17);
          String venteDevise3 = td6.text();
          Element td7 = doc.select("td.text-center").get(42);
          String uniteDevise3 = td7.text();
        
          
        
          
        
        
          Element KWD = doc.select("td.text-uppercase").get(9);
          String nomdevise7 = KWD.text();
          Element achatKWD = doc.select("td.font-weight-bold").get(18);
          String achatDevise7 = achatKWD.text();
          Element td14 = doc.select("td.font-weight-bold").get(19);
          String venteDevise7 = td14.text();
          Element td15 = doc.select("td.text-center").get(47);
          String uniteDevise7 = td15.text();
        
          Element NOK = doc.select("td.text-uppercase").get(10);
          String nomdevise8 = NOK.text();
          Element achatNOK = doc.select("td.font-weight-bold").get(20);
          String achatDevise8 = achatNOK.text();
          Element td16 = doc.select("td.font-weight-bold").get(21);
          String venteDevise8 = td16.text();
          Element td17 = doc.select("td.text-center").get(52);
          String uniteDevise8 = td17.text();
        
          Element QAR = doc.select("td.text-uppercase").get(11);
          String nomdevise9 = QAR.text();
          Element achatQAR = doc.select("td.font-weight-bold").get(22);
          String achatDevise9 = achatQAR.text();
          Element td18 = doc.select("td.font-weight-bold").get(23);
          String venteDevise9 = td18.text();
          Element td19 = doc.select("td.text-center").get(57);
          String uniteDevise9 = td19.text();
        
          Element SEK = doc.select("td.text-uppercase").get(12);
          String nomdevise10 = SEK.text();
          Element achatSEK = doc.select("td.font-weight-bold").get(24);
          String achatDevise10 = achatSEK.text();
          Element td20 = doc.select("td.font-weight-bold").get(25);
          String venteDevise10 = td20.text();
          Element td21 = doc.select("td.text-center").get(62);
          String uniteDevise10 = td21.text();
        
          Element CHF = doc.select("td.text-uppercase").get(13);
          String nomdevise11 = CHF.text();
          Element achatCHF = doc.select("td.font-weight-bold").get(26);
          String achatDevise11 = achatCHF.text();
          Element td22 = doc.select("td.font-weight-bold").get(27);
          String venteDevise11 = td22.text();
          Element td23 = doc.select("td.text-center").get(67);
          String uniteDevise11 = td23.text();

         
        
          Element BHD = doc.select("td.text-uppercase").get(14);
          String nomdevise13 = BHD.text();
          Element achatBHD = doc.select("td.font-weight-bold").get(28);
          String achatDevise13 = achatBHD.text();
          System.out.println("unite 5 : " + achatDevise13);
          Element td26 = doc.select("td.font-weight-bold").get(29);
          String venteDevise13 = td26.text();
          Element td27 = doc.select("td.text-center").get(72);
          String uniteDevise13 = td27.text();
        
          Element CNYY= doc.select("td.text-uppercase").get(15);
          String nomdevise16 = CNYY.text();
          Element achatCNYY = doc.select("td.font-weight-bold").get(30);
          String achatDevise16 = achatCNYY.text();
          System.out.println("unite 5 : " + achatDevise13);
          Element td50 = doc.select("td.font-weight-bold").get(31);
          String venteDevise16 = td50.text();
          Element td51 = doc.select("td.text-center").get(77);
          String uniteDevise16 = td51.text();
        
          
          
          Vente v = new Vente();
          v.setData("uib", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
       		   venteDevise12,venteDevise1,  venteDevise3, 
       		   venteDevise7, venteDevise8, venteDevise9,venteDevise10,
       		   venteDevise11,  venteDevise13, venteDevise16, venteDevise0);
          System.out.println(v);
        //verfication 
          List<Vente> verf = venteInterface.verification(v.getNomBanque());
          
          if(verf.isEmpty()) {
       	   //ajout
       	   venteInterface.save(v);
          }
          else  {
       	   //update
       	   venteInterface.updateVente(verf.get(0), v);
          }
          
          Achat achat = new Achat();
          achat.setData("uib", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
       		   achatDevise12,achatDevise1,  achatDevise3, 
       		   achatDevise7, achatDevise8, achatDevise9,achatDevise10,
       		   achatDevise11,  achatDevise13, achatDevise16, achatDevise0);
          System.out.println(achat);
        //verfication 
          List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
          
          if(verfAchat.isEmpty()) {
       	   //ajout
       	   achatInterface.save(achat);
          }
          else  {
       	   //update
       	   achatInterface.updateAchat(verfAchat.get(0), achat);
          }
        return("ok");
       	}catch (Exception e) {
   			return("no"+e);
   		}
        
        
    }
    @GetMapping("/scrapeATT")
    public ATT[] scrapeWebsiteATT() throws IOException {
    	 // need http protocol
    	Document doc;
        doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/attijari-bank").get();
       
        // get page title
        String title = doc.title();
        System.out.println("title6 : " + title);
        
        
      
      Element AED = doc.select("td.text-uppercase").get(0);
      String nomdevise0 = AED.text();
      System.out.println("title 0 : " + nomdevise0);
        Element UniteSAR = doc.select("td.font-weight-bold").get(0);
        String UniteDevise0 = UniteSAR.text();
        System.out.println("unite 0 : " + UniteDevise0);
        Element td1 = doc.select("td.font-weight-bold").get(1);
        String AchatDevise0 = td1.text();
        System.out.println("achat 0 : " + AchatDevise0);
        Element td0 = doc.select("td.text-center").get(2);
        String VenteDevise0 = td0.text();
        System.out.println("vente0 : " + VenteDevise0);
       // System.out.println("title4 : " + VenteDevise0);
        
        Element CNY = doc.select("td.text-uppercase").get(1);
        String nomdevise5 = CNY.text();
        System.out.println("title : " + nomdevise5);
        Element UniteCNY = doc.select("td.font-weight-bold").get(2);
        String UniteDevise5 = UniteCNY.text();
        System.out.println("unite 1 : " + UniteDevise5);
        Element td10 = doc.select("td.font-weight-bold").get(3);
        String AchatDevise5 = td10.text();
        System.out.println("achat 1 : " + AchatDevise5);
        Element td11 = doc.select("td.text-center").get(7);
        String VenteDevise5 = td11.text();
        System.out.println("vente2 : " + VenteDevise5);
        
        Element GBP = doc.select("td.text-uppercase").get(2);
        String nomdevise14 = GBP.text();
        Element UniteGBP = doc.select("td.font-weight-bold").get(4);
        String UniteDevise14 = UniteGBP.text();
       
        Element td28 = doc.select("td.font-weight-bold").get(5);
        String AchatDevise14 = td28.text();
        Element td29 = doc.select("td.text-center").get(12);
        String VenteDevise14 = td29.text();
        
        Element DKK = doc.select("td.text-uppercase").get(3);
        String nomdevise2 = DKK.text();
        Element UniteDKK = doc.select("td.font-weight-bold").get(6);
        String UniteDevise2 = UniteDKK.text();
        Element td4 = doc.select("td.font-weight-bold").get(7);
        String AchatDevise2 = td4.text();
        Element td5 = doc.select("td.text-center").get(17);
        String VenteDevise2 = td5.text();

        Element USD = doc.select("td.text-uppercase").get(4);
        String nomdevise4 = USD.text();
        Element UniteUSD = doc.select("td.font-weight-bold").get(8);
        String UniteDevise4 = UniteUSD.text();
        Element td8 = doc.select("td.font-weight-bold").get(9);
        String AchatDevise4 = td8.text();
        Element td9 = doc.select("td.text-center").get(22);
        String VenteDevise4 = td9.text();
        
        Element JPY = doc.select("td.text-uppercase").get(5);
        String nomdevise6 = JPY.text();
        Element UniteJPY = doc.select("td.font-weight-bold").get(10);
        String UniteDevise6 = UniteJPY.text();
        Element td12 = doc.select("td.font-weight-bold").get(11);
        String AchatDevise6 = td12.text();
        Element td13 = doc.select("td.text-center").get(27);
        String VenteDevise6 = td13.text();
        
        Element EUR = doc.select("td.text-uppercase").get(6);
        String nomdevise12 = EUR.text();
        Element UniteEUR = doc.select("td.font-weight-bold").get(12);
        String UniteDevise12 = UniteEUR.text();
        Element td24 = doc.select("td.font-weight-bold").get(13);
        String AchatDevise12 = td24.text();
        Element td25 = doc.select("td.text-center").get(32);
        String VenteDevise12 = td25.text();
  
     
        Element CAD = doc.select("td.text-uppercase").get(7);
        String nomdevise1 = CAD.text();
        Element UniteCAD = doc.select("td.font-weight-bold").get(14);
        String UniteDevise1 = UniteCAD.text();
        Element td2 = doc.select("td.font-weight-bold").get(15);
        String AchatDevise1 = td2.text();
        Element td3 = doc.select("td.text-center").get(37);
        String VenteDevise1 = td3.text();
       
      
      
      
        Element ggg = doc.select("td.text-uppercase").get(8);
        String nomdevise3 = ggg.text();
        Element Uniteggg = doc.select("td.font-weight-bold").get(16);
        String UniteDevise3 = Uniteggg.text();
        Element td6 = doc.select("td.font-weight-bold").get(17);
        String AchatDevise3 = td6.text();
        Element td7 = doc.select("td.text-center").get(42);
        String VenteDevise3 = td7.text();
      
        
      
        
      
      
        Element KWD = doc.select("td.text-uppercase").get(9);
        String nomdevise7 = KWD.text();
        Element UniteKWD = doc.select("td.font-weight-bold").get(18);
        String UniteDevise7 = UniteKWD.text();
        Element td14 = doc.select("td.font-weight-bold").get(19);
        String AchatDevise7 = td14.text();
        Element td15 = doc.select("td.text-center").get(47);
        String VenteDevise7 = td15.text();
      
        Element NOK = doc.select("td.text-uppercase").get(10);
        String nomdevise8 = NOK.text();
        Element UniteNOK = doc.select("td.font-weight-bold").get(20);
        String UniteDevise8 = UniteNOK.text();
        Element td16 = doc.select("td.font-weight-bold").get(21);
        String AchatDevise8 = td16.text();
        Element td17 = doc.select("td.text-center").get(52);
        String VenteDevise8 = td17.text();
      
        Element QAR = doc.select("td.text-uppercase").get(11);
        String nomdevise9 = QAR.text();
        Element UniteQAR = doc.select("td.font-weight-bold").get(22);
        String UniteDevise9 = UniteQAR.text();
        Element td18 = doc.select("td.font-weight-bold").get(23);
        String AchatDevise9 = td18.text();
        Element td19 = doc.select("td.text-center").get(57);
        String VenteDevise9 = td19.text();
      
        Element SEK = doc.select("td.text-uppercase").get(12);
        String nomdevise10 = SEK.text();
        Element UniteSEK = doc.select("td.font-weight-bold").get(24);
        String UniteDevise10 = UniteSEK.text();
        Element td20 = doc.select("td.font-weight-bold").get(25);
        String AchatDevise10 = td20.text();
        Element td21 = doc.select("td.text-center").get(62);
        String VenteDevise10 = td21.text();
      
        Element CHF = doc.select("td.text-uppercase").get(12);
        String nomdevise11 = CHF.text();
        Element UniteCHF = doc.select("td.font-weight-bold").get(26);
        String UniteDevise11 = UniteCHF.text();
        Element td22 = doc.select("td.font-weight-bold").get(27);
        String AchatDevise11 = td22.text();
        Element td23 = doc.select("td.text-center").get(67);
        String VenteDevise11 = td23.text();

       
      
        Element BHD = doc.select("td.text-uppercase").get(14);
        String nomdevise13 = BHD.text();
        Element UniteBHD = doc.select("td.font-weight-bold").get(28);
        String UniteDevise13 = UniteBHD.text();
        System.out.println("unite 5 : " + UniteDevise13);
        Element td26 = doc.select("td.font-weight-bold").get(29);
        String AchatDevise13 = td26.text();
        Element td27 = doc.select("td.text-center").get(72);
        String VenteDevise13 = td27.text();
      

        
        
        ATT[] arr1;
        
        // Allocating memory for 2 objects
        // of type student
        arr1 = new ATT[16];
 
        // Creating actual student objects
          arr1[0] = new ATT();
          arr1[5] = new ATT();
          arr1[14] = new ATT();
         
          arr1[2] = new ATT();
          arr1[4] = new ATT();
          arr1[12] = new ATT();
          arr1[6] = new ATT();
        arr1[1] = new ATT();
       
          arr1[3] = new ATT();
          ;
          arr1[7] = new ATT();
          arr1[8] = new ATT();
          arr1[9] = new ATT();
          arr1[10] = new ATT();
          arr1[11] = new ATT();
         
          arr1[13] = new ATT();
       //  arr1[15].setData(nomdevise15,UniteDevise15,VenteDevise15,AchatDevise15);
      
          arr1[0].setData(nomdevise0,VenteDevise0,UniteDevise0,AchatDevise0);
          arr1[5].setData( nomdevise5,UniteDevise5,VenteDevise5,AchatDevise5);
          arr1[14].setData( nomdevise14,VenteDevise14,UniteDevise14,AchatDevise14); 
          arr1[2].setData( nomdevise2,VenteDevise2,UniteDevise2,AchatDevise2);
          arr1[4].setData( nomdevise4,VenteDevise4,UniteDevise4,AchatDevise4);
          
          arr1[6].setData( nomdevise6,VenteDevise6,UniteDevise6,AchatDevise6);
          arr1[12].setData( nomdevise12,VenteDevise12,UniteDevise12,AchatDevise12);
        arr1[1].setData( nomdevise1,VenteDevise1,UniteDevise1,AchatDevise1);
         
          arr1[3].setData(nomdevise3,VenteDevise3,UniteDevise3,AchatDevise3);
          
          arr1[7].setData( nomdevise7,VenteDevise7,UniteDevise7,AchatDevise7);
          arr1[8].setData( nomdevise8,VenteDevise8,UniteDevise8,AchatDevise8);
          arr1[9].setData( nomdevise9,VenteDevise9,UniteDevise9,AchatDevise9);
          arr1[10].setData( nomdevise10,VenteDevise10,UniteDevise10,AchatDevise10);
        arr1[11].setData( nomdevise11,VenteDevise11,UniteDevise11,AchatDevise11); 
        
        arr1[13].setData( nomdevise13,VenteDevise13,UniteDevise13,AchatDevise13);
        
     
       
        System.out.println(
                "ligne 1: ");
        arr1[0].display();
            System.out.println(
                    "ligne 2: ");
            arr1[0].display();
           // arr1[1].display();
      //  Syst
      //  System.out.println(title);
      //  System.out.println(tdContent);
      //  List<STB> stbs=new ArrayList<>();
      //  stbs.add({1,nomdevise0,UniteDevise15,VenteDevise15,AchatDevise15,DateDevise15});
        for(ATT a : arr1) {
            	attInterface.save(a);
            }
        
            return arr1;
    
   
        
    }
    
    @GetMapping("/scrapeATBB")
    public String scrapeWebsiteATB() throws IOException {
    	 // need http protocol
    	try {
    	Document doc;
        doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/atb").get();
       
        // get page title
        String title = doc.title();
        System.out.println("title6 : " + title);
        
      
      Element AED = doc.select("td.text-uppercase").get(0);
      String nomdevise0 = AED.text();
      System.out.println("title 0 : " + nomdevise0);
        Element achatSAR = doc.select("td.font-weight-bold").get(0);
        String achatDevise0 = achatSAR.text();
        System.out.println("achat 0 : " + achatDevise0);
        Element td1 = doc.select("td.font-weight-bold").get(1);
        String venteDevise0 = td1.text();
        System.out.println("achat 0 : " + venteDevise0);
        Element td0 = doc.select("td.text-center").get(2);
        String uniteDevise0 = td0.text();
        System.out.println("vente0 : " + uniteDevise0);
        
        Element CNY = doc.select("td.text-uppercase").get(1);
        String nomdevise5 = CNY.text();
        System.out.println("title : " + nomdevise5);
        Element achatCNY = doc.select("td.font-weight-bold").get(2);
        String achatDevise5 = achatCNY.text();
        System.out.println("achat : " + achatDevise5);
        Element td10 = doc.select("td.font-weight-bold").get(3);
        String venteDevise5 = td10.text();
        System.out.println("vente 1 : " + venteDevise5);
        Element td11 = doc.select("td.text-center").get(7);
        String uniteDevise5 = td11.text();
        System.out.println("unite : " + uniteDevise5);
        
        Element GBP = doc.select("td.text-uppercase").get(2);
        String nomdevise14 = GBP.text();
        Element achatGBP = doc.select("td.font-weight-bold").get(4);
        String achatDevise14 = achatGBP.text();
       
        Element td28 = doc.select("td.font-weight-bold").get(5);
        String venteDevise14 = td28.text();
        Element td29 = doc.select("td.text-center").get(12);
        String uniteDevise14 = td29.text();
        
        Element DKK = doc.select("td.text-uppercase").get(3);
        String nomdevise2 = DKK.text();
        Element achatDKK = doc.select("td.font-weight-bold").get(6);
        String achatDevise2 = achatDKK.text();
        Element td4 = doc.select("td.font-weight-bold").get(7);
        String venteDevise2 = td4.text();
        Element td5 = doc.select("td.text-center").get(17);
        String uniteDevise2 = td5.text();

        Element USD = doc.select("td.text-uppercase").get(4);
        String nomdevise4 = USD.text();
        Element achatUSD = doc.select("td.font-weight-bold").get(8);
        String achatDevise4 = achatUSD.text();
        Element td8 = doc.select("td.font-weight-bold").get(9);
        String venteDevise4 = td8.text();
        Element td9 = doc.select("td.text-center").get(22);
        String uniteDevise4 = td9.text();
        
        Element JPY = doc.select("td.text-uppercase").get(5);
        String nomdevise6 = JPY.text();
        Element achatJPY = doc.select("td.font-weight-bold").get(10);
        String achatDevise6 = achatJPY.text();
        Element td12 = doc.select("td.font-weight-bold").get(11);
        String venteDevise6 = td12.text();
        Element td13 = doc.select("td.text-center").get(27);
        String uniteDevise6 = td13.text();
        
        Element EUR = doc.select("td.text-uppercase").get(6);
        String nomdevise12 = EUR.text();
        Element achatEUR = doc.select("td.font-weight-bold").get(12);
        String achatDevise12 = achatEUR.text();
        Element td24 = doc.select("td.font-weight-bold").get(13);
        String venteDevise12 = td24.text();
        Element td25 = doc.select("td.text-center").get(32);
        String uniteDevise12 = td25.text();
  
     
        Element CAD = doc.select("td.text-uppercase").get(7);
        String nomdevise1 = CAD.text();
        Element achatCAD = doc.select("td.font-weight-bold").get(14);
        String achatDevise1 = achatCAD.text();
        Element td2 = doc.select("td.font-weight-bold").get(15);
        String venteDevise1 = td2.text();
        Element td3 = doc.select("td.text-center").get(37);
        String uniteDevise1 = td3.text();
       
      
      
      
        Element ggg = doc.select("td.text-uppercase").get(8);
        String nomdevise3 = ggg.text();
        Element achatggg = doc.select("td.font-weight-bold").get(16);
        String achatDevise3 = achatggg.text();
        Element td6 = doc.select("td.font-weight-bold").get(17);
        String venteDevise3 = td6.text();
        Element td7 = doc.select("td.text-center").get(42);
        String uniteDevise3 = td7.text();
      
        
      
        
      
      
        Element KWD = doc.select("td.text-uppercase").get(9);
        String nomdevise7 = KWD.text();
        Element achatKWD = doc.select("td.font-weight-bold").get(18);
        String achatDevise7 = achatKWD.text();
        Element td14 = doc.select("td.font-weight-bold").get(19);
        String venteDevise7 = td14.text();
        Element td15 = doc.select("td.text-center").get(47);
        String uniteDevise7 = td15.text();
      
        Element NOK = doc.select("td.text-uppercase").get(10);
        String nomdevise8 = NOK.text();
        Element achatNOK = doc.select("td.font-weight-bold").get(20);
        String achatDevise8 = achatNOK.text();
        Element td16 = doc.select("td.font-weight-bold").get(21);
        String venteDevise8 = td16.text();
        Element td17 = doc.select("td.text-center").get(52);
        String uniteDevise8 = td17.text();
      
        Element QAR = doc.select("td.text-uppercase").get(11);
        String nomdevise9 = QAR.text();
        Element achatQAR = doc.select("td.font-weight-bold").get(22);
        String achatDevise9 = achatQAR.text();
        Element td18 = doc.select("td.font-weight-bold").get(23);
        String venteDevise9 = td18.text();
        Element td19 = doc.select("td.text-center").get(57);
        String uniteDevise9 = td19.text();
      
        Element SEK = doc.select("td.text-uppercase").get(12);
        String nomdevise10 = SEK.text();
        Element achatSEK = doc.select("td.font-weight-bold").get(24);
        String achatDevise10 = achatSEK.text();
        Element td20 = doc.select("td.font-weight-bold").get(25);
        String venteDevise10 = td20.text();
        Element td21 = doc.select("td.text-center").get(62);
        String uniteDevise10 = td21.text();
      
        Element CHF = doc.select("td.text-uppercase").get(13);
        String nomdevise11 = CHF.text();
        Element achatCHF = doc.select("td.font-weight-bold").get(26);
        String achatDevise11 = achatCHF.text();
        Element td22 = doc.select("td.font-weight-bold").get(27);
        String venteDevise11 = td22.text();
        Element td23 = doc.select("td.text-center").get(67);
        String uniteDevise11 = td23.text();

       
      
        Element BHD = doc.select("td.text-uppercase").get(14);
        String nomdevise13 = BHD.text();
        Element achatBHD = doc.select("td.font-weight-bold").get(28);
        String achatDevise13 = achatBHD.text();
        System.out.println("unite 5 : " + achatDevise13);
        Element td26 = doc.select("td.font-weight-bold").get(29);
        String venteDevise13 = td26.text();
        Element td27 = doc.select("td.text-center").get(72);
        String uniteDevise13 = td27.text();
      

        
        
        Vente v = new Vente();
        v.setData("atb", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
        		venteDevise12,venteDevise1,  venteDevise3, 
        		venteDevise7, venteDevise8, venteDevise9,venteDevise10,
        		venteDevise11,  venteDevise13, "0", venteDevise0);
      //verfication 
        List<Vente> verf = venteInterface.verification(v.getNomBanque());
        
        if(verf.isEmpty()) {
     	   //ajout
     	   venteInterface.save(v);
        }
        else  {
     	   //update
     	   venteInterface.updateVente(verf.get(0), v);
        }
        
        Achat achat = new Achat();
        achat.setData("atb", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
        		achatDevise12,achatDevise1,  achatDevise3, 
       		 achatDevise7, achatDevise8, achatDevise9,achatDevise10,
       		achatDevise11,  achatDevise13, "0", achatDevise0);
      //verfication 
        List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
        
        if(verfAchat.isEmpty()) {
     	   //ajout
     	   achatInterface.save(achat);
        }
        else  {
     	   //update
     	   achatInterface.updateAchat(verfAchat.get(0), achat);
        }
        return("ok");
       	}catch (Exception e) {
   			return("no"+e);
   		}
        
   
        
    }
    
    @GetMapping("/scrapeTSBB")
    public String scrapeWebsiteTSB() throws IOException {
    	 // need http protocol
    	try {
    	Document doc;
        doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/tsb").get();
       
        // get page title
        String title = doc.title();
        System.out.println("title6 : " + title);
        
        
      
        Element AED = doc.select("td.text-uppercase").get(0);
        String nomdevise0 = AED.text();
        System.out.println("title 0 : " + nomdevise0);
          Element achatSAR = doc.select("td.font-weight-bold").get(0);
          String achatDevise0 = achatSAR.text();
          System.out.println("achat 0 : " + achatDevise0);
          Element td1 = doc.select("td.font-weight-bold").get(1);
          String venteDevise0 = td1.text();
          System.out.println("vente 0 : " + venteDevise0);
          Element td0 = doc.select("td.text-center").get(2);
          String uniteDevise0 = td0.text();
          System.out.println("vente0 : " + uniteDevise0);
         // System.out.println("title4 : " + VenteDevise0);
          
          Element CNY = doc.select("td.text-uppercase").get(1);
          String nomdevise5 = CNY.text();
          System.out.println("title : " + nomdevise5);
          Element achatCNY = doc.select("td.font-weight-bold").get(2);
          String achatDevise5 = achatCNY.text();
          System.out.println("unite 1 : " + achatDevise5);
          Element td10 = doc.select("td.font-weight-bold").get(3);
          String venteDevise5 = td10.text();
          System.out.println("vente 1 : " + venteDevise5);
          Element td11 = doc.select("td.text-center").get(7);
          String uniteDevise5 = td11.text();
          System.out.println("vente2 : " + uniteDevise5);
          
          Element GBP = doc.select("td.text-uppercase").get(2);
          String nomdevise14 = GBP.text();
          Element achatGBP = doc.select("td.font-weight-bold").get(4);
          String achatDevise14 = achatGBP.text();
         
          Element td28 = doc.select("td.font-weight-bold").get(5);
          String venteDevise14 = td28.text();
          Element td29 = doc.select("td.text-center").get(12);
          String uniteDevise14 = td29.text();
          
          Element DKK = doc.select("td.text-uppercase").get(3);
          String nomdevise2 = DKK.text();
          Element achatDKK = doc.select("td.font-weight-bold").get(6);
          String achatDevise2 = achatDKK.text();
          Element td4 = doc.select("td.font-weight-bold").get(7);
          String venteDevise2 = td4.text();
          Element td5 = doc.select("td.text-center").get(17);
          String uniteDevise2 = td5.text();

          Element USD = doc.select("td.text-uppercase").get(4);
          String nomdevise4 = USD.text();
          Element achatUSD = doc.select("td.font-weight-bold").get(8);
          String achatDevise4 = achatUSD.text();
          Element td8 = doc.select("td.font-weight-bold").get(9);
          String venteDevise4 = td8.text();
          Element td9 = doc.select("td.text-center").get(22);
          String uniteDevise4 = td9.text();
          
          Element JPY = doc.select("td.text-uppercase").get(5);
          String nomdevise6 = JPY.text();
          Element achatJPY = doc.select("td.font-weight-bold").get(10);
          String achatDevise6 = achatJPY.text();
          Element td12 = doc.select("td.font-weight-bold").get(11);
          String venteDevise6 = td12.text();
          Element td13 = doc.select("td.text-center").get(27);
          String uniteDevise6 = td13.text();
          
          Element EUR = doc.select("td.text-uppercase").get(6);
          String nomdevise12 = EUR.text();
          Element achatEUR = doc.select("td.font-weight-bold").get(12);
          String achatDevise12 = achatEUR.text();
          Element td24 = doc.select("td.font-weight-bold").get(13);
          String venteDevise12 = td24.text();
          Element td25 = doc.select("td.text-center").get(32);
          String uniteDevise12 = td25.text();
    
       
          Element CAD = doc.select("td.text-uppercase").get(7);
          String nomdevise1 = CAD.text();
          Element achatCAD = doc.select("td.font-weight-bold").get(14);
          String achatDevise1 = achatCAD.text();
          Element td2 = doc.select("td.font-weight-bold").get(15);
          String venteDevise1 = td2.text();
          Element td3 = doc.select("td.text-center").get(37);
          String uniteDevise1 = td3.text();
         
        
        
        
          Element ggg = doc.select("td.text-uppercase").get(8);
          String nomdevise3 = ggg.text();
          Element achatggg = doc.select("td.font-weight-bold").get(16);
          String achatDevise3 = achatggg.text();
          Element td6 = doc.select("td.font-weight-bold").get(17);
          String venteDevise3 = td6.text();
          Element td7 = doc.select("td.text-center").get(42);
          String uniteDevise3 = td7.text();
        
          
        
          
        
        
          Element KWD = doc.select("td.text-uppercase").get(9);
          String nomdevise7 = KWD.text();
          Element achatKWD = doc.select("td.font-weight-bold").get(18);
          String achatDevise7 = achatKWD.text();
          Element td14 = doc.select("td.font-weight-bold").get(19);
          String venteDevise7 = td14.text();
          Element td15 = doc.select("td.text-center").get(47);
          String uniteDevise7 = td15.text();
        
          Element NOK = doc.select("td.text-uppercase").get(10);
          String nomdevise8 = NOK.text();
          Element achatNOK = doc.select("td.font-weight-bold").get(20);
          String achatDevise8 = achatNOK.text();
          Element td16 = doc.select("td.font-weight-bold").get(21);
          String venteDevise8 = td16.text();
          Element td17 = doc.select("td.text-center").get(52);
          String uniteDevise8 = td17.text();
        
          Element QAR = doc.select("td.text-uppercase").get(11);
          String nomdevise9 = QAR.text();
          Element achatQAR = doc.select("td.font-weight-bold").get(22);
          String achatDevise9 = achatQAR.text();
          Element td18 = doc.select("td.font-weight-bold").get(23);
          String venteDevise9 = td18.text();
          Element td19 = doc.select("td.text-center").get(57);
          String uniteDevise9 = td19.text();
        
          Element SEK = doc.select("td.text-uppercase").get(12);
          String nomdevise10 = SEK.text();
          Element achatSEK = doc.select("td.font-weight-bold").get(24);
          String achatDevise10 = achatSEK.text();
          Element td20 = doc.select("td.font-weight-bold").get(25);
          String venteDevise10 = td20.text();
          Element td21 = doc.select("td.text-center").get(62);
          String uniteDevise10 = td21.text();
        
          Element CHF = doc.select("td.text-uppercase").get(13);
          String nomdevise11 = CHF.text();
          Element achatCHF = doc.select("td.font-weight-bold").get(26);
          String achatDevise11 = achatCHF.text();
          Element td22 = doc.select("td.font-weight-bold").get(27);
          String venteDevise11 = td22.text();
          Element td23 = doc.select("td.text-center").get(67);
          String uniteDevise11 = td23.text();

         
        
          Element BHD = doc.select("td.text-uppercase").get(14);
          String nomdevise13 = BHD.text();
          Element achatBHD = doc.select("td.font-weight-bold").get(28);
          String achatDevise13 = achatBHD.text();
          System.out.println("unite 5 : " + achatDevise13);
          Element td26 = doc.select("td.font-weight-bold").get(29);
          String venteDevise13 = td26.text();
          Element td27 = doc.select("td.text-center").get(72);
          String uniteDevise13 = td27.text();
            Vente v = new Vente();
            v.setData("tsb", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
            		venteDevise12,venteDevise1,  venteDevise3, 
            		venteDevise7, venteDevise8, venteDevise9,venteDevise10,
            		venteDevise11,  venteDevise13, "0", venteDevise0);
          //verfication 
            List<Vente> verf = venteInterface.verification(v.getNomBanque());
            
            if(verf.isEmpty()) {
         	   //ajout
         	   venteInterface.save(v);
            }
            else  {
         	   //update
         	   venteInterface.updateVente(verf.get(0), v);
            }
            Achat achat = new Achat();
            achat.setData("tsb", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
            		achatDevise12,achatDevise1,  achatDevise3, 
           		 achatDevise7, achatDevise8, achatDevise9,achatDevise10,
           		achatDevise11,  achatDevise13, "0", achatDevise0);
          //verfication 
            List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
            
            if(verfAchat.isEmpty()) {
         	   //ajout
         	   achatInterface.save(achat);
            }
            else  {
         	   //update
         	   achatInterface.updateAchat(verfAchat.get(0), achat);
            }
        return("ok");
       	}catch (Exception e) {
   			return("no"+e);
   		}
        
   
        
    }
    
    @GetMapping("/scrapeBTLL")
    public String scrapeWebsiteBTL() throws IOException {
    	 // need http protocol
    	try {
    	Document doc;
        doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/btl").get();
       
        // get page title
        String title = doc.title();
        System.out.println("title6 : " + title);
       
      
        Element AED = doc.select("td.text-uppercase").get(0);
        String nomdevise0 = AED.text();
        System.out.println("title 0 : " + nomdevise0);
          Element achatSAR = doc.select("td.font-weight-bold").get(0);
          String achatDevise0 = achatSAR.text();
          System.out.println("achat 0 : " + achatDevise0);
          Element td1 = doc.select("td.font-weight-bold").get(1);
          String venteDevise0 = td1.text();
          System.out.println("vente 0 : " + venteDevise0);
          Element td0 = doc.select("td.text-center").get(2);
          String uniteDevise0 = td0.text();
          System.out.println("vente0 : " + uniteDevise0);
         // System.out.println("title4 : " + VenteDevise0);
          
          Element CNY = doc.select("td.text-uppercase").get(1);
          String nomdevise5 = CNY.text();
          System.out.println("title : " + nomdevise5);
          Element achatCNY = doc.select("td.font-weight-bold").get(2);
          String achatDevise5 = achatCNY.text();
          System.out.println("unite 1 : " + achatDevise5);
          Element td10 = doc.select("td.font-weight-bold").get(3);
          String venteDevise5 = td10.text();
          System.out.println("vente 1 : " + venteDevise5);
          Element td11 = doc.select("td.text-center").get(7);
          String uniteDevise5 = td11.text();
          System.out.println("vente2 : " + uniteDevise5);
          
          Element GBP = doc.select("td.text-uppercase").get(2);
          String nomdevise14 = GBP.text();
          Element achatGBP = doc.select("td.font-weight-bold").get(4);
          String achatDevise14 = achatGBP.text();
         
          Element td28 = doc.select("td.font-weight-bold").get(5);
          String venteDevise14 = td28.text();
          Element td29 = doc.select("td.text-center").get(12);
          String uniteDevise14 = td29.text();
          
          Element DKK = doc.select("td.text-uppercase").get(3);
          String nomdevise2 = DKK.text();
          Element achatDKK = doc.select("td.font-weight-bold").get(6);
          String achatDevise2 = achatDKK.text();
          Element td4 = doc.select("td.font-weight-bold").get(7);
          String venteDevise2 = td4.text();
          Element td5 = doc.select("td.text-center").get(17);
          String uniteDevise2 = td5.text();

          Element USD = doc.select("td.text-uppercase").get(4);
          String nomdevise4 = USD.text();
          Element achatUSD = doc.select("td.font-weight-bold").get(8);
          String achatDevise4 = achatUSD.text();
          Element td8 = doc.select("td.font-weight-bold").get(9);
          String venteDevise4 = td8.text();
          Element td9 = doc.select("td.text-center").get(22);
          String uniteDevise4 = td9.text();
          
          Element JPY = doc.select("td.text-uppercase").get(5);
          String nomdevise6 = JPY.text();
          Element achatJPY = doc.select("td.font-weight-bold").get(10);
          String achatDevise6 = achatJPY.text();
          Element td12 = doc.select("td.font-weight-bold").get(11);
          String venteDevise6 = td12.text();
          Element td13 = doc.select("td.text-center").get(27);
          String uniteDevise6 = td13.text();
          
          Element EUR = doc.select("td.text-uppercase").get(6);
          String nomdevise12 = EUR.text();
          Element achatEUR = doc.select("td.font-weight-bold").get(12);
          String achatDevise12 = achatEUR.text();
          Element td24 = doc.select("td.font-weight-bold").get(13);
          String venteDevise12 = td24.text();
          Element td25 = doc.select("td.text-center").get(32);
          String uniteDevise12 = td25.text();
    
       
          Element CAD = doc.select("td.text-uppercase").get(7);
          String nomdevise1 = CAD.text();
          Element achatCAD = doc.select("td.font-weight-bold").get(14);
          String achatDevise1 = achatCAD.text();
          Element td2 = doc.select("td.font-weight-bold").get(15);
          String venteDevise1 = td2.text();
          Element td3 = doc.select("td.text-center").get(37);
          String uniteDevise1 = td3.text();
         
        
        
        
          Element ggg = doc.select("td.text-uppercase").get(8);
          String nomdevise3 = ggg.text();
          Element achatggg = doc.select("td.font-weight-bold").get(16);
          String achatDevise3 = achatggg.text();
          Element td6 = doc.select("td.font-weight-bold").get(17);
          String venteDevise3 = td6.text();
          Element td7 = doc.select("td.text-center").get(42);
          String uniteDevise3 = td7.text();
        
          
        
          
        
        
          Element KWD = doc.select("td.text-uppercase").get(9);
          String nomdevise7 = KWD.text();
          Element achatKWD = doc.select("td.font-weight-bold").get(18);
          String achatDevise7 = achatKWD.text();
          Element td14 = doc.select("td.font-weight-bold").get(19);
          String venteDevise7 = td14.text();
          Element td15 = doc.select("td.text-center").get(47);
          String uniteDevise7 = td15.text();
        
          Element NOK = doc.select("td.text-uppercase").get(10);
          String nomdevise8 = NOK.text();
          Element achatNOK = doc.select("td.font-weight-bold").get(20);
          String achatDevise8 = achatNOK.text();
          Element td16 = doc.select("td.font-weight-bold").get(21);
          String venteDevise8 = td16.text();
          Element td17 = doc.select("td.text-center").get(52);
          String uniteDevise8 = td17.text();
        
          Element QAR = doc.select("td.text-uppercase").get(11);
          String nomdevise9 = QAR.text();
          Element achatQAR = doc.select("td.font-weight-bold").get(22);
          String achatDevise9 = achatQAR.text();
          Element td18 = doc.select("td.font-weight-bold").get(23);
          String venteDevise9 = td18.text();
          Element td19 = doc.select("td.text-center").get(57);
          String uniteDevise9 = td19.text();
        
          Element SEK = doc.select("td.text-uppercase").get(12);
          String nomdevise10 = SEK.text();
          Element achatSEK = doc.select("td.font-weight-bold").get(24);
          String achatDevise10 = achatSEK.text();
          Element td20 = doc.select("td.font-weight-bold").get(25);
          String venteDevise10 = td20.text();
          Element td21 = doc.select("td.text-center").get(62);
          String uniteDevise10 = td21.text();
        
          Element CHF = doc.select("td.text-uppercase").get(13);
          String nomdevise11 = CHF.text();
          Element achatCHF = doc.select("td.font-weight-bold").get(26);
          String achatDevise11 = achatCHF.text();
          Element td22 = doc.select("td.font-weight-bold").get(27);
          String venteDevise11 = td22.text();
          Element td23 = doc.select("td.text-center").get(67);
          String uniteDevise11 = td23.text();

         
        
          Element BHD = doc.select("td.text-uppercase").get(14);
          String nomdevise13 = BHD.text();
          Element achatBHD = doc.select("td.font-weight-bold").get(28);
          String achatDevise13 = achatBHD.text();
          System.out.println("unite 5 : " + achatDevise13);
          Element td26 = doc.select("td.font-weight-bold").get(29);
          String venteDevise13 = td26.text();
          Element td27 = doc.select("td.text-center").get(72);
          String uniteDevise13 = td27.text();
            Vente v = new Vente();
            v.setData("btl", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
            		venteDevise12,venteDevise1,  venteDevise3, 
            		venteDevise7, venteDevise8, venteDevise9,venteDevise10,
            		venteDevise11,  venteDevise13, "0", venteDevise0);
          //verfication 
            List<Vente> verf = venteInterface.verification(v.getNomBanque());
            
            if(verf.isEmpty()) {
         	   //ajout
         	   venteInterface.save(v);
            }
            else  {
         	   //update
         	   venteInterface.updateVente(verf.get(0), v);
            }
            Achat achat = new Achat();
            achat.setData("btl", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
            		achatDevise12,achatDevise1,  achatDevise3, 
           		 achatDevise7, achatDevise8, achatDevise9,achatDevise10,
           		achatDevise11,  achatDevise13, "0", achatDevise0);
          //verfication 
            List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
            
            if(verfAchat.isEmpty()) {
         	   //ajout
         	   achatInterface.save(achat);
            }
            else  {
         	   //update
         	   achatInterface.updateAchat(verfAchat.get(0), achat);
            }
            return("ok");
           	}catch (Exception e) {
       			return("no"+e);
       		}
                  
           
        
    }
    @GetMapping("/scrapeSTBB")
    public String scrapeWebsiteSTB() throws IOException {
    	 // need http protocol
    	try {
    	Document doc;
        doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/stb").get();
       
        // get page title
        String title = doc.title();
        System.out.println("title6 : " + title);
        
        
      
        Element AED = doc.select("td.text-uppercase").get(0);
        String nomdevise0 = AED.text();
        System.out.println("title 0 : " + nomdevise0);
          Element achatSAR = doc.select("td.font-weight-bold").get(0);
          String achatDevise0 = achatSAR.text();
          System.out.println("achat 0 : " + achatDevise0);
          Element td1 = doc.select("td.font-weight-bold").get(1);
          String venteDevise0 = td1.text();
          System.out.println("vente 0 : " + venteDevise0);
          Element td0 = doc.select("td.text-center").get(2);
          String uniteDevise0 = td0.text();
          System.out.println("vente0 : " + uniteDevise0);
         // System.out.println("title4 : " + VenteDevise0);
          
          Element CNY = doc.select("td.text-uppercase").get(1);
          String nomdevise5 = CNY.text();
          System.out.println("title : " + nomdevise5);
          Element achatCNY = doc.select("td.font-weight-bold").get(2);
          String achatDevise5 = achatCNY.text();
          System.out.println("unite 1 : " + achatDevise5);
          Element td10 = doc.select("td.font-weight-bold").get(3);
          String venteDevise5 = td10.text();
          System.out.println("vente 1 : " + venteDevise5);
          Element td11 = doc.select("td.text-center").get(7);
          String uniteDevise5 = td11.text();
          System.out.println("vente2 : " + uniteDevise5);
          
          Element GBP = doc.select("td.text-uppercase").get(2);
          String nomdevise14 = GBP.text();
          Element achatGBP = doc.select("td.font-weight-bold").get(4);
          String achatDevise14 = achatGBP.text();
         
          Element td28 = doc.select("td.font-weight-bold").get(5);
          String venteDevise14 = td28.text();
          Element td29 = doc.select("td.text-center").get(12);
          String uniteDevise14 = td29.text();
          
          Element DKK = doc.select("td.text-uppercase").get(3);
          String nomdevise2 = DKK.text();
          Element achatDKK = doc.select("td.font-weight-bold").get(6);
          String achatDevise2 = achatDKK.text();
          Element td4 = doc.select("td.font-weight-bold").get(7);
          String venteDevise2 = td4.text();
          Element td5 = doc.select("td.text-center").get(17);
          String uniteDevise2 = td5.text();

          Element USD = doc.select("td.text-uppercase").get(4);
          String nomdevise4 = USD.text();
          Element achatUSD = doc.select("td.font-weight-bold").get(8);
          String achatDevise4 = achatUSD.text();
          Element td8 = doc.select("td.font-weight-bold").get(9);
          String venteDevise4 = td8.text();
          Element td9 = doc.select("td.text-center").get(22);
          String uniteDevise4 = td9.text();
          
          Element JPY = doc.select("td.text-uppercase").get(5);
          String nomdevise6 = JPY.text();
          Element achatJPY = doc.select("td.font-weight-bold").get(10);
          String achatDevise6 = achatJPY.text();
          Element td12 = doc.select("td.font-weight-bold").get(11);
          String venteDevise6 = td12.text();
          Element td13 = doc.select("td.text-center").get(27);
          String uniteDevise6 = td13.text();
          
          Element EUR = doc.select("td.text-uppercase").get(6);
          String nomdevise12 = EUR.text();
          Element achatEUR = doc.select("td.font-weight-bold").get(12);
          String achatDevise12 = achatEUR.text();
          Element td24 = doc.select("td.font-weight-bold").get(13);
          String venteDevise12 = td24.text();
          Element td25 = doc.select("td.text-center").get(32);
          String uniteDevise12 = td25.text();
    
       
          Element CAD = doc.select("td.text-uppercase").get(7);
          String nomdevise1 = CAD.text();
          Element achatCAD = doc.select("td.font-weight-bold").get(14);
          String achatDevise1 = achatCAD.text();
          Element td2 = doc.select("td.font-weight-bold").get(15);
          String venteDevise1 = td2.text();
          Element td3 = doc.select("td.text-center").get(37);
          String uniteDevise1 = td3.text();
         
        
        
        
          Element ggg = doc.select("td.text-uppercase").get(8);
          String nomdevise3 = ggg.text();
          Element achatggg = doc.select("td.font-weight-bold").get(16);
          String achatDevise3 = achatggg.text();
          Element td6 = doc.select("td.font-weight-bold").get(17);
          String venteDevise3 = td6.text();
          Element td7 = doc.select("td.text-center").get(42);
          String uniteDevise3 = td7.text();
        
          
        
          
        
        
          Element KWD = doc.select("td.text-uppercase").get(9);
          String nomdevise7 = KWD.text();
          Element achatKWD = doc.select("td.font-weight-bold").get(18);
          String achatDevise7 = achatKWD.text();
          Element td14 = doc.select("td.font-weight-bold").get(19);
          String venteDevise7 = td14.text();
          Element td15 = doc.select("td.text-center").get(47);
          String uniteDevise7 = td15.text();
        
          Element NOK = doc.select("td.text-uppercase").get(10);
          String nomdevise8 = NOK.text();
          Element achatNOK = doc.select("td.font-weight-bold").get(20);
          String achatDevise8 = achatNOK.text();
          Element td16 = doc.select("td.font-weight-bold").get(21);
          String venteDevise8 = td16.text();
          Element td17 = doc.select("td.text-center").get(52);
          String uniteDevise8 = td17.text();
        
          Element QAR = doc.select("td.text-uppercase").get(11);
          String nomdevise9 = QAR.text();
          Element achatQAR = doc.select("td.font-weight-bold").get(22);
          String achatDevise9 = achatQAR.text();
          Element td18 = doc.select("td.font-weight-bold").get(23);
          String venteDevise9 = td18.text();
          Element td19 = doc.select("td.text-center").get(57);
          String uniteDevise9 = td19.text();
        
          Element SEK = doc.select("td.text-uppercase").get(12);
          String nomdevise10 = SEK.text();
          Element achatSEK = doc.select("td.font-weight-bold").get(24);
          String achatDevise10 = achatSEK.text();
          Element td20 = doc.select("td.font-weight-bold").get(25);
          String venteDevise10 = td20.text();
          Element td21 = doc.select("td.text-center").get(62);
          String uniteDevise10 = td21.text();
        
          Element CHF = doc.select("td.text-uppercase").get(13);
          String nomdevise11 = CHF.text();
          Element achatCHF = doc.select("td.font-weight-bold").get(26);
          String achatDevise11 = achatCHF.text();
          Element td22 = doc.select("td.font-weight-bold").get(27);
          String venteDevise11 = td22.text();
          Element td23 = doc.select("td.text-center").get(67);
          String uniteDevise11 = td23.text();

         
        
          Element BHD = doc.select("td.text-uppercase").get(14);
          String nomdevise13 = BHD.text();
          Element achatBHD = doc.select("td.font-weight-bold").get(28);
          String achatDevise13 = achatBHD.text();
          System.out.println("unite 5 : " + achatDevise13);
          Element td26 = doc.select("td.font-weight-bold").get(29);
          String venteDevise13 = td26.text();
          Element td27 = doc.select("td.text-center").get(72);
          String uniteDevise13 = td27.text();
        
          Element CNYY= doc.select("td.text-uppercase").get(15);
          String nomdevise16 = CNYY.text();
          Element achatCNYY = doc.select("td.font-weight-bold").get(30);
          String achatDevise16 = achatCNYY.text();
          System.out.println("unite 5 : " + achatDevise13);
          Element td50 = doc.select("td.font-weight-bold").get(31);
          String venteDevise16 = td50.text();
          Element td51 = doc.select("td.text-center").get(77);
          String uniteDevise16 = td51.text();
        
          
          
          Vente v = new Vente();
          v.setData("stb", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
       		   venteDevise12,venteDevise1,  venteDevise3, 
       		   venteDevise7, venteDevise8, venteDevise9,venteDevise10,
       		   venteDevise11,  venteDevise13, venteDevise16, venteDevise0);
          System.out.println(v);
        //verfication 
          List<Vente> verf = venteInterface.verification(v.getNomBanque());
          
          if(verf.isEmpty()) {
       	   //ajout
       	   venteInterface.save(v);
          }
          else  {
       	   //update
       	   venteInterface.updateVente(verf.get(0), v);
          }
          
          Achat achat = new Achat();
          achat.setData("stb", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
       		   achatDevise12,achatDevise1,  achatDevise3, 
       		   achatDevise7, achatDevise8, achatDevise9,achatDevise10,
       		   achatDevise11,  achatDevise13, achatDevise16, achatDevise0);
          System.out.println(achat);
        //verfication 
          List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
          
          if(verfAchat.isEmpty()) {
       	   //ajout
       	   achatInterface.save(achat);
          }
          else  {
       	   //update
       	   achatInterface.updateAchat(verfAchat.get(0), achat);
          }
        
        return("ok");
       	}catch (Exception e) {
   			return("no"+e);
   		}
              
       
   
        
    }
    @GetMapping("/scrapeBTEE")
    public String scrapeWebsiteBTE() throws IOException {
    	 // need http protocol
    	try {
    	Document doc;
        doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/bte").get();
       
        // get page title
        String title = doc.title();
        System.out.println("title6 : " + title);
        
        
      
      Element AED = doc.select("td.text-uppercase").get(0);
      String nomdevise0 = AED.text();
      System.out.println("title 0 : " + nomdevise0);
        Element achatSAR = doc.select("td.font-weight-bold").get(0);
        String achatDevise0 = achatSAR.text();
        System.out.println("achat 0 : " + achatDevise0);
        Element td1 = doc.select("td.font-weight-bold").get(1);
        String venteDevise0 = td1.text();
        System.out.println("vente 0 : " + venteDevise0);
        Element td0 = doc.select("td.text-center").get(2);
        String uniteDevise0 = td0.text();
        System.out.println("unite0 : " + uniteDevise0);
       
        
        Element CNY = doc.select("td.text-uppercase").get(1);
        String nomdevise5 = CNY.text();
        System.out.println("title : " + nomdevise5);
        Element achatCNY = doc.select("td.font-weight-bold").get(2);
        String achatDevise5 = achatCNY.text();
        System.out.println("achat 1 : " + achatDevise5);
        Element td10 = doc.select("td.font-weight-bold").get(3);
        String venteDevise5 = td10.text();
        System.out.println("vente 1 : " + venteDevise5);
        Element td11 = doc.select("td.text-center").get(7);
        String uniteDevise5 = td11.text();
        System.out.println("unite : " + uniteDevise5);
        
        Element GBP = doc.select("td.text-uppercase").get(2);
        String nomdevise14 = GBP.text();
        Element achatGBP = doc.select("td.font-weight-bold").get(4);
        String achatDevise14 = achatGBP.text();
       
        Element td28 = doc.select("td.font-weight-bold").get(5);
        String venteDevise14 = td28.text();
        Element td29 = doc.select("td.text-center").get(12);
        String uniteDevise14 = td29.text();
        
        Element DKK = doc.select("td.text-uppercase").get(3);
        String nomdevise2 = DKK.text();
        Element achatDKK = doc.select("td.font-weight-bold").get(6);
        String achatDevise2 = achatDKK.text();
        Element td4 = doc.select("td.font-weight-bold").get(7);
        String venteDevise2 = td4.text();
        Element td5 = doc.select("td.text-center").get(17);
        String uniteDevise2 = td5.text();

        Element USD = doc.select("td.text-uppercase").get(4);
        String nomdevise4 = USD.text();
        Element achatUSD = doc.select("td.font-weight-bold").get(8);
        String achatDevise4 = achatUSD.text();
        Element td8 = doc.select("td.font-weight-bold").get(9);
        String venteDevise4 = td8.text();
        Element td9 = doc.select("td.text-center").get(22);
        String uniteDevise4 = td9.text();
        
        
        Vente v = new Vente();
        v.setData("bte", "0", "0",venteDevise0, "0", venteDevise5,
        		"0", "0", venteDevise14, "0",venteDevise2,
        		venteDevise4, "0", "0", "0","0", "0");
      //verfication 
        List<Vente> verf = venteInterface.verification(v.getNomBanque());
        
        if(verf.isEmpty()) {
     	   //ajout
     	   venteInterface.save(v);
        }
        else  {
     	   //update
     	   venteInterface.updateVente(verf.get(0), v);
        }
        Achat achat = new Achat();
        achat.setData("bte", "0", "0",achatDevise0, "0", achatDevise5,
        		"0", "0", achatDevise14, "0",achatDevise2,
        		achatDevise4, "0", "0", "0","0", "0");
      //verfication 
        List<Achat> verifList = achatInterface.verification(achat.getNomBanque());
        
        if(verifList.isEmpty()) {
     	   //ajout
     	   achatInterface.save(achat);
        }
        else  {
     	   //update
     	   achatInterface.updateAchat(verifList.get(0), achat);
        }
        return("ok");
       	}catch (Exception e) {
   			return("no"+e);
   		}
              
       
      
         
        
    }
    @GetMapping("/scrapeBTKK")
    public String scrapeWebsiteBTK() throws IOException {
    	 // need http protocol
    	try {
    	Document doc;
        doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/btk").get();
       
        // get page title
        String title = doc.title();
        System.out.println("title6 : " + title);
       
      
      Element AED = doc.select("td.text-uppercase").get(0);
      String nomdevise0 = AED.text();
      System.out.println("title 0 : " + nomdevise0);
        Element achatSAR = doc.select("td.font-weight-bold").get(0);
        String achatDevise0 = achatSAR.text();
        System.out.println("achat 0 : " + achatDevise0);
        Element td1 = doc.select("td.font-weight-bold").get(1);
        String venteDevise0 = td1.text();
        System.out.println("vente 0 : " + venteDevise0);
        Element td0 = doc.select("td.text-center").get(2);
        String uniteDevise0 = td0.text();
        System.out.println("vente0 : " + uniteDevise0);
       // System.out.println("title4 : " + VenteDevise0);
        
        Element CNY = doc.select("td.text-uppercase").get(1);
        String nomdevise5 = CNY.text();
        System.out.println("title : " + nomdevise5);
        Element achatCNY = doc.select("td.font-weight-bold").get(2);
        String achatDevise5 = achatCNY.text();
        System.out.println("achat 1 : " + achatDevise5);
        Element td10 = doc.select("td.font-weight-bold").get(3);
        String venteDevise5 = td10.text();
        System.out.println("vente 1 : " + venteDevise5);
        Element td11 = doc.select("td.text-center").get(7);
        String uniteDevise5 = td11.text();
        System.out.println("vente2 : " + uniteDevise5);
        
        Element GBP = doc.select("td.text-uppercase").get(2);
        String nomdevise14 = GBP.text();
        Element achatGBP = doc.select("td.font-weight-bold").get(4);
        String achatDevise14 = achatGBP.text();
       
        Element td28 = doc.select("td.font-weight-bold").get(5);
        String venteDevise14 = td28.text();
        Element td29 = doc.select("td.text-center").get(12);
        String uniteDevise14 = td29.text();
        
        Element DKK = doc.select("td.text-uppercase").get(3);
        String nomdevise2 = DKK.text();
        Element achatDKK = doc.select("td.font-weight-bold").get(6);
        String achatDevise2 = achatDKK.text();
        Element td4 = doc.select("td.font-weight-bold").get(7);
        String venteDevise2 = td4.text();
        Element td5 = doc.select("td.text-center").get(17);
        String uniteDevise2 = td5.text();

        Element USD = doc.select("td.text-uppercase").get(4);
        String nomdevise4 = USD.text();
        Element achatUSD = doc.select("td.font-weight-bold").get(8);
        String achatDevise4 = achatUSD.text();
        Element td8 = doc.select("td.font-weight-bold").get(9);
        String venteDevise4 = td8.text();
        Element td9 = doc.select("td.text-center").get(22);
        String uniteDevise4 = td9.text();
        
        Element JPY = doc.select("td.text-uppercase").get(5);
        String nomdevise6 = JPY.text();
        Element achatJPY = doc.select("td.font-weight-bold").get(10);
        String achatDevise6 =achatJPY.text();
        Element td12 = doc.select("td.font-weight-bold").get(11);
        String venteDevise6 = td12.text();
        Element td13 = doc.select("td.text-center").get(27);
        String uniteDevise6 = td13.text();
        
        Element EUR = doc.select("td.text-uppercase").get(6);
        String nomdevise12 = EUR.text();
        Element achatEUR = doc.select("td.font-weight-bold").get(12);
        String achatDevise12 = achatEUR.text();
        Element td24 = doc.select("td.font-weight-bold").get(13);
        String venteDevise12 = td24.text();
        Element td25 = doc.select("td.text-center").get(32);
        String uniteDevise12 = td25.text();
  
     
        Element CAD = doc.select("td.text-uppercase").get(7);
        String nomdevise1 = CAD.text();
        Element achatCAD = doc.select("td.font-weight-bold").get(14);
        String achatDevise1 = achatCAD.text();
        Element td2 = doc.select("td.font-weight-bold").get(15);
        String venteDevise1 = td2.text();
        Element td3 = doc.select("td.text-center").get(37);
        String uniteDevise1 = td3.text();
       
      
      
      
        Element ggg = doc.select("td.text-uppercase").get(8);
        String nomdevise3 = ggg.text();
        Element achatggg = doc.select("td.font-weight-bold").get(16);
        String achatDevise3 = achatggg.text();
        Element td6 = doc.select("td.font-weight-bold").get(17);
        String venteDevise3 = td6.text();
        Element td7 = doc.select("td.text-center").get(42);
        String uniteDevise3 = td7.text();
      
        
      
        
      
      
        Element KWD = doc.select("td.text-uppercase").get(9);
        String nomdevise7 = KWD.text();
        Element achatKWD = doc.select("td.font-weight-bold").get(18);
        String achatDevise7 = achatKWD.text();
        Element td14 = doc.select("td.font-weight-bold").get(19);
        String venteDevise7 = td14.text();
        Element td15 = doc.select("td.text-center").get(47);
        String uniteDevise7 = td15.text();
      
        Element NOK = doc.select("td.text-uppercase").get(10);
        String nomdevise8 = NOK.text();
        Element achatNOK = doc.select("td.font-weight-bold").get(20);
        String achatDevise8 = achatNOK.text();
        Element td16 = doc.select("td.font-weight-bold").get(21);
        String venteDevise8 = td16.text();
        Element td17 = doc.select("td.text-center").get(52);
        String uniteDevise8 = td17.text();
      
        Element QAR = doc.select("td.text-uppercase").get(11);
        String nomdevise9 = QAR.text();
        Element achatQAR = doc.select("td.font-weight-bold").get(22);
        String achatDevise9 = achatQAR.text();
        Element td18 = doc.select("td.font-weight-bold").get(23);
        String venteDevise9 = td18.text();
        Element td19 = doc.select("td.text-center").get(57);
        String uniteDevise9 = td19.text();
      
        Element SEK = doc.select("td.text-uppercase").get(12);
        String nomdevise10 = SEK.text();
        Element achatSEK = doc.select("td.font-weight-bold").get(24);
        String achatDevise10 = achatSEK.text();
        Element td20 = doc.select("td.font-weight-bold").get(25);
        String venteDevise10 = td20.text();
        Element td21 = doc.select("td.text-center").get(62);
        String uniteDevise10 = td21.text();
      
        Element CHF = doc.select("td.text-uppercase").get(13);
        String nomdevise11 = CHF.text();
        Element achatCHF = doc.select("td.font-weight-bold").get(26);
        String achatDevise11 = achatCHF.text();
        Element td22 = doc.select("td.font-weight-bold").get(27);
        String venteDevise11 = td22.text();
        Element td23 = doc.select("td.text-center").get(67);
        String uniteDevise11 = td23.text();
        
        
        Vente v = new Vente();
        v.setData("btk", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
        		venteDevise12,venteDevise1,  venteDevise3, 
        		venteDevise7, venteDevise8, venteDevise9,"0",venteDevise10,
        		venteDevise11,  "0",  venteDevise0);
      //verfication 
        List<Vente> verf = venteInterface.verification(v.getNomBanque());
        
        if(verf.isEmpty()) {
     	   //ajout
     	   venteInterface.save(v);
        }
        else  {
     	   //update
     	   venteInterface.updateVente(verf.get(0), v);
        }
        Achat achat = new Achat();
        achat.setData("btk", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
     		   achatDevise12,achatDevise1,  achatDevise3, 
     		   achatDevise7, achatDevise8, achatDevise9,"0",achatDevise10,
     		   achatDevise11,  "0", achatDevise0);
        System.out.println(achat);
      //verfication 
        List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
        
        if(verfAchat.isEmpty()) {
     	   //ajout
     	   achatInterface.save(achat);
        }
        else  {
     	   //update
     	   achatInterface.updateAchat(verfAchat.get(0), achat);
        }
        return("ok");
       	}catch (Exception e) {
   			return("no"+e);
   		}
              
       
      
         
   
   
        
    }
    @GetMapping("/scrapeBTT")
    public String scrapeWebsiteBT() throws IOException {
   	 // need http protocol
   	try {
   	Document doc;
       doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/bt").get();
      
       // get page title
       String title = doc.title();
       System.out.println("title6 : " + title);
       
     
       Element AED = doc.select("td.text-uppercase").get(0);
       String nomdevise0 = AED.text();
       System.out.println("title 0 : " + nomdevise0);
         Element achatSAR = doc.select("td.font-weight-bold").get(0);
         String achatDevise0 = achatSAR.text();
         System.out.println("achat 0 : " + achatDevise0);
         Element td1 = doc.select("td.font-weight-bold").get(1);
         String venteDevise0 = td1.text();
         System.out.println("vente 0 : " + venteDevise0);
         Element td0 = doc.select("td.text-center").get(2);
         String uniteDevise0 = td0.text();
         System.out.println("vente0 : " + uniteDevise0);
        // System.out.println("title4 : " + VenteDevise0);
         
         Element CNY = doc.select("td.text-uppercase").get(1);
         String nomdevise5 = CNY.text();
         System.out.println("title : " + nomdevise5);
         Element achatCNY = doc.select("td.font-weight-bold").get(2);
         String achatDevise5 = achatCNY.text();
         System.out.println("unite 1 : " + achatDevise5);
         Element td10 = doc.select("td.font-weight-bold").get(3);
         String venteDevise5 = td10.text();
         System.out.println("vente 1 : " + venteDevise5);
         Element td11 = doc.select("td.text-center").get(7);
         String uniteDevise5 = td11.text();
         System.out.println("vente2 : " + uniteDevise5);
         
         Element GBP = doc.select("td.text-uppercase").get(2);
         String nomdevise14 = GBP.text();
         Element achatGBP = doc.select("td.font-weight-bold").get(4);
         String achatDevise14 = achatGBP.text();
        
         Element td28 = doc.select("td.font-weight-bold").get(5);
         String venteDevise14 = td28.text();
         Element td29 = doc.select("td.text-center").get(12);
         String uniteDevise14 = td29.text();
         
         Element DKK = doc.select("td.text-uppercase").get(3);
         String nomdevise2 = DKK.text();
         Element achatDKK = doc.select("td.font-weight-bold").get(6);
         String achatDevise2 = achatDKK.text();
         Element td4 = doc.select("td.font-weight-bold").get(7);
         String venteDevise2 = td4.text();
         Element td5 = doc.select("td.text-center").get(17);
         String uniteDevise2 = td5.text();

         Element USD = doc.select("td.text-uppercase").get(4);
         String nomdevise4 = USD.text();
         Element achatUSD = doc.select("td.font-weight-bold").get(8);
         String achatDevise4 = achatUSD.text();
         Element td8 = doc.select("td.font-weight-bold").get(9);
         String venteDevise4 = td8.text();
         Element td9 = doc.select("td.text-center").get(22);
         String uniteDevise4 = td9.text();
         
         Element JPY = doc.select("td.text-uppercase").get(5);
         String nomdevise6 = JPY.text();
         Element achatJPY = doc.select("td.font-weight-bold").get(10);
         String achatDevise6 = achatJPY.text();
         Element td12 = doc.select("td.font-weight-bold").get(11);
         String venteDevise6 = td12.text();
         Element td13 = doc.select("td.text-center").get(27);
         String uniteDevise6 = td13.text();
         
         Element EUR = doc.select("td.text-uppercase").get(6);
         String nomdevise12 = EUR.text();
         Element achatEUR = doc.select("td.font-weight-bold").get(12);
         String achatDevise12 = achatEUR.text();
         Element td24 = doc.select("td.font-weight-bold").get(13);
         String venteDevise12 = td24.text();
         Element td25 = doc.select("td.text-center").get(32);
         String uniteDevise12 = td25.text();
   
      
         Element CAD = doc.select("td.text-uppercase").get(7);
         String nomdevise1 = CAD.text();
         Element achatCAD = doc.select("td.font-weight-bold").get(14);
         String achatDevise1 = achatCAD.text();
         Element td2 = doc.select("td.font-weight-bold").get(15);
         String venteDevise1 = td2.text();
         Element td3 = doc.select("td.text-center").get(37);
         String uniteDevise1 = td3.text();
        
       
       
       
         Element ggg = doc.select("td.text-uppercase").get(8);
         String nomdevise3 = ggg.text();
         Element achatggg = doc.select("td.font-weight-bold").get(16);
         String achatDevise3 = achatggg.text();
         Element td6 = doc.select("td.font-weight-bold").get(17);
         String venteDevise3 = td6.text();
         Element td7 = doc.select("td.text-center").get(42);
         String uniteDevise3 = td7.text();
       
         
       
         
       
       
         Element KWD = doc.select("td.text-uppercase").get(9);
         String nomdevise7 = KWD.text();
         Element achatKWD = doc.select("td.font-weight-bold").get(18);
         String achatDevise7 = achatKWD.text();
         Element td14 = doc.select("td.font-weight-bold").get(19);
         String venteDevise7 = td14.text();
         Element td15 = doc.select("td.text-center").get(47);
         String uniteDevise7 = td15.text();
       
         Element NOK = doc.select("td.text-uppercase").get(10);
         String nomdevise8 = NOK.text();
         Element achatNOK = doc.select("td.font-weight-bold").get(20);
         String achatDevise8 = achatNOK.text();
         Element td16 = doc.select("td.font-weight-bold").get(21);
         String venteDevise8 = td16.text();
         Element td17 = doc.select("td.text-center").get(52);
         String uniteDevise8 = td17.text();
       
         Element QAR = doc.select("td.text-uppercase").get(11);
         String nomdevise9 = QAR.text();
         Element achatQAR = doc.select("td.font-weight-bold").get(22);
         String achatDevise9 = achatQAR.text();
         Element td18 = doc.select("td.font-weight-bold").get(23);
         String venteDevise9 = td18.text();
         Element td19 = doc.select("td.text-center").get(57);
         String uniteDevise9 = td19.text();
       
         Element SEK = doc.select("td.text-uppercase").get(12);
         String nomdevise10 = SEK.text();
         Element achatSEK = doc.select("td.font-weight-bold").get(24);
         String achatDevise10 = achatSEK.text();
         Element td20 = doc.select("td.font-weight-bold").get(25);
         String venteDevise10 = td20.text();
         Element td21 = doc.select("td.text-center").get(62);
         String uniteDevise10 = td21.text();
       
         Element CHF = doc.select("td.text-uppercase").get(13);
         String nomdevise11 = CHF.text();
         Element achatCHF = doc.select("td.font-weight-bold").get(26);
         String achatDevise11 = achatCHF.text();
         Element td22 = doc.select("td.font-weight-bold").get(27);
         String venteDevise11 = td22.text();
         Element td23 = doc.select("td.text-center").get(67);
         String uniteDevise11 = td23.text();

        
       
         Element BHD = doc.select("td.text-uppercase").get(14);
         String nomdevise13 = BHD.text();
         Element achatBHD = doc.select("td.font-weight-bold").get(28);
         String achatDevise13 = achatBHD.text();
         System.out.println("unite 5 : " + achatDevise13);
         Element td26 = doc.select("td.font-weight-bold").get(29);
         String venteDevise13 = td26.text();
         Element td27 = doc.select("td.text-center").get(72);
         String uniteDevise13 = td27.text();
       
         Element CNYY= doc.select("td.text-uppercase").get(15);
         String nomdevise16 = CNYY.text();
         Element achatCNYY = doc.select("td.font-weight-bold").get(30);
         String achatDevise16 = achatCNYY.text();
         System.out.println("unite 5 : " + achatDevise13);
         Element td50 = doc.select("td.font-weight-bold").get(31);
         String venteDevise16 = td50.text();
         Element td51 = doc.select("td.text-center").get(77);
         String uniteDevise16 = td51.text();
       
         
         
         Vente v = new Vente();
         v.setData("bt", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
      		   venteDevise12,venteDevise1,  venteDevise3, 
      		   venteDevise7, venteDevise8, venteDevise9,venteDevise10,
      		   venteDevise11,  venteDevise13, venteDevise16, venteDevise0);
         System.out.println(v);
       //verfication 
         List<Vente> verf = venteInterface.verification(v.getNomBanque());
         
         if(verf.isEmpty()) {
      	   //ajout
      	   venteInterface.save(v);
         }
         else  {
      	   //update
      	   venteInterface.updateVente(verf.get(0), v);
         }
         
         Achat achat = new Achat();
         achat.setData("bt", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
      		   achatDevise12,achatDevise1,  achatDevise3, 
      		   achatDevise7, achatDevise8, achatDevise9,achatDevise10,
      		   achatDevise11,  achatDevise13, achatDevise16, achatDevise0);
         System.out.println(achat);
       //verfication 
         List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
         
         if(verfAchat.isEmpty()) {
      	   //ajout
      	   achatInterface.save(achat);
         }
         else  {
      	   //update
      	   achatInterface.updateAchat(verfAchat.get(0), achat);
         }
       return("ok");
      	}catch (Exception e) {
  			return("no"+e);
  		}
             
      
  
       
   }
    @GetMapping("/scrapeBNAA")
    public String scrapeWebsiteBNA() throws IOException {
   	 // need http protocol
   	try {
   	Document doc;
       doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/bna").get();
      
       // get page title
       String title = doc.title();
       System.out.println("title6 : " + title);
       
       
     
       Element AED = doc.select("td.text-uppercase").get(0);
       String nomdevise0 = AED.text();
       System.out.println("title 0 : " + nomdevise0);
         Element achatSAR = doc.select("td.font-weight-bold").get(0);
         String achatDevise0 = achatSAR.text();
         System.out.println("achat 0 : " + achatDevise0);
         Element td1 = doc.select("td.font-weight-bold").get(1);
         String venteDevise0 = td1.text();
         System.out.println("vente 0 : " + venteDevise0);
         Element td0 = doc.select("td.text-center").get(2);
         String uniteDevise0 = td0.text();
         System.out.println("vente0 : " + uniteDevise0);
        // System.out.println("title4 : " + VenteDevise0);
         
         Element CNY = doc.select("td.text-uppercase").get(1);
         String nomdevise5 = CNY.text();
         System.out.println("title : " + nomdevise5);
         Element achatCNY = doc.select("td.font-weight-bold").get(2);
         String achatDevise5 = achatCNY.text();
         System.out.println("unite 1 : " + achatDevise5);
         Element td10 = doc.select("td.font-weight-bold").get(3);
         String venteDevise5 = td10.text();
         System.out.println("vente 1 : " + venteDevise5);
         Element td11 = doc.select("td.text-center").get(7);
         String uniteDevise5 = td11.text();
         System.out.println("vente2 : " + uniteDevise5);
         
         Element GBP = doc.select("td.text-uppercase").get(2);
         String nomdevise14 = GBP.text();
         Element achatGBP = doc.select("td.font-weight-bold").get(4);
         String achatDevise14 = achatGBP.text();
        
         Element td28 = doc.select("td.font-weight-bold").get(5);
         String venteDevise14 = td28.text();
         Element td29 = doc.select("td.text-center").get(12);
         String uniteDevise14 = td29.text();
         
         Element DKK = doc.select("td.text-uppercase").get(3);
         String nomdevise2 = DKK.text();
         Element achatDKK = doc.select("td.font-weight-bold").get(6);
         String achatDevise2 = achatDKK.text();
         Element td4 = doc.select("td.font-weight-bold").get(7);
         String venteDevise2 = td4.text();
         Element td5 = doc.select("td.text-center").get(17);
         String uniteDevise2 = td5.text();

         Element USD = doc.select("td.text-uppercase").get(4);
         String nomdevise4 = USD.text();
         Element achatUSD = doc.select("td.font-weight-bold").get(8);
         String achatDevise4 = achatUSD.text();
         Element td8 = doc.select("td.font-weight-bold").get(9);
         String venteDevise4 = td8.text();
         Element td9 = doc.select("td.text-center").get(22);
         String uniteDevise4 = td9.text();
         
         Element JPY = doc.select("td.text-uppercase").get(5);
         String nomdevise6 = JPY.text();
         Element achatJPY = doc.select("td.font-weight-bold").get(10);
         String achatDevise6 = achatJPY.text();
         Element td12 = doc.select("td.font-weight-bold").get(11);
         String venteDevise6 = td12.text();
         Element td13 = doc.select("td.text-center").get(27);
         String uniteDevise6 = td13.text();
         
         Element EUR = doc.select("td.text-uppercase").get(6);
         String nomdevise12 = EUR.text();
         Element achatEUR = doc.select("td.font-weight-bold").get(12);
         String achatDevise12 = achatEUR.text();
         Element td24 = doc.select("td.font-weight-bold").get(13);
         String venteDevise12 = td24.text();
         Element td25 = doc.select("td.text-center").get(32);
         String uniteDevise12 = td25.text();
   
      
         Element CAD = doc.select("td.text-uppercase").get(7);
         String nomdevise1 = CAD.text();
         Element achatCAD = doc.select("td.font-weight-bold").get(14);
         String achatDevise1 = achatCAD.text();
         Element td2 = doc.select("td.font-weight-bold").get(15);
         String venteDevise1 = td2.text();
         Element td3 = doc.select("td.text-center").get(37);
         String uniteDevise1 = td3.text();
        
       
       
       
         Element ggg = doc.select("td.text-uppercase").get(8);
         String nomdevise3 = ggg.text();
         Element achatggg = doc.select("td.font-weight-bold").get(16);
         String achatDevise3 = achatggg.text();
         Element td6 = doc.select("td.font-weight-bold").get(17);
         String venteDevise3 = td6.text();
         Element td7 = doc.select("td.text-center").get(42);
         String uniteDevise3 = td7.text();
       
         
       
         
       
       
         Element KWD = doc.select("td.text-uppercase").get(9);
         String nomdevise7 = KWD.text();
         Element achatKWD = doc.select("td.font-weight-bold").get(18);
         String achatDevise7 = achatKWD.text();
         Element td14 = doc.select("td.font-weight-bold").get(19);
         String venteDevise7 = td14.text();
         Element td15 = doc.select("td.text-center").get(47);
         String uniteDevise7 = td15.text();
       
         Element NOK = doc.select("td.text-uppercase").get(10);
         String nomdevise8 = NOK.text();
         Element achatNOK = doc.select("td.font-weight-bold").get(20);
         String achatDevise8 = achatNOK.text();
         Element td16 = doc.select("td.font-weight-bold").get(21);
         String venteDevise8 = td16.text();
         Element td17 = doc.select("td.text-center").get(52);
         String uniteDevise8 = td17.text();
       
         Element QAR = doc.select("td.text-uppercase").get(11);
         String nomdevise9 = QAR.text();
         Element achatQAR = doc.select("td.font-weight-bold").get(22);
         String achatDevise9 = achatQAR.text();
         Element td18 = doc.select("td.font-weight-bold").get(23);
         String venteDevise9 = td18.text();
         Element td19 = doc.select("td.text-center").get(57);
         String uniteDevise9 = td19.text();
       
         Element SEK = doc.select("td.text-uppercase").get(12);
         String nomdevise10 = SEK.text();
         Element achatSEK = doc.select("td.font-weight-bold").get(24);
         String achatDevise10 = achatSEK.text();
         Element td20 = doc.select("td.font-weight-bold").get(25);
         String venteDevise10 = td20.text();
         Element td21 = doc.select("td.text-center").get(62);
         String uniteDevise10 = td21.text();
       
         Element CHF = doc.select("td.text-uppercase").get(13);
         String nomdevise11 = CHF.text();
         Element achatCHF = doc.select("td.font-weight-bold").get(26);
         String achatDevise11 = achatCHF.text();
         Element td22 = doc.select("td.font-weight-bold").get(27);
         String venteDevise11 = td22.text();
         Element td23 = doc.select("td.text-center").get(67);
         String uniteDevise11 = td23.text();

        
       
         Element BHD = doc.select("td.text-uppercase").get(14);
         String nomdevise13 = BHD.text();
         Element achatBHD = doc.select("td.font-weight-bold").get(28);
         String achatDevise13 = achatBHD.text();
         System.out.println("unite 5 : " + achatDevise13);
         Element td26 = doc.select("td.font-weight-bold").get(29);
         String venteDevise13 = td26.text();
         Element td27 = doc.select("td.text-center").get(72);
         String uniteDevise13 = td27.text();
       
         Element CNYY= doc.select("td.text-uppercase").get(15);
         String nomdevise16 = CNYY.text();
         Element achatCNYY = doc.select("td.font-weight-bold").get(30);
         String achatDevise16 = achatCNYY.text();
         System.out.println("unite 5 : " + achatDevise13);
         Element td50 = doc.select("td.font-weight-bold").get(31);
         String venteDevise16 = td50.text();
         Element td51 = doc.select("td.text-center").get(77);
         String uniteDevise16 = td51.text();
       
         
         
         Vente v = new Vente();
         v.setData("bna", venteDevise5,venteDevise14, venteDevise2,venteDevise4,venteDevise6,
      		   venteDevise12,venteDevise1,  venteDevise3, 
      		   venteDevise7, venteDevise8, venteDevise9,venteDevise10,
      		   venteDevise11,  venteDevise13, venteDevise16, venteDevise0);
         System.out.println(v);

       //verfication 
         List<Vente> verf = venteInterface.verification(v.getNomBanque());
         
         if(verf.isEmpty()) {
      	   //ajout
      	   venteInterface.save(v);
         }
         else  {
      	   //update
      	   venteInterface.updateVente(verf.get(0), v);
         }
         
         Achat achat = new Achat();
         achat.setData("bna", achatDevise5,achatDevise14, achatDevise2,achatDevise4,achatDevise6,
      		   achatDevise12,achatDevise1,  achatDevise3, 
      		   achatDevise7, achatDevise8, achatDevise9,achatDevise10,
      		   achatDevise11,  achatDevise13, achatDevise16, achatDevise0);
         System.out.println(achat);
       //verfication 
         List<Achat> verfAchat = achatInterface.verification(achat.getNomBanque());
         
         if(verfAchat.isEmpty()) {
      	   //ajout
      	   achatInterface.save(achat);
         }
         else  {
      	   //update
      	   achatInterface.updateAchat(verfAchat.get(0), achat);
         }
       return("ok");
      	}catch (Exception e) {
  			return("no"+e);
  		}
             
      
  
       
   }
    
    
    /*@GetMapping("/scrapeVENTE")
    public AMEN[] scrapeWebsiteVENTE() throws IOException {
    	 // need http protocol
    	Document doc;
        doc = Jsoup.connect("https://www.dinartunisien.com/fr/banque/amen-banque").get();
       
        // get page title
        String title = doc.title();
        System.out.println("title6 : " + title);
        
      
      Element AED = doc.select("td.text-uppercase").get(0);
      String nomdevise0 = AED.text();
      System.out.println("title 0 : " + nomdevise0);
        Element UniteSAR = doc.select("td.font-weight-bold").get(0);
        String UniteDevise0 = UniteSAR.text();
        System.out.println("unite 0 : " + UniteDevise0);
        Element td1 = doc.select("td.font-weight-bold").get(1);
        String AchatDevise0 = td1.text();
        System.out.println("achat 0 : " + AchatDevise0);
        Element td0 = doc.select("td.text-center").get(2);
        String VenteDevise0 = td0.text();
        System.out.println("vente0 : " + VenteDevise0);
        
        Element CNY = doc.select("td.text-uppercase").get(1);
        String nomdevise5 = CNY.text();
        System.out.println("title : " + nomdevise5);
        Element UniteCNY = doc.select("td.font-weight-bold").get(2);
        String UniteDevise5 = UniteCNY.text();
        System.out.println("unite 1 : " + UniteDevise5);
        Element td10 = doc.select("td.font-weight-bold").get(3);
        String AchatDevise5 = td10.text();
        System.out.println("achat 1 : " + AchatDevise5);
        Element td11 = doc.select("td.text-center").get(7);
        String VenteDevise5 = td11.text();
        System.out.println("vente2 : " + VenteDevise5);
        
        Element GBP = doc.select("td.text-uppercase").get(2);
        String nomdevise14 = GBP.text();
        Element UniteGBP = doc.select("td.font-weight-bold").get(4);
        String UniteDevise14 = UniteGBP.text();
       
        Element td28 = doc.select("td.font-weight-bold").get(5);
        String AchatDevise14 = td28.text();
        Element td29 = doc.select("td.text-center").get(12);
        String VenteDevise14 = td29.text();
        
        Element DKK = doc.select("td.text-uppercase").get(3);
        String nomdevise2 = DKK.text();
        Element UniteDKK = doc.select("td.font-weight-bold").get(6);
        String UniteDevise2 = UniteDKK.text();
        Element td4 = doc.select("td.font-weight-bold").get(7);
        String AchatDevise2 = td4.text();
        Element td5 = doc.select("td.text-center").get(17);
        String VenteDevise2 = td5.text();

        Element USD = doc.select("td.text-uppercase").get(4);
        String nomdevise4 = USD.text();
        Element UniteUSD = doc.select("td.font-weight-bold").get(8);
        String UniteDevise4 = UniteUSD.text();
        Element td8 = doc.select("td.font-weight-bold").get(9);
        String AchatDevise4 = td8.text();
        Element td9 = doc.select("td.text-center").get(22);
        String VenteDevise4 = td9.text();
        
        Element JPY = doc.select("td.text-uppercase").get(5);
        String nomdevise6 = JPY.text();
        Element UniteJPY = doc.select("td.font-weight-bold").get(10);
        String UniteDevise6 = UniteJPY.text();
        Element td12 = doc.select("td.font-weight-bold").get(11);
        String AchatDevise6 = td12.text();
        Element td13 = doc.select("td.text-center").get(27);
        String VenteDevise6 = td13.text();
        
        Element EUR = doc.select("td.text-uppercase").get(6);
        String nomdevise12 = EUR.text();
        Element UniteEUR = doc.select("td.font-weight-bold").get(12);
        String UniteDevise12 = UniteEUR.text();
        Element td24 = doc.select("td.font-weight-bold").get(13);
        String AchatDevise12 = td24.text();
        Element td25 = doc.select("td.text-center").get(32);
        String VenteDevise12 = td25.text();
  
     
        Element CAD = doc.select("td.text-uppercase").get(7);
        String nomdevise1 = CAD.text();
        Element UniteCAD = doc.select("td.font-weight-bold").get(14);
        String UniteDevise1 = UniteCAD.text();
        Element td2 = doc.select("td.font-weight-bold").get(15);
        String AchatDevise1 = td2.text();
        Element td3 = doc.select("td.text-center").get(37);
        String VenteDevise1 = td3.text();
       
      
      
      
        Element ggg = doc.select("td.text-uppercase").get(8);
        String nomdevise3 = ggg.text();
        Element Uniteggg = doc.select("td.font-weight-bold").get(16);
        String UniteDevise3 = Uniteggg.text();
        Element td6 = doc.select("td.font-weight-bold").get(17);
        String AchatDevise3 = td6.text();
        Element td7 = doc.select("td.text-center").get(42);
        String VenteDevise3 = td7.text();
      
        
      
        
      
      
        Element KWD = doc.select("td.text-uppercase").get(9);
        String nomdevise7 = KWD.text();
        Element UniteKWD = doc.select("td.font-weight-bold").get(18);
        String UniteDevise7 = UniteKWD.text();
        Element td14 = doc.select("td.font-weight-bold").get(19);
        String AchatDevise7 = td14.text();
        Element td15 = doc.select("td.text-center").get(47);
        String VenteDevise7 = td15.text();
      
        Element NOK = doc.select("td.text-uppercase").get(10);
        String nomdevise8 = NOK.text();
        Element UniteNOK = doc.select("td.font-weight-bold").get(20);
        String UniteDevise8 = UniteNOK.text();
        Element td16 = doc.select("td.font-weight-bold").get(21);
        String AchatDevise8 = td16.text();
        Element td17 = doc.select("td.text-center").get(52);
        String VenteDevise8 = td17.text();
      
        Element QAR = doc.select("td.text-uppercase").get(11);
        String nomdevise9 = QAR.text();
        Element UniteQAR = doc.select("td.font-weight-bold").get(22);
        String UniteDevise9 = UniteQAR.text();
        Element td18 = doc.select("td.font-weight-bold").get(23);
        String AchatDevise9 = td18.text();
        Element td19 = doc.select("td.text-center").get(57);
        String VenteDevise9 = td19.text();
      
        Element SEK = doc.select("td.text-uppercase").get(12);
        String nomdevise10 = SEK.text();
        Element UniteSEK = doc.select("td.font-weight-bold").get(24);
        String UniteDevise10 = UniteSEK.text();
        Element td20 = doc.select("td.font-weight-bold").get(25);
        String AchatDevise10 = td20.text();
        Element td21 = doc.select("td.text-center").get(62);
        String VenteDevise10 = td21.text();
      
        Element CHF = doc.select("td.text-uppercase").get(13);
        String nomdevise11 = CHF.text();
        Element UniteCHF = doc.select("td.font-weight-bold").get(26);
        String UniteDevise11 = UniteCHF.text();
        Element td22 = doc.select("td.font-weight-bold").get(27);
        String AchatDevise11 = td22.text();
        Element td23 = doc.select("td.text-center").get(67);
        String VenteDevise11 = td23.text();

       
      
        Element BHD = doc.select("td.text-uppercase").get(14);
        String nomdevise13 = BHD.text();
        Element UniteBHD = doc.select("td.font-weight-bold").get(28);
        String UniteDevise13 = UniteBHD.text();
        System.out.println("unite 5 : " + UniteDevise13);
        Element td26 = doc.select("td.font-weight-bold").get(29);
        String AchatDevise13 = td26.text();
        Element td27 = doc.select("td.text-center").get(72);
        String VenteDevise13 = td27.text();
      

        
        
      AMEN[] arr1;
        
        arr1 = new AMEN[15];
 
          arr1[0] = new AMEN();
          arr1[5] = new AMEN();
          arr1[14] = new AMEN();
         
          arr1[2] = new AMEN();
          arr1[4] = new AMEN();
          arr1[12] = new AMEN();
          arr1[6] = new AMEN();
        arr1[1] = new AMEN();
       
          arr1[3] = new AMEN();
          ;
          arr1[7] = new AMEN();
          arr1[8] = new AMEN();
          arr1[9] = new AMEN();
          arr1[10] = new AMEN();
          arr1[11] = new AMEN();
         
          arr1[13] = new AMEN();
      
          arr1[0].setData(nomdevise0,VenteDevise0,UniteDevise0,AchatDevise0);
          arr1[5].setData( nomdevise5,VenteDevise5,UniteDevise5,AchatDevise5);
          arr1[14].setData( nomdevise14,VenteDevise14,UniteDevise14,AchatDevise14); 
          arr1[2].setData( nomdevise2,VenteDevise2,UniteDevise2,AchatDevise2);
          arr1[4].setData( nomdevise4,VenteDevise4,UniteDevise4,AchatDevise4);
          
          arr1[6].setData( nomdevise6,VenteDevise6,UniteDevise6,AchatDevise6);
          arr1[12].setData( nomdevise12,VenteDevise12,UniteDevise12,AchatDevise12);
        arr1[1].setData( nomdevise1,VenteDevise1,UniteDevise1,AchatDevise1);
         
          arr1[3].setData(nomdevise3,VenteDevise3,UniteDevise3,AchatDevise3);
          
          arr1[7].setData( nomdevise7,VenteDevise7,UniteDevise7,AchatDevise7);
          arr1[8].setData( nomdevise8,VenteDevise8,UniteDevise8,AchatDevise8);
          arr1[9].setData( nomdevise9,VenteDevise9,UniteDevise9,AchatDevise9);
          arr1[10].setData( nomdevise10,VenteDevise10,UniteDevise10,AchatDevise10);
        arr1[11].setData( nomdevise11,VenteDevise11,UniteDevise11,AchatDevise11); 
        
        arr1[13].setData( nomdevise13,VenteDevise13,UniteDevise13,AchatDevise13);
        
     
       
        System.out.println(
                "ligne 1: ");
        arr1[0].display();
            System.out.println(
                    "ligne 2: ");
            arr1[0].display();
            for(AMEN a : arr1) {
            	List<AMEN> exists=amenInterface.modification(a.getCodeDevise());
            	if (exists.isEmpty()) {
            		System.out.println("vide");
            		amenInterface.save(a);
            	} else {
            		System.out.println("no");
            		a.setIdAMEN(exists.get(0).getIdAMEN());
            		a.setDatedevise(exists.get(0).getDatedevise());
            		amenInterface.update(a);
            	}
            }
         
            return arr1;
    
   
        
    }*/
    
    
    
	@PostMapping("/saveSTB")
	public BasicResponse save(@RequestBody STB stb) {
		return stbInterface.save(stb);
	}
	@PostMapping("/saveBIAT")
	public BasicResponse save(@RequestBody BIAT biat) {
		return biatInterface.save(biat);
	}
	 @GetMapping("/getAllBiat")
	    public List<BIAT> getAllBiat() {
		 return biatInterface.findAll();
	 } 
	 @GetMapping("/getAlluib")
	    public List<UIB> getAlluib() {
		 return uibInterface.findAll();
	 }

	 @PutMapping("/update")
		public BasicResponse update(@RequestBody BIAT biat) {
			return biatInterface.update(biat);
		}
		
	 @GetMapping("/getALLVente")
	    public List<Vente> getAllVente() {
		 return venteInterface.findAll();
	 }
	 
	 @GetMapping("/getVenteMAX/{currency}")
	    public Vente getVENTEMAX(@PathVariable String currency) {
		 return venteInterface.findMAX(currency);
	 }
	 
	 @GetMapping("/getVenteMIN/{currency}")
	    public Vente getVENTEMIN(@PathVariable String currency) {
		 return venteInterface.findMIN(currency);
	 }
	 
	 @GetMapping("/getVenteMAX/{currency}/{date}")
	    public Vente getVENTEMAXDATE(@PathVariable String currency, @PathVariable String date) {
		 return venteInterface.findMAX(currency, date);
	 }
	 
	 @GetMapping("/getVenteMIN/{currency}/{date}")
	    public Vente getVENTEMINDATE(@PathVariable String currency, @PathVariable String date) {
		 return venteInterface.findMIN(currency, date);
	 }
	 @GetMapping("/getAveragevente")
	    public ChartDto getAllAVGVENTE() {
		 return scrapingService.getChart();
	 }
	   
	 @PostMapping("/saveAVG")
		public BasicResponse save(@RequestBody AVGVENTE avgvente) {
			return avgventeInterface.save(avgvente);
		}

	   
}
