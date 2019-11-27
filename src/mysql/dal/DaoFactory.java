package mysql.dal;


import mysql.dal.jdbc.ChambreDaoJdbcImpl;
import mysql.dal.jdbc.ClientDaoJdbcImpl;
import mysql.dal.jdbc.LigneReservationDaoJdbcImpl;
import mysql.dal.jdbc.ReservationDaoJdbcImpl;

public class DaoFactory {
  

	public static ReservationDao getReservationDao() {
		return new ReservationDaoJdbcImpl();
	}
	
	public static LigneReservationDao getArticleDao() {
		return new LigneReservationDaoJdbcImpl();
	}
	
	public static ChambreDao getChambreDao() {
		return new ChambreDaoJdbcImpl();
	}
	
	public static ClientDao getClientDao() {
		return new ClientDaoJdbcImpl();
	}
}
