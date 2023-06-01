package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.AVGVENTE;
import com.tta.boxchange.entities.AVGVENTE;


public class AVGVENTERowMapper implements RowMapper<AVGVENTE> {

	@Override
	public AVGVENTE mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		AVGVENTE avgvente = new AVGVENTE();
		avgvente.setId(rs.getInt("id"));
		avgvente.setDevisesar(rs.getFloat("devisesar"));
		avgvente.setDevisecad(rs.getFloat("devisecad"));
	
		avgvente.setDevisedkk(rs.getFloat("devisedkk"));
		avgvente.setDeviseusd(rs.getFloat("deviseusd"));
		
		avgvente.setDevisegbp(rs.getFloat("devisegbp"));
		avgvente.setDevisejpy(rs.getFloat("devisejpy"));
		
		avgvente.setDevisenok(rs.getFloat("devisenok"));
		avgvente.setDevisesek(rs.getFloat("devisesek"));
		
		avgvente.setDevisechf(rs.getFloat("devisechf"));
		avgvente.setDevisekwd(rs.getFloat("deviseKWD"));
		
		avgvente.setDeviseaed(rs.getFloat("deviseaed"));
		avgvente.setDeviseeur(rs.getFloat("deviseeur"));
		
		avgvente.setDeviselyd(rs.getFloat("deviselyd"));
		avgvente.setDevisebhd(rs.getFloat("devisebhd"));
		
		avgvente.setDeviseqar(rs.getFloat("deviseqar"));
		avgvente.setDevisecny(rs.getFloat("devisecny"));
		
		
		
		avgvente.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return avgvente;
	}

}