package coneccioDBsinDepndencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class d_deleteOfDB {
 public static void delete (String dbName, String email){
	 Connection conn = connectionDB.connection(dbName);
	 String query = "DELETE FROM contacto WHERE correo = ?";

	 try ( PreparedStatement queryDelete = conn.prepareStatement(query) ){
      queryDelete.setString(1, email);

      int result =  queryDelete.executeUpdate();
			if(result > 0) System.out.println("Contacts deleted "+result);
	 } catch ( SQLException e ){
    System.out.println(e);
	 }
 }
}
