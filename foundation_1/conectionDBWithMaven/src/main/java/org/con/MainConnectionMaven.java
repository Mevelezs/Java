package org.con;


import org.connectionDB.connectionDBmaven;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainConnectionMaven {

	/**
	 *Creacioǹ del proyecto
	  -> Si se está en un proyecto que no implementa maven -> se crea un modulo -> y desde ahí se inicia el proyecto maven
	  -> En el archivo pomp que da la creación del proyecto -> se agrega a las depndencias el conector y el driver que
	     maneja el pool de conecciones (HikariCP, Apache DBCP, etc)
	 -> Se crea la clase que gestiona la conección y crea el pool con sus respectivas especificaciones
	 -> Se llama la clase conectora donde sea requerida

	 */
	public static void main(String[] args){

		try{

			String query = "SELECT * FROM contacto";
			PreparedStatement preparedStatement = connectionDBmaven.getConnectionDB().prepareStatement(query);

			ResultSet result = preparedStatement.executeQuery();

			while ( result.next() ) System.out.println(result.getString("nombre")+" "+result.getString("correo"));

		} catch ( SQLException e ){
			System.out.println(e);
		}
	}

}
