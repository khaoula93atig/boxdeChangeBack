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
		avgvente.setNombanque(rs.getString("nombanque"));
		avgvente.setDevisesar(rs.getDouble("devisesar"));
		avgvente.setDevisecad(rs.getString("devisecad"));
	
		avgvente.setDevisedkk(rs.getString("devisedkk"));
		avgvente.setDeviseusd(rs.getString("deviseusd"));
		
		avgvente.setDevisegbp(rs.getString("devisegbp"));
		avgvente.setDevisejpy(rs.getString("devisejpy"));
		
		avgvente.setDevisenok(rs.getString("devisenok"));
		avgvente.setDevisesek(rs.getString("devisesek"));
		
		avgvente.setDevisechf(rs.getString("devisechf"));
		avgvente.setDevisekwd(rs.getString("deviseKWD"));
		
		avgvente.setDeviseaed(rs.getString("deviseaed"));
		avgvente.setDeviseeur(rs.getString("deviseeur"));
		
		avgvente.setDeviselyd(rs.getString("deviselyd"));
		avgvente.setDevisebhd(rs.getString("devisebhd"));
		
		avgvente.setDeviseqar(rs.getString("deviseqar"));
		avgvente.setDevisecny(rs.getString("devisecny"));
		
		
		
		avgvente.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return avgvente;
	}

}