package coneccioDBsinDepndencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class a_getOfDB {

	public static void get(String dbName){
		Connection conn = connectionDB.connection(dbName);
		String query = "SELECT * FROM contacto";

		try ( PreparedStatement queryGet = conn.prepareStatement(query) ){
			//System.out.println("Connection was successfully");
			ResultSet result = queryGet.executeQuery();

			while ( result.next() ){
				String name = result.getString("nombre");
				String email = result.getString("correo");
				System.out.println("Name: " + name + " " + "Email: " + email);

			}

		} catch ( SQLException e ){
			System.out.println(e);
		}
	}
	public static void get(String dbName, String dbTable){
		Connection conn = connectionDB.connection(dbName);
		String query = "SELECT * FROM dbTable";

		try ( PreparedStatement queryGet = conn.prepareStatement(query) ){
			//System.out.println("Connection was successfully");
			ResultSet result = queryGet.executeQuery();

			while ( result.next() ){
				String name = result.getString("nombre");
				String email = result.getString("correo");
				int tel = result.getInt("telefono");
				String image = result.getString("correo");

				System.out.println("Name: " + name + " " + "Email: " + email);

			}

		} catch ( SQLException e ){
			System.out.println(e);
		}
	}
}
