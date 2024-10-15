package coneccioDBsinDepndencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class d_deleteOfDB {
 public static void delete (String email){
	 String query = "DELETE FROM contacto WHERE correo = ?";
  Connection conn = connectionDB.connection();

	 try ( PreparedStatement queryDelete = conn.prepareStatement(query) ){
      queryDelete.setString(1, email);

      int result =  queryDelete.executeUpdate();
			if(result > 0) System.out.println("Contacts deleted "+result);
	 } catch ( SQLException e ){
    System.out.println(e);
	 }
 }
}
