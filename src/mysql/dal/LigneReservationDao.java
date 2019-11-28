package mysql.dal;


import mysql.bo.LigneReservation;

public interface LigneReservationDao {
	
	LigneReservation insert(LigneReservation ligneReservation) throws Exception;
}
