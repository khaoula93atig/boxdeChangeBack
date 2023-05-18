package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.BIATInterface;
import com.tta.boxchange.entities.BIAT;

//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.BIATRowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BIATRepository implements BIATInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BIAT> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT \"idBIAT\", \"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise\r\n"
				+ "	FROM public.\"BIAT\";", new BIATRowMapper());

	}

	

	@Override
	public BasicResponse save(BIAT biat) {
		try {

		//	System.out.println("stb " + stb.toString());
			biat.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO public.\"BIAT\"(\r\n"
					+ "	\"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?)",
					biat.getCodeDevise(),biat.getUniteDevise(),biat.getAchatdevise(),biat.getVentedevise(),biat.getDatedevise()
					);

			return new BasicResponse("Un ajout dans biat a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(BIAT biat) {
		System.out.println(biat);
		try {
			List<BIAT> toUpdate = this.getbyId(biat.getIdBIAT());
			System.out.println(toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("BIAT  update " + biat.toString());
				// rendezVous.setCreationDate(new Date());
				// rendezVous.setIdRdv(UUID.randomUUID().toString().replace("-", ""));
				jdbcTemplate.update("UPDATE public.\"BIAT\"\r\n"
						+ "	SET \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"idBIAT\"=?;", biat.getCodeDevise(),biat.getUniteDevise(),biat.getAchatdevise(),biat.getVentedevise(),biat.getDatedevise(),biat.getIdBIAT());
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
	public List<BIAT> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BIAT\"\r\n"
				+ "	where \"idBIAT\"=?;", new Object[] { id },
				new BIATRowMapper());
	}

	@Override
	public List<BIAT> modification(String codeDevise) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BIAT\"\r\n"
				+ "	where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { codeDevise },
				new BIATRowMapper());
	}
	






	
	

}
