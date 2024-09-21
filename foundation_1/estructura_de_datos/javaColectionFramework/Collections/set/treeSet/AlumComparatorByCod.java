package estructura_de_datos.javaColectionFramework.Collections.set.treeSet;

import java.util.Comparator;

public class AlumComparatorByCod implements Comparator <Alum2>{

	@Override
	public int compare(Alum2 a1, Alum2 a2){
		if (a1.getCod().compareTo(a2.getCod()) == 0) return 0; // no deja que se repita el Cod
		int comparative = Integer.compare(a1.getAge(), a2.getAge()); // ordena por edad
		if(comparative == 0) comparative = a1.getName().compareTo(a2.getName()); // compara por nombre
		return comparative;
	}


}
