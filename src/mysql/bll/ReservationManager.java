package mysql.bll;

import mysql.bo.Client;
import mysql.bo.Reservation;
import mysql.dal.DaoFactory;
import mysql.dal.ReservationDao;

public class ReservationManager {

private ReservationDao reservationDao;
	
	public ReservationManager() {
		this.reservationDao =DaoFactory.getReservationDao();
	}
	
public Reservation ajouterReservation(Reservation reservation) throws Exception{		
		
	Reservation nouvelleReservation = new Reservation(reservation);
			return DaoFactory.getReservationDao().insert(reservation);
		}
	
}
