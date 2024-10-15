package coneccioDBsinDepndencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class b_postOfDB {

	public static void insert(String name, String email ){
		// query parametrizada (values (?,?))para evitar la inyección sql
		String query = "INSERT INTO contacto (nombre, correo) VALUES (?, ?)";
		Connection conn = connectionDB.connection();

		try ( PreparedStatement queryInsert = conn.prepareStatement(query) ){

			queryInsert.setString(1, name);
			queryInsert.setString(2, email);

			int result = queryInsert.executeUpdate();

			if(result == 1) System.out.println("Contact insertion was successful");

		} catch ( SQLException e ){
			System.out.println(e);
		}
	}
}
