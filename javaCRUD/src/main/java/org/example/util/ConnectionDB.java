package org.example.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
  private static BasicDataSource pool;
  private static final String url = "jdbc:mysql://localhost:3306/crud";
  private static final String user = "root";
  private static final String password = "admin123";

  public static  BasicDataSource getInstanceDB() throws SQLException {
    if( pool == null) {
      pool = new BasicDataSource ();
      pool.setUrl ( url );
      pool.setUsername ( user );
      pool.setPassword ( password );

      pool.setInitialSize ( 3 );
      pool.setMinIdle ( 3 );
      pool.setMaxIdle ( 10 );
      pool.setMaxTotal ( 10 );

    }
    return pool;
  }
  public static Connection getConnectionDB() throws SQLException {
    return getInstanceDB ().getConnection ();
  }
}
