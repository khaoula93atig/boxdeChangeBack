package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.VENTEInterface;
import com.tta.boxchange.entities.VENTE;

//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.VENTERowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VENTERepository implements VENTEInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<VENTE> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT v1.*\r\n"
				+ "FROM public.\"VENTE\" v1\r\n"
				+ "INNER JOIN (\r\n"
				+ "    SELECT \"nomBanque\", MAX(datedevise) AS max_datedevise\r\n"
				+ "    FROM public.\"VENTE\"\r\n"
				+ "    GROUP BY \"nomBanque\"\r\n"
				+ ") v2\r\n"
				+ "ON v1.\"nomBanque\" = v2.\"nomBanque\" AND v1.datedevise = v2.max_datedevise", new VENTERowMapper());

	}


	@Override
	public VENTE findMAX(String currency) {
		
		String columntochange = "devise" + currency;
		return jdbcTemplate.query("SELECT * FROM public.\"VENTE\" WHERE CAST(\"" + columntochange + "\" AS float) = " +
	               "(SELECT MAX(CAST(\"" + columntochange + "\" AS float)) FROM public.\"VENTE\") " +
	               "ORDER BY datedevise DESC LIMIT 1;", new VENTERowMapper()).get(0);
	}
	
	@Override
	public VENTE findMIN(String currency) {
		
		String columntochange = "devise" + currency;
		return jdbcTemplate.query("SELECT * FROM public.\"VENTE\" WHERE CAST(\"" + columntochange + "\" AS float) = " +
	               "(SELECT MIN(CAST(\"" + columntochange + "\" AS float)) FROM public.\"VENTE\") " +
	               "ORDER BY datedevise DESC LIMIT 1;", new VENTERowMapper()).get(0);
	}
	

	@Override
	public VENTE findMAX(String currency, String date) {
		
		String columntochange = "devise" + currency;
		return jdbcTemplate.query("SELECT *\n" +
	               "FROM public.\"VENTE\"\n" +
	               "WHERE CAST(\"" + columntochange + "\" AS float) = (\n" +
	               "  SELECT MAX(CAST(\"" + columntochange + "\" AS float))\n" +
	               "  FROM public.\"VENTE\"\n" +
	               "  WHERE DATE_TRUNC('" + date + "', datedevise) = DATE_TRUNC('" + date + "', CURRENT_DATE)\n" +
	               ")\n" +
	               "ORDER BY datedevise DESC\n" +
	               "LIMIT 1;", new VENTERowMapper()).get(0);
	}
	
	@Override
	public VENTE findMIN(String currency, String date) {
		
		String columntochange = "devise" + currency;
		return jdbcTemplate.query("SELECT *\n" +
	               "FROM public.\"VENTE\"\n" +
	               "WHERE CAST(\"" + columntochange + "\" AS float) = (\n" +
	               "  SELECT MIN(CAST(\"" + columntochange + "\" AS float))\n" +
	               "  FROM public.\"VENTE\"\n" +
	               "  WHERE DATE_TRUNC('" + date + "', datedevise) = DATE_TRUNC('" + date + "', CURRENT_DATE)\n" +
	               ")\n" +
	               "ORDER BY datedevise DESC\n" +
	               "LIMIT 1;", new VENTERowMapper()).get(0);
	}
	@Override
	public BasicResponse save(VENTE vente) {
		try {

		//	System.out.println("stb " + stb.toString());
			vente.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO public.\"VENTE\"(\r\n"
					+ "	\"deviseCAD\", \"deviseDKK\", \"deviseUSD\", \"deviseGBP\", \"deviseJPY\", \"deviseNOK\", \"deviseSEK\", \"deviseCHF\", \"deviseKWD\", \"deviseAED\", \"deviseEUR\", \"deviseLYD\", \"deviseBHD\", datedevise, \"nomBanque\", \"deviseQAR\", \"deviseCNY\", \"deviseSAR\")\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
					vente.getDeviseCAD(),vente.getDeviseDKK(),vente.getDeviseUSD(),vente.getDeviseGBP(),
					vente.getDeviseJPY(),vente.getDeviseNOK(),vente.getDeviseSEK(),vente.getDeviseCHF(),vente.getDeviseKWD(),
					vente.getDeviseAED(),vente.getDeviseEUR(),vente.getDeviseLYD(),vente.getDeviseBHD(),
					vente.getDatedevise(),vente.getNomBanque(),
					vente.getDeviseQAR(),vente.getDeviseCNY(),vente.getDeviseSAR()
					);

			return new BasicResponse("Un ajout dans vente a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(VENTE vente) {
		System.out.println(vente);
		try {
			List<VENTE> toUpdate = this.getbyId(vente.getIdVENTE());
			System.out.println(toUpdate);
			if (!toUpdate.isEmpty()) {
				System.out.println("VENTE  update " + vente.toString());
				// rendezVous.setCreationDate(new Date());
				// rendezVous.setIdRdv(UUID.randomUUID().toString().replace("-", ""));
				jdbcTemplate.update("UPDATE public.\"VENTE\"\r\n"
						+ "	SET \"codeDevise\"=?, \"uniteDevise\"=?, achatdevise=?, ventedevise=?, datedevise=?\r\n"
						+ "	WHERE \"VENTE\"=?;", vente.getDeviseSAR(),vente.getDeviseCAD(),vente.getDeviseDKK(),vente.getDeviseUSD(),vente.getDeviseGBP(),
						vente.getDeviseJPY(),vente.getDeviseNOK(),vente.getDeviseSEK(),vente.getDeviseCHF(),vente.getDeviseKWD(),
						vente.getDeviseAED(),vente.getDeviseEUR(),vente.getDeviseLYD(),vente.getDeviseBHD(),vente.getDeviseQAR(),
						vente.getDeviseCNY(),vente.getDatedevise(),vente.getNomBanque());
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
	public List<VENTE> getbyId(int id) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"VENTE\"\r\n"
				+ "	where \"idVENTE\"=?;", new Object[] { id },
				new VENTERowMapper());
	}

	@Override
	public List<VENTE> modification(String nomBanque) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.\"VENTE\"\r\n"
				+ "	where \"codeDevise\" =? and datedevise=CURRENT_DATE;", new Object[] { nomBanque },
				new VENTERowMapper());
	}









	
	

}
