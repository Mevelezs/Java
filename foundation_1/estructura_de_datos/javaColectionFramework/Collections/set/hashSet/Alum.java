package estructura_de_datos.javaColectionFramework.Collections.set.hashSet;

import java.util.Objects;

public class Alum {

	private final String name;
	private final int age;
	private final double grade;

	public Alum(String name, int age, double grade){
		this.name = name;
		this.age = age;
		this.grade = grade;
	}

	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}

	public double getGrade(){
		return grade;
	}

	// El hashCode devuelve un entero, si dos objetos devuelven el mismo numero Java compara el equeals que de vuelve
	// un booleano, si la respuesta es true el los objetos son los mismos.


	@Override
	public boolean equals(Object o){
		if ( this == o ) return true;
		if ( o == null || getClass() != o.getClass() ) return false;
		Alum alum = ( Alum ) o;
		return age == alum.age && Double.compare(grade, alum.grade) == 0 && Objects.equals(name, alum.name);
	}

	@Override
	public int hashCode(){
		return Objects.hash(name, age, grade);
	}

	@Override
	public String toString(){
		return "Alum [ " + "name = " + name + ", age = " + age + ", grade = " + grade + " ]";
	}


}
