package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

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
		window.setSize(500, 500);

		// Preparando contenedores de imagen
		BufferedImage originalImageCar = null;
		BufferedImage originalImageWarning = null;
		BufferedImage originalImageURL = null;


		try{
			// creando buffer de imagen
			originalImageCar = ImageIO.read(new File("/home/mevelezs/Pictures/car.jpg"));
			originalImageWarning = ImageIO.read(new File("/home/mevelezs/Pictures/warning.jpg"));
			originalImageURL = ImageIO.read(new URL("https://www.shutterstock" +
					".com/shutterstock/photos/2506761705/display_1500/stock-vector-cow-logo-cow-farm-product-logo-design-vector-vintage-cattle-angus-beef-logo-2506761705.jpg"));


		} catch ( IOException e ){
			throw new RuntimeException(e);
		}

		// escalando imagen e intanciando elemento con imagen escalada
		Image scaledImageCar= originalImageCar.getScaledInstance(40, 20, Image.SCALE_SMOOTH);
		JLabel label1 = new JLabel(new ImageIcon(scaledImageCar));

		Image scaledImageWarning = originalImageWarning.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    JButton button = new JButton("Click", new ImageIcon(scaledImageWarning));
		button.setFocusable(false); // quita el foco del boton
		button.addActionListener(e -> System.out.println("Click button"));

		Image scaledImageURL = originalImageURL.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		JLabel label2 = new JLabel(new ImageIcon(scaledImageURL));


  	window.add(button);
		window.add(label1);
		window.add(label2);
		window.setLayout(new FlowLayout());
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
