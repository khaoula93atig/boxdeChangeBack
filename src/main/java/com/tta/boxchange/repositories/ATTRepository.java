package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.ATTInterface;
import com.tta.boxchange.entities.ATT;

//import com.tta.boxchange.entities.Notifications;
//import com.tta.boxchange.entities.RendezVous;
import com.tta.boxchange.mappers.ATTRowMapper;
//import com.tta.boxchange.mappers.RendezVousRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ATTRepository implements ATTInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ATT> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from  ATT;", new ATTRowMapper());

	}

	

	@Override
	public BasicResponse save(ATT att) {
		try {

		//	System.out.println("stb " + stb.toString());
			att.setDatedevise(new Date());
			//stb.setIdSTB(UUID.randomUUID().toString().replace("-", ""));
		
			jdbcTemplate.update(
					"INSERT INTO public.\"ATT\"(\r\n"
					+ "\"codeDevise\", \"uniteDevise\", achatdevise, ventedevise, datedevise)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?);",
					att.getCodeDevise(),att.getUniteDevise(),att.getAchatdevise(),att.getVentedevise(),att.getDatedevise()
					);

			return new BasicResponse("Un ajout dans ATT a été effectué", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(ATT att) {
		// TODO Auto-generated method stub
		return null;
	}







	@Override
	public List<ATT> getbyId(String id) {
		return jdbcTemplate.query("SELECT * FROM public.ATT\r\n"
				+ "	Where idATT=?; ", new Object[] { id },
				new ATTRowMapper());
	}



	
	

}
