package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.AVERAGEVENTE;
import com.tta.boxchange.entities.AVERAGEVENTE;


public class AVERAGEVENTERowMapper implements RowMapper<AVERAGEVENTE> {

	@Override
	public AVERAGEVENTE mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		AVERAGEVENTE averagevente = new AVERAGEVENTE();
		averagevente.setIdAVERAGEVENTE(rs.getInt("idAVERAGEVENTE"));
		averagevente.setDevise(rs.getString("devise"));
		averagevente.setAverage(rs.getString("average"));
		averagevente.setDateAVERAGEVENTE(rs.getDate("dateAVERAGEVENTE"));
		

		
	

		
		return averagevente;
	}

}