package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.AVGVENTEInterface;
import com.tta.boxchange.entities.AVGVENTE;

//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.AVGVENTERowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AVGVENTERepository implements AVGVENTEInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<AVGVENTE> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT id, nombanque, devisesar, devisecad, devisedkk, deviseusd, devisegbp, devisejpy, devisenok, devisesek, devisechf, devisekwd, deviseaed, deviseeur, deviselyd, devisebhd, deviseqar, devisecny, datedevise\r\n"
				+ "	FROM public.averagefiras;", new AVGVENTERowMapper());

	}

	

	@Override
	public BasicResponse save(AVGVENTE avgvente) {
		try {

		//	System.out.println("stb " + stb.toString());
			avgvente.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO averagefiras (deviseSAR, deviseCAD, deviseDKK, deviseUSD, deviseGBP, deviseJPY, deviseNOK, deviseSEK, deviseCHF, deviseKWD, deviseAED, deviseEUR, deviseLYD, deviseBHD, deviseQAR, deviseCNY)\r\n"
					+ "SELECT  AVG(\"deviseSAR\"::numeric), AVG(\"deviseCAD\"::numeric), AVG(\"deviseDKK\"::numeric), AVG(\"deviseUSD\"::numeric), AVG(\"deviseGBP\"::numeric), AVG(\"deviseJPY\"::numeric), AVG(\"deviseNOK\"::numeric), AVG(\"deviseSEK\"::numeric), AVG(\"deviseCHF\"::numeric), AVG(\"deviseKWD\"::numeric), AVG(\"deviseAED\"::numeric), AVG(\"deviseEUR\"::numeric), AVG(\"deviseLYD\"::numeric), AVG(\"deviseBHD\"::numeric), AVG(\"deviseQAR\"::numeric), AVG(\"deviseCNY\"::numeric)\r\n"
					+ "FROM public.\"VENTE\"",
					avgvente.getDevisesar(),avgvente.getDevisecad(),avgvente.getDevisedkk(),avgvente.getDeviseusd(),avgvente.getDevisegbp(),avgvente.getDevisejpy(),avgvente.getDevisenok(),avgvente.getDevisesek(),
					avgvente.getDevisechf(),avgvente.getDevisekwd(),avgvente.getDeviseaed(),avgvente.getDeviseeur(),avgvente.getDeviselyd(),
					avgvente.getDevisebhd(),avgvente.getDeviseqar(),avgvente.getDevisecny(),avgvente.getDatedevise()
					);

			return new BasicResponse("Un ajout dans moyenne a été effectué", HttpStatus.OK);
			
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
	public BasicResponse update(AVGVENTE avgvente) {
		System.out.println(avgvente);
		try {
			List<AVGVENTE> toUpdate = this.getbyId(avgvente.getId());
			System.out.println(toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("BIAT  update " + avgvente.toString());
				// rendezVous.setCreationDate(new Date());
				// rendezVous.setIdRdv(UUID.randomUUID().toString().replace("-", ""));
				jdbcTemplate.update("UPDATE public.\"BIAT\"\r\n"
						+ "	SET \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"idBIAT\"=?;", avgvente.getCodeDevise(),avgvente.getUniteDevise(),biat.getAchatdevise(),biat.getVentedevise(),biat.getDatedevise(),biat.getIdBIAT());
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

*/

	@Override
	public List<AVGVENTE> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BIAT\"\r\n"
				+ "	where \"idBIAT\"=?;", new Object[] { id },
				new AVGVENTERowMapper());
	}

	@Override
	public List<AVGVENTE> modification(String codeDevise) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"BIAT\"\r\n"
				+ "	where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { codeDevise },
				new AVGVENTERowMapper());
	}
	






	
	

}
