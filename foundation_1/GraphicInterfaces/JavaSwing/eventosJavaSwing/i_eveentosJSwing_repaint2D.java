package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.swing.*;

/**
 Graphics2d -> Es una clase que hereda de graphics -> ofrece capasidades mas extensas de dibujo
 @métodos
 -> rotate(double theta) -> Rota alrededor del angulo proporcionado el punto dado. -> todos los métodos de dibujo que
    siguen usaran esta rotación.
 -> scale(double sx, double sy) -> Escala multiplicando por sx y sy las coordenadasd del dibujp.
 -> serStroke(Stroke s) -> se utiliza para establecer el trazado que define como se dubujan las lineas y curvas ->
    Stroke es una interfaz, cuya implementación básica es BasicStroke -> genera distintos tipos de trazos tanto en
    lineas como en las terminaciones.
 -> GradientPaint(float x1, float y1, Color color1, float x2, float y2, Color color2 ) -> Crea un gradiente lineal a
    lo largo de la linea degfinida por los puntos dado con los colores dados -> pinta una transicion de colores entre
    puntos.
 */
public class i_eveentosJSwing_repaint2D {

	public static void main(String[] args){

    JFrame window = new JFrame("Graphics 2D");
    window.add(new paintingBorderFigures());
    window.setSize(400, 400);
    window.setVisible(true);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
