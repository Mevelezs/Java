package estructura_de_datos.javaColectionFramework.Collections.set.treeSet;

public class Alum2 {

	private String name;
	private String cod;
	private int age;

	public Alum2(String name, String cod, int age){
		this.name = name;
		this.cod = cod;
		this.age = age;
	}

	public String getCod(){
		return cod;
	}

	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}


	@Override
	public String toString(){
		return "Alum2{" + "name='" + name + '\'' + ", cod='" + cod + '\'' + ", age=" + age + '}';
	}


}
