package ficheros.javaIO.a_ficherosDeTexto.b_flujos_O_Streams;

import java.io.FileReader;
import java.io.IOException;

public class b_fileReader {

	public static void main(String[] args){
		String file = "/home/mevelezs/Downloads/ensayoJava/archivo.txt";
		try {
			FileReader fileReader = new FileReader(file);

			int character;
			System.out.println("File content"+ file + " : ");

			while ( (character = fileReader.read()) != -1 ){
				System.out.print((char) character);
			}
			fileReader.close();

		} catch ( IOException e ){
			throw new RuntimeException("Something went wrong: "+e);
		}
	}
}
