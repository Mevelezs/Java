package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.swing.*;
import java.awt.*;

public class paintingFigures extends JPanel {

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		//dibuja reacta harizontal en rojo
		g.setColor(Color.RED);
		g.drawLine(20, 30, 200, 30);

		// dibuja rectangulo
		g.drawRect(50, 50, 200, 100);

		//dibuja ovalo
		g.drawOval(200, 50, 150, 100);

		Polygon triangle = new Polygon();
		triangle.addPoint(50, 200);
		triangle.addPoint(100, 250);
		triangle.addPoint(150, 200);
		g.drawPolygon(triangle);
	}


}
