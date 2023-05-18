package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.BIAT;
import com.tta.boxchange.entities.BIAT;


public class BIATRowMapper implements RowMapper<BIAT> {

	@Override
	public BIAT mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		BIAT biat = new BIAT();
		biat.setIdBIAT(rs.getInt("idBIAT"));
		biat.setCodeDevise(rs.getString("codeDevise"));
		biat.setUniteDevise(rs.getString("uniteDevise"));
		biat.setAchatdevise(rs.getString("achatdevise"));
		biat.setVentedevise(rs.getString("ventedevise"));
		biat.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return biat;
	}

}