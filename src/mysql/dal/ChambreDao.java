package mysql.dal;
import java.util.List;

import mysql.bo.Chambre;

public interface ChambreDao {
	
	List<Chambre> selectByDate() throws Exception;

}
