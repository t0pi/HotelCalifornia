package mysql.bll;



import mysql.bo.Client;
import mysql.dal.DaoFactory;

public class ClientManager {
 
	public Client ajouterClient(String nom, String prenom, String adresse, String telephone ) throws Exception{
		
			Client client = new Client(nom, prenom, adresse, telephone);
			return DaoFactory.getClientDao().insert(client);
		}
		
	
}
