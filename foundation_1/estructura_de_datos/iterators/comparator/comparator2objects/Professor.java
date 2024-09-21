package estructura_de_datos.iterators.comparator.comparator2objects;

public class Professor {
	private String name;
	private int age;
	private final String ROLE = "professor";

	public Professor(String name, int age){
		this.name = name;
		this.age = age;

	}

	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}

	public String getRole(){
		return ROLE;
	}

	@Override
	public String toString(){
		return "\nProfessor{" + "name='" + name + '\'' + ", age='" + age + '\'' + ", role='" + ROLE+ '\'' + '}';
	}

}
