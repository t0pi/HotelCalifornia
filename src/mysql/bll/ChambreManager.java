package mysql.bll;

import mysql.dal.DaoFactory;

import java.time.LocalDate;
import java.util.List;

import mysql.bo.Chambre;
import mysql.dal.ChambreDao;

public class ChambreManager {
  
private ChambreDao ChambreDao;
	
	public ChambreManager() {
		this.ChambreDao =DaoFactory.getChambreDao();
	}
	
	public List<Chambre> selectionnerChambres(LocalDate dateArrivee, LocalDate dateDepart) throws Exception
	{
		return this.ChambreDao.selectByDate(dateArrivee, dateDepart);
	}
	
	public List<Chambre> selectionnerChambresParId(LocalDate dateArrivee, LocalDate dateDepart, int idChambre) throws Exception
	{
		return this.ChambreDao.selectByDateEtChambre(dateArrivee, dateDepart, idChambre);
	}
	
	public List<Chambre> selectionnerNomsChambres() throws Exception
	{
		return this.ChambreDao.selectAll();
	}
	
	public Chambre selectionnerChambresById(int id) throws Exception
	{
		return this.ChambreDao.selectAllById(id);
	}

	
	
}
