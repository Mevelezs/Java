package ficheros.javaIO.serializacion;

import java.io.Serializable;

public class Alumno implements Serializable {
  private String nombre;
	private String nia;
	private int edad;


	public Alumno(String name, String nia, int age){
		this.nombre = name;
		this.nia = nia;
		this.edad = age;
	}

	public String getNombre(){
		return nombre;
	}

	public String getNia(){
		return nia;
	}

	public int getEdad(){
		return edad;
	}

	@Override
	public String toString(){
		return "Alum{" + "nombre='" + nombre + '\'' + ", nia='" + nia + '\'' + ", edad=" + edad + '}';
	}

}
