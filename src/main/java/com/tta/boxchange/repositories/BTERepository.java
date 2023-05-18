package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.BTEInterface;
import com.tta.boxchange.entities.BIAT;
import com.tta.boxchange.entities.BTE;
import com.tta.boxchange.mappers.BIATRowMapper;
//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.BTERowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BTERepository implements BTEInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BTE> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from  BTE;", new BTERowMapper());

	}

	

	@Override
	public BasicResponse save(BTE bte) {
		try {

		//	System.out.println("stb " + stb.toString());
			bte.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO public.\"BTE\"(\r\n"
					+ "\"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?);",
					bte.getCodeDevise(),bte.getUniteDevise(),bte.getAchatdevise(),bte.getVentedevise(),bte.getDatedevise()
					);

			return new BasicResponse("Un ajout dans bte a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}


	@Override
	public BasicResponse update(BTE bte) {
		System.out.println(bte);
		try {
			List<BTE> toUpdate = this.getbyId(bte.getIdBTE());
			System.out.println(toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("BTE  update " + bte.toString());
				// rendezVous.setCreationDate(new Date());
				// rendezVous.setIdRdv(UUID.randomUUID().toString().replace("-", ""));
				jdbcTemplate.update("UPDATE public.\"BTE\"\r\n"
						+ "	SET \"idBTE\"=?, \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"BTE\"=?;", bte.getCodeDevise(),bte.getUniteDevise(),bte.getAchatdevise(),bte.getVentedevise(),bte.getDatedevise(),bte.getIdBTE());
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
	public List<BTE> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BTE\"\r\n"
				+ "	where \"idBTE\"=?;", new Object[] { id },
				new BTERowMapper());
	}

	@Override
	public List<BTE> modification(String codeDevise) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BTE\"\r\n"
				+ "	where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { codeDevise },
				new BTERowMapper());
	}
	

	
	

}
