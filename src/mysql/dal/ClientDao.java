package mysql.dal;

import mysql.bo.Client;

public interface ClientDao {
  
	Client insert(Client client) throws Exception;

}
