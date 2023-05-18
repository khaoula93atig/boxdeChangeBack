package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.ATT;



public class ATTRowMapper implements RowMapper<ATT> {

	@Override
	public ATT mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		ATT att = new ATT();
		att.setId(rs.getInt("idATT"));
		att.setCodeDevise(rs.getString("codeDevise"));
		att.setUniteDevise(rs.getString("uniteDevise"));
		att.setAchatdevise(rs.getString("achatdevise"));
		att.setVentedevise(rs.getString("ventedevise"));
		att.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return att;
	}

}