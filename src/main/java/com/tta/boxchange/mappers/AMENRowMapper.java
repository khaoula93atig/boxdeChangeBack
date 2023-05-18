package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.AMEN;



public class AMENRowMapper implements RowMapper<AMEN> {

	@Override
	public AMEN mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		AMEN amen = new AMEN();
		amen.setIdAMEN(rs.getInt("idAMEN"));
		amen.setCodeDevise(rs.getString("codeDevise"));
		amen.setUniteDevise(rs.getString("uniteDevise"));
		amen.setAchatdevise(rs.getString("achatdevise"));
		amen.setVentedevise(rs.getString("ventedevise"));
		amen.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return amen;
	}

}