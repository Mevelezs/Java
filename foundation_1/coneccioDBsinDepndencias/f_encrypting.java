package coneccioDBsinDepndencias;




import at.favre.lib.crypto.bcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 -> Descargar el archivo  https://jar-download.com/artifact-search/bcrypt
 -> Descomprimir aquí
 -> Añadir el class Phat (Ctrl+Shift+Alt+S) -> Libraries -> + -> java -> seleccione el .jar y se agrega
 */
public class f_encrypting {
  public static void insertWithEncryptPassword (String dbName, String nombre, String correo, String password){
	  Connection conn = connectionDB.connection(dbName);
		String query = "INSERT INTO contacto (nombre, correo, password) Values (?, ?, ?)";

	 try ( PreparedStatement queryInsert = conn.prepareStatement(query) ){

		  String pwd = BCrypt.withDefaults().hashToString(12, password.toCharArray());

		  System.out.println(pwd);
			queryInsert.setString(1, nombre);
			queryInsert.setString(2, correo);
			queryInsert.setString(3, pwd);

			int result = queryInsert.executeUpdate();
			if(result == 1 ) System.out.println("Contact insertion successfully");
	  }catch ( SQLException e ){
		  System.out.println(e);
	  }

  }

  public static void getInfoUserWithCredentials (String dbName){
    Connection conn = connectionDB.connection(dbName);
    String query = "SELECT * FROM contacto WHERE correo = ?";

	  Scanner sc = new Scanner(System.in);
	  System.out.println("Write you email");
		String email = sc.nextLine();

	  try{
		  PreparedStatement queryGet = conn.prepareStatement(query);

			queryGet.setString(1, email);
			ResultSet result = queryGet.executeQuery();

		 while ( !result.next() ){
		   System.out.println("Email not found write your email again");
		   email = sc.nextLine();
		   queryGet.setString(1, email);
		   result = queryGet.executeQuery();
	   }

		  System.out.println("Write your password");
		  String password = sc.nextLine();
		  String passwordDB = result.getString("password");

			BCrypt.Result comparaPassword =  BCrypt.verifyer().verify(password.toCharArray(), passwordDB);

			if(comparaPassword.verified){
				System.out.println("This is the information found");
				String name = result.getString("nombre");
				System.out.println("Name: "+name+" Email: "+email);
			}else{
				System.out.println("The password is wrong");
			}
			sc.close();
			queryGet.close();
	  } catch ( SQLException e ){
		  System.out.println(e);
	  }
  }
}
