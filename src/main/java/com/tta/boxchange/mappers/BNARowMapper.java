package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.BNA;



public class BNARowMapper implements RowMapper<BNA> {

	@Override
	public BNA mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		BNA bna = new BNA();
		bna.setIdBNA(rs.getInt("idBNA"));
		bna.setCodeDevise(rs.getString("codeDevise"));
		bna.setUniteDevise(rs.getString("uniteDevise"));
		bna.setAchatdevise(rs.getString("achatdevise"));
		bna.setVentedevise(rs.getString("ventedevise"));
		bna.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return bna;
	}

}