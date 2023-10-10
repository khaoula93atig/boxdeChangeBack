package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.AVGVENTEInterface;
import com.tta.boxchange.entities.AVGVENTE;
import com.tta.boxchange.entities.AverageVenteDevise;
//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.AVGVENTERowMapper;
import com.tta.boxchange.mappers.AvgVenteDeviseRowMapper;
import com.tta.boxchange.mappers.VENTERowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AVGVENTERepository implements AVGVENTEInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<AVGVENTE> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT id, nombanque, devisesar, devisecad, devisedkk, deviseusd, devisegbp, devisejpy, devisenok, devisesek, devisechf, devisekwd, deviseaed, deviseeur, deviselyd, devisebhd, deviseqar, devisecny, datedevise\r\n"
				+ "	FROM public.averagefiras;", new AVGVENTERowMapper());

	}

	

	@Override
	public BasicResponse save(AVGVENTE avgvente) {
		try {
			avgvente.setDatedevise(new Date());
			avgvente.setDeviseaed(getMoyenneVente("deviseaed"));
			avgvente.setDevisebhd(getMoyenneVente("devisebhd"));
			avgvente.setDevisecad(getMoyenneVente("devisecad"));
			avgvente.setDevisechf(getMoyenneVente("devisechf"));
			avgvente.setDevisecny(getMoyenneVente("devisecny"));
			avgvente.setDevisedkk(getMoyenneVente("devisedkk"));
			avgvente.setDeviseeur(getMoyenneVente("deviseeur"));
			avgvente.setDevisegbp(getMoyenneVente("devisegbp"));
			avgvente.setDevisejpy(getMoyenneVente("devisejpy"));
			avgvente.setDevisekwd(getMoyenneVente("devisekwd"));
			avgvente.setDeviselyd(getMoyenneVente("deviselyd"));
			avgvente.setDevisenok(getMoyenneVente("devisenok"));
			avgvente.setDeviseqar(getMoyenneVente("deviseqar"));
			avgvente.setDevisesar(getMoyenneVente("devisesar"));
			avgvente.setDevisesek(getMoyenneVente("devisesek"));
			avgvente.setDeviseusd(getMoyenneVente("deviseusd"));
			System.out.println(avgvente.toString());
			jdbcTemplate.update(
					"INSERT INTO public.avgvente(\r\n"
					+ "datedevise, deviseaed, devisebhd, devisecad, devisechf, devisecny,"
					+ " devisedkk, deviseeur, devisegbp, devisejpy, devisekwd, deviselyd, devisenok, deviseqar, devisesar, devisesek, deviseusd)\r\n"
					+ "	VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
					avgvente.getDatedevise(),avgvente.getDeviseaed(),avgvente.getDevisebhd(),avgvente.getDevisecad(),avgvente.getDevisechf(),avgvente.getDevisecny(),
					avgvente.getDevisedkk(),avgvente.getDeviseeur(),avgvente.getDevisegbp(),avgvente.getDevisejpy(),avgvente.getDevisekwd(),avgvente.getDeviselyd(),
					avgvente.getDevisenok(),avgvente.getDeviseqar(),avgvente.getDevisesar(),avgvente.getDevisesek(),avgvente.getDeviseusd()
					);
			return new BasicResponse("Un ajout dans moyenne a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}



	@Override
	public List<AVGVENTE> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BIAT\"\r\n"
				+ "	where \"idBIAT\"=?;", new Object[] { id },
				new AVGVENTERowMapper());
	}

	@Override
	public List<AVGVENTE> modification(String codeDevise) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BIAT\"\r\n"
				+ "	where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { codeDevise },
				new AVGVENTERowMapper());
	}
	
	
	//calcul de la moyenne de vente pour chaque devise
	public float getMoyenneVente(String devise) {
		String req="SELECT ROUND(avg("+devise+"::numeric), 3)\r\n"
				+ "	FROM (select "+ devise+" from vente where "+devise+" <> '0' and "+devise+"<>'-')as avg;";
		return jdbcTemplate.queryForObject(req,float.class);
	}



	@Override
	public List<AVGVENTE> verification() {
		String req="select * from avgvente where datedevise::Date = NOW()::Date;";
		return jdbcTemplate.query(req,new AVGVENTERowMapper() );
	}



	@Override
	public BasicResponse update(AVGVENTE ancienAvgvente) {
		try {
			ancienAvgvente.setDeviseaed(getMoyenneVente("deviseaed"));
			ancienAvgvente.setDevisebhd(getMoyenneVente("devisebhd"));
			ancienAvgvente.setDevisecad(getMoyenneVente("devisecad"));
			ancienAvgvente.setDevisechf(getMoyenneVente("devisechf"));
			ancienAvgvente.setDevisecny(getMoyenneVente("devisecny"));
			ancienAvgvente.setDevisedkk(getMoyenneVente("devisedkk"));
			ancienAvgvente.setDeviseeur(getMoyenneVente("deviseeur"));
			ancienAvgvente.setDevisegbp(getMoyenneVente("devisegbp"));
			ancienAvgvente.setDevisejpy(getMoyenneVente("devisejpy"));
			ancienAvgvente.setDevisekwd(getMoyenneVente("devisekwd"));
			ancienAvgvente.setDeviselyd(getMoyenneVente("deviselyd"));
			ancienAvgvente.setDevisenok(getMoyenneVente("devisenok"));
			ancienAvgvente.setDeviseqar(getMoyenneVente("deviseqar"));
			ancienAvgvente.setDevisesar(getMoyenneVente("devisesar"));
			ancienAvgvente.setDevisesek(getMoyenneVente("devisesek"));
			ancienAvgvente.setDeviseusd(getMoyenneVente("deviseusd"));
			String req = "UPDATE public.avgvente\r\n"
					+ "	SET deviseaed=?, devisebhd=?, devisecad=?, devisechf=?, devisecny=?,"
					+ " devisedkk=?, deviseeur=?, devisegbp=?, devisejpy=?, devisekwd=?, deviselyd=?,"
					+ " devisenok=?, deviseqar=?, devisesar=?, devisesek=?, deviseusd=?\r\n"
					+ "	WHERE id=?;";
			jdbcTemplate.update(req,ancienAvgvente.getDeviseaed(),ancienAvgvente.getDevisebhd(),ancienAvgvente.getDevisecad(),ancienAvgvente.getDevisechf(),ancienAvgvente.getDevisecny(),
					ancienAvgvente.getDevisedkk(),ancienAvgvente.getDeviseeur(),ancienAvgvente.getDevisegbp(),ancienAvgvente.getDevisejpy(),ancienAvgvente.getDevisekwd(),ancienAvgvente.getDeviselyd(),
					ancienAvgvente.getDevisenok(),ancienAvgvente.getDeviseqar(),ancienAvgvente.getDevisesar(),ancienAvgvente.getDevisesek(),ancienAvgvente.getDeviseusd(),
					ancienAvgvente.getId());
			System.out.println("up ok");
			
			return new BasicResponse("La modification effectuée avec succes", HttpStatus.OK);
		}catch (Exception e) {
			return new BasicResponse("Erreur", HttpStatus.OK);
		}
	}



	@Override
	public List<AverageVenteDevise> averageBydevise(String devise) {
		devise="devise"+devise;
		String req ="SELECT datedevise, "+devise +" AS devise FROM public.avgvente;";
		System.out.println(jdbcTemplate.query(req,new AvgVenteDeviseRowMapper() ));
		return jdbcTemplate.query(req,new AvgVenteDeviseRowMapper() );
	}
	






	
	

}
