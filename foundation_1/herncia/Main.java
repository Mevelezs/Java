package herncia;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    Hija hija = new Hija("Mauricio",30, "Josefa" );
    hija.mostrarInfo();
    hija.setEdad(20);
    hija.mostrarInfo();

    Padre padre = new Padre("Esteban");

    padre.mostrarInfo();
    System.out.println();

    Student firstStudent = new Student("Mauricio", 39);
    System.out.println(firstStudent.getName());
    System.out.println(firstStudent);

    Student secondStudent = new Student("Mauricio", 39);
    Student tirthStudent = firstStudent;
    System.out.println();

    Persona firstPerson = new Persona(45, "Esteban", "Physic");
    System.out.println(firstPerson);
    System.out.println(firstPerson.getName());

    System.out.println("------------------------------------------");
    ArrayList<Persona> personas = new ArrayList<>();

    personas.add(firstPerson);
    personas.add(firstStudent);

    for (Persona p : personas){
      System.out.println(p);
    }

    System.out.println("*******************************************");
    System.out.println(firstPerson.getClass().getName());

    System.out.println("*******************************************");

    // metodo equals reescrito para que ignore la dirección en memoria y los valores y el tipo de objeto de la clase
    if(firstStudent.equals(secondStudent)) System.out.println("true");
    else System.out.println("false");
  }
}
