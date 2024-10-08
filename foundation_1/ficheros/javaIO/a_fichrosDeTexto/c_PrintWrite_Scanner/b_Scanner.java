package ficheros.javaIO.a_fichrosDeTexto.c_PrintWrite_Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class b_Scanner {

	/**
	 * Permite procesar tipos primitivos y cadenas de texto. Divide los datos de entrada en tokens (elementos
	 * individuales) que seran procesados de forma individual.
	 */
	public static void main(String[] args){
    String file = "/home/mevelezs/Downloads/ensayoJava/archivo.txt";
		File intFail = new File(file);

		try{
			Scanner scanner = new Scanner(intFail);

			while ( scanner.hasNextLine() ){ // devuelve un true mientras queden lineas por leer
				if(scanner.hasNextInt()) System.out.println(scanner.nextInt());
				else System.out.println(scanner.nextLine());// me quedo con una linea

			}
			scanner.close();
		} catch ( FileNotFoundException e ){
			throw new RuntimeException(e);
		}
	}
}
