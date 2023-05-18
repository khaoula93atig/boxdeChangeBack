package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.BNAInterface;
import com.tta.boxchange.entities.BIAT;
import com.tta.boxchange.entities.BNA;
import com.tta.boxchange.mappers.BIATRowMapper;
//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.BNARowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BNARepository implements BNAInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BNA> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT \"idBNA\", \"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise\r\n"
				+ "	FROM public.\"BNA\";", new BNARowMapper());

	}

	

	@Override
	public BasicResponse save(BNA bna) {
		try {

		//	System.out.println("stb " + stb.toString());
			bna.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO public.\"BNA\"(\r\n"
					+ "\"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?);",
					bna.getCodeDevise(),bna.getUniteDevise(),bna.getAchatdevise(),bna.getVentedevise(),bna.getDatedevise()
					);

			return new BasicResponse("Un ajout dans bna a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(BNA bna) {
		System.out.println(bna);
		try {
			List<BNA> toUpdate = this.getbyId(bna.getIdBNA());
			System.out.println(toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("BNA  update " + bna.toString());
				// rendezVous.setCreationDate(new Date());
				// rendezVous.setIdRdv(UUID.randomUUID().toString().replace("-", ""));
				jdbcTemplate.update("UPDATE public.\"BNA\"\r\n"
						+ "	SET \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"idBNA\"=?;", bna.getCodeDevise(),bna.getUniteDevise(),bna.getAchatdevise(),bna.getVentedevise(),bna.getDatedevise(),bna.getIdBNA());
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
	public List<BNA> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BNA\"\r\n"
				+ "	where \"idBNA\"=?;", new Object[] { id },
				new BNARowMapper());
	}

	@Override
	public List<BNA> modification(String codeDevise) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BNA\"\r\n"
				+ "	where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { codeDevise },
				new BNARowMapper());
	}
	




	
	

}
