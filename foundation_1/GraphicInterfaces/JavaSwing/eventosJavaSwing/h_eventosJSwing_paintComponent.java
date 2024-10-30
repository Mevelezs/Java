package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.swing.*;

/**
 El método pintComponent(Graphics g) se llama automaticamente pos Swing cuando cree que es necesario volver a dibujar
 un componente -> Cuando se hace visible por primera vez, cuando se redimensiona la ventana, cuando el componente se
 ha invalidado (por ejemplo llamando al método repaint())

 El parámetro Graphics g que se pasa como parámetro al paintComponent es el contexto grafico en el que se realizan
 las operaciones de dibujo.
 @metodos
   -> setColor(Color c) -> Establece el color actual en el contexto -> todos los métodos de dibujo que siguen usarán
      el color
   -> getColor() -> Devuelve el color actual utilizado por ese componente.
   -> setFont(Font font) -> Establece la fuente actual del contexto grafico -> todos los métodos de dibujo que siguen usarán
      el fuente
   -> getFont() ->  Devuelve el fuente actual utilizado por ese componente.
   -> drawString(String str, int x, int y) -> Dibuja el texto representado por str en la posición dada x e y
   -> dawLine(int x1, int y1, int x2, int y2) -> Dibuja una linea desde la posición (x1, y1) hasta (x2, y2)
   -> drawRect(int x1, int y1, int width, int height) -> Dibuja un rectangulo.
   -> fillRect(int x1, int y1, int width, int height) -> Dibuja un rectangulo relleno.
   -> drawOval(int x1, int y1, int width, int height) -> Dibuja un elipse.
   -> fillOval(int x1, int y1, int width, int height) -> Dibuja un elipse rellena.
   -> drawArc(int x1, int y1, int width, int height, int starAngle, int arcAngle) -> Dibuja un sector circular.
   -> fillArc(int x1, int y1, int width, int height, int starAngle, int arcAngle) -> Dibuja un sector circular rellena.
   -> drawPolygon(Polygon p) -> Dibuja un poligono.
   -> fillPolygon(Polygon p) -> Dibuja un poligono relleno.
 */
public class h_eventosJSwing_paintComponent {

	public static void main(String[] args){

     JFrame window = new JFrame("Figures");
     window.add(new paintingFigures());
     window.setSize(400, 400);
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     window.setVisible(true);

     JFrame window2 = new JFrame("Repaint with clock");
     repaintHour panel = new repaintHour();
     window2.add(panel);

     window2.setSize(400, 200);
     window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     window2.setVisible(true);

    Timer clock = new Timer(1000, e -> panel.repaint());
    clock.start();
	}

}
