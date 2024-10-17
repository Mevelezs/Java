package coneccioDBsinDepndencias;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class d_getImageFromDB {
 public static void getImage (String dbName) throws SQLException, IOException{

	 Connection conn = connectionDB.connection(dbName);
	 String query = "SELECT imagen, correo FROM contacto";

	 PreparedStatement getImage = conn.prepareStatement(query);
	 ResultSet contacts = getImage.executeQuery();

	 //recorriendo lo obtenido
	 while ( contacts.next() ){

		 Blob blob = contacts.getBlob("imagen"); // como en la db se guarda así de esta forma lo obtenemos
		 //Convertimo a un array de bytes el binario obtenido de la db -> (desde donde empieza, donde acaba)
		 byte[] blobByte = blob.getBytes(1, ( int ) blob.length());

		 // para que las imagenes tengan un nombre distinto
		 String nameImage = contacts.getString("correo");

		 //escribimos los bytes en un archivo FileOutputStream
		 String pathImage = "/home/mevelezs/Downloads/ensayoJava/ensayoJava2/"+nameImage+".jpg";

		 FileOutputStream fos = new FileOutputStream(pathImage);
		 fos.write(blobByte);
		 fos.close();

		 System.out.println("Image downloaded");
	 }

 }
}
