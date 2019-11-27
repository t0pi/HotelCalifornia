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
	
	public List<Chambre> selectionnerChambre() throws Exception
	{
		return this.ChambreDao.selectByDate();
	}

	public List<Chambre> selectByDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
