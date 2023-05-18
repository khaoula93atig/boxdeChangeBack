package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.BTKInterface;
import com.tta.boxchange.entities.BIAT;
import com.tta.boxchange.entities.BTK;
import com.tta.boxchange.mappers.BIATRowMapper;
//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.BTKRowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BTKRepository implements BTKInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BTK> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from  BTK;", new BTKRowMapper());

	}

	

	@Override
	public BasicResponse save(BTK btk) {
		try {

		//	System.out.println("stb " + stb.toString());
			btk.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO public.\"BTK\"(\r\n"
					+ "\"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?);",
					btk.getCodeDevise(),btk.getUniteDevise(),btk.getAchatdevise(),btk.getVentedevise(),btk.getDatedevise()
					);

			return new BasicResponse("Un ajout dans btk a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(BTK btk) {
		System.out.println(btk);
		try {
			List<BTK> toUpdate = this.getbyId(btk.getIdBTK());
			System.out.println(toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("BTK  update " + btk.toString());
				// rendezVous.setCreationDate(new Date());
				// rendezVous.setIdRdv(UUID.randomUUID().toString().replace("-", ""));
				jdbcTemplate.update("UPDATE public.\"BTK\"\r\n"
						+ "	SET \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"idBTK\"=?;", btk.getCodeDevise(),btk.getUniteDevise(),btk.getAchatdevise(),btk.getVentedevise(),btk.getDatedevise(),btk.getIdBTK());
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
	public List<BTK> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BTK\"\r\n"
				+ "	where \"idBTK\"=?;", new Object[] { id },
				new BTKRowMapper());
	}

	@Override
	public List<BTK> modification(String codeDevise) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BTK\"\r\n"
				+ "	where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { codeDevise },
				new BTKRowMapper());
	}
	



	
	

}
