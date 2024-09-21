package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainExceptions {
  public static void main(String[] args) {


    try {
      FileReader file = new FileReader("file1.txt");
      file.close();
    } catch (FileNotFoundException e) {
      System.out.println("\n"+e );
    } catch (IOException e) {
      System.out.println(e);
      throw new RuntimeException(e);
    }

    try {
     int num = Integer.parseInt("2");
     System.out.println(num);
     double rest = num/0;
   }catch (Exception e){
     System.out.println(e);
   }
    System.out.println("After the error");


  }
}
