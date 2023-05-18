package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.UIB;



public class UIBRowMapper implements RowMapper<UIB> {

	@Override
	public UIB mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		UIB uib = new UIB();
		uib.setIdUIB(rs.getInt("idUIB"));
		uib.setCodeDevise(rs.getString("codeDevise"));
		uib.setUniteDevise(rs.getString("uniteDevise"));
		uib.setAchatdevise(rs.getString("achatdevise"));
		uib.setVentedevise(rs.getString("ventedevise"));
		uib.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return uib;
	}

}