package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.BTInterface;
import com.tta.boxchange.entities.BIAT;
import com.tta.boxchange.entities.BT;
import com.tta.boxchange.mappers.BIATRowMapper;
//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.BTRowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BTRepository implements BTInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BT> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT \"idBT\", \"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise\r\n"
				+ "	FROM public.\"BT\";", new BTRowMapper());

	}

	

	@Override
	public BasicResponse save(BT bt) {
		try {

		//	System.out.println("stb " + stb.toString());
			bt.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO public.\"BT\"(\r\n"
					+ "\"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?);",
					bt.getCodeDevise(),bt.getUniteDevise(),bt.getAchatdevise(),bt.getVentedevise(),bt.getDatedevise()
					);

			return new BasicResponse("Un ajout dans BT a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}


	@Override
	public BasicResponse update(BT bt) {
		System.out.println(bt);
		try {
			List<BT> toUpdate = this.getbyId(bt.getIdBT());
			System.out.println(toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("BT  update " + bt.toString());
				// rendezVous.setCreationDate(new Date());
				// rendezVous.setIdRdv(UUID.randomUUID().toString().replace("-", ""));
				jdbcTemplate.update("UPDATE public.\"BT\"\r\n"
						+ "	SET \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"idBT\"=?;", bt.getCodeDevise(),bt.getUniteDevise(),bt.getAchatdevise(),bt.getVentedevise(),bt.getDatedevise(),bt.getIdBT());
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
	public List<BT> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BT\"\r\n"
				+ "	where \"idBT\"=?;", new Object[] { id },
				new BTRowMapper());
	}

	@Override
	public List<BT> modification(String codeDevise) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BT\"\r\n"
				+ "	where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { codeDevise },
				new BTRowMapper());
	}
	


	
	

}
