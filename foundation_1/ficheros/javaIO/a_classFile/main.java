package ficheros.javaIO.a_classFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class main {

	public static void main(String[] args){

		File archivo = new File("/home/mevelezs/Downloads"); // leyendo carpeta

		File[] files1 = archivo.listFiles(); // listando files
		Arrays.stream(files1).sorted().forEach(f -> System.out.println(f.getName())); // imprimiendo file por nombres

		File archivo2 = new File("/home/mevelezs/Downloads/ensayoJava");
		System.out.println(archivo2.mkdir());
		System.out.println(archivo2.getParent());
		System.out.println(archivo2.isDirectory());


	}

}
