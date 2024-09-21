package estructura_de_datos.iterators.comparator;

import java.util.ArrayList;
import java.util.Comparator;

public class ComaparetoAlumnosPorEdad implements Comparator <Alumnos> {

	@Override
	public int compare(Alumnos a1, Alumnos a2){
		int comparacion = Integer.compare(a1.getAge(), a2.getAge());
		if ( comparacion == 0 ) comparacion = a1.getName().compareTo(a2.getName());
		return comparacion;
	}

	// implementandolo dentro de un metodo directo

	public void ComaparetoAlumnosPorEdadMetodo(ArrayList <Alumnos> al){
		al.sort(new Comparator <Alumnos>() {

			@Override
			public int compare(Alumnos a1, Alumnos a2){
				//if (a1.getAge() > a2.getAge()) return 1;
				//if(a1.getAge() < a2.getAge()) return -1;
				// modificado para que solo compare por nombre
				return a1.getName().compareTo(a2.getName());
			}
		});
	}


}



