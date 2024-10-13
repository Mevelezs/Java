package org.connectionDB;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class connectionDBmaven {

	private static BasicDataSource pool;
	private static final String url = "jdbc:mysql://localhost:3306/foundation";
	private static final String user = "root";
	private static final String password = "admin123";

	public static  BasicDataSource getInstanceDB() {
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
			return getInstanceDB ().getConnection();
		}
}
