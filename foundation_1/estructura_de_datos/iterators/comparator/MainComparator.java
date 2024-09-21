package estructura_de_datos.iterators.comparator;

import java.util.ArrayList;
import java.util.Collections;
// ventajas del comparator sobre el comparable es que este lo puedo implementar en una clase aparte modificarlo y
// llamarlo en las otrs clases a parte de que lo puedo implementar varias veces en la misma para darle
// comportaminento difernte a cada uno.
public class MainComparator {

	public static void main(String[] args){
		ArrayList <Alumnos> al = new ArrayList <>();
		al.add(new Alumnos("Mauricio", 32, 4));
		al.add(new Alumnos("Null", 42, 4));
		al.add(new Alumnos("Esteban", 62, 4));
		al.add(new Alumnos("Solís", 4, 4));
		al.add(new Alumnos("Vélez", 2, 4));

		System.out.println(al);
		//llamando al comparator
		Collections.sort(al, new ComaparetoAlumnosPorEdad());

		System.out.println(al);
		// llamando al método con la clase que implementa el comparador como método
		ComaparetoAlumnosPorEdad compare = new ComaparetoAlumnosPorEdad();
		compare.ComaparetoAlumnosPorEdadMetodo(al);

		System.out.println(al);
	}


}
