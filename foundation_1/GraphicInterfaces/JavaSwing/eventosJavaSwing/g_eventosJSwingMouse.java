package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		JLabel labelImage = new JLabel(new ImageIcon("/home/mevelezs/Pictures/car.jpg"));
		labelImage.addMouseListener(new MouseListener() {

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
	}
}
