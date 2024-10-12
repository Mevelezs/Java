package ficheros.javaIO.serializacion;

public class mainSerializacion {

	/**
	  La serialización es un mecanismo que se usa para convertir el estado de un objeto en secuensia de bytes, lo cual
	  permite persistir la información en bases de datos o ficheros binarios; por otra parte la deserialización el el
	  proceso inverso.

	 @Serializar
	  -> La o las clases deben implementar la interfaz Serializable de java.io
	  -> Se crea un File para almacenar el objeto
	  -> Se envuelve en un FileOutputStream para crear el flujo de datos
	  -> Envolver el objeto anterior en una instancia de ObjectOutputStream para poder escribir objetos de flujo de datos
	  -> Usar el método writeObject en una instancia del objeto que implementa la interfaz Serializable

	 @Deserializar
	  -> Se crea Un File para leer objetos del fichero
	  -> Se envuelve en un FileInputStream para crear el flujo de datos
	  -> Envolver el objeto anterior en una instancia de ObjectInputStream para poder leer objetos de flujo de datos
	  -> Usar el método readObject en una instancia del objeto que implementa la interfaz Serializable -> devolverá un
	    Object que se debe convertir al tipo de la clase del objeto con un casting -> puese lanzar una excepcioón
	    ClassNotFoundException
	 */
	public static void main(String[] args){

	}
}
