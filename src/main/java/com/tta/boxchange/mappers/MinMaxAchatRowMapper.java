package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.MaxMinAchat;
public class MinMaxAchatRowMapper implements RowMapper<MaxMinAchat>{

	@Override
	public MaxMinAchat mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MaxMinAchat maxMinAchat= new MaxMinAchat();
		
		maxMinAchat.setIdMaxMinAchat(rs.getInt("id_max_min_Achat"));
		maxMinAchat.setMaxAED(rs.getFloat("maxaed"));
		maxMinAchat.setMinAED(rs.getFloat("minaed"));
		maxMinAchat.setMaxBHD(rs.getFloat("maxbhd"));
		maxMinAchat.setMinBHD(rs.getFloat("minbhd"));
		maxMinAchat.setMaxCAD(rs.getFloat("maxcad"));
		maxMinAchat.setMinCAD(rs.getFloat("mincad"));
		maxMinAchat.setMaxCHF(rs.getFloat("maxchf"));
		maxMinAchat.setMinCHF(rs.getFloat("minchf"));
		maxMinAchat.setMaxCNY(rs.getFloat("maxcny"));
		maxMinAchat.setMinCNY(rs.getFloat("mincny"));
		maxMinAchat.setMaxDKK(rs.getFloat("maxdkk"));
		maxMinAchat.setMinDKK(rs.getFloat("mindkk"));
		maxMinAchat.setMaxEUR(rs.getFloat("maxeur"));
		maxMinAchat.setMinEUR(rs.getFloat("mineur"));
		maxMinAchat.setMaxGBP(rs.getFloat("maxgbp"));
		maxMinAchat.setMinGBP(rs.getFloat("mingbp"));
		maxMinAchat.setMaxJPY(rs.getFloat("maxjpy"));
		maxMinAchat.setMinJPY(rs.getFloat("minjpy"));
		maxMinAchat.setMaxKWD(rs.getFloat("maxkwd"));
		maxMinAchat.setMinKWD(rs.getFloat("minkwd"));
		maxMinAchat.setMaxLYD(rs.getFloat("maxlyd"));
		maxMinAchat.setMinLYD(rs.getFloat("minlyd"));
		maxMinAchat.setMaxNOK(rs.getFloat("maxnok"));
		maxMinAchat.setMinNOK(rs.getFloat("minnok"));
		maxMinAchat.setMaxQAR(rs.getFloat("maxqar"));
		maxMinAchat.setMinQAR(rs.getFloat("minqar"));
		maxMinAchat.setMaxSAR(rs.getFloat("maxsar"));
		maxMinAchat.setMinSAR(rs.getFloat("minsar"));
		maxMinAchat.setMaxSEK(rs.getFloat("maxsek"));
		maxMinAchat.setMinSEK(rs.getFloat("minsek"));
		maxMinAchat.setMaxUSD(rs.getFloat("maxusd"));
		maxMinAchat.setMinUSD(rs.getFloat("minusd"));
		maxMinAchat.setMinMaxdate(rs.getDate("min_maxdate"));
		
		return maxMinAchat;
	}

}
