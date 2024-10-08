package ficheros.javaIO.a_fichrosDeTexto.d_Buffereds;

import java.io.*;
import java.util.Arrays;

public class a_bufferedReader {

	/**
	 *Los buffers como los files son untilizados para leer y escribir en ficheros pero estos utilizan un buffer
	 * (espacio de memoria temporal) intermedio que minimiza las opereciones de lectura y escritura en disco.
	 */
	public static void main(String[] args){

		String file = "/home/mevelezs/Downloads/ensayoJava/archivo.txt";
		bufferWriter(file, 34); // escribiendo archivos con buffer
		System.out.println("********************************");
		bufferReaderAndCountWorlds(file);

	}
	static void bufferWriter(String file, int n){

		try{
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			for ( int i = 1; i <= n; i++ ){
				bufferedWriter.write("Esta es la linea: "+i);
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			System.out.println("archivo.txt crado con "+n+" lineas");
		} catch ( IOException e ){
			throw new RuntimeException(e);
		}
	}

	static void bufferReaderAndCountWorlds (String file){

		try{

			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line;
			int wordsLength = 0;

			while ( (line = bufferedReader.readLine()) != null ){
				System.out.println(line);

				String [] wordsLine = line.split("\\s+");
				wordsLength += wordsLine.length;

				System.out.println(Arrays.toString(wordsLine )+"\n");
			}

			bufferedReader.close();
			System.out.println("\n"+file+" contiene "+ wordsLength+" palabras");
		} catch ( IOException e ){
			throw new RuntimeException(e);
		}
	}
}
