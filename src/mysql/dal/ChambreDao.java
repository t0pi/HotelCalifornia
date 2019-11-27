package mysql.dal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import mysql.bo.Chambre;

public interface ChambreDao {
	
	//List<Chambre> selectByDate() throws Exception;


	List<Chambre> selectByDate(LocalDate dateArrivee, LocalDate dateDepart) throws Exception;

}
