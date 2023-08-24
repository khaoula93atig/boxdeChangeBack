package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.boxchange.dao.MinMaxAchatInterface;
import com.tta.boxchange.dao.AchatInterface;
import com.tta.boxchange.dto.MinMaxResult;
import com.tta.boxchange.entities.MaxMinAchat;
import com.tta.boxchange.mappers.MinMaxAchatRowMapper;
import com.tta.boxchange.mappers.MinMaxResultRowMapper;
import com.tta.boxchange.response.BasicResponse;

@Repository
public class MinMaxAchatRepository implements MinMaxAchatInterface {
	
	@Autowired
	AchatInterface achatInterface;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public BasicResponse save(MaxMinAchat maxMinAchat) {
		try {
			maxMinAchat.setMinMaxdate(new Date());
			maxMinAchat.setMaxAED(achatInterface.maxAchatCeJour("aed"));
			maxMinAchat.setMinAED(achatInterface.minAchatCeJour("aed"));
			
			maxMinAchat.setMaxBHD(achatInterface.maxAchatCeJour("bhd"));
			maxMinAchat.setMinBHD(achatInterface.minAchatCeJour("bhd"));
			
			maxMinAchat.setMaxCAD(achatInterface.maxAchatCeJour("cad"));
			maxMinAchat.setMinCAD(achatInterface.minAchatCeJour("cad"));
			
			maxMinAchat.setMaxCHF(achatInterface.maxAchatCeJour("chf"));
			maxMinAchat.setMinCHF(achatInterface.minAchatCeJour("chf"));
			
			maxMinAchat.setMaxCNY(achatInterface.maxAchatCeJour("cny"));
			maxMinAchat.setMinCNY(achatInterface.minAchatCeJour("cny"));
			
			maxMinAchat.setMaxDKK(achatInterface.maxAchatCeJour("dkk"));
			maxMinAchat.setMinDKK(achatInterface.minAchatCeJour("dkk"));
			
			maxMinAchat.setMaxEUR(achatInterface.maxAchatCeJour("eur"));
			maxMinAchat.setMinEUR(achatInterface.minAchatCeJour("eur"));
			
			maxMinAchat.setMaxGBP(achatInterface.maxAchatCeJour("gbp"));
			maxMinAchat.setMinGBP(achatInterface.minAchatCeJour("gbp"));
			
			maxMinAchat.setMaxJPY(achatInterface.maxAchatCeJour("jpy"));
			maxMinAchat.setMinJPY(achatInterface.minAchatCeJour("jpy"));
			
			maxMinAchat.setMaxKWD(achatInterface.maxAchatCeJour("kwd"));
			maxMinAchat.setMinKWD(achatInterface.minAchatCeJour("kwd"));
			
			maxMinAchat.setMaxLYD(achatInterface.maxAchatCeJour("lyd"));
			maxMinAchat.setMinLYD(achatInterface.minAchatCeJour("lyd"));
			
			maxMinAchat.setMaxNOK(achatInterface.maxAchatCeJour("nok"));
			maxMinAchat.setMinNOK(achatInterface.minAchatCeJour("nok"));
			
			maxMinAchat.setMaxQAR(achatInterface.maxAchatCeJour("qar"));
			maxMinAchat.setMinQAR(achatInterface.minAchatCeJour("qar"));
			
			maxMinAchat.setMaxSAR(achatInterface.maxAchatCeJour("sar"));
			maxMinAchat.setMinSAR(achatInterface.minAchatCeJour("sar"));
			
			maxMinAchat.setMaxSEK(achatInterface.maxAchatCeJour("sek"));
			maxMinAchat.setMinSEK(achatInterface.minAchatCeJour("sek"));
			
			maxMinAchat.setMaxUSD(achatInterface.maxAchatCeJour("usd"));
			maxMinAchat.setMinUSD(achatInterface.minAchatCeJour("usd"));
			System.out.println(maxMinAchat.toString());
			jdbcTemplate.update(
					"INSERT INTO public.max_min_achat(\r\n"
					+ "min_maxdate, maxaed, maxbhd, maxcad, maxchf,"
					+ " maxcny, maxdkk, maxeur, maxgbp, maxjpy, maxkwd,"
					+ " maxlyd, maxnok, maxqar, maxsar, maxsek, maxusd,"
					+ " minaed, minbhd, mincad, minchf, mincny, mindkk,"
					+ " mineur, mingbp, minjpy, minkwd, minlyd, minnok,"
					+ " minqar, minsar, minsek, minusd)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
					maxMinAchat.getMinMaxdate(),maxMinAchat.getMaxAED(),maxMinAchat.getMaxBHD(),maxMinAchat.getMaxCAD(),maxMinAchat.getMaxCHF(),
					maxMinAchat.getMaxCNY(),maxMinAchat.getMaxDKK(),maxMinAchat.getMaxEUR(),maxMinAchat.getMaxGBP(),maxMinAchat.getMaxJPY(),maxMinAchat.getMaxKWD(),
					maxMinAchat.getMaxLYD(),maxMinAchat.getMaxNOK(),maxMinAchat.getMaxQAR(),maxMinAchat.getMaxSAR(),maxMinAchat.getMaxSEK(),maxMinAchat.getMaxUSD(),
					maxMinAchat.getMinAED(),maxMinAchat.getMinBHD(),maxMinAchat.getMinCAD(),maxMinAchat.getMinCHF(),maxMinAchat.getMinCNY(),maxMinAchat.getMinDKK(),
					maxMinAchat.getMinEUR(),maxMinAchat.getMinGBP(),maxMinAchat.getMinJPY(),maxMinAchat.getMinKWD(),maxMinAchat.getMinLYD(),maxMinAchat.getMinNOK(),
					maxMinAchat.getMinQAR(),maxMinAchat.getMinSAR(),maxMinAchat.getMinSEK(),maxMinAchat.getMinUSD()
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
	public List<MaxMinAchat> verif() {
		String req="select * from max_min_achat where min_maxdate::Date = NOW()::Date ORDER BY id_max_min_achat DESC;";
		return jdbcTemplate.query(req,new MinMaxAchatRowMapper());
	}

	@Override
	public BasicResponse update(MaxMinAchat maxMinAchat) {
		try {
			Boolean doUpdate=false;
			float maxAed=achatInterface.maxAchatCeJour("aed");
			if(maxAed>maxJour("aed")) {
				doUpdate=true;
				System.out.println("maxead");
				maxMinAchat.setMaxAED(maxAed);
			}
			float maxBhd=achatInterface.maxAchatCeJour("bhd");
			if(maxBhd>maxJour("bhd")) {
				doUpdate=true;
				System.out.println("maxbhd");
				maxMinAchat.setMaxBHD(maxBhd);
			}
			float maxCad=achatInterface.maxAchatCeJour("cad");
			if(maxCad>maxJour("cad")) {
				doUpdate=true;
				System.out.println("maxcad");
				maxMinAchat.setMaxCAD(maxCad);
			}
			float maxChf=achatInterface.maxAchatCeJour("chf");
			if(maxChf>maxJour("chf")) {
				doUpdate=true;
				System.out.println("maxechf");
				maxMinAchat.setMaxCHF(maxChf);
			}
			float maxCny=achatInterface.maxAchatCeJour("cny");
			if(maxCny>maxJour("cny")) {
				doUpdate=true;
				System.out.println("maxcny");
				maxMinAchat.setMaxCNY(maxCny);
			}
			float maxDkk=achatInterface.maxAchatCeJour("dkk");
			if(maxDkk>maxJour("dkk")) {
				doUpdate=true;
				System.out.println("maxdkk");
				maxMinAchat.setMaxDKK(maxDkk);
			}
			float maxEur=achatInterface.maxAchatCeJour("eur");
			if(maxEur>maxJour("eur")) {
				doUpdate=true;
				System.out.println("maxeur");
				maxMinAchat.setMaxEUR(maxEur);
			}
			float maxGbp=achatInterface.maxAchatCeJour("gbp");
			if(maxGbp>maxJour("gbp")) {
				doUpdate=true;
				System.out.println("maxgbp");
				maxMinAchat.setMaxGBP(maxGbp);
			}
			float maxJpy=achatInterface.maxAchatCeJour("jpy");
			if(maxJpy>maxJour("jpy")) {
				doUpdate=true;
				System.out.println("maxjpy");
				maxMinAchat.setMaxJPY(maxJpy);
			}
			float maxKwd=achatInterface.maxAchatCeJour("kwd");
			if(maxKwd>maxJour("kwd")) {
				doUpdate=true;
				System.out.println("maxkwd");
				maxMinAchat.setMaxKWD(maxKwd);
			}
			float maxLyd=achatInterface.maxAchatCeJour("lyd");
			if(maxLyd>maxJour("lyd")) {
				doUpdate=true;
				System.out.println("maxlyd");
				maxMinAchat.setMaxLYD(maxLyd);
			}
			float maxNok=achatInterface.maxAchatCeJour("nok");
			if(maxNok>maxJour("nok")) {
				doUpdate=true;
				System.out.println("maxnok");
				maxMinAchat.setMaxNOK(maxNok);
			}
			float maxQar=achatInterface.maxAchatCeJour("qar");
			if(maxQar>maxJour("qar")) {
				doUpdate=true;
				System.out.println("maxqar");
				maxMinAchat.setMaxQAR(maxQar);
			}
			float maxSar=achatInterface.maxAchatCeJour("sar");
			if(maxSar>maxJour("sar")) {
				doUpdate=true;
				System.out.println("maxsar");
				maxMinAchat.setMaxSAR(maxSar);
			}
			float maxSek=achatInterface.maxAchatCeJour("sek");
			if(maxSek>maxJour("sek")) {
				doUpdate=true;
				System.out.println("maxsek");
				maxMinAchat.setMaxSEK(maxSek);
			}
			float maxUsd=achatInterface.maxAchatCeJour("usd");
			if(maxUsd>maxJour("usd")) {
				doUpdate=true;
				System.out.println("maxusd");
				maxMinAchat.setMaxUSD(maxUsd);
			}
		
			float minAed=achatInterface.minAchatCeJour("aed");
			if(minAed<minJour("aed")) {
				doUpdate=true;
				System.out.println("minaed");
				maxMinAchat.setMinAED(minAed);
			}
			float minBhd=achatInterface.minAchatCeJour("bhd");
			if(minBhd<minJour("bhd")) {
				doUpdate=true;
				System.out.println("minbhd");
				maxMinAchat.setMinBHD(minBhd);
			}
			float minCad=achatInterface.minAchatCeJour("cad");
			if(minCad<minJour("cad")) {
				doUpdate=true;
				System.out.println("mincad");
				maxMinAchat.setMinCAD(minCad);
			}
			float minChf=achatInterface.minAchatCeJour("chf");
			if(minChf<minJour("chf")) {
				doUpdate=true;
				System.out.println("minchf");
				maxMinAchat.setMinCHF(minChf);
			}
			float minCny=achatInterface.minAchatCeJour("cny");
			if(minCny<minJour("cny")) {
				doUpdate=true;
				System.out.println("mincny");
				maxMinAchat.setMinCNY(minCny);
			}
			float minDkk=achatInterface.minAchatCeJour("dkk");
			if(minDkk<minJour("dkk")) {
				doUpdate=true;
				System.out.println("mindkk");
				maxMinAchat.setMinDKK(minDkk);
			}
			float minEur=achatInterface.minAchatCeJour("eur");
			if(minEur<minJour("eur")) {
				doUpdate=true;
				System.out.println("mineur");
				maxMinAchat.setMinEUR(minEur);
			}
			float minGbp=achatInterface.minAchatCeJour("gbp");
			if(minGbp<minJour("gbp")) {
				doUpdate=true;
				System.out.println("mingbp");
				maxMinAchat.setMinGBP(minGbp);
			}
			float minJpy=achatInterface.minAchatCeJour("jpy");
			if(minJpy<minJour("jpy")) {
				doUpdate=true;
				System.out.println("minjpy");
				maxMinAchat.setMinJPY(minJpy);
			}
			float minKwd=achatInterface.minAchatCeJour("kwd");
			if(minKwd<minJour("kwd")) {
				doUpdate=true;
				System.out.println("minkwd");
				maxMinAchat.setMinKWD(minKwd);
			}
			float minLyd=achatInterface.minAchatCeJour("lyd");
			if(minLyd<minJour("lyd")) {
				doUpdate=true;
				System.out.println("minlyd");
				maxMinAchat.setMinLYD(minLyd);
			}
			float minNok=achatInterface.minAchatCeJour("nok");
			if(minNok<minJour("nok")) {
				doUpdate=true;
				System.out.println("minnok");
				maxMinAchat.setMinNOK(minNok);
			}
			float minQar=achatInterface.minAchatCeJour("qar");
			if(minQar<minJour("qar")) {
				doUpdate=true;
				System.out.println("minqar");
				maxMinAchat.setMinQAR(minQar);
			}
			float minSar=achatInterface.minAchatCeJour("sar");
			if(minSar<minJour("sar")) {
				doUpdate=true;
				System.out.println("minsar");
				maxMinAchat.setMinSAR(minSar);
			}
			float minSek=achatInterface.minAchatCeJour("sek");
			if(minSek<minJour("sek")) {
				doUpdate=true;
				System.out.println("minsek");
				maxMinAchat.setMinSEK(minSek);
			}
			float minUsd=achatInterface.minAchatCeJour("usd");
			if(minUsd<minJour("usd")) {
				doUpdate=true;
				System.out.println("minusd");
				maxMinAchat.setMinUSD(minUsd);
			}
			
			System.out.println(doUpdate);
			if(doUpdate==true) {
				save(maxMinAchat);
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
		String req="SELECT max("+devise+") FROM public.max_min_achat WHERE min_maxdate::DATE = NOW()::DATE;";
		float max= jdbcTemplate.queryForObject(req, float.class);
		return max;
	}

	@Override
	public float minJour(String devise) {
		devise = "min"+devise;
		String req="SELECT min("+devise+") FROM public.max_min_achat WHERE min_maxdate::DATE = NOW()::DATE;";
		float min= jdbcTemplate.queryForObject(req, float.class);
		return min;
	}

	@Override
	public MinMaxResult maxAchatSemaine(String devise) {
		devise = "max"+devise;
		String req="SELECT "+devise+" as valeur , min_maxdate as date FROM public.max_min_achat   \r\n"
				+ "WHERE "+ devise+"=(select max("+devise+") FROM public.max_min_achat WHERE DATE_PART('week',min_maxdate) = DATE_PART('week',NOW()))\r\n"
				+ "order by min_maxdate DESC limit 1;";
		MinMaxResult max= jdbcTemplate.queryForObject(req, new MinMaxResultRowMapper());
		return max;
	}

	@Override
	public MinMaxResult minAchatSemaine(String devise) {
		devise = "min"+devise;
		String req="SELECT "+devise+" as valeur , min_maxdate as date FROM public.max_min_achat   \r\n"
				+ "WHERE "+ devise+"=(select min("+devise+") FROM public.max_min_achat WHERE DATE_PART('week',min_maxdate) = DATE_PART('week',NOW()))\r\n"
				+ "order by min_maxdate DESC limit 1;";
		MinMaxResult min= jdbcTemplate.queryForObject(req, new MinMaxResultRowMapper());
		return min;
	}

	@Override
	public MinMaxResult maxAchatMois(String devise) {
		devise = "max"+devise;
		String req="SELECT "+devise+" as valeur , min_maxdate  as date FROM  public.max_min_achat   \r\n"
				+ "WHERE "+ devise+"=(select max("+devise+") FROM public.max_min_achat WHERE extract (Month from min_maxdate) = extract (Month from Now()))\r\n"
				+ "order by min_maxdate DESC limit 1;";
		MinMaxResult max= jdbcTemplate.queryForObject(req, new MinMaxResultRowMapper());
		return max;
	}

	@Override
	public MinMaxResult minAchatMois(String devise) {
		devise = "min"+devise;
		String req="SELECT "+devise+" as valeur , min_maxdate as date FROM public.max_min_achat   \r\n"
				+ "WHERE "+ devise+"=(select min("+devise+") FROM public.max_min_achat WHERE extract (Month from min_maxdate) = extract (Month from Now()))\r\n"
				+ "order by min_maxdate DESC limit 1;";
		//String min= jdbcTemplate.queryForObject(req, String.class);
		MinMaxResult minValue = jdbcTemplate.queryForObject(req, new MinMaxResultRowMapper());
		return minValue;
	}

	@Override
	public MinMaxResult maxAchatAns(String devise) {
		devise = "max"+devise;
		String req="SELECT "+devise+" as valeur , min_maxdate as date FROM public.max_min_achat   \r\n"
				+ "WHERE "+ devise+"=(select max("+devise+") FROM public.max_min_achat WHERE extract (year from min_maxdate) = extract (year from Now()) )\r\n"
				+ "order by min_maxdate DESC limit 1;";
		MinMaxResult max= jdbcTemplate.queryForObject(req, new MinMaxResultRowMapper());
		return max;
	}

	@Override
	public MinMaxResult minAchatAns(String devise) {
		devise = "min"+devise;
		String req="SELECT "+devise+" as valeur , min_maxdate as date FROM public.max_min_achat   \r\n"
				+ "WHERE "+ devise+"=(select min("+devise+") FROM public.max_min_achat WHERE extract (year from min_maxdate) = extract (year from Now()) )\r\n"
				+ "order by min_maxdate DESC limit 1;";
		MinMaxResult min= jdbcTemplate.queryForObject(req, new MinMaxResultRowMapper());
		return min;
	}

}
