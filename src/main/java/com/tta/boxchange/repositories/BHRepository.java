package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.BHInterface;
import com.tta.boxchange.entities.BH;
import com.tta.boxchange.entities.BIAT;
//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.BHRowMapper;
import com.tta.boxchange.mappers.BIATRowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BHRepository implements BHInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BH> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT \"idBH\", \"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise\r\n"
				+ "	FROM public.\"BH\";", new BHRowMapper());

	}

	

	@Override
	public BasicResponse save(BH bh) {
		try {

		//	System.out.println("stb " + stb.toString());
			bh.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO public.\"BH\"(\r\n"
					+ "\"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?);",
					bh.getCodeDevise(),bh.getUniteDevise(),bh.getAchatdevise(),bh.getVentedevise(),bh.getDatedevise()
					);

			return new BasicResponse("Un ajout dans bh a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}


	@Override
	public BasicResponse update(BH bh) {
		System.out.println(bh);
		try {
			List<BH> toUpdate = this.getbyId(bh.getIdBH());
			System.out.println(toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("BH  update " + bh.toString());
				// rendezVous.setCreationDate(new Date());
				// rendezVous.setIdRdv(UUID.randomUUID().toString().replace("-", ""));
				jdbcTemplate.update("UPDATE public.\"BH\"\r\n"
						+ "	SET \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"idBH\"=?;", bh.getCodeDevise(),bh.getUniteDevise(),bh.getAchatdevise(),bh.getVentedevise(),bh.getDatedevise(),bh.getIdBH());
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
	public List<BH> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BH\"\r\n"
				+ "	where \"idBH\"=?;", new Object[] { id },
				new BHRowMapper());
	}

	@Override
	public List<BH> modification(String codeDevise) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BH\"\r\n"
				+ "	where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { codeDevise },
				new BHRowMapper());
	}
	

	

}
