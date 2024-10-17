package coneccioDBsinDepndencias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDB {
	private static final String USER = "root";
	private static final String PASSWORD = "admin123";
	private static final String URL = "jdbc:mysql://localhost:3306/";

	public static Connection connection(String dbName){
		try {
			Connection conn = DriverManager.getConnection(URL+dbName, USER, PASSWORD);
			return conn;
		} catch ( SQLException e ){
			System.out.println(e);
		}
		return null;
	}

}
