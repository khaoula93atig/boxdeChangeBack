package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.Vente;



public class VENTERowMapper implements RowMapper<Vente> {

	@Override
	public Vente mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		Vente vente = new Vente();
		vente.setIdVENTE(rs.getInt("idVENTE"));
		vente.setNomBanque(rs.getString("nom_banque"));
		vente.setDeviseSAR(rs.getString("deviseSAR"));
		vente.setDeviseCAD(rs.getString("deviseCAD"));
	
		vente.setDeviseDKK(rs.getString("deviseDKK"));
		vente.setDeviseUSD(rs.getString("deviseUSD"));
		
		vente.setDeviseGBP(rs.getString("deviseGBP"));
		vente.setDeviseJPY(rs.getString("deviseJPY"));
		
		vente.setDeviseNOK(rs.getString("deviseNOK"));
		vente.setDeviseSEK(rs.getString("deviseSEK"));
		
		vente.setDeviseCHF(rs.getString("deviseCHF"));
		vente.setDeviseKWD(rs.getString("deviseKWD"));
		
		vente.setDeviseAED(rs.getString("deviseAED"));
		vente.setDeviseEUR(rs.getString("deviseEUR"));
		
		vente.setDeviseLYD(rs.getString("deviseLYD"));
		vente.setDeviseBHD(rs.getString("deviseBHD"));
		
		vente.setDeviseQAR(rs.getString("deviseQAR"));
		vente.setDeviseCNY(rs.getString("deviseCNY"));
		
		
		
		vente.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return vente;
	}

}