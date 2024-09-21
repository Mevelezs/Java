package herncia;

public class Padre {
  protected String nombre;

  public Padre (String nombre){
     this.nombre = nombre;

  }

  public void mostrarInfo(){
    System.out.print( nombre );
  }
}
