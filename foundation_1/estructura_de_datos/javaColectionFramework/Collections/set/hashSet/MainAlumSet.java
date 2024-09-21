package estructura_de_datos.javaColectionFramework.Collections.set.hashSet;

import java.util.HashSet;
import java.util.Set;

public class MainAlumSet {

	public static void main(String[] args){

		Set<Alum> alums = new HashSet <>();
		//como se ocupan espacios de memoria diferentes los toma como objetos distintos, aún no se han reescrito el equals()
		// ni el hashCode()
		Alum alum = new Alum("Mauricio",39, 3);
		alums.add(new Alum("Mauricio", 39, 3));
		alums.add(new Alum("Mauricio", 39, 3));
		alums.add(new Alum("Mauricio", 39, 3));
		alums.add(alum);

		// (Desactivando le equals() y el hashCode() de la clase Alum ) misma referencia de memoria, ya no los agrega;
		// (Activando los metodos en la clase Alum que están generados para que compare los tres parametros ) ya no los
		// agrega
		alums.add(alum);




		System.out.println("\n"+alums);

	}

}
