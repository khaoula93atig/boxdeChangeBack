package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.STBInterface;
import com.tta.boxchange.entities.BIAT;
import com.tta.boxchange.entities.STB;
import com.tta.boxchange.entities.UIB;
import com.tta.boxchange.mappers.BIATRowMapper;
//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.STBRowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class STBRepository implements STBInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<STB> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from  STB;", new STBRowMapper());

	}

	

	@Override
	public BasicResponse save(STB stb) {
		try {

		//	System.out.println("stb " + stb.toString());
			stb.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO public.\"STB\"(\r\n"
					+ "\"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?);",
					stb.getCodeDevise(),stb.getUniteDevise(),stb.getAchatdevise(),stb.getVentedevise(),stb.getDatedevise()
					);

			return new BasicResponse("Un ajout dans stb a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(STB stb) {
		System.out.println(stb);
		try {
			List<STB> toUpdate = this.getbyId(stb.getIdSTB());
			System.out.println(toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("STB  update " + stb.toString());
				// rendezVous.setCreationDate(new Date());
				// rendezVous.setIdRdv(UUID.randomUUID().toString().replace("-", ""));
				jdbcTemplate.update("UPDATE public.\"STB\"\r\n"
						+ "	SET \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"idSTB\"=?;", stb.getCodeDevise(),stb.getUniteDevise(),stb.getAchatdevise(),stb.getVentedevise(),stb.getDatedevise(),stb.getIdSTB());
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
	public List<STB> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"STB\"\r\n"
				+ "	where \"idSTB\"=?;", new Object[] { id },
				new STBRowMapper());
	}

	@Override
	public List<STB> modification(String codeDevise) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"STB\"\r\n"
				+ "	where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { codeDevise },
				new STBRowMapper());
	}
	



	

}
