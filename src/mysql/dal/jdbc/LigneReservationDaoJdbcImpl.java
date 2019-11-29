package mysql.dal.jdbc;

import mysql.bo.LigneReservation;
import mysql.dal.LigneReservationDao;

public class LigneReservationDaoJdbcImpl implements  LigneReservationDao {

	@Override
	public LigneReservation insert(LigneReservation ligneReservation) throws Exception {
		return ligneReservation;
	}

}
