package ficheros.javaIO.b_ficherosBinarios.datosPrimitivosRandW;

import java.io.*;

public class MainReadandWriteBinarios {

	/**
	 * La lectura y escritura de tipos primitivos (boolean, int, float, string..) en formato binario sobre ficheros se
	 * realizausando las clases DataInputStream (lectura) y DataOuputStream (escritura) del paquete java.io.
	 * <p>
	 * Pasos
	 * -> Crear una instancia de la clase File con el origen/destino de datos.
	 * -> Envolverlo en FileInputStream/FileOutputStream para crear el flujo de datos desde/hacia el fichero
	 * -> Envolver ele objeto anterior en un DataInputStream/DataOutputStream para poder leer/escribir tipos de datos
	 * primitovos en flujos de datos.
	 * -> Usar métodos como writeInt, writeDouble, readInt, readDouble...
	 */
	public static void main(String[] args){
		String fileBin = "/home/mevelezs/Downloads/ensayoJava/archivo.dat";
		File fileName = new File(fileBin);

		try{
			DataOutputStream fis = new DataOutputStream(new FileOutputStream((fileName))); // creando el fichero binario
			fis.writeUTF("Data");//escribiendo un String en utf

			FileInputStream fis1 = new FileInputStream(fileName); // creando la instancia para leer
			int num;
			System.out.println("Datos leidos del archivo");
			// El metodo read permite leer bit a bit (manda el valor ASCII del caracter y -1 cuando es vacío)
			while ( ( num = fis1.read() ) != -1 ) System.out.print(num + " ");

			fis.close(); // cerramos el fichero
		} catch ( IOException e ){
			throw new RuntimeException(e);
		}
	}

}