package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.Proposition;

public class PropositionRowMapper implements RowMapper<Proposition> {

	@Override
	public Proposition mapRow(ResultSet rs, int rowNum) throws SQLException {
		Proposition prop = new Proposition();
		prop.setIdProposition(rs.getLong(rowNum));
		prop.setDateCreation(rs.getDate(rowNum));
		return null;
	}

}
