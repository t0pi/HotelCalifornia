package mysql.dal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import mysql.bo.Chambre;

public interface ChambreDao {
	
	//List<Chambre> selectByDate() throws Exception;


	List<Chambre> selectByDate(LocalDate dateArrivee, LocalDate dateDepart) throws Exception;

	List<Chambre> selectByDateEtChambre(LocalDate dateArrivee, LocalDate dateDepart, int idChambre) throws Exception;

	List<Chambre> selectAll() throws Exception;

}
