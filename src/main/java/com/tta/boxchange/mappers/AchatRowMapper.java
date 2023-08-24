package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.Achat;
import com.tta.boxchange.entities.Vente;

public class AchatRowMapper implements RowMapper<Achat> {

	@Override
	public Achat mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		Achat achat = new Achat();
		achat.setIdAchat(rs.getInt("id_achat"));
		achat.setNomBanque(rs.getString("nom_banque"));
		achat.setDeviseSAR(rs.getString("deviseSAR"));
		achat.setDeviseCAD(rs.getString("deviseCAD"));
	
		achat.setDeviseDKK(rs.getString("deviseDKK"));
		achat.setDeviseUSD(rs.getString("deviseUSD"));
		
		achat.setDeviseGBP(rs.getString("deviseGBP"));
		achat.setDeviseJPY(rs.getString("deviseJPY"));
		
		achat.setDeviseNOK(rs.getString("deviseNOK"));
		achat.setDeviseSEK(rs.getString("deviseSEK"));
		
		achat.setDeviseCHF(rs.getString("deviseCHF"));
		achat.setDeviseKWD(rs.getString("deviseKWD"));
		
		achat.setDeviseAED(rs.getString("deviseAED"));
		achat.setDeviseEUR(rs.getString("deviseEUR"));
		
		achat.setDeviseLYD(rs.getString("deviseLYD"));
		achat.setDeviseBHD(rs.getString("deviseBHD"));
		
		achat.setDeviseQAR(rs.getString("deviseQAR"));
		achat.setDeviseCNY(rs.getString("deviseCNY"));
		
		
		
		achat.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return achat;
	}

}
