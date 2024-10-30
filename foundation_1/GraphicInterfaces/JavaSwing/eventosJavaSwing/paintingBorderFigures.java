package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.swing.*;
import java.awt.*;

public class paintingBorderFigures extends JPanel {

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2d = ( Graphics2D ) g;

		// dibuja una linea en rojo con ancho de 5
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(20, 30, 300, 30);

		//dibuja un rectangulo verde de 300x200 rotando 5 grados en la posicion (100,100) y con borde verde con un ancho
		// de 3
		g2d.setColor(Color.GREEN);
		g2d.setStroke(new BasicStroke(3));
		g2d.rotate(Math.toRadians(5));
		g2d.scale(2,2);
		g2d.fillRect(50,50, 150,100);

		g2d.setColor(Color.BLACK);
		g2d.drawRect(50,50, 150,100);

	}


}
