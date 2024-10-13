package coneccioDBsinDepndencias;

import java.sql.*;
import java.util.Arrays;

public class mainconnetDB {
	/**
	 Para poder conectar la db sin dependencias se necesita
	 -> Descargar el connector https://dev.mysql.com/downloads/connector/j/ -> opcion platform independent.
	 -> Descomprimimos el archivo -> guardamos el conctor (MySQL:connector -> myql-connector.jar)-> de preferencia en
	 esta misma carpeta
	 -> Añadir el class Phat (Ctrl+Shift+Alt+S) -> Libraries -> + -> java -> seleccione el .jar y se agrega
	 */

	public static final String USER = "root";
	public static final String PASSWORD = "admin123";
	public static final String URL = "jdbc:mysql://localhost:3306/foundation";

	public static void main(String[] args){

		String query = "SELECT * FROM contacto";
		try ( PreparedStatement preparedStatement = connection().prepareStatement(query) ){
			System.out.println("Connection was successfully");

			ResultSet result = preparedStatement.executeQuery();

			while ( result.next() ){
				String name = result.getString("nombre");
				String email = result.getString("correo");
				System.out.println("Name: "+name+" "+"Email: "+ email);
			}
      connection().close();
		} catch ( SQLException e ){
			System.out.println(e);
		}

	}

	public static Connection connection(){
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			return conn;
		} catch ( SQLException e ){
			System.out.println(e);
		}
		return null;
	}

}
