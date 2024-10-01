package API_de_java.c_API_stream;

import java.util.Random;

public class Worker {
  private String name;
	private int age;

	public  Worker (String name){
		this.name = name;
		Random r = new Random();
		this.age = r.nextInt(48)+18; // entre 18 y 65
	}

	public int getAge(){
		return age;
	}

	public String getName(){
		return name;
	}

	@Override
	public String toString(){
		return "[ name = "+ this.name+" age = "+this.age+" ]";
	}


}
