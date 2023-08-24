package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.AVGVENTE;
import com.tta.boxchange.entities.AvgAchat;

public class AvgAchatRowMapper implements RowMapper<AvgAchat> {

	@Override
	public AvgAchat mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		AvgAchat avgAchat = new AvgAchat();
		avgAchat.setIdAvgAchat(rs.getInt("id_avg_achat"));
		avgAchat.setDevisesar(rs.getFloat("devisesar"));
		avgAchat.setDevisecad(rs.getFloat("devisecad"));
	
		avgAchat.setDevisedkk(rs.getFloat("devisedkk"));
		avgAchat.setDeviseusd(rs.getFloat("deviseusd"));
		
		avgAchat.setDevisegbp(rs.getFloat("devisegbp"));
		avgAchat.setDevisejpy(rs.getFloat("devisejpy"));
		
		avgAchat.setDevisenok(rs.getFloat("devisenok"));
		avgAchat.setDevisesek(rs.getFloat("devisesek"));
		
		avgAchat.setDevisechf(rs.getFloat("devisechf"));
		avgAchat.setDevisekwd(rs.getFloat("deviseKWD"));
		
		avgAchat.setDeviseaed(rs.getFloat("deviseaed"));
		avgAchat.setDeviseeur(rs.getFloat("deviseeur"));
		
		avgAchat.setDeviselyd(rs.getFloat("deviselyd"));
		avgAchat.setDevisebhd(rs.getFloat("devisebhd"));
		
		avgAchat.setDeviseqar(rs.getFloat("deviseqar"));
		avgAchat.setDevisecny(rs.getFloat("devisecny"));
		
		
		
		avgAchat.setDatedevise(rs.getDate("datedevise"));

		
	

		
		return avgAchat;
	}


}
