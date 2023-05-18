package com.tta.boxchange.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.tta.boxchange.dao.AVGVENTEInterface;
import com.tta.boxchange.dto.ChartDto;
import com.tta.boxchange.dto.DataSet;
import com.tta.boxchange.entities.AVGVENTE;

import java.io.IOException;
import java.util.List;

@Service
public class ScrapingService {

	private final AVGVENTEInterface avgRespository;
	
    public ScrapingService(AVGVENTEInterface avgRespository) {
		this.avgRespository = avgRespository;
	}



    public ChartDto getChart() {
    	List<AVGVENTE> avgList = avgRespository.findAll();
    	
    	DataSet SAR = new DataSet();
    	SAR.setLabel("SAR");
    	SAR.setBackgroundColor("#96eab6");
    	SAR.setBorderColor("#96eab6");
    	
    	DataSet CAD = new DataSet();
    	CAD.setLabel("CAD");
    	CAD.setBackgroundColor("#971aad");
    	CAD.setBorderColor("#971aad");
    	
    	DataSet DKK = new DataSet();
    	DKK.setLabel("DKK");
    	DKK.setBackgroundColor("#02dd1f");
    	DKK.setBorderColor("#02dd1f");
    	
    	DataSet USD = new DataSet();
    	USD.setLabel("USD");
    	USD.setBackgroundColor("#02dd1f");
    	USD.setBorderColor("#02dd1f");
    	
    	DataSet GBP = new DataSet();
    	GBP.setLabel("GBP");
    	GBP.setBackgroundColor("#5f6b62");
    	GBP.setBorderColor("#5f6b62");
    	
    	DataSet JPY = new DataSet();
    	JPY.setLabel("SAR");
    	JPY.setBackgroundColor("#3e8fe0");
    	JPY.setBorderColor("#3e8fe0");
    	
    	DataSet NOK = new DataSet();
    	NOK.setLabel("NOK");
    	NOK.setBackgroundColor("#96918e");
    	NOK.setBorderColor("#96918e");
    	
    	DataSet SEK = new DataSet();
    	SEK.setLabel("SEK");
    	SEK.setBackgroundColor("#324149");
    	SEK.setBorderColor("#324149");
    	
    	DataSet CHF = new DataSet();
    	CHF.setLabel("CHF");
    	CHF.setBackgroundColor("#756d40");
    	CHF.setBorderColor("#756d40");
    	
    	DataSet KWD = new DataSet();
    	KWD.setLabel("KWD");
    	KWD.setBackgroundColor("#754759");
    	KWD.setBorderColor("#754759");
    	
    	DataSet AED = new DataSet();
    	AED.setLabel("AED");
    	AED.setBackgroundColor("#8c30f4");
    	AED.setBorderColor("#8c30f4");
    	
    	DataSet EUR = new DataSet();
    	EUR.setLabel("EUR");
    	EUR.setBackgroundColor("#d8f435");
    	EUR.setBorderColor("#d8f435");
    	
    	DataSet LYD = new DataSet();
    	LYD.setLabel("LYD");
    	LYD.setBackgroundColor("#bce23f");
    	LYD.setBorderColor("#bce23f");
    	
    	DataSet BHD = new DataSet();
    	BHD.setLabel("BHD");
    	BHD.setBackgroundColor("#ea91ad");
    	BHD.setBorderColor("#ea91ad");
    	
    	DataSet QAR = new DataSet();
    	QAR.setLabel("QAR");
    	QAR.setBackgroundColor("#256784");
    	QAR.setBorderColor("#256784");
    	
    	DataSet CNY = new DataSet();
    	CNY.setLabel("CNY");
    	CNY.setBackgroundColor("#578e20");
    	CNY.setBorderColor("#578e20");
    	
    	ChartDto chart = new ChartDto();
    	avgList.forEach(avg -> {
    		chart.labels.add(avg.getDatedevise().toString());
    		SAR.data.add(avg.getDevisesar());
    		CAD.data.add(Double.parseDouble(avg.getDevisecad()));
    		DKK.data.add(Double.parseDouble(avg.getDevisedkk()));
    		USD.data.add(Double.parseDouble(avg.getDeviseusd()));
    		GBP.data.add(Double.parseDouble(avg.getDevisegbp()));
    		JPY.data.add(Double.parseDouble(avg.getDevisejpy()));
    		NOK.data.add(Double.parseDouble(avg.getDevisenok()));
    		SEK.data.add(Double.parseDouble(avg.getDevisesek()));
    		CHF.data.add(Double.parseDouble(avg.getDevisechf()));
    		KWD.data.add(Double.parseDouble(avg.getDevisekwd()));
    		AED.data.add(Double.parseDouble(avg.getDeviseaed()));
    		EUR.data.add(Double.parseDouble(avg.getDeviseeur()));
    		LYD.data.add(Double.parseDouble(avg.getDeviselyd()));
    		BHD.data.add(Double.parseDouble(avg.getDevisebhd()));
    		QAR.data.add(Double.parseDouble(avg.getDeviseqar()));
    		CNY.data.add(Double.parseDouble(avg.getDevisecny()));    		
    	});
    	chart.datasets.add(SAR);
    	chart.datasets.add(CAD);
    	chart.datasets.add(DKK);
    	chart.datasets.add(USD);
    	chart.datasets.add(GBP);
    	chart.datasets.add(JPY);
    	chart.datasets.add(NOK);
    	chart.datasets.add(SEK);
    	chart.datasets.add(CHF);
    	chart.datasets.add(KWD);
    	chart.datasets.add(AED);
    	chart.datasets.add(EUR);
    	chart.datasets.add(LYD);
    	chart.datasets.add(BHD);
    	chart.datasets.add(QAR);
    	chart.datasets.add(CNY);
    	
    	return chart;
    	
    }
    
	public Elements getDataFromWebPage(String url, String selector) throws IOException {
        Document document = Jsoup.connect(url).get();
        return document.select(selector);
    }
}