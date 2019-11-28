package mysql.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import mysql.bo.LigneReservation;
import mysql.bo.Reservation;
import mysql.dal.ReservationDao;

public class ReservationDaoJdbcImpl implements ReservationDao {
	
	
	private final static String INSERT_RESERVATION = "INSERT INTO Reservations( client, le, payeeLe) VALUES(?, ?, ?)";
	
	private final static String INSERT_LIGNE_RESERVATION = "INSERT INTO LignesReservation(reservation, ligneReservation, chambre, arrivée, depart) VALUES(?, ?, ?,?, ?)";

	@Override
	public List<Reservation> selectAllByName() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Reservation insertReservation(int client, LocalDate le, LocalDate payeele) throws Exception {
		return insertReservation(0, null, null);
	}
	
	@Override
	public Reservation insert(Reservation reservation) throws Exception {

		try(Connection cnx = MySQLConnection.getConnection()) {
			try {
				
				PreparedStatement pStmt = cnx.prepareStatement(INSERT_RESERVATION, Statement.RETURN_GENERATED_KEYS);
				pStmt.setInt(1, reservation.getClient().getIdClient());
				pStmt.setDate(2, java.sql.Date.valueOf(reservation.getLe()));
				pStmt.setDate(3, java.sql.Date.valueOf(reservation.getPayeele()));
				int n = pStmt.executeUpdate();
				System.out.println(pStmt);
				ResultSet rs = pStmt.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					reservation.setIdReservation(id);
				}
				System.out.println("our culprit:"+ reservation.getLigneReservation());
				
				 /*for( int i = 0 ; i < reservation.getLigneReservation().size() ; i++ ) {
					LigneReservation lr = reservation.getLigneReservation().get(i);
					pStmt = cnx.prepareStatement(INSERT_LIGNE_RESERVATION);
					pStmt.setInt(1, reservation.getIdReservation());
					pStmt.setInt(2, i+1);
					pStmt.setInt(3, lr.getChambre().getIdChambre());
					pStmt.setDate(4, java.sql.Date.valueOf(lr.getArrivee()));
					pStmt.setDate(5, java.sql.Date.valueOf(lr.getDepart()));
					pStmt.executeUpdate();
					System.out.println(pStmt);
					pStmt.close();
				 }
				cnx.commit();*/
			} catch (SQLException e) {
				e.printStackTrace();
				cnx.rollback();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return reservation;
	}
  
	
}
