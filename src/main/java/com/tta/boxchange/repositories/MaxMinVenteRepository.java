package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.boxchange.dao.MaxMinVenteInterface;
import com.tta.boxchange.dao.VENTEInterface;
import com.tta.boxchange.entities.MaxMinVente;
import com.tta.boxchange.mappers.MaxMinVenteRowMapper;
import com.tta.boxchange.mappers.VENTERowMapper;
import com.tta.boxchange.response.BasicResponse;

@Repository
public class MaxMinVenteRepository implements MaxMinVenteInterface {
	@Autowired
	VENTEInterface venteInterface;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public BasicResponse save(MaxMinVente maxMinVente) {
		try {
			maxMinVente.setMinMaxdate(new Date());
			maxMinVente.setMaxAED(venteInterface.maxVenteCeJour("aed"));
			maxMinVente.setMinAED(venteInterface.minVenteCeJour("aed"));
			
			maxMinVente.setMaxBHD(venteInterface.maxVenteCeJour("bhd"));
			maxMinVente.setMinBHD(venteInterface.minVenteCeJour("bhd"));
			
			maxMinVente.setMaxCAD(venteInterface.maxVenteCeJour("cad"));
			maxMinVente.setMinCAD(venteInterface.minVenteCeJour("cad"));
			
			maxMinVente.setMaxCHF(venteInterface.maxVenteCeJour("chf"));
			maxMinVente.setMinCHF(venteInterface.minVenteCeJour("chf"));
			
			maxMinVente.setMaxCNY(venteInterface.maxVenteCeJour("cny"));
			maxMinVente.setMinCNY(venteInterface.minVenteCeJour("cny"));
			
			maxMinVente.setMaxDKK(venteInterface.maxVenteCeJour("dkk"));
			maxMinVente.setMinDKK(venteInterface.minVenteCeJour("dkk"));
			
			maxMinVente.setMaxEUR(venteInterface.maxVenteCeJour("eur"));
			maxMinVente.setMinEUR(venteInterface.minVenteCeJour("eur"));
			
			maxMinVente.setMaxGBP(venteInterface.maxVenteCeJour("gbp"));
			maxMinVente.setMinGBP(venteInterface.minVenteCeJour("gbp"));
			
			maxMinVente.setMaxJPY(venteInterface.maxVenteCeJour("jpy"));
			maxMinVente.setMinJPY(venteInterface.minVenteCeJour("jpy"));
			
			maxMinVente.setMaxKWD(venteInterface.maxVenteCeJour("kwd"));
			maxMinVente.setMinKWD(venteInterface.minVenteCeJour("kwd"));
			
			maxMinVente.setMaxLYD(venteInterface.maxVenteCeJour("lyd"));
			maxMinVente.setMinLYD(venteInterface.minVenteCeJour("lyd"));
			
			maxMinVente.setMaxNOK(venteInterface.maxVenteCeJour("nok"));
			maxMinVente.setMinNOK(venteInterface.minVenteCeJour("nok"));
			
			maxMinVente.setMaxQAR(venteInterface.maxVenteCeJour("qar"));
			maxMinVente.setMinQAR(venteInterface.minVenteCeJour("qar"));
			
			maxMinVente.setMaxSAR(venteInterface.maxVenteCeJour("sar"));
			maxMinVente.setMinSAR(venteInterface.minVenteCeJour("sar"));
			
			maxMinVente.setMaxSEK(venteInterface.maxVenteCeJour("sek"));
			maxMinVente.setMinSEK(venteInterface.minVenteCeJour("sek"));
			
			maxMinVente.setMaxUSD(venteInterface.maxVenteCeJour("usd"));
			maxMinVente.setMinUSD(venteInterface.minVenteCeJour("usd"));
			System.out.println(maxMinVente.toString());
			jdbcTemplate.update(
					"INSERT INTO public.max_min_vente(\r\n"
					+ "min_maxdate, maxaed, maxbhd, maxcad, maxchf,"
					+ " maxcny, maxdkk, maxeur, maxgbp, maxjpy, maxkwd,"
					+ " maxlyd, maxnok, maxqar, maxsar, maxsek, maxusd,"
					+ " minaed, minbhd, mincad, minchf, mincny, mindkk,"
					+ " mineur, mingbp, minjpy, minkwd, minlyd, minnok,"
					+ " minqar, minsar, minsek, minusd)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
					maxMinVente.getMinMaxdate(),maxMinVente.getMaxAED(),maxMinVente.getMaxBHD(),maxMinVente.getMaxCAD(),maxMinVente.getMaxCHF(),
					maxMinVente.getMaxCNY(),maxMinVente.getMaxDKK(),maxMinVente.getMaxEUR(),maxMinVente.getMaxGBP(),maxMinVente.getMaxJPY(),maxMinVente.getMaxKWD(),
					maxMinVente.getMaxLYD(),maxMinVente.getMaxNOK(),maxMinVente.getMaxQAR(),maxMinVente.getMaxSAR(),maxMinVente.getMaxSEK(),maxMinVente.getMaxUSD(),
					maxMinVente.getMinAED(),maxMinVente.getMinBHD(),maxMinVente.getMinCAD(),maxMinVente.getMinCHF(),maxMinVente.getMinCNY(),maxMinVente.getMinDKK(),
					maxMinVente.getMinEUR(),maxMinVente.getMinGBP(),maxMinVente.getMinJPY(),maxMinVente.getMinKWD(),maxMinVente.getMinLYD(),maxMinVente.getMinNOK(),
					maxMinVente.getMinQAR(),maxMinVente.getMinSAR(),maxMinVente.getMinSEK(),maxMinVente.getMinUSD()
					);
			return new BasicResponse("Un ajout dans minmax a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<MaxMinVente> verif() {
		String req="select * from max_min_vente where min_maxdate::Date = NOW()::Date ORDER BY id_max_min DESC;";
		return jdbcTemplate.query(req,new MaxMinVenteRowMapper());
	}

	@Override
	public BasicResponse update(MaxMinVente maxMinVente) {
		try {
			Boolean doUpdate=false;
			float maxAed=venteInterface.maxVenteCeJour("aed");
			if(maxAed>maxJour("aed")) {
				doUpdate=true;
				System.out.println("maxead");
				maxMinVente.setMaxAED(maxAed);
			}
			float maxBhd=venteInterface.maxVenteCeJour("bhd");
			if(maxBhd>maxJour("bhd")) {
				doUpdate=true;
				System.out.println("maxbhd");
				maxMinVente.setMaxBHD(maxBhd);
			}
			float maxCad=venteInterface.maxVenteCeJour("cad");
			if(maxCad>maxJour("cad")) {
				doUpdate=true;
				System.out.println("maxcad");
				maxMinVente.setMaxCAD(maxCad);
			}
			float maxChf=venteInterface.maxVenteCeJour("chf");
			if(maxChf>maxJour("chf")) {
				doUpdate=true;
				System.out.println("maxechf");
				maxMinVente.setMaxCHF(maxChf);
			}
			float maxCny=venteInterface.maxVenteCeJour("cny");
			if(maxCny>maxJour("cny")) {
				doUpdate=true;
				System.out.println("maxcny");
				maxMinVente.setMaxCNY(maxCny);
			}
			float maxDkk=venteInterface.maxVenteCeJour("dkk");
			if(maxDkk>maxJour("dkk")) {
				doUpdate=true;
				System.out.println("maxdkk");
				maxMinVente.setMaxDKK(maxDkk);
			}
			float maxEur=venteInterface.maxVenteCeJour("eur");
			if(maxEur>maxJour("eur")) {
				doUpdate=true;
				System.out.println("maxeur");
				maxMinVente.setMaxEUR(maxEur);
			}
			float maxGbp=venteInterface.maxVenteCeJour("gbp");
			if(maxGbp>maxJour("gbp")) {
				doUpdate=true;
				System.out.println("maxgbp");
				maxMinVente.setMaxGBP(maxGbp);
			}
			float maxJpy=venteInterface.maxVenteCeJour("jpy");
			if(maxJpy>maxJour("jpy")) {
				doUpdate=true;
				System.out.println("maxjpy");
				maxMinVente.setMaxJPY(maxJpy);
			}
			float maxKwd=venteInterface.maxVenteCeJour("kwd");
			if(maxKwd>maxJour("kwd")) {
				doUpdate=true;
				System.out.println("maxkwd");
				maxMinVente.setMaxKWD(maxKwd);
			}
			float maxLyd=venteInterface.maxVenteCeJour("lyd");
			if(maxLyd>maxJour("lyd")) {
				doUpdate=true;
				System.out.println("maxlyd");
				maxMinVente.setMaxLYD(maxLyd);
			}
			float maxNok=venteInterface.maxVenteCeJour("nok");
			if(maxNok>maxJour("nok")) {
				doUpdate=true;
				System.out.println("maxnok");
				maxMinVente.setMaxNOK(maxNok);
			}
			float maxQar=venteInterface.maxVenteCeJour("qar");
			if(maxQar>maxJour("qar")) {
				doUpdate=true;
				System.out.println("maxqar");
				maxMinVente.setMaxQAR(maxQar);
			}
			float maxSar=venteInterface.maxVenteCeJour("sar");
			if(maxSar>maxJour("sar")) {
				doUpdate=true;
				System.out.println("maxsar");
				maxMinVente.setMaxSAR(maxSar);
			}
			float maxSek=venteInterface.maxVenteCeJour("sek");
			if(maxSek>maxJour("sek")) {
				doUpdate=true;
				System.out.println("maxsek");
				maxMinVente.setMaxSEK(maxSek);
			}
			float maxUsd=venteInterface.maxVenteCeJour("usd");
			if(maxUsd>maxJour("usd")) {
				doUpdate=true;
				System.out.println("maxusd");
				maxMinVente.setMaxUSD(maxUsd);
			}
		
			float minAed=venteInterface.minVenteCeJour("aed");
			if(minAed<minJour("aed")) {
				doUpdate=true;
				System.out.println("minaed");
				maxMinVente.setMinAED(minAed);
			}
			float minBhd=venteInterface.minVenteCeJour("bhd");
			if(minBhd<minJour("bhd")) {
				doUpdate=true;
				System.out.println("minbhd");
				maxMinVente.setMinBHD(minBhd);
			}
			float minCad=venteInterface.minVenteCeJour("cad");
			if(minCad<minJour("cad")) {
				doUpdate=true;
				System.out.println("mincad");
				maxMinVente.setMinCAD(minCad);
			}
			float minChf=venteInterface.minVenteCeJour("chf");
			if(minChf<minJour("chf")) {
				doUpdate=true;
				System.out.println("minchf");
				maxMinVente.setMinCHF(minChf);
			}
			float minCny=venteInterface.minVenteCeJour("cny");
			if(minCny<minJour("cny")) {
				doUpdate=true;
				System.out.println("mincny");
				maxMinVente.setMinCNY(minCny);
			}
			float minDkk=venteInterface.minVenteCeJour("dkk");
			if(minDkk<minJour("dkk")) {
				doUpdate=true;
				System.out.println("mindkk");
				maxMinVente.setMinDKK(minDkk);
			}
			float minEur=venteInterface.minVenteCeJour("eur");
			if(minEur<minJour("eur")) {
				doUpdate=true;
				System.out.println("mineur");
				maxMinVente.setMinEUR(minEur);
			}
			float minGbp=venteInterface.minVenteCeJour("gbp");
			if(minGbp<minJour("gbp")) {
				doUpdate=true;
				System.out.println("mingbp");
				maxMinVente.setMinGBP(minGbp);
			}
			float minJpy=venteInterface.minVenteCeJour("jpy");
			if(minJpy<minJour("jpy")) {
				doUpdate=true;
				System.out.println("minjpy");
				maxMinVente.setMinJPY(minJpy);
			}
			float minKwd=venteInterface.minVenteCeJour("kwd");
			if(minKwd<minJour("kwd")) {
				doUpdate=true;
				System.out.println("minkwd");
				maxMinVente.setMinKWD(minKwd);
			}
			float minLyd=venteInterface.minVenteCeJour("lyd");
			if(minLyd<minJour("lyd")) {
				doUpdate=true;
				System.out.println("minlyd");
				maxMinVente.setMinLYD(minLyd);
			}
			float minNok=venteInterface.minVenteCeJour("nok");
			if(minNok<minJour("nok")) {
				doUpdate=true;
				System.out.println("minnok");
				maxMinVente.setMinNOK(minNok);
			}
			float minQar=venteInterface.minVenteCeJour("qar");
			if(minQar<minJour("qar")) {
				doUpdate=true;
				System.out.println("minqar");
				maxMinVente.setMinQAR(minQar);
			}
			float minSar=venteInterface.minVenteCeJour("sar");
			if(minSar<minJour("sar")) {
				doUpdate=true;
				System.out.println("minsar");
				maxMinVente.setMinSAR(minSar);
			}
			float minSek=venteInterface.minVenteCeJour("sek");
			if(minSek<minJour("sek")) {
				doUpdate=true;
				System.out.println("minsek");
				maxMinVente.setMinSEK(minSek);
			}
			float minUsd=venteInterface.minVenteCeJour("usd");
			if(minUsd<minJour("usd")) {
				doUpdate=true;
				System.out.println("minusd");
				maxMinVente.setMinUSD(minUsd);
			}
			
			System.out.println(doUpdate);
			if(doUpdate==true) {
				save(maxMinVente);
				return new BasicResponse("Un ajout dans minmax a été effectué", HttpStatus.OK);
			}
			else {
				return new BasicResponse("tout est up to date", HttpStatus.OK);
			}
		
		
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public float maxJour(String devise) {
		devise = "max"+devise;
		String req="SELECT max("+devise+") FROM public.max_min_vente WHERE min_maxdate::DATE = NOW()::DATE;";
		float max= jdbcTemplate.queryForObject(req, float.class);
		return max;
	}

	@Override
	public float minJour(String devise) {
		devise = "min"+devise;
		String req="SELECT min("+devise+") FROM public.max_min_vente WHERE min_maxdate::DATE = NOW()::DATE;";
		float min= jdbcTemplate.queryForObject(req, float.class);
		return min;
	}
	
	@Override
	public Float maxVenteSemaine(String devise) {
		devise = "max"+devise;
		String req="SELECT max("+devise+") as max FROM public.max_min_vente	WHERE DATE_PART('week',min_maxdate) = DATE_PART('week',NOW());";
		float max= jdbcTemplate.queryForObject(req, float.class);
		return max;
	}


	@Override
	public Float minVenteSemaine(String devise) {
		devise = "min"+devise;
		String req="SELECT min("+devise+") as min FROM public.max_min_vente	WHERE DATE_PART('week',min_maxdate) = DATE_PART('week',NOW());";
		float min= jdbcTemplate.queryForObject(req, Float.class);
		return min;
	}


	@Override
	public Float maxVenteMois(String devise) {
		devise = "max"+devise;
		String req="SELECT max("+devise+") as max FROM public.max_min_vente WHERE extract (Month from min_maxdate) = extract (Month from Now());";
		float max= jdbcTemplate.queryForObject(req, float.class);
		return max;
	}


	@Override
	public Float minVenteMois(String devise) {
		devise = "min"+devise;
		String req="SELECT min("+devise+") as min FROM public.max_min_vente WHERE extract (Month from min_maxdate) = extract (Month from Now());";
		String min= jdbcTemplate.queryForObject(req, String.class);
		Float minValue = new Float(min);
		return minValue;
	}


	@Override
	public Float maxVenteAns(String devise) {
		devise = "max"+devise;
		String req="SELECT max("+devise+") as max FROM public.max_min_vente	WHERE extract (year from min_maxdate) = extract (year from Now());";
		float max= jdbcTemplate.queryForObject(req, float.class);
		return max;
	}


	@Override
	public Float minVenteAns(String devise) {
		devise = "min"+devise;
		String req="SELECT min("+devise+") as min FROM public.max_min_vente	WHERE extract (year from min_maxdate) = extract (year from Now());";
		float min= jdbcTemplate.queryForObject(req, float.class);
		return min;
	}


}
