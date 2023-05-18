package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.AMENInterface;
import com.tta.boxchange.entities.AMEN;
import com.tta.boxchange.entities.BIAT;
//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.AMENRowMapper;
import com.tta.boxchange.mappers.BIATRowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AMENRepository implements AMENInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<AMEN> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT \"idAMEN\", \"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise\r\n"
				+ "	FROM public.\"AMEN\";", new AMENRowMapper());

	}

	

	@Override
	public BasicResponse save(AMEN amen) {
		try {

		//	System.out.println("stb " + stb.toString());
			amen.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO public.\"AMEN\"(\r\n"
					+ "\"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?);",
					amen.getCodeDevise(),amen.getUniteDevise(),amen.getAchatdevise(),amen.getVentedevise(),amen.getDatedevise()
					);

			return new BasicResponse("Un ajout dans amen a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(AMEN amen) {
		System.out.println(amen);
		try {
			List<AMEN> toUpdate = this.getbyId(amen.getIdAMEN());
			System.out.println(toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("AMEN  update " + amen.toString());
				// rendezVous.setCreationDate(new Date());
				// rendezVous.setIdRdv(UUID.randomUUID().toString().replace("-", ""));
				jdbcTemplate.update("UPDATE public.\"AMEN\"\r\n"
						+ "	SET \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"idAMEN\"=?;", amen.getCodeDevise(),amen.getUniteDevise(),amen.getAchatdevise(),amen.getVentedevise(),amen.getDatedevise(),amen.getIdAMEN());
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
	public List<AMEN> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"AMEN\"\r\n"
				+ "	where \"idAMEN\"=?;", new Object[] { id },
				new AMENRowMapper());
	}

	@Override
	public List<AMEN> modification(String codeDevise) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"AMEN\" where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { codeDevise },
				new AMENRowMapper());
	}
	





	
	

}
