package herncia;

public class Hija extends  Padre{
  private int edad;
  private String nameHija;

  public Hija (String nombre, int edad,  String nameHija){
    super(nombre);
    this.edad = edad;
    this.nameHija = nameHija;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public void mostrarInfo () {

    System.out.println(super.nombre + " tiene una hija, " + nameHija + " de " + edad + " años. ");
  }
}
