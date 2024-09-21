package estructura_de_datos.iterators.comparable;


public class Alumnos implements Comparable <Alumnos> {

	private final String name;
	private final int age;
	private final double grade;

	public Alumnos(String name, int age, double grade){
		this.name = name;
		this.age = age;
		this.grade = grade;
	}


	@Override
	public int compareTo(Alumnos a){
		int comparator = Integer.compare(this.age, a.age); // comparación 1
		if ( comparator == 0 ) comparator = this.name.compareTo(a.name); // comparación 2
		return comparator;
	}

	@Override
	public String toString(){
		return "\n[ name = " + name + ", age=" + age + " ]";
	}


}
