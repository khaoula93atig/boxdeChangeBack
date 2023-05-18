package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.EnchereInterface;
import com.tta.boxchange.entities.Enchere;
import com.tta.boxchange.mappers.EnchereRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EnchereRepository implements EnchereInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Enchere> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from  enchere;", new EnchereRowMapper());

	}
	public List<Enchere> findAllNull() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT *FROM public.enchere where taux_soumission is null;", new EnchereRowMapper());

	}
	public List<Enchere> findAllNotNull() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT *FROM public.enchere where taux_soumission is not null;", new EnchereRowMapper());

	}
	

	@Override
	public BasicResponse save(Enchere enchere) {
		try {

			System.out.println("enchere " + enchere.toString());
			enchere.setDate(new Date());
			enchere.setIdEnchere(UUID.randomUUID().toString().replace("-", ""));
			jdbcTemplate.update(
					"INSERT INTO enchere(id_enchere, reference_enchere, sens_enchere, montant_enchere, devise, date, date_debut, date_fin, description,taux_soumission) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
					enchere.getIdEnchere(),enchere.getReferenceEnchere(),enchere.getSensEnchere(),enchere.getMontantEnchere(),enchere.getDevise(),enchere.getDate(),enchere.getDateDebut(),enchere.getHeureFin(),enchere.getDescription(),enchere.getTauxSoumission()
					);

			return new BasicResponse("Une Enchere a été envoyée", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(Enchere Enchere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicResponse delete(Enchere Enchere) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Long countEnchere(Long userId) {
		return jdbcTemplate.queryForObject("SELECT count(*)\r\n"
				+ "	FROM public.enchere\r\n"
				+ "	where id_user=?;",new Object[] {userId},Long.class);
	}

	

}