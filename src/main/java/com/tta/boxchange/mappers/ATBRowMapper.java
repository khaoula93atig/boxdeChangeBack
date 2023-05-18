package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.ATB;



public class ATBRowMapper implements RowMapper<ATB> {

	@Override
	public ATB mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		ATB atb = new ATB();
		atb.setIdATB(rs.getInt("idATB"));
		atb.setCodeDevise(rs.getString("codeDevise"));
		atb.setUniteDevise(rs.getString("uniteDevise"));
		atb.setAchatdevise(rs.getString("achatdevise"));
		atb.setVentedevise(rs.getString("ventedevise"));
		atb.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return atb;
	}

}