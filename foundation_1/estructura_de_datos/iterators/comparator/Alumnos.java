package estructura_de_datos.iterators.comparator;

public class Alumnos {

	private final String name;
	private final int age;
	private final double grade;

	public Alumnos(String name, int age, double grade){
		this.name = name;
		this.age = age;
		this.grade = grade;
	}

	public int getAge(){
		return age;
	}

	public String getName(){
		return name;
	}

	public double getGrade(){
		return grade;
	}


	@Override
	public String toString(){
		return "{" + "name='" + name + ", age=" + age + ", grade=" + grade + '}' + "\n";
	}


}
