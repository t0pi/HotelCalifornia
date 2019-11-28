package mysql.dal;

import mysql.bo.Client;

public interface ClientDao {
  
	Client insert(Client client) throws Exception;
	
	//public void update(int idClient ) throws Exception;
	//public void delete(int idClient) throws Exception;
	
	//Client selectById(int id) throws Exception;
	
}
