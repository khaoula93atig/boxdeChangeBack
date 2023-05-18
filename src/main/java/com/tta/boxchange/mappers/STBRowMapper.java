package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.STB;
import com.tta.boxchange.entities.STB;


public class STBRowMapper implements RowMapper<STB> {

	@Override
	public STB mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		STB stb = new STB();
		stb.setIdSTB(rs.getInt("idSTB"));
		stb.setCodeDevise(rs.getString("codeDevise"));
		stb.setUniteDevise(rs.getString("uniteDevise"));
		stb.setAchatdevise(rs.getString("achatdevise"));
		stb.setVentedevise(rs.getString("ventedevise"));
		stb.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return stb;
	}

}