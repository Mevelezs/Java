package estructura_de_datos.javaColectionFramework.Collections;

public class Alum {
	private String name;
	private int age;
	private double grade;

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

	@Override
	public String toString(){
		return "\n{ name = "+ name +", age = " + age + ", grade = "+ grade +" }";
	}

}
