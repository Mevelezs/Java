package ficheros.javaNIO.a_ficherosDetexto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class mainFicherosdeTextosNio {

	/**
	 java.nio proporciona distintas clases para realizar operaciones de lectura y escritura en ficheros de texto de una
	 forma más eficiente que java.io
	 */
	public static void main(String[] args){

		System.out.println("\nArchivos de texto escribir/leer los datos");
		List <String> lines = Arrays.asList("Hello", "World", "From", "Java.nio");
		Path path = Paths.get("/home/mevelezs/Downloads/ensayoJava/ensayoJava2/archivo.txt");

		try{
			Files.write(path, lines, StandardCharsets.UTF_8); // escribiendo (ruta, lines de texto, codifiacion)

			List<String> getLines = Files.readAllLines(path, StandardCharsets.UTF_8);// Leyendo (ruta, codificación)

			System.out.println(getLines);
			for ( String s: getLines ) System.out.println(s);
		} catch ( IOException e ){
			throw new RuntimeException(e);
		}

		System.out.println("\nArchivos binarios usando un buffer intermedio para escribir/leer los datos");

		try{
			//Escribiendo
			//creamos el archivo y obtenemos el canal para escribir
			FileOutputStream fos = new FileOutputStream("/home/mevelezs/Downloads/ensayoJava/ensayoJava2/archivo.bin");
			FileChannel channel = fos.getChannel();

			//creamos el buffer y algunos enteros en el
			ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES * 4);
			for ( int i = 0; i < 4; i++ ){
				buffer.putInt(i);//escribe el numero en binario en el buffer

			}
      //Preparamos el buffer para escribir
			buffer.flip();
			//Se escribe el buffer a través del canal
			channel.write(buffer);

			fos.close();

			//Leyendo
			FileInputStream fis = new FileInputStream("/home/mevelezs/Downloads/ensayoJava/ensayoJava2/archivo.bin");
			channel = fis.getChannel();

			//buffer = ByteBuffer.allocate(Integer.BYTES * 4);
			channel.read(buffer);
			//prepara el buffer para la lectura
			buffer.flip();

			//hasRemaining devuelve true si quedan datos por leer
			while ( buffer.hasRemaining() ) System.out.println(buffer.getInt());

			fis.close();

		} catch ( IOException e ){
			e.printStackTrace();
		}

	}

}
