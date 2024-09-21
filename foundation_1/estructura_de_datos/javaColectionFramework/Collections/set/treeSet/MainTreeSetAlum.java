package estructura_de_datos.javaColectionFramework.Collections.set.treeSet;

import java.util.TreeSet;

public class MainTreeSetAlum {

	public static void main(String[] args){

		TreeSet<Alum> alums = new TreeSet <>();

		Alum a2 = new Alum("Mauricio", "ABC02",33);
		Alum a5 = new Alum("Mauricio", "ABC05",36);
		Alum a4 = new Alum("Mauricio", "ABC04",35);
		Alum a1 = new Alum("Mauricio", "ABC01",23);
		Alum a3 = new Alum("Mauricio", "ABC03",34);
		Alum a6 = new Alum("Esteban", "ABC05",36);


		alums.add(a2);
		System.out.println(alums);
		alums.add(a5);
		System.out.println(alums);
		alums.add(a4);
		System.out.println(alums);
		alums.add(a1);
		System.out.println(alums);
		alums.add(a3);
		System.out.println(alums);
		alums.add(a6);
		System.out.println(alums);

		System.out.println("\n-------------------------------------------");

		TreeSet<Alum2> alums2 = new TreeSet <>(new AlumComparatorByCod());
    // Funcionamiento igual pero más flexibilidad a la hora de manejar varios comparadores ya que el comparador no es
		// un método directo de la clase Alumno
		Alum2 al2 = new Alum2("Mauricio", "ABC02",33);
		Alum2 al6 = new Alum2("Esteban", "ABC05",33);
		Alum2 al5 = new Alum2("Mauricio", "ABC05",36);
		Alum2 al4 = new Alum2("Mauricio", "ABC04",33);
		Alum2 al1 = new Alum2("Mauricio", "ABC01",23);
		Alum2 al3 = new Alum2("Mauricio", "ABC03",34);

		alums2.add(al2);
		System.out.println(alums2);
		alums2.add(al5);
		System.out.println(alums2);
		alums2.add(al4);
		System.out.println(alums2);
		alums2.add(al1);
		System.out.println(alums2);
		alums2.add(al3);
		System.out.println(alums2);
		alums2.add(al6);
		System.out.println(alums2);
	}

}
