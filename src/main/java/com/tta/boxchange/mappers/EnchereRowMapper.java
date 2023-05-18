package com.tta.boxchange.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.boxchange.entities.Enchere;
import com.tta.boxchange.entities.Enchere;

public class EnchereRowMapper implements RowMapper<Enchere> {

	@Override
	public Enchere mapRow(ResultSet rs, int arg1) throws SQLException {

		Enchere enchere = new Enchere();
		enchere.setIdEnchere(rs.getString("id_enchere"));
		enchere.setReferenceEnchere(rs.getString("reference_enchere"));
		enchere.setSensEnchere(rs.getString("sens_enchere"));
		enchere.setMontantEnchere(rs.getInt("montant_enchere"));
		enchere.setDevise(rs.getString("devise"));
		enchere.setDate(rs.getDate("date"));
		enchere.setDateDebut(rs.getTimestamp("date_debut"));
		enchere.setHeureFin(rs.getDate("heure_fin"));
		enchere.setDescription(rs.getString("description"));
		enchere.setTauxSoumission(rs.getString("taux_soumission"));

		return enchere;
	}

}