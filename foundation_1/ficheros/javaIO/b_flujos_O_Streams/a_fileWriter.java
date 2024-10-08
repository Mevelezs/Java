package ficheros.javaIO.b_flujos_O_Streams;

import java.io.FileWriter;
import java.io.IOException;

/**
 * En Java la entrada y salida de datos se realiza utilizando flujos (streams) y/o canales.
 * Un stream es una secuencia de información que tienen, flujo de entrada (lectura) o un flujo de salida (escritura).
 * Los flujos en JAVA se pueden clasificar en dos categorías principales. Flujos de entrada (Inputstreams) y flujos
 * de salida (OutputStreams).
 * Existen dos tipos de flujos de datos.
 *   @Flujos de bytes (8 bits o 1 byte) -> Realizan operaciones de entrada y salida de bytes -> Uso orientado a
 *   lectura/escritura de ficheros binarios.

 *   @Flujos de cracteres (16 bits o 2 bytes) -> Realizan operaciones de entrada y salida de caracteres -> Uso
 *   orientado a lectura/escritura de ficheros de texto.
 *
 *   @Clases (tipos) de InputStreams
 *      @FileInputStream -> Permite leer datos desde un archivo
 *      @BufferInputStream -> Añade un buffer a otro InputStream para mejorar la eficiencia de lectura
 *      @DataInputStream -> Permite leer tipos de datos primitivos e Java desde un InputStream
 *      @ObjectInputStream -> Permite leer objetos serializables de Java desde un InputStream.
 *
 *   @Clases (tipos) de OutputStreams
 *      @FileOuputStream -> Permite escribir datos desde un archivo
 *      @BufferOuputStream -> Añade un buffer a otro OutputStream para mejorar la eficiencia de escritura
 *      @DataOuputStream -> Permite escribir tipos de datos primitivos e Java desde un OutputStream
 *      @ObjectOuputStream -> Permite escribir objetos serializables de Java desde un OutputStream.

 * JAVA proporciona flujos de caracteres (Reader y Writer) que están diseñados para trabajar con datos de caracteres
 * y cadenas de texto, y gestionan automaticamente la conversion entre bytes y caracteres.
 *
 * @Readers -> (Lectores de caracteres) Se utilizan para leer caracteres.
 *   @FileReader -> Lee datos de caracteres desde un archivo.
 *   @BufferedReader -> Añade un buffer a otro Reader para mejorar la eficiencia de lectura.
 *   @InputStreamReader -> Convierte un inputStreama un Reader,permitiendo leer datos de caracteres desde un
 *   inputStream.
 * @Writers (Escritores de caracteres) -> Se usan para escribir carateres.
 *   @FileWriter -> Escribe datos de caracteres desde un archivo.
 *   @BufferedWriter -> Añade un buffer a otro Writer para mejorar la eficiencia de Escritura.
 *   @InputStreamWriter -> Convierte un OutputStreama un Writer,permitiendo escribir datos de caracteres desde un
 *   OutputStream.
 */
public class a_fileWriter {

	public static void main(String[] args){
     String text = "\nThis is an example about to use of FileWriter in Java";
		 String file = "/home/mevelezs/Downloads/ensayoJava/archivo.txt"; // si el archivo no existe lo crea

		 try{
			 FileWriter fileWriter = new FileWriter(file, true); // append para que no machaque el contenido (true)
			 fileWriter.write(text);
			 fileWriter.close();
			 System.out.println("The text has been written successfully.");
		 } catch ( IOException e ){
			 throw new RuntimeException(e);
		 }
	}
}
