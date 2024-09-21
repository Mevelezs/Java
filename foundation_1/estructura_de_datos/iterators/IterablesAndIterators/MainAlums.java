package estructura_de_datos.iterators.IterablesAndIterators;

import java.util.Iterator;

public class MainAlums {
public static void main(String[] args){

  AlumsGrup alumsGrup = new AlumsGrup("Alums_01");

  alumsGrup.addAlums(new Alum("Mauricio", 39, 4.5));
  alumsGrup.addAlums(new Alum("Esteban", 39, 4));
  alumsGrup.addAlums(new Alum("Vélez", 40, 3));
  alumsGrup.addAlums(new Alum("Solís", 23, 2));
  alumsGrup.addAlums(new Alum("john", 0, 1.3));
  alumsGrup.addAlums(new Alum(null, 13, 3.2));

  System.out.println("-------------------------------------------");
  System.out.println(alumsGrup.getName());

  System.out.println("-------------------------------------------");

  for ( Alum a : alumsGrup ){ // este for puede recorrer la instancia de Alunmnos porque por dentro tiene implementado en Iterator
    System.out.println(a);
  }
  System.out.println("-------------------------------------------");

  Iterator <Alum> alum = alumsGrup.iterator(); // este es el iterator de la clase java.util...
  while ( alum.hasNext() ){
    System.out.println(alum.next());
  }

  System.out.println("-------------------------------------------");
  System.out.println();

}
}
