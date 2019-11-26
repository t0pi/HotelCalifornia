package mysql.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MySQLConnection {
	private static DataSource dataSource;
	
	static {
		try {
			InitialContext context = new InitialContext();
			dataSource = 
					(DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
