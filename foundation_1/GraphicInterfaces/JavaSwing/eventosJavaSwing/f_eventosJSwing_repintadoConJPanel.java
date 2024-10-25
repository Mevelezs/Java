package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class f_eventosJSwing_repintadoConJPanel {

	public static void main(String[] args){
		try{
				// obteniendo la imagen
				URL urlImage = new URL("https://decimodan.com/skills/java.png");
				BufferedImage image = ImageIO.read(urlImage);

				JFrame window = new JFrame();
				window.setSize(image.getWidth(),image.getHeight());

				// Panel pesonalizado para manejar el dibujado
				JPanel panel = new JPanel(){
					@Override
	        protected void paintComponent (Graphics g){
						super.paintComponent(g);
						g.drawImage(image,0, 0, this.getWidth(), this.getHeight(), this);
					}
				};

				window.add(panel);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setVisible(true);
			} catch ( IOException e ){
			System.out.println("Erroe al cargar la imagen "+ e);
			}
	}
}
