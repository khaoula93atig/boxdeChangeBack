package com.tta.boxchange.repositories;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.VENTEInterface;
import com.tta.boxchange.entities.Vente;
//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.VENTERowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VENTERepository implements VENTEInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Vente> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT v1.*\r\n"
				+ "FROM public.\"VENTE\" v1\r\n"
				+ "INNER JOIN (\r\n"
				+ "    SELECT \"nomBanque\", MAX(datedevise) AS max_datedevise\r\n"
				+ "    FROM public.\"VENTE\"\r\n"
				+ "    GROUP BY \"nomBanque\"\r\n"
				+ ") v2\r\n"
				+ "ON v1.\"nomBanque\" = v2.\"nomBanque\" AND v1.datedevise = v2.max_datedevise", new VENTERowMapper());

	}


	@Override
	public Vente findMAX(String currency) {
		
		String columntochange = "devise" + currency;
		return jdbcTemplate.query("SELECT * FROM public.\"VENTE\" WHERE CAST(\"" + columntochange + "\" AS float) = " +
	               "(SELECT MAX(CAST(\"" + columntochange + "\" AS float)) FROM public.\"VENTE\") " +
	               "ORDER BY datedevise DESC LIMIT 1;", new VENTERowMapper()).get(0);
	}
	
	@Override
	public Vente findMIN(String currency) {
		
		String columntochange = "devise" + currency;
		return jdbcTemplate.query("SELECT * FROM public.\"VENTE\" WHERE CAST(\"" + columntochange + "\" AS float) = " +
	               "(SELECT MIN(CAST(\"" + columntochange + "\" AS float)) FROM public.\"VENTE\") " +
	               "ORDER BY datedevise DESC LIMIT 1;", new VENTERowMapper()).get(0);
	}
	

	@Override
	public Vente findMAX(String currency, String date) {
		
		String columntochange = "devise" + currency;
		return jdbcTemplate.query("SELECT *\n" +
	               "FROM public.\"VENTE\"\n" +
	               "WHERE CAST(\"" + columntochange + "\" AS float) = (\n" +
	               "  SELECT MAX(CAST(\"" + columntochange + "\" AS float))\n" +
	               "  FROM public.\"VENTE\"\n" +
	               "  WHERE DATE_TRUNC('" + date + "', datedevise) = DATE_TRUNC('" + date + "', CURRENT_DATE)\n" +
	               ")\n" +
	               "ORDER BY datedevise DESC\n" +
	               "LIMIT 1;", new VENTERowMapper()).get(0);
	}
	
	@Override
	public Vente findMIN(String currency, String date) {
		
		String columntochange = "devise" + currency;
		return jdbcTemplate.query("SELECT *\n" +
	               "FROM public.\"VENTE\"\n" +
	               "WHERE CAST(\"" + columntochange + "\" AS float) = (\n" +
	               "  SELECT MIN(CAST(\"" + columntochange + "\" AS float))\n" +
	               "  FROM public.\"VENTE\"\n" +
	               "  WHERE DATE_TRUNC('" + date + "', datedevise) = DATE_TRUNC('" + date + "', CURRENT_DATE)\n" +
	               ")\n" +
	               "ORDER BY datedevise DESC\n" +
	               "LIMIT 1;", new VENTERowMapper()).get(0);
	}
	@Override
	public BasicResponse save(Vente vente) {
		try {
			
			Date dateDevise = new Date();
			vente.setDatedevise(dateDevise);
		this.modificationChar(vente);
			jdbcTemplate.update(
					"INSERT INTO public.vente(\r\n"
					+ "	datedevise, deviseaed, devisebhd, devisecad, devisechf, devisecny,"
					+ " devisedkk, deviseeur, devisegbp, devisejpy, devisekwd, deviselyd,"
					+ " devisenok, deviseqar, devisesar, devisesek, deviseusd, nom_banque)\r\n"
					+ "	VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
					vente.getDatedevise(),vente.getDeviseAED(),vente.getDeviseBHD(),vente.getDeviseCAD(),vente.getDeviseCHF(),vente.getDeviseCNY(),
					vente.getDeviseDKK(),vente.getDeviseEUR(),vente.getDeviseGBP(),vente.getDeviseJPY(),vente.getDeviseKWD(),vente.getDeviseLYD(),
					vente.getDeviseNOK(),vente.getDeviseQAR(),vente.getDeviseSAR(),vente.getDeviseSEK(),vente.getDeviseUSD(),
					vente.getNomBanque()
					);

			return new BasicResponse("Un ajout dans vente a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(Vente vente) {
		System.out.println(vente);
		try {
			List<Vente> toUpdate = this.getbyId(vente.getIdVENTE());
			System.out.println(toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("VENTE  update " + vente.toString());
				this.modificationChar(vente);
				jdbcTemplate.update("UPDATE public.\"VENTE\"\r\n"
						+ "	SET \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"VENTE\"=?;", vente.getDeviseSAR(),vente.getDeviseCAD(),vente.getDeviseDKK(),vente.getDeviseUSD(),vente.getDeviseGBP(),
						vente.getDeviseJPY(),vente.getDeviseNOK(),vente.getDeviseSEK(),vente.getDeviseCHF(),vente.getDeviseKWD(),
						vente.getDeviseAED(),vente.getDeviseEUR(),vente.getDeviseLYD(),vente.getDeviseBHD(),vente.getDeviseQAR(),
						vente.getDeviseCNY(),vente.getDatedevise(),vente.getNomBanque());
				return new BasicResponse("La modification effectuée avec succes", HttpStatus.OK);
			} else {
				return new BasicResponse("Erreur", HttpStatus.OK);
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
	public List<Vente> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"VENTE\"\r\n"
				+ "	where \"idVENTE\"=?;", new Object[] { id },
				new VENTERowMapper());
	}

	@Override
	public List<Vente> modification(String nomBanque) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"VENTE\"\r\n"
				+ "	where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { nomBanque },
				new VENTERowMapper());
	}


	@Override
	public List<Vente> findLasts() {
		return jdbcTemplate.query("SELECT * FROM public.vente\r\n"
				+ "				WHERE nom_banque in ('amen','zitouna','btl','btk','bte',\r\n"
				+ "									 'bh','biat','tsb','wifak','qnb',\r\n"
				+ "									 'attijari','al baraka' ,'uib','stb','atb',\r\n"
				+ "									 'bt','bna') and datedevise::DATE = NOW()::DATE\r\n"
				+ "					order by datedevise desc;",
				new VENTERowMapper());
	}


	@Override
	public Float maxVenteCeJour(String devise) {
		devise = "devise"+devise;
		String req="SELECT max("+ devise +") FROM public.vente WHERE datedevise::DATE = NOW()::DATE;";
		String max= jdbcTemplate.queryForObject(req, String.class);
		Float maxValue = new Float(max);
		return maxValue;
	}


	@Override
	public Float minVenteCeJour(String devise) {
		devise = "devise"+devise;
		String req="SELECT min("+ devise + ")as min FROM (select "+ devise +" from public.vente\r\n"
				+ "	WHERE datedevise::DATE = NOW()::DATE and "+ devise +" <> '0') as test;";
		String min= jdbcTemplate.queryForObject(req, String.class);
		Float minValue = new Float(min);
		return minValue;
	}


	

	@Override
	public List<Vente> verification(String Bank) {
		String req="select * from vente where datedevise::Date = NOW()::Date and nom_banque= ?;";
		return jdbcTemplate.query(req,new Object[] { Bank },new VENTERowMapper());
		
	}


	@Override
	public BasicResponse updateVente(Vente ancienneVente, Vente nouveauVente) {
		try {
			String req = "UPDATE public.vente\r\n"
					+ "	SET deviseaed=?, devisebhd=?, devisecad=?, devisechf=?, devisecny=?,"
					+ " devisedkk=?, deviseeur=?, devisegbp=?, devisejpy=?, devisekwd=?, deviselyd=?,"
					+ " devisenok=?, deviseqar=?, devisesar=?, devisesek=?, deviseusd=?\r\n"
					+ "	WHERE idvente=?";
			jdbcTemplate.update(req,nouveauVente.getDeviseAED(),nouveauVente.getDeviseBHD(),nouveauVente.getDeviseCAD(),nouveauVente.getDeviseCHF(),nouveauVente.getDeviseCNY(),
					nouveauVente.getDeviseDKK(),nouveauVente.getDeviseEUR(),nouveauVente.getDeviseGBP(),nouveauVente.getDeviseJPY(),nouveauVente.getDeviseKWD(),nouveauVente.getDeviseLYD(),
					nouveauVente.getDeviseNOK(),nouveauVente.getDeviseQAR(),nouveauVente.getDeviseSAR(),nouveauVente.getDeviseSEK(),nouveauVente.getDeviseUSD(),ancienneVente.getIdVENTE());
			
			return new BasicResponse("La modification effectuée avec succes", HttpStatus.OK);
		}catch (Exception e) {
			return new BasicResponse("Erreur", HttpStatus.OK);
		}
	}

	public Vente modificationChar(Vente vente){
		System.out.println("test "+vente.getDeviseCAD().chars().allMatch( Character::isDigit ));
		System.out.println("test "+vente.getDeviseEUR().chars().allMatch( Character::isDigit ));
		if(vente.getDeviseAED().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseAED("0");
		}
		if(vente.getDeviseBHD().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseBHD("0");
		}
		if(vente.getDeviseCNY().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseCNY("0");
		}
		if(vente.getDeviseCHF().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseCHF("0");
		}
		if(vente.getDeviseDKK().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseDKK("0");
		}
		if(vente.getDeviseLYD().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseLYD("0");
		}
		if(vente.getDeviseEUR().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseEUR("0");
		}
		if(vente.getDeviseKWD().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseKWD("0");
		}
		if(vente.getDeviseGBP().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseGBP("0");
		}
		if(vente.getDeviseCAD().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseCAD("0");
		}
		if(vente.getDeviseJPY().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseJPY("0");
		}
		if(vente.getDeviseNOK().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseNOK("0");
		}
		if(vente.getDeviseQAR().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseQAR("0");
		}
		if(vente.getDeviseUSD().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseUSD("0");
		}
		if(vente.getDeviseSAR().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseSAR("0");
		}
		if(vente.getDeviseSEK().chars().allMatch( Character::isDigit )==false){
			vente.setDeviseSEK("0");
		}
		return vente;
	}









	
	

}
