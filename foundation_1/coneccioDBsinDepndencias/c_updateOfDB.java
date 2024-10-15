package coneccioDBsinDepndencias;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class c_updateOfDB {
	public static void update (String updatedName, String email){
		String query = "UPDATE contacto SET nombre = ? WHERE correo = ?";

		try ( PreparedStatement queryUpdate = connectionDB.connection().prepareStatement(query) ){
			queryUpdate.setString(1, email);
			queryUpdate.setString(2, updatedName);

			int result = queryUpdate.executeUpdate();

			if(result > 0 ) System.out.println("Contact name updated");

		}catch ( SQLException e ){
			System.out.println(e);
		}
	}
}
