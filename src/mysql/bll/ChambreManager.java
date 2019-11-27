package mysql.bll;

import mysql.dal.DaoFactory;

import java.util.List;


import mysql.bo.Chambre;
import mysql.dal.ChambreDao;

public class ChambreManager {
  
private ChambreDao ChambreDao;
	
	public ChambreManager() {
		this.ChambreDao =DaoFactory.getChambreDao();
	}
	
	public List<Chambre> selectionnerChambres() throws Exception
	{
		return this.ChambreDao.selectByDate();
	}

	
	
}
