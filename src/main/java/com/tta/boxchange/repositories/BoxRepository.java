package com.tta.boxchange.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.tta.boxchange.dao.BoxInterface;
import com.tta.boxchange.dao.BoxInterface;
import com.tta.boxchange.entities.Box;
import com.tta.boxchange.mappers.BoxRowMapper;
import com.tta.boxchange.response.BasicResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoxRepository implements BoxInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Box> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from  box;", new BoxRowMapper());

	}

	

	@Override
	public BasicResponse save(Box box) {
		try {

			System.out.println("box " + box.toString());
			//box.setDate(new Date());
			box.setIdbox(UUID.randomUUID().toString().replace("-", ""));
			jdbcTemplate.update(
					"INSERT INTO box(id_box, libelle, adresse, username, emaiil, telephone, passsword) VALUES (?, ?, ?, ?, ?, ?, ?);",
					box.getIdbox(),box.getLibelle(),box.getAdresse(),box.getUsername(),box.getEmaiil(),box.getTelephone(),box.getPasssword()
					);

			return new BasicResponse("Une box a été envoyée", HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(Box Box) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicResponse delete(Box Box) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
