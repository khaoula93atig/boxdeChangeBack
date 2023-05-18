package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.BTK;



public class BTKRowMapper implements RowMapper<BTK> {

	@Override
	public BTK mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		BTK btk = new BTK();
		btk.setIdBTK(rs.getInt("idBTK"));
		btk.setCodeDevise(rs.getString("codeDevise"));
		btk.setUniteDevise(rs.getString("uniteDevise"));
		btk.setAchatdevise(rs.getString("achatdevise"));
		btk.setVentedevise(rs.getString("ventedevise"));
		btk.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return btk;
	}

}