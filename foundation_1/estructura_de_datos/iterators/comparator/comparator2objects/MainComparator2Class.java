package estructura_de_datos.iterators.comparator.comparator2objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainComparator2Class {

	public static void main(String[] args){
		ArrayList <Object> dataSchool = new ArrayList<>();
		dataSchool.add(new Student("Mauricio", 39));
		dataSchool.add(new Student("Esteban", 23 ));
		dataSchool.add(new Student(null, 21));
		dataSchool.add(new Student("Solís", 60));
		dataSchool.add(new Professor("Aureliano", 50));
		dataSchool.add(new Professor("Beatriz", 39));
		dataSchool.add(new Professor("Neila", 60));
		dataSchool.add(new Professor("Jacobo", 75));

		System.out.println(dataSchool);
		System.out.println("---------------------------");

		Collections.sort(dataSchool, new NameComparator());

		System.out.println(dataSchool);

	}
}
