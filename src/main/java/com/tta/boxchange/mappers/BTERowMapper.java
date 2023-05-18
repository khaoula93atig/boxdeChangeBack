package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.BTE;



public class BTERowMapper implements RowMapper<BTE> {

	@Override
	public BTE mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		BTE bte = new BTE();
		bte.setIdBTE(rs.getInt("idBTE"));
		bte.setCodeDevise(rs.getString("codeDevise"));
		bte.setUniteDevise(rs.getString("uniteDevise"));
		bte.setAchatdevise(rs.getString("achatdevise"));
		bte.setVentedevise(rs.getString("ventedevise"));
		bte.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return bte;
	}

}