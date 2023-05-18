package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.BTLInterface;
import com.tta.boxchange.entities.BIAT;
import com.tta.boxchange.entities.BTL;
import com.tta.boxchange.mappers.BIATRowMapper;
//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.BTLRowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BTLRepository implements BTLInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BTL> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from  BTL;", new BTLRowMapper());

	}

	

	@Override
	public BasicResponse save(BTL btl) {
		try {

		//	System.out.println("stb " + stb.toString());
			btl.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO public.\"BTL\"(\r\n"
					+ "\"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?);",
					btl.getCodeDevise(),btl.getUniteDevise(),btl.getAchatdevise(),btl.getVentedevise(),btl.getDatedevise()
					);

			return new BasicResponse("Un ajout dans BTL a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(BTL btl) {
		System.out.println(btl);
		try {
			List<BTL> toUpdate = this.getbyId(btl.getIdBTL());
			System.out.println(toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("BTL  update " + btl.toString());
				// rendezVous.setCreationDate(new Date());
				// rendezVous.setIdRdv(UUID.randomUUID().toString().replace("-", ""));
				jdbcTemplate.update("UPDATE public.\"BTL\"\r\n"
						+ "	SET \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"idBTL\"=?;", btl.getCodeDevise(),btl.getUniteDevise(),btl.getAchatdevise(),btl.getVentedevise(),btl.getDatedevise(),btl.getIdBTL());
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
	public List<BTL> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BTL\"\r\n"
				+ "	where \"idBTL\"=?;", new Object[] { id },
				new BTLRowMapper());
	}

	@Override
	public List<BTL> modification(String codeDevise) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BTL\"\r\n"
				+ "	where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { codeDevise },
				new BTLRowMapper());
	}
	



	
	

}
