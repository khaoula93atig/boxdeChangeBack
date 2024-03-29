package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;

import com.tta.boxchange.entities.Vente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.boxchange.dao.AchatInterface;
import com.tta.boxchange.entities.Achat;
import com.tta.boxchange.mappers.AchatRowMapper;
import com.tta.boxchange.mappers.VENTERowMapper;
import com.tta.boxchange.response.BasicResponse;

@Repository
public class AchatRepository implements AchatInterface {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Achat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Achat> findLasts() {
		return jdbcTemplate.query("SELECT * FROM public.achat\r\n"
				+ "				WHERE nom_banque in ('amen','zitouna','btl','btk','bte',\r\n"
				+ "									 'bh','biat','tsb','wifak','qnb',\r\n"
				+ "									 'attijari','al baraka' ,'uib','stb','atb',\r\n"
				+ "									 'bt','bna') and datedevise::DATE = NOW()::DATE\r\n"
				+ "					order by datedevise desc;",
				new AchatRowMapper());
	}

	@Override
	public Achat findMAX(String currency) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Achat> getbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicResponse save(Achat achat) {
try {
			
			Date dateDevise = new Date();
			achat.setDatedevise(dateDevise);
	this.modificationChar(achat);
			jdbcTemplate.update(
					"INSERT INTO public.achat(\r\n"
					+ "	datedevise, deviseaed, devisebhd, devisecad, devisechf, devisecny,"
					+ " devisedkk, deviseeur, devisegbp, devisejpy, devisekwd, deviselyd,"
					+ " devisenok, deviseqar, devisesar, devisesek, deviseusd, nom_banque)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
					achat.getDatedevise(),achat.getDeviseAED(),achat.getDeviseBHD(),achat.getDeviseCAD(),achat.getDeviseCHF(),achat.getDeviseCNY(),
					achat.getDeviseDKK(),achat.getDeviseEUR(),achat.getDeviseGBP(),achat.getDeviseJPY(),achat.getDeviseKWD(),achat.getDeviseLYD(),
					achat.getDeviseNOK(),achat.getDeviseQAR(),achat.getDeviseSAR(),achat.getDeviseSEK(),achat.getDeviseUSD(),
					achat.getNomBanque()
					);

			return new BasicResponse("ajout d'un nouveau achat a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(Achat chat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Achat> modification(String nomBanque) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Achat> verification(String Bank) {
		String req="select * from achat where datedevise::Date = NOW()::Date and nom_banque= ?;";
		return jdbcTemplate.query(req,new Object[] { Bank },new AchatRowMapper());
	}

	@Override
	public BasicResponse updateAchat(Achat ancienneAchat, Achat nouveauAchat) {
		try {
			this.modificationChar(nouveauAchat);
			String req = "UPDATE public.achat\r\n"
					+ "	SET deviseaed=?, devisebhd=?, devisecad=?, devisechf=?,"
					+ " devisecny=?, devisedkk=?, deviseeur=?, devisegbp=?, devisejpy=?, "
					+ "devisekwd=?, deviselyd=?, devisenok=?, deviseqar=?, devisesar=?,"
					+ " devisesek=?, deviseusd=?, nom_banque=?\r\n"
					+ "	WHERE id_achat=?;";
			jdbcTemplate.update(req,nouveauAchat.getDeviseAED(),nouveauAchat.getDeviseBHD(),nouveauAchat.getDeviseCAD(),nouveauAchat.getDeviseCHF(),
					nouveauAchat.getDeviseCNY(),nouveauAchat.getDeviseDKK(),nouveauAchat.getDeviseEUR(),nouveauAchat.getDeviseGBP(),nouveauAchat.getDeviseJPY(),
					nouveauAchat.getDeviseKWD(),nouveauAchat.getDeviseLYD(),nouveauAchat.getDeviseNOK(),nouveauAchat.getDeviseQAR(),nouveauAchat.getDeviseSAR(),
					nouveauAchat.getDeviseSEK(),nouveauAchat.getDeviseUSD(),ancienneAchat.getIdAchat());
			
			return new BasicResponse("La modification effectuée avec succes", HttpStatus.OK);
		}catch (Exception e) {
			return new BasicResponse("Erreur", HttpStatus.OK);
		}
	}

	@Override
	public Achat findMIN(String currency) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Achat findMAX(String currency, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Achat findMIN(String currency, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float maxAchatCeJour(String devise) {
		devise = "devise"+devise;
		String req="SELECT max("+ devise +") FROM public.achat WHERE datedevise::DATE = NOW()::DATE;";
		String max= jdbcTemplate.queryForObject(req, String.class);
		Float maxValue = new Float(max);
		return maxValue;
	}

	@Override
	public Float minAchatCeJour(String devise) {
		devise = "devise"+devise;
		String req="SELECT min("+ devise + ")as min FROM (select "+ devise +" from public.achat\r\n"
				+ "	WHERE datedevise::DATE = NOW()::DATE and "+ devise +" <> '0') as test;";
		String min= jdbcTemplate.queryForObject(req, String.class);
		Float minValue = new Float(min);
		return minValue;
	}

	public Achat modificationChar(Achat achat){
		System.out.println(achat);
		//System.out.println("testachat "+achat.getDeviseCAD().chars().allMatch( Character::isDigit ));
		//System.out.println("test "+achat.getDeviseEUR().chars().allMatch( Character::isDigit ));
		if(achat.getDeviseAED().matches("[a-zA-Z]+")){
			achat.setDeviseAED("0");
		}
		if(achat.getDeviseBHD().matches("[a-zA-Z]+")){
			achat.setDeviseBHD("0");
		}
		if(achat.getDeviseCNY().matches("[a-zA-Z]+")){
			achat.setDeviseCNY("0");
		}
		if(achat.getDeviseCHF().matches("[a-zA-Z]+")){
			achat.setDeviseCHF("0");
		}
		if(achat.getDeviseDKK().matches("[a-zA-Z]+")){
			achat.setDeviseDKK("0");
		}
		if(achat.getDeviseLYD().matches("[a-zA-Z]+")){
			achat.setDeviseLYD("0");
		}
		if(achat.getDeviseEUR().matches("[a-zA-Z]+")){
			achat.setDeviseEUR("0");
		}
		if(achat.getDeviseKWD().matches("[a-zA-Z]+")){
			achat.setDeviseKWD("0");
		}
		if(achat.getDeviseGBP().matches("[a-zA-Z]+")){
			achat.setDeviseGBP("0");
		}
		if(achat.getDeviseCAD().matches("[a-zA-Z]+")){
			achat.setDeviseCAD("0");
		}
		if(achat.getDeviseJPY().matches("[a-zA-Z]+")){
			achat.setDeviseJPY("0");
		}
		if(achat.getDeviseNOK().matches("[a-zA-Z]+")){
			achat.setDeviseNOK("0");
		}
		if(achat.getDeviseQAR().matches("[a-zA-Z]+")){
			achat.setDeviseQAR("0");
		}
		if(achat.getDeviseUSD().matches("[a-zA-Z]+")){
			achat.setDeviseUSD("0");
		}
		if(achat.getDeviseSAR().matches("[a-zA-Z]+")){
			achat.setDeviseSAR("0");
		}
		if(achat.getDeviseSEK().matches("[a-zA-Z]+")){
			achat.setDeviseSEK("0");
		}
		return achat;
	}

}
