package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.boxchange.dao.AvgAchatInterface;
import com.tta.boxchange.entities.AverageVenteDevise;
import com.tta.boxchange.entities.AvgAchat;
import com.tta.boxchange.mappers.AVGVENTERowMapper;
import com.tta.boxchange.mappers.AvgAchatRowMapper;
import com.tta.boxchange.mappers.AvgVenteDeviseRowMapper;
import com.tta.boxchange.response.BasicResponse;

@Repository
public class AvgAchatRepository implements AvgAchatInterface {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public BasicResponse save(AvgAchat avgAchat) {
		try {
			avgAchat.setDatedevise(new Date());
			avgAchat.setDeviseaed(getMoyenneAchat("deviseaed"));
			avgAchat.setDevisebhd(getMoyenneAchat("devisebhd"));
			avgAchat.setDevisecad(getMoyenneAchat("devisecad"));
			avgAchat.setDevisechf(getMoyenneAchat("devisechf"));
			avgAchat.setDevisecny(getMoyenneAchat("devisecny"));
			avgAchat.setDevisedkk(getMoyenneAchat("devisedkk"));
			avgAchat.setDeviseeur(getMoyenneAchat("deviseeur"));
			avgAchat.setDevisegbp(getMoyenneAchat("devisegbp"));
			avgAchat.setDevisejpy(getMoyenneAchat("devisejpy"));
			avgAchat.setDevisekwd(getMoyenneAchat("devisekwd"));
			avgAchat.setDeviselyd(getMoyenneAchat("deviselyd"));
			avgAchat.setDevisenok(getMoyenneAchat("devisenok"));
			avgAchat.setDeviseqar(getMoyenneAchat("deviseqar"));
			avgAchat.setDevisesar(getMoyenneAchat("devisesar"));
			avgAchat.setDevisesek(getMoyenneAchat("devisesek"));
			avgAchat.setDeviseusd(getMoyenneAchat("deviseusd"));
			System.out.println(avgAchat.toString());
			jdbcTemplate.update(
					"INSERT INTO public.avg_achat(\r\n"
					+ "datedevise, deviseaed, devisebhd, devisecad, devisechf, devisecny,"
					+ " devisedkk, deviseeur, devisegbp, devisejpy, devisekwd, deviselyd, devisenok, deviseqar, devisesar, devisesek, deviseusd)\r\n"
					+ "	VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
					avgAchat.getDatedevise(),avgAchat.getDeviseaed(),avgAchat.getDevisebhd(),avgAchat.getDevisecad(),avgAchat.getDevisechf(),avgAchat.getDevisecny(),
					avgAchat.getDevisedkk(),avgAchat.getDeviseeur(),avgAchat.getDevisegbp(),avgAchat.getDevisejpy(),avgAchat.getDevisekwd(),avgAchat.getDeviselyd(),
					avgAchat.getDevisenok(),avgAchat.getDeviseqar(),avgAchat.getDevisesar(),avgAchat.getDevisesek(),avgAchat.getDeviseusd()
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
	public BasicResponse update(AvgAchat ancienAvgAchat) {
		try {
			ancienAvgAchat.setDeviseaed(getMoyenneAchat("deviseaed"));
			ancienAvgAchat.setDevisebhd(getMoyenneAchat("devisebhd"));
			ancienAvgAchat.setDevisecad(getMoyenneAchat("devisecad"));
			ancienAvgAchat.setDevisechf(getMoyenneAchat("devisechf"));
			ancienAvgAchat.setDevisecny(getMoyenneAchat("devisecny"));
			ancienAvgAchat.setDevisedkk(getMoyenneAchat("devisedkk"));
			ancienAvgAchat.setDeviseeur(getMoyenneAchat("deviseeur"));
			ancienAvgAchat.setDevisegbp(getMoyenneAchat("devisegbp"));
			ancienAvgAchat.setDevisejpy(getMoyenneAchat("devisejpy"));
			ancienAvgAchat.setDevisekwd(getMoyenneAchat("devisekwd"));
			ancienAvgAchat.setDeviselyd(getMoyenneAchat("deviselyd"));
			ancienAvgAchat.setDevisenok(getMoyenneAchat("devisenok"));
			ancienAvgAchat.setDeviseqar(getMoyenneAchat("deviseqar"));
			ancienAvgAchat.setDevisesar(getMoyenneAchat("devisesar"));
			ancienAvgAchat.setDevisesek(getMoyenneAchat("devisesek"));
			ancienAvgAchat.setDeviseusd(getMoyenneAchat("deviseusd"));
			String req = "UPDATE public.avg_achat\r\n"
					+ "	SET deviseaed=?, devisebhd=?, devisecad=?, devisechf=?, devisecny=?,"
					+ " devisedkk=?, deviseeur=?, devisegbp=?, devisejpy=?, devisekwd=?, deviselyd=?,"
					+ " devisenok=?, deviseqar=?, devisesar=?, devisesek=?, deviseusd=?\r\n"
					+ "	WHERE id=?;";
			jdbcTemplate.update(req,ancienAvgAchat.getDeviseaed(),ancienAvgAchat.getDevisebhd(),ancienAvgAchat.getDevisecad(),ancienAvgAchat.getDevisechf(),ancienAvgAchat.getDevisecny(),
					ancienAvgAchat.getDevisedkk(),ancienAvgAchat.getDeviseeur(),ancienAvgAchat.getDevisegbp(),ancienAvgAchat.getDevisejpy(),ancienAvgAchat.getDevisekwd(),ancienAvgAchat.getDeviselyd(),
					ancienAvgAchat.getDevisenok(),ancienAvgAchat.getDeviseqar(),ancienAvgAchat.getDevisesar(),ancienAvgAchat.getDevisesek(),ancienAvgAchat.getDeviseusd(),
					ancienAvgAchat.getIdAvgAchat());
			System.out.println("up ok");
			
			return new BasicResponse("La modification effectuée avec succes", HttpStatus.OK);
		}catch (Exception e) {
			return new BasicResponse("Erreur", HttpStatus.OK);
		}
	}


	@Override
	public List<AvgAchat> verification() {
		String req="select * from avg_achat where datedevise::Date = NOW()::Date;";
		return jdbcTemplate.query(req,new AvgAchatRowMapper() );
	}
	
	public float getMoyenneAchat(String devise) {
		String req="SELECT ROUND(avg("+devise+"::numeric), 3)\r\n"
				+ "	FROM (select "+ devise+" from achat where deviseqar <> '0')as avg;";
		return jdbcTemplate.queryForObject(req,float.class);
	}

	@Override
	public List<AverageVenteDevise> averageBydevise(String devise) {
		devise="devise"+devise;
		String req ="SELECT datedevise, "+devise +" AS devise FROM public.avg_achat;";
		System.out.println(jdbcTemplate.query(req,new AvgVenteDeviseRowMapper() ));
		return jdbcTemplate.query(req,new AvgVenteDeviseRowMapper() );
	}

}
