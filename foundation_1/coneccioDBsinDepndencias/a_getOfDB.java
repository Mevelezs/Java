package coneccioDBsinDepndencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class a_getOfDB {

	public static void get(){
		String query = "SELECT * FROM contacto";
		Connection conn = connectionDB.connection();

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
}
