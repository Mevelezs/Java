package coneccioDBsinDepndencias;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class mainconnetDB {
	/**
	 Para poder conectar la db sin dependencias se necesita
	 -> Descargar el connector https://dev.mysql.com/downloads/connector/j/ -> opcion platform independent.
	 -> Descomprimimos el archivo -> guardamos el conctor (MySQL:connector -> myql-connector.jar)-> de preferencia en
	 esta misma carpeta
	 -> Añadir el class Phat (Ctrl+Shift+Alt+S) -> Libraries -> + -> java -> seleccione el .jar y se agrega
	 */

	public static void main(String[] args){

		a_getOfDB.get("foundation");
		System.out.println("---------------------------------");
		b_postOfDB.insert( "foundation","Pepe_Grillo", "pepe@pepe.com");
		a_getOfDB.get("foundation");
		System.out.println("---------------------------------");
		c_updateOfDB.update("foundation","pepe@pepe.com", "pepe2");
		a_getOfDB.get("foundation");
		System.out.println("---------------------------------");
		d_deleteOfDB.delete("foundation","pepe@pepe.com");
		a_getOfDB.get("foundation");

    // Guardando imagenes como binarios en la db
		b_postOfDB.insert("agenda", "Mauric", "mai@ma.co", 123454312, "/home/mevelezs/Downloads/foto_carnet.jpeg");
		
		// obteniendo las imagenes de la db
		try{
			e_getImageFromDB.getImage("agenda");
		} catch ( SQLException e ){
			System.out.println(e);
		} catch ( IOException e ){
			System.out.println(e);
		}

      Scanner pwd = new Scanner(System.in);
		System.out.println("Write your password: ");
		f_encrypting.insertWithEncryptPassword("agenda2","Mauricio","mevelezs@gmail.coo.o", pwd.nextLine());

		f_encrypting.getInfoUserWithCredentials("agenda2");
	}

}
