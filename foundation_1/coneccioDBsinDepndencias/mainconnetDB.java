package coneccioDBsinDepndencias;

public class mainconnetDB {
	/**
	 Para poder conectar la db sin dependencias se necesita
	 -> Descargar el connector https://dev.mysql.com/downloads/connector/j/ -> opcion platform independent.
	 -> Descomprimimos el archivo -> guardamos el conctor (MySQL:connector -> myql-connector.jar)-> de preferencia en
	 esta misma carpeta
	 -> Añadir el class Phat (Ctrl+Shift+Alt+S) -> Libraries -> + -> java -> seleccione el .jar y se agrega
	 */

	public static void main(String[] args){

		a_getOfDB.get();
		System.out.println("---------------------------------");
		b_postOfDB.insert( "Pepe_Grillo", "pepe@pepe.com");
		a_getOfDB.get();
		System.out.println("---------------------------------");
		c_updateOfDB.update("pepe@pepe.com", "pepe2");
		a_getOfDB.get();
		System.out.println("---------------------------------");
		d_deleteOfDB.delete("pepe@pepe.com");
		a_getOfDB.get();




	}

}
