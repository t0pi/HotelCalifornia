package mysql.dal;

import java.util.List;

import mysql.bo.Reservation;



public interface ReservationDao {

	List<Reservation> selectAllByName() throws Exception;
	Reservation insert(Reservation reservation) throws Exception;
}
