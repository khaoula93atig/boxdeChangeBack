package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.dto.MinMaxResult;

public class MinMaxResultRowMapper implements RowMapper<MinMaxResult> {

	@Override
	public MinMaxResult mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		MinMaxResult minMax= new MinMaxResult();
		minMax.setValeur(rs.getFloat("valeur"));
		minMax.setDate(rs.getDate("date"));
		return minMax;
	}

}
