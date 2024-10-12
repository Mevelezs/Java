package ficheros.javaIO.serializacion;

import java.io.Serializable;
import java.util.ArrayList;

public class Grupo implements Serializable {
  private String nombre;
	private ArrayList<Alumno> alumos;

	public Grupo(String nombre){
		this.nombre = nombre;
		this.alumos = new ArrayList<>();
	}

	public ArrayList <Alumno> getAlumos(){
		return alumos;
	}

	public  void agregarAlumnos (Alumno a){
    alumos.add(a);
	}

	public void mostrarAlumnos (){
		for ( Alumno a: alumos ){
			System.out.println(a);
		}
	}
}
