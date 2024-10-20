package GraphicInterfaces.JavaSwing;

import javax.swing.*;
import java.awt.*;

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

 @LAYOUTS
 -> LatoutManager -> Un objeto que implementa esta interfaz se usa para controlar la forma en que se distribuyen los
   componentes.
   -> FlowLayout -> Coloca los componentes en una línea horizontal, uno al lado del otro (de izquierda a derecha), y
     cuando no caben en una sola fila, empiezan a colocarse en una nueva fila (de arriba a abajo).
     Alineación => Puedes especificar la alineación (izquierda, centro, derecha) y el espacio entre los componentes.
     Uso común: Es el layout por defecto de los paneles (JPanel). Panel panel = new JPanel(new FlowLayout());

 -> BorderLayout -> Divide el contenedor en cinco áreas: Norte (NORTH), Sur (SOUTH), Este (EAST), Oeste (WEST), y
     Centro (CENTER). Puedes añadir componentes en cualquiera de estas regiones, y el componente en el centro toma el
     espacio restante. Características => Solo puede haber un componente en cada área. Uso común: Ideal para crear
     interfaces con un área central importante y paneles o botones alrededor.
       JFrame frame = new JFrame();
       frame.setLayout(new BorderLayout());

   -> GridLayout -> Organiza los componentes en una cuadrícula (filas y columnas). Todos los componentes tienen el
      mismo tamaño y ocupan una celda en la cuadrícula. Uso común: Se usa cuando necesitas una disposición regular y
      uniforme de los componentes. JPanel panel = new JPanel(new GridLayout(2, 3)); // 2 filas, 3 columnas

   -> GridBagLayout -> Es una de las disposiciones más flexibles. Permite organizar los componentes en una cuadrícula
      pero con la capacidad de especificar restricciones para cada componente, como su tamaño relativo, alineación,
      expansión, etc. Características => Es complejo pero muy poderoso. Cada componente puede ocupar más de una celda,
      y su tamaño puede cambiar dinámicamente. Uso común: Cuando se requiere un control preciso sobre la colocación y
      el tamaño de los componentes. JPanel panel = new JPanel(new GridBagLayout());

   -> BoxLayout -> Organiza los componentes en una sola fila (horizontal) o en una sola columna (vertical).
      Uso común => Ideal para disponer componentes en una secuencia vertical u horizontal, por ejemplo, botones
      alineados en un panel.
       JPanel panel = new JPanel();
       panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Disposición vertical

 -> OverlayLayout -> Superpone los componentes uno encima del otro. El tamaño y la posición de cada componente están
    controlados por las propiedades de los propios componentes. Uso común: Se usa cuando los componentes necesitan
    estar uno sobre otro en capas.
      JPanel panel = new JPanel();
      panel.setLayout(new OverlayLayout(panel));

 -> CustomLayout -> No es un layout predefinido en Java. Un CustomLayout sería una clase que implementa la interfaz
    LayoutManager o LayoutManager2, y define un comportamiento personalizado para organizar los componentes.
    Uso común: Se utiliza cuando ninguno de los layouts existentes satisface los requisitos de diseño, y el
    desarrollador crea su propio layout.

 @COMPONENTES
 -> JLabel -> Crea etiquetas para mostrar texto
 -> JButton -> Crea botones
 -> JTextField -> Permite ingresar una cadena de caracteres por teclado
 -> JTextArea -> Ingresar textos en multi-lineas.
 -> JMenuBar -> Crea un menú horizontal en la parte superior del JFrame -> Se puede combinar con objetos de la clase
    JMenu y la clase JMenuItem
 -> JCheckBox -> Permite seleccionar varias opciones de una lista
 -> JRadioButton -> Seleccionar una opción
 -> JComboBox -> Permite seleccionar una opción de una lista desplegable.
 */
public class Main {

  public static void main(String[] args){
    JFrame window = new JFrame("My first window");
    window.setSize(600, 400);
    window.setLayout(new FlowLayout());

    JButton button = new JButton("Click");
    window.add(button);

    JLabel label = new JLabel("This is a Label");
    window.add(label);

    JTextField textField = new JTextField("This is a TextField");
    window.add(textField);

    JCheckBox checkBox = new JCheckBox("CheckBox");
    window.add(checkBox);
    JCheckBox checkBox2 = new JCheckBox("CheckBox 2");
    window.add(checkBox2);


    //Creando botones
    JRadioButton radioButton1 = new JRadioButton("Radio Button 1");
    JRadioButton radioButton2 = new JRadioButton("Radio Button 2");
    JRadioButton radioButton3 = new JRadioButton("Radio Button 3");

    // creando dependencia entre los botones
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(radioButton1);
    buttonGroup.add(radioButton2);
    buttonGroup.add(radioButton3);

    // Agregando los botones a la ventana
    window.add(radioButton1);
    window.add(radioButton2);
    window.add(radioButton3);


    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("This is a Menu");
    menu.add(new JMenuItem("Option 1"));
    menu.add(new JMenuItem("Option 2"));
    menu.add(new JMenuItem("Option 3"));

    JMenu menu2 = new JMenu("This is the menu 2");
    menu2.add(new JMenuItem("Option 2.1"));
    menu2.add(new JMenuItem("Option 2.2"));
    menu2.add(new JMenuItem("Option 2.3"));

    menuBar.add(menu);
    menuBar.add(menu2);
    window.setJMenuBar(menuBar);

    window.setVisible(true); // para que la ventana sea visible - Esto se debe hacer de último
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

}
