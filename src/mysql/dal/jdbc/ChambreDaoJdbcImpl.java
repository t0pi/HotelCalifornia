package mysql.dal.jdbc;

import mysql.dal.ChambreDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mysql.bo.Chambre;

public abstract class ChambreDaoJdbcImpl implements ChambreDao {
	
	private final static String SELECT_ALL_BY_DATE = "SELECT * " +
			"FROM chambres " +
			"WHERE idChambre IN " +
			"("+
			   " SELECT chambre "+
			   " FROM   LignesReservation l "+
			   " JOIN reservations r " +
			       " ON l.reservation = r.idReservation"+
			       " JOIN clients c" +
			       " ON r.client = c.idClient"+
			   " WHERE  (arrivee <= '2019-12-12' AND depart >= '2019-12-12') "+
			   	   " OR (arrivee < '2019-12-20' AND depart >= '2019-12-20' ) "+
			   	   " OR ('2019-12-12' <= arrivee AND '2019-12-20' >= arrivee) ";
	
	@Override
	public List<Chambre> selectByDate() throws Exception {

		List<Chambre> mesChambres = new ArrayList<Chambre>();
		
		try(Connection cnx = MySQLConnection.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_BY_DATE);
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
		
		return new Chambre(nom, id);
	}
			
}
