package ficheros.javaIO.a_classFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class main {

	public static void main(String[] args) throws IOException{

		File archivo = new File("/home/mevelezs/Downloads"); // leyendo carpeta

		File[] files1 = archivo.listFiles(); // listando files
		Arrays.stream(files1).sorted().forEach(f -> System.out.println(f.getName())); // imprimiendo file por nombres

		System.out.println("---------------------------------------------------------------");

		File archivo2 = new File("/home/mevelezs/Downloads/ensayoJava","ensayoJava2"); // creando la carpeta
		System.out.println(archivo2.mkdirs());

		File archivo3 = new File("/home/mevelezs/Downloads/ensayoJava/","archivo.txt");
		File archivo4 = new File("/home/mevelezs/Downloads/ensayoJava/ensayoJava2","archivo.txt");

		System.out.println(archivo3.createNewFile());
		System.out.println(archivo4.createNewFile());

		File archivo5 = new File("/home/mevelezs/Downloads/ensayoJava");
		String [] list = archivo5.list();
		System.out.println(Arrays.stream(list).toList());

		System.out.println("---------------------------------------------------------------");
		System.out.println("Listando archivos y recorriendo subcarpetas");
		listarArchivos(archivo5);
		System.out.println("---------------------------------------------------------------");

		System.out.println(archivo3.isFile() + " ---->");
		System.out.println(archivo2.length() + " bytes");
		System.out.println(archivo3.length() + " bytes");
		System.out.println(archivo4.length() + " bytes");

		System.out.println(archivo2.getParent());
		System.out.println(archivo2.isDirectory());
		System.out.println(archivo2.getAbsolutePath());

		//System.out.println(archivo3.delete());
		//System.out.println(archivo4.delete());
		//System.out.println(archivo2.delete());//eliminando la carpeta - no funciona si tiene archivos
		System.out.println(archivo2.isDirectory());
		System.out.println(archivo2.getAbsolutePath());

	}

   public static void listarArchivos (File carpeta){
		if(carpeta.isDirectory()){
			File [] archivos = carpeta.listFiles();
			for ( File archivo : archivos  ){
				if(archivo.isFile()) System.out.println("Name : " + archivo.getName() +" "+ archivo.length()+" bytes");
				else if(archivo.isDirectory()){
					System.out.println(archivo.getName());
					listarArchivos(archivo);
				}
			}
		}
   }
}
