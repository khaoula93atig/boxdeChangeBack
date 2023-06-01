package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.AverageVenteDevise;

public class AvgVenteDeviseRowMapper implements RowMapper<AverageVenteDevise> {

	@Override
	public AverageVenteDevise mapRow(ResultSet rs, int rowNum) throws SQLException {
		AverageVenteDevise avgvente = new AverageVenteDevise();
		avgvente.setDatedevise(rs.getDate("datedevise"));
		avgvente.setDevise(rs.getFloat("devise"));
		return avgvente;
	}

}
