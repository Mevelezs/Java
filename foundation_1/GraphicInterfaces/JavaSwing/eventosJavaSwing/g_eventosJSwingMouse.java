package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 @MouseListener -> Es la interfaz que se usa para recibir eventos del ratón (clicks, movimientod del ratón, arrastrat
 y soltar)

 @Métodos
 -> mouseClicked(MouseEvent e) -> Se activa cuando se hace click en un componente que tiene asociado el MouseListener
 -> mosePressed(MouseEvent e) -> Cuando se presione el botón del ratón
 -> mouseReleased(MouseEvent e) -> Cuando se suelta.
 -> mouseEntered(MouseEvent e) -> Cuando el cursor entra en la zona del componente
 -> mouseExited(MouseEvent e) -> Cuando el cursor sale de la zona del componente.

 Para añadir la el MouseListener a un componente se debe hacer por medio del mátodo addMouseListener(), el cual
 recibe como parámetro una instancia de un objeto que implemente la interfaz MouseListener.

 Orden de ejecución de los eventos -> mousePressed -> moseReleased -> mouseClicked
 */
public class g_eventosJSwingMouse {

	public static void main(String[] args){
		JFrame window = new JFrame();
		BufferedImage image = null;

		try{
			image = ImageIO.read(new File("/home/mevelezs/Pictures/car.jpg"));
		} catch ( IOException e ){
			throw new RuntimeException(e);
		}

		Image scaledImage = image.getScaledInstance(image.getWidth()/2, image.getHeight()/2, Image.SCALE_SMOOTH);
    JLabel label = new JLabel(new ImageIcon(scaledImage));

		label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e){
				System.out.println("Has pulsado en la imagen "+"("+e.getX()+", "+e.getY()+" )");
			}

			@Override
			public void mousePressed(MouseEvent mouseEvent){
				System.out.println("Has pulsado con el foco en la imagen");
			}

			@Override
			public void mouseReleased(MouseEvent mouseEvent){
				System.out.println("Has soltado el botón");
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent){
				System.out.println("Has entado en la imagen");
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent){
				System.out.println("Has salido de la imagen");
			}
		});
		window.setSize(image.getWidth()+2, image.getHeight()+2);
		window.setLayout(new FlowLayout());
		window.add(label);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
