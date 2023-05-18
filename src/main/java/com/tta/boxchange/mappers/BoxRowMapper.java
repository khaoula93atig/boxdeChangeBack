package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.Box;
import com.tta.boxchange.entities.Box;

public class BoxRowMapper implements RowMapper<Box> {

	@Override
	public Box mapRow(ResultSet rs, int arg1) throws SQLException {

		Box box = new Box();
		box.setIdbox(rs.getString("id_box"));
		box.setLibelle(rs.getString("libelle"));
		box.setAdresse(rs.getString("adresse"));
		box.setUsername(rs.getString("username"));
		box.setEmaiil(rs.getString("emaiil"));
		box.setTelephone(rs.getString("telephone"));
		box.setPasssword(rs.getString("passsword"));

		return box;
	}

}
