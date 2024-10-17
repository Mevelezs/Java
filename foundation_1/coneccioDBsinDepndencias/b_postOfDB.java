package coneccioDBsinDepndencias;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class b_postOfDB {

	public static void insert(String dbName, String name, String email ){

		Connection conn = connectionDB.connection(dbName);
		// query parametrizada (values (?,?))para evitar la inyección sql
		String query = "INSERT INTO contacto (nombre, correo) VALUES (?, ?)";

		try ( PreparedStatement queryInsert = conn.prepareStatement(query) ){

			queryInsert.setString(1, name);
			queryInsert.setString(2, email);

			int result = queryInsert.executeUpdate();

			if(result == 1) System.out.println("Contact insertion was successful");

		} catch ( SQLException e ){
			System.out.println(e);
		}
	}
	public static void insert(String dbName, String name, String email, int tel, String imagePath ){

		Connection conn = connectionDB.connection(dbName);

		String query = "INSERT INTO contacto (nombre, correo) VALUES (?, ?, ?, ?)";

		try {
		// para insertar una imagen en la db primero hay que convertirla en un array de bites
		// en la db este array se guarda como tipo BLOB
		final byte[] binaryImage = Files.readAllBytes(Paths.get(imagePath));

		PreparedStatement queryInsert = conn.prepareStatement(query);

			queryInsert.setString(1, name);
			queryInsert.setString(2, email);
			queryInsert.setInt(3, tel);
			queryInsert.setBytes(4, binaryImage);

			int result = queryInsert.executeUpdate();

			if ( result == 1 ) System.out.println("Contact insertion was successful");

			conn.close();
		} catch ( SQLException | IOException e){
			System.out.println(e);
		}
	}
}
