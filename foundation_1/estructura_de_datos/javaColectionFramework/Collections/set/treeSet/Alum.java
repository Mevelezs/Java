package estructura_de_datos.javaColectionFramework.Collections.set.treeSet;


public class Alum implements Comparable <Alum>{

	private String name;
	private String cod;
	private int age;

	public Alum(String name, String cod, int age){
		this.name = name;
		this.cod = cod;
		this.age = age;
	}

	public String getName(){
		return name;
	}

	public String getCod(){
		return cod;
	}

	public int getAge(){
		return age;
	}

	@Override
	public int compareTo(Alum alum){
		if(alum.getCod().compareTo(this.cod) == 0) return 0; // restringe por cod
		int comparative = Integer.compare(this.age, alum.getAge()); // ordena por edad
		if (comparative == 0) comparative = this.cod.compareTo(alum.getCod()); // ordena por Cod
		return comparative;
	}

	@Override
	public String toString(){
		return "Alum{" + "name='" + name + '\'' + ", cod='" + cod + '\'' + ", age=" + age + '}';
	}


}
