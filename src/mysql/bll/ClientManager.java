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
		
		try {
			validationNom(nom); 
			validationPrenom(prenom);
			validationAdresse(adresse); 
			validationTelephone(telephone);
		} catch (Exception e ) {
			
			e.printStackTrace();
		}
		
			Client client = new Client(nom, prenom, adresse, telephone);
			return DaoFactory.getClientDao().insert(client);
		}
	
	
	  
	private void validationNom(String nom ) throws Exception {
		
	}
	
    private void validationPrenom(String prenom ) throws Exception {
		
	}
	
    private void validationAdresse(String adresse ) throws Exception {
		
	}
    
    private void validationTelephone(String telephone ) throws Exception {
		
   	}
	
    
    public Client selectionnerClient(String telephone) throws Exception {
		return this.clientDao.selectByTelephone(telephone);
	}
	
    

	
		
	
}
