package mysql.dal.jdbc;

import mysql.dal.ChambreDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import mysql.bo.Chambre;
import mysql.bo.LigneReservation;

public class ChambreDaoJdbcImpl implements ChambreDao {
	
	private final static String SELECT_ALL_BY_DATE = "SELECT * " +
			"FROM chambres " +
			"WHERE idChambre NOT IN " +
			"("+
			   " SELECT chambre "+
			   " FROM   LignesReservation l "+
			   " JOIN reservations r " +
			       " ON l.reservation = r.idReservation"+
			       " JOIN clients c" +
			       " ON r.client = c.idClient"+
			   " WHERE  (arrivee <= ? AND depart >= ?) "+
			   	   " OR (arrivee < ? AND depart >= ? ) "+
			   	   " OR (? <= arrivee AND ? >= arrivee)) ";
	
	@Override
	public List<Chambre> selectByDate(LocalDate dateArrivee, LocalDate dateDepart) throws Exception {

		List<Chambre> mesChambres = new ArrayList<Chambre>();
		
		try(Connection cnx = MySQLConnection.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_BY_DATE);
			//Statement stmt = cnx.createStatement();
			pstmt.setDate(1,  java.sql.Date.valueOf(dateArrivee));
			pstmt.setDate(2, java.sql.Date.valueOf(dateArrivee));
			pstmt.setDate(3,  java.sql.Date.valueOf(dateArrivee));
			pstmt.setDate(4, java.sql.Date.valueOf(dateArrivee));
			pstmt.setDate(5,  java.sql.Date.valueOf(dateArrivee));
			pstmt.setDate(6, java.sql.Date.valueOf(dateArrivee));

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				mesChambres.add(map(rs));
			}
		} catch (SQLException e) {
			throw e;
		}
		
		return mesChambres;
	}
	
	private Chambre map(ResultSet rs) throws SQLException {
		int id = rs.getInt("idChambre");
		String nom = rs.getString("nom");
		int nbLits = rs.getInt("nombreLit");
		float prix = rs.getFloat("prix");
		
		return new Chambre(id, nom, nbLits,prix);
	}

	
			
}
