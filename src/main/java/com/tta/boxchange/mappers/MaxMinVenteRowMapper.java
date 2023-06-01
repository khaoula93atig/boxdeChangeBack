package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.MaxMinVente;



public class MaxMinVenteRowMapper implements RowMapper<MaxMinVente>{

	@Override
	public MaxMinVente mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MaxMinVente maxMinVente= new MaxMinVente();
		
		maxMinVente.setIdMaxMin(rs.getInt("id_max_min"));
		maxMinVente.setMaxAED(rs.getFloat("maxaed"));
		maxMinVente.setMinAED(rs.getFloat("minaed"));
		maxMinVente.setMaxBHD(rs.getFloat("maxbhd"));
		maxMinVente.setMinBHD(rs.getFloat("minbhd"));
		maxMinVente.setMaxCAD(rs.getFloat("maxcad"));
		maxMinVente.setMinCAD(rs.getFloat("mincad"));
		maxMinVente.setMaxCHF(rs.getFloat("maxchf"));
		maxMinVente.setMinCHF(rs.getFloat("minchf"));
		maxMinVente.setMaxCNY(rs.getFloat("maxcny"));
		maxMinVente.setMinCNY(rs.getFloat("mincny"));
		maxMinVente.setMaxDKK(rs.getFloat("maxdkk"));
		maxMinVente.setMinDKK(rs.getFloat("mindkk"));
		maxMinVente.setMaxEUR(rs.getFloat("maxeur"));
		maxMinVente.setMinEUR(rs.getFloat("mineur"));
		maxMinVente.setMaxGBP(rs.getFloat("maxgbp"));
		maxMinVente.setMinGBP(rs.getFloat("mingbp"));
		maxMinVente.setMaxJPY(rs.getFloat("maxjpy"));
		maxMinVente.setMinJPY(rs.getFloat("minjpy"));
		maxMinVente.setMaxKWD(rs.getFloat("maxkwd"));
		maxMinVente.setMinKWD(rs.getFloat("minkwd"));
		maxMinVente.setMaxLYD(rs.getFloat("maxlyd"));
		maxMinVente.setMinLYD(rs.getFloat("minlyd"));
		maxMinVente.setMaxNOK(rs.getFloat("maxnok"));
		maxMinVente.setMinNOK(rs.getFloat("minnok"));
		maxMinVente.setMaxQAR(rs.getFloat("maxqar"));
		maxMinVente.setMinQAR(rs.getFloat("minqar"));
		maxMinVente.setMaxSAR(rs.getFloat("maxsar"));
		maxMinVente.setMinSAR(rs.getFloat("minsar"));
		maxMinVente.setMaxSEK(rs.getFloat("maxsek"));
		maxMinVente.setMinSEK(rs.getFloat("minsek"));
		maxMinVente.setMaxUSD(rs.getFloat("maxusd"));
		maxMinVente.setMinUSD(rs.getFloat("minusd"));
		maxMinVente.setMinMaxdate(rs.getDate("min_maxdate"));
		
		return maxMinVente;
	}

}
