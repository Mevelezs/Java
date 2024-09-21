package estructura_de_datos.javaColectionFramework.Maps.treeMap;

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
	public int compareTo( Alum alum){
		if(alum.getCod().compareTo(this.cod) == 0) return 0; // restringe por cod
		int comparative = this.cod.compareTo(alum.getCod()); // ordena por cod
		if (comparative == 0) comparative = Integer.compare(this.age, alum.getAge()); // ordena por edad
		return comparative;
	}


	@Override
	public String toString(){
		return "{" + "name='" + name + '\'' + ", cod='" + cod + '\'' + ", age=" + age + '}';
	}



}
