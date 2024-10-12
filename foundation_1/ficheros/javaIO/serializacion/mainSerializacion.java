package ficheros.javaIO.serializacion;

import java.io.*;
import java.util.Arrays;

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


		Grupo dam = new Grupo("1DAM");
		dam.agregarAlumnos(new Alumno("Mauricio", "1QWEZ3",39));
		dam.agregarAlumnos(new Alumno("Esteban", "2DSER3", 23));

		Grupo dam2 = null;

		try{
      // Escribiendo el estado en el fichero binario (Serializando)
		  FileOutputStream fos = new FileOutputStream("/home/mevelezs/Downloads/ensayoJava/ensayoJava2/archivo.dat");
		  ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(dam);

			out.close();

			//Deserializando
			FileInputStream fis = new FileInputStream("/home/mevelezs/Downloads/ensayoJava/ensayoJava2/archivo.dat");
			ObjectInputStream in = new ObjectInputStream(fis);

			dam2 = (Grupo) in.readObject();
			dam2.mostrarAlumnos();

			in.close();

		} catch ( IOException | ClassNotFoundException e ){
			 e.printStackTrace();
		}
	}
}
