package coneccioDBsinDepndencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class c_updateOfDB {
	public static void update (String email, String updatedName){
		String query = "UPDATE contacto SET nombre = ? WHERE correo = ?";

		Connection conn = connectionDB.connection();

		try ( PreparedStatement queryUpdate = conn.prepareStatement(query) ){
			queryUpdate.setString(1, updatedName);
			queryUpdate.setString(2, email);

			int result = queryUpdate.executeUpdate();

			if(result > 0 ) System.out.println("Contact name updated: "+result);

		}catch ( SQLException e ){
			System.out.println(e);
		}
	}
}
