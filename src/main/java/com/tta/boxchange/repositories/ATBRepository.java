package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.ATBInterface;
import com.tta.boxchange.entities.ATB;
import com.tta.boxchange.entities.BIAT;
//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.ATBRowMapper;
import com.tta.boxchange.mappers.BIATRowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ATBRepository implements ATBInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ATB> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT \"idATB\", \"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise\r\n"
				+ "	FROM public.\"ATB\";", new ATBRowMapper());

	}

	

	@Override
	public BasicResponse save(ATB atb) {
		try {

		//	System.out.println("stb " + stb.toString());
			atb.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO public.\"ATB\"(\r\n"
					+ "\"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?);",
					atb.getCodeDevise(),atb.getUniteDevise(),atb.getAchatdevise(),atb.getVentedevise(),atb.getDatedevise()
					);

			return new BasicResponse("Un ajout dans atb a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(ATB atb) {
		System.out.println(atb);
		try {
			List<ATB> toUpdate = this.getbyId(atb.getIdATB());
			System.out.println(toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("ATB  update " + atb.toString());
				// rendezVous.setCreationDate(new Date());
				// rendezVous.setIdRdv(UUID.randomUUID().toString().replace("-", ""));
				jdbcTemplate.update("UPDATE public.\"ATB\"\r\n"
						+ "	SET \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"idATB\"=?;", atb.getCodeDevise(),atb.getUniteDevise(),atb.getAchatdevise(),atb.getVentedevise(),atb.getDatedevise(),atb.getIdATB());
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
	public List<ATB> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"ATB\"\r\n"
				+ "	where \"idATB\"=?;", new Object[] { id },
				new ATBRowMapper());
	}

	@Override
	public List<ATB> modification(String codeDevise) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"ATB\"\r\n"
				+ "	where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { codeDevise },
				new ATBRowMapper());
	}
	






	
	
	
	

}
