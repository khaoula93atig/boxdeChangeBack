package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.BT;



public class BTRowMapper implements RowMapper<BT> {

	@Override
	public BT mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		BT bt = new BT();
		bt.setIdBT(rs.getInt("idBT"));
		bt.setCodeDevise(rs.getString("codeDevise"));
		bt.setUniteDevise(rs.getString("uniteDevise"));
		bt.setAchatdevise(rs.getString("achatdevise"));
		bt.setVentedevise(rs.getString("ventedevise"));
		bt.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return bt;
	}

}