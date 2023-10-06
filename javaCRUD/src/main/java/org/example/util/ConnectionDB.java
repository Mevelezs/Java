package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
  private static Connection conn;
  private static final String url = "jdbc:mysql://localhost:3306/crud";
  private static final String user = "root";
  private static final String password = "admin123";

  public static  Connection getConnectionDB() throws SQLException {
    if( conn == null) {
      conn = DriverManager.getConnection( url, user, password );
      // System.out.println ( "connected" );
    }
    return conn;
  }
}
