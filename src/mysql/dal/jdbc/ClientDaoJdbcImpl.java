package mysql.dal.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mysql.bo.Chambre;
import mysql.bo.Client;
import mysql.dal.ClientDao;

public class ClientDaoJdbcImpl implements ClientDao {

	//private final static String INSERT_CLIENT = "INSERT INTO Clients(nom, prenom, adresse, telephone ) VALUES(?,?, ?, ?)";	
	
	private final static String INSERT_CLIENT_WHERE_NOT_EXIST = "INSERT INTO clients "+
			"(nom, prenom, adresse, telephone) "+
			"SELECT ?,?,?,? "+
			"WHERE NOT EXISTS ( "+
				"SELECT telephone FROM clients WHERE telephone = ?"+
				")";
	
	
	private final static String SELECT_CLIENT_BY_PHONE = " SELECT idClient FROM Clients WHERE telephone = ?";
	
	//private final static String UPDATE_CLIENT = "UPDATE Clients SET nom = ?, prenom = ?, adresse = ?, telephone = ? WHERE idClient = ?";
	
	//private final static String DELETE_CLIENT = "DELETE FROM Clients WHERE idClient = ?";
	

	
	
	@Override
	public Client insert(Client client) throws Exception {
		try(Connection cnx = MySQLConnection.getConnection()) {
			
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_CLIENT_WHERE_NOT_EXIST, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, client.getNom());
			pStmt.setString(2, client.getPrenom());
			pStmt.setString(3, client.getAdresse());
			pStmt.setString(4, client.getTelephone());
			pStmt.setString(5, client.getTelephone());
			
			//int n = pStmt.executeUpdate();

			System.out.println("--------------- query client "+ pStmt);
				
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				client.setIdClient(id);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return client;
	}
	
	
	public Client selectByTelephone( String telephone) throws Exception {
		Client nouveauClient = new Client();
           try(Connection cnx = MySQLConnection.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_CLIENT_BY_PHONE);
			pStmt.setString(1, telephone);
			ResultSet rs = pStmt.executeQuery();
			System.out.println("--------------- query client "+ pStmt);
			if (rs.next()) {
				nouveauClient.setIdClient(rs.getInt("idClient"));
			}
			
           } catch ( Exception e) {
        	   
           }
		return nouveauClient;
	}
	
	public Client selectByTel(String telephone) throws Exception {

		Client client = null;
		
		try(Connection cnx = MySQLConnection.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_CLIENT_BY_PHONE);
			//Statement stmt = cnx.createStatement();
			pStmt.setString(1, telephone);

			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				client = map(rs);
			}
		} catch (SQLException e) {
			throw e;
		}
		
		return client;
	}
	
	

	
	
	
/*
	@Override
	public void update(int idClient) throws Exception {
         try(Connection cnx = MySQLConnection.getConnection()) {
			
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE_CLIENT);
			pStmt.setInt(1, idClient);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int idClient) throws Exception {
	   
		 try(Connection cnx = MySQLConnection.getConnection()) {
				PreparedStatement pStmt = cnx.prepareStatement(DELETE_CLIENT);
				pStmt.setInt(1, idClient);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}

	@Override
	public Client selectById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
   */
	
	public static Client map(ResultSet rs) throws SQLException {
		int idClient = rs.getInt("idClient");
		
		
		return new Client(idClient);
		
	}
	


}
