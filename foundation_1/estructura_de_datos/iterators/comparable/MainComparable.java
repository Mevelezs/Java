package estructura_de_datos.iterators.comparable;

import java.util.ArrayList;
import java.util.Collections;

public class MainComparable {
public static void main(String[] args){
  ArrayList <Alumnos> al = new ArrayList <>();
  al.add(new Alumnos("Mauricio", 39, 4.5));
  al.add(new Alumnos("Esteban", 39, 4));
  al.add(new Alumnos("Vélez", 40, 3));
  al.add(new Alumnos("Solís", 23, 2));
  al.add(new Alumnos("john", 0, 1.3));
  al.add(new Alumnos(null, 13, 3.2));

  // Ordenando un ArrayList
  System.out.println(al);
  System.out.println("--------------------------");
  Collections.sort(al); // siempre se llama de esta forma al comparable
  System.out.println("--------------------------");
  System.out.println(al);
}

}
