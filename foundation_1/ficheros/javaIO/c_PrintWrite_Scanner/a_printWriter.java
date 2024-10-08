package ficheros.javaIO.c_PrintWrite_Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class a_printWriter {

	/**
	 * La clase PrintWriter en JAVA es una subclase de la clase abstracta Writer y se utiliza para escribir datos
	 * formateados en un flujo de salida.A diferencia de FileWriter, PrintWriter tiene la capacidada de imprimir
	 * representaciones de varios topos de datos. Proprciona metodos para imprimir una kinea completa.
	 */
	public static void main(String[] args){

		try{
			PrintWriter pw1 = new PrintWriter(new FileWriter("/home/mevelezs/Downloads/ensayoJava/archivo.txt"));
			pw1.println("Start PrintWriter");
			pw1.println(2.898f);

			Arrays.stream(new int [] {1, 3, 5, 7})
					.filter(n -> n > 2)
					.forEach(n -> pw1.println((int) Math.pow(n, 3)));
			pw1.close();

		} catch ( IOException e ){
			throw new RuntimeException(e);
		}
	}
}
