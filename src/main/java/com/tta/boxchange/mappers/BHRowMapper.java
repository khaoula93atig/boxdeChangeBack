package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.BH;



public class BHRowMapper implements RowMapper<BH> {

	@Override
	public BH mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		BH atb = new BH();
		atb.setIdBH(rs.getInt("idBH"));
		atb.setCodeDevise(rs.getString("codeDevise"));
		atb.setUniteDevise(rs.getString("uniteDevise"));
		atb.setAchatdevise(rs.getString("achatdevise"));
		atb.setVentedevise(rs.getString("ventedevise"));
		atb.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return atb;
	}

}