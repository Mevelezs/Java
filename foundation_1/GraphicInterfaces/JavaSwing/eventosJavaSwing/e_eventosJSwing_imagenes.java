package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 EL uso de imagenes en Java Swing se basa en la clase imageIcon -> Permite cargar imagenes en formato JPEG, PNG,
 entre otros -> La imagen se puede mostrar directamente ne componetes como JLabel, JButton, etc, o se puede pintar en
 un panel con la ayuda del método drawImage() de la clase  Graphics.
 -> Para escalar y/o redimensionar las imagenes usamos una clase de java.jwt.Image -> es abstracta (no se puede
 hacer instancias) -> usamos sus métodos despues de llamarla

 @Métodos
 -> getScaledInstance(int width, int height, int hints) -> para escalar las imagenes -> devuelve una imagen escalada
    -> usa constantes para definir el tipo de escalado (parámetro hints) -> (SCALE_DEFAULT,SCALE_FAZT, sCALE_SMOOTH,
      SCALE_REPLICATED, SCALE_AREA_AVERAGING).
 -> getWidth(), getHeight() -> obtener las dimensiones de la imagen.
 -> flush() -> para limpiar los recursos usados por la imagen.

 Debido a que Image es abstracta , a menudo trabajaremos con subclases de Image
 -> BufferedImage -> perminte la manipulación directa de pixeles e imagen y se utiliza para imagenes en memoria.
 -> VolatileImage -> Se utiliza para imagenes que pueden ser aceleradas por hardware. Esto significa que la imagen se
    almacena en la tarjeta gráfica en lufgar de la mempria dle sistema.
 */
public class e_eventosJSwing_imagenes {

	public static void main(String[] args){
		JFrame window = new JFrame("Image window");
		window.setSize(800, 400);

		// Preparando contenedores de imagen
		BufferedImage originalImageCar = null;
		BufferedImage originalImageWarning = null;
		try{
			// creando buffer de imagen
			originalImageCar = ImageIO.read(new File("/home/mevelezs/Pictures/car.jpg"));
			originalImageWarning = ImageIO.read(new File("/home/mevelezs/Pictures/warning.jpg"));

		} catch ( IOException e ){
			throw new RuntimeException(e);
		}

		// escalando imagen e intanciando elemento con imagen escalada
		Image scaledImageCar= originalImageCar.getScaledInstance(40, 20, Image.SCALE_SMOOTH);
		JLabel label = new JLabel(new ImageIcon(scaledImageCar));

		Image scaleImageWarning = originalImageWarning.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    JButton button = new JButton("Click", new ImageIcon(scaleImageWarning));
		button.setFocusable(false); // quita el foco del boton

  	window.add(button);
		window.add(label);
		window.setLayout(new FlowLayout());
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
