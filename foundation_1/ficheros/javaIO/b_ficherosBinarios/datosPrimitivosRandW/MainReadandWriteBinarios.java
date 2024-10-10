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

			FileInputStream fis1 = new FileInputStream(fileName); // creando la instancia para leer el fichero
			int num;
			System.out.println("Datos leidos del archivo");
			// El metodo read permite leer bit a bit (manda el valor ASCII del caracter y -1 cuando es vacío)
			while ( ( num = fis1.read() ) != -1 ) System.out.print(num + " ");

			fis.close(); // cerramos el fichero
		} catch ( IOException e ){
			throw new RuntimeException(e);
		}

		//Escribiendo y leyendo distintos tipos de primitivos en un archivo binario
		String fileBin2 = "/home/mevelezs/Downloads/ensayoJava/archivo2.dat";
		boolean approve = true;
		String name = "Mauricio";
		int age = 39;
		double height = 1.68;

		try{
			FileOutputStream fos = new FileOutputStream(fileBin2);
			// Escribiendo -> pasamos un buffer para mejora la eficiencia
			DataOutputStream out = new DataOutputStream(new BufferedOutputStream(fos));
			out.writeBoolean(approve);
			out.writeUTF(name);
			out.writeInt(age);
			out.writeDouble(height);
			out.close();

			System.out.println("\n---------------------------------------------");
			//Leyendo -> Se tiene que saber el orden de los datos para poder leerlos (no se lee en cualquier orden)
			DataInputStream in = new DataInputStream(new FileInputStream(fileBin2));
			System.out.println("Reading value approve: "+ in.readBoolean());
			System.out.println("Reading value name: "+ in.readUTF());
			System.out.println("Reading value age: "+ in.readInt());
			System.out.println("Reading value height: "+ in.readDouble());
			in.close();

		} catch ( IOException e ){
			throw new RuntimeException(e);
		}
	}

}