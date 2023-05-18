package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.ExcelData;
import com.tta.boxchange.entities.ExcelData;

public class ExcelDataRowMapper implements RowMapper<ExcelData> {

	@Override
	public ExcelData mapRow(ResultSet rs, int arg1) throws SQLException {

		ExcelData excelData = new ExcelData();
		excelData.setId(rs.getLong("id"));
		excelData.setBankname(rs.getString("bankname"));
		excelData.setData(rs.getString("data"));
		excelData.setDevisename(rs.getString("devisename"));
		
		

		return excelData;
	}

}
