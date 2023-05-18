package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.BTL;



public class BTLRowMapper implements RowMapper<BTL> {

	@Override
	public BTL mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		BTL btl = new BTL();
		btl.setIdBTL(rs.getInt("idBTL"));
		btl.setCodeDevise(rs.getString("codeDevise"));
		btl.setUniteDevise(rs.getString("uniteDevise"));
		btl.setAchatdevise(rs.getString("achatdevise"));
		btl.setVentedevise(rs.getString("ventedevise"));
		btl.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return btl;
	}

}