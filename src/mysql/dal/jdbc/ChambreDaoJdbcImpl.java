package mysql.dal.jdbc;

import mysql.dal.ChambreDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import mysql.bo.Chambre;

public class ChambreDaoJdbcImpl implements ChambreDao {
	
	private final static String SELECT_ALL = "SELECT * " +
			"FROM chambres ";
	
	private final static String SELECT_ALL_BY_ID = "SELECT * " +
			"FROM chambres WHERE idChambre = ? ";
	
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
	
	private final static String SELECT_ALL_BY_DATE_AND_CHAMBRE = "SELECT * " +
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
			   	   " OR (? <= arrivee AND ? >= arrivee)) "+
			   	   "AND idChambre = ?";
	
	
	@Override
	public List<Chambre> selectAll() throws Exception {

		List<Chambre> mesChambres = new ArrayList<Chambre>();
		
		try(Connection cnx = MySQLConnection.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {
				mesChambres.add(map(rs));
			}
		} catch (SQLException e) {
			throw e;
		}
		
		return mesChambres;
	}
	
	
	@Override
	public List<Chambre> selectByDate(LocalDate dateArrivee, LocalDate dateDepart) throws Exception {

		List<Chambre> mesChambres = new ArrayList<Chambre>();
		
		try(Connection cnx = MySQLConnection.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_BY_DATE);
			//Statement stmt = cnx.createStatement();
			pstmt.setDate(1,  java.sql.Date.valueOf(dateArrivee));
			pstmt.setDate(2, java.sql.Date.valueOf(dateDepart));
			pstmt.setDate(3,  java.sql.Date.valueOf(dateArrivee));
			pstmt.setDate(4, java.sql.Date.valueOf(dateDepart));
			pstmt.setDate(5,  java.sql.Date.valueOf(dateArrivee));
			pstmt.setDate(6, java.sql.Date.valueOf(dateDepart));

			ResultSet rs = pstmt.executeQuery();

			System.out.println("::::::::::::::: SQL : select chambres dispo par dates OK");
			while(rs.next()) {
				mesChambres.add(map(rs));
			}
		} catch (SQLException e) {
			throw e;
		}
		
		return mesChambres;
	}
	
	@Override
	public Chambre selectAllById(int id) throws Exception {

		Chambre chambre = null;
		
		try(Connection cnx = MySQLConnection.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_BY_ID);
			//Statement stmt = cnx.createStatement();
			pstmt.setInt(1,  id);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				chambre = map(rs);
			}
		} catch (SQLException e) {
			throw e;
		}
		
		return chambre;
	}
	
	@Override
	public List<Chambre> selectByDateEtChambre(LocalDate dateArrivee, LocalDate dateDepart, int idChambre) throws Exception {

		List<Chambre> mesChambres = new ArrayList<Chambre>();
		
		try(Connection cnx = MySQLConnection.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_BY_DATE_AND_CHAMBRE);
			//Statement stmt = cnx.createStatement();
			pstmt.setDate(1,  java.sql.Date.valueOf(dateArrivee));
			pstmt.setDate(2, java.sql.Date.valueOf(dateArrivee));
			pstmt.setDate(3,  java.sql.Date.valueOf(dateArrivee));
			pstmt.setDate(4, java.sql.Date.valueOf(dateArrivee));
			pstmt.setDate(5,  java.sql.Date.valueOf(dateArrivee));
			pstmt.setDate(6, java.sql.Date.valueOf(dateArrivee));
			pstmt.setInt(7, idChambre);

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
