package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.UIBInterface;
import com.tta.boxchange.entities.BIAT;
import com.tta.boxchange.entities.BNA;
import com.tta.boxchange.entities.UIB;
import com.tta.boxchange.mappers.BIATRowMapper;
import com.tta.boxchange.mappers.BNARowMapper;
//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.UIBRowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UIBRepository implements UIBInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UIB> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT \"idUIB\", \"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise\r\n"
				+ "	FROM public.\"UIB\";", new UIBRowMapper());

	}

	

	@Override
	public BasicResponse save(UIB uib) {
		try {

		//	System.out.println("stb " + stb.toString());
			uib.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO public.\"UIB\"(\r\n"
					+ "\"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?);",
					uib.getCodeDevise(),uib.getUniteDevise(),uib.getAchatdevise(),uib.getVentedevise(),uib.getDatedevise()
					);

			return new BasicResponse("Un ajout dans uib a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(UIB uib) {
		System.out.println(uib);
		try {
			List<UIB> toUpdate = this.getbyId(uib.getIdUIB());
			System.out.println("firaaaas"+toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("uib  update " + uib.toString());
				// rendezVous.setCreationDate(new Date());
				// rendezVous.setIdRdv(UUID.randomUUID().toString().replace("-", ""));
				jdbcTemplate.update("UPDATE public.\"UIB\"\r\n"
						+ "	SET \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"idUIB\"=?;", uib.getCodeDevise(),uib.getUniteDevise(),uib.getAchatdevise(),uib.getVentedevise(),uib.getDatedevise(),uib.getIdUIB());
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

/*
	@Override
	public List<UIB> getbyId(String id) {
		return jdbcTemplate.query("SELECT * FROM public.BNA\r\n"
				+ "	Where idBNA=?; ", new Object[] { id },
				new UIBRowMapper());
	}
*/
	@Override
	public List<UIB> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"UIB\"\r\n"
				+ "	where \"idUIB\"=?;", new Object[] { id },
				new UIBRowMapper());
	}

	@Override
	public List<UIB> modification(String codeDevise) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"UIB\" where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { codeDevise },
				new UIBRowMapper());
	}
	




	
	

}
