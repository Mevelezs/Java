package GraphicInterfaces.JavaSwing;

import javax.swing.*;

/**
 @CONTENEDORES
  -> JFRAME -> Contenedor principal que se trata de una ventana completa con titulo, iconos y botones especificos. Un
    JFrame no admite una ventana como padre.
 -> JPanel -> Es un contenedor que se incluye dentro de un marco para organizar un grupo de elementos. Es un
    contenedor secundario por ende tiene que estar dentro de un JFrame.
 -> JDialog -> Es una ventana emergente que se suele utilizar para mostrar mensajes. No es una venetana completamente
    funcional como un marco. Siempre admitirá como padre otro JDialog o JFrame -> Las ventanas emergentes siempre
    estarán encima del padre.

 Acciones a realizar cunado una ventana se cierre > Cuando las ventanas se cierran el programa no se detiene.
 Se toma acción a treavez del método setDefaultCloseOperation(JFrame...) de la clase  JFrame pasandole la orden.
 -> EXIT_ON_CLOSE => Cierra la aplicación al cerrar la ventana.
 -> DISPOSE_ON_CLOSE => Elimina la ventana al cerrarla.
 -> HIDE_ON_CLOSE => Oculta la ventana al cerrrarla.

 */
public class Main {

  public static void main(String[] args){
    JFrame window = new JFrame("My first window");
    window.setVisible(true); // para que la ventana sea visible
    window.setSize(800, 400);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}
