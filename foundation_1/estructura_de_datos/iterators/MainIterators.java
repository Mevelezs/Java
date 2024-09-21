package estructura_de_datos.iterators;

import java.util.ArrayList;
import java.util.Iterator;

public class MainIterators {
  public static void main ( String[] args ) {

    ArrayList<String> cities  = new ArrayList<> ();
    cities.add ( "Paris" );
    cities.add ( "Tokyo" );
    cities.add ( "London" );
    cities.add ( "New York" );
    cities.add ( "Tirane" );

    for ( String city : cities ) System.out.print (city + ", ");

    Iterator <String> it = cities.iterator ();

//    System.out.println ("\n----------------------------------------");
//    while ( it.hasNext () ) {
//      System.out.print ( it.next () + ", " );
//    }

//    for ( String c : cities ){
//      if( c.equals ( "Tokyo" )) cities.remove ( c );
//    }
//    System.out.println (cities);
//    ConcurrentModificationException -> se está modificando la longitud del arreglo en ejecición

   // cities.removeIf ( c -> c.equals ( "Tokyo" ) ); // buena alternativa
    // System.out.println ( "\n"+ cities ) ;


    while ( it.hasNext () ) { // esto no se ejecuta si se llama al it.hasNext() en el ciclo arriba
      String city = it.next ();
      if ( city.equals ( "Tirane" ) ) it.remove ();
    }
    System.out.println ( "\n" + cities );
  }
}
