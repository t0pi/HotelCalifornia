package mysql.bll;

import mysql.dal.DaoFactory;

import java.util.List;

import mysql.bo.Client;
import mysql.dal.ClientDao;

public class ClientManager {
	
	private ClientDao clientDao;
	
	public ClientManager() {
		this.clientDao =DaoFactory.getClientDao();
	}
	
	
	public Client ajouterClient(String nom, String prenom, String adresse, String telephone ) throws Exception{
			
			Client client = new Client(nom, prenom, adresse, telephone);
		    return DaoFactory.getClientDao().insert(client);
			
		}
	
    
    public Client selectionnerClient(String telephone) throws Exception {
		return this.clientDao.selectByTelephone(telephone);
	}
	
    

	
		
	
}
