package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class a_eventosJavaSwing_botones {

	/**
	 * > Para conectarnos a los eventos se usan interfaces, una de las mas usadas en ActionListener que tiene un único
	 * método addActionListener() el cual se aplica a los componentes los cuales JAVA determin a la acción por defecto.
	 * EJ: Pare el JButton -> click, JTextField -> pulsar INTO, JComboBox -> seleccionar una opción ...
	 */
	public static void main(String[] args){
		// Primera forma -> usando una clase que implementa (ActionListener -> su metodo actionPerformed pasandole el
		// ActionEvent) y pasandole una instancia al botón desde su metodo addActionListener()
		JFrame window = new JFrame("Components window");
		window.setLayout(new FlowLayout());
		window.setSize(700, 400);

		JButton button = new JButton("First Form");
		button.addActionListener(new GrettingButton());

    window.add(button);

		// Segunda forma -> Sin instanciar una clase externa aplicamos el evento dentro del boton -> invocamon el
		// metodo addActionListener del botón -> le pasamos una instancia de ActionListener como parametro -> dentro del
		// ActionListener invocamos el metodo actionPerformed pasandole el ActionEvent

		JButton button2 = new JButton("Second Form");
		button2.addActionListener(new ActionListener() {
			int count = 0;
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("Hello from second Button "+ ++count);
			}
		});

		window.add(button2);

		// Tercera forma -> Lo hacemos con una lamda
		JButton button3 = new JButton("Third form");

		AtomicInteger count = new AtomicInteger();
		button3.addActionListener(e -> System.out.println("Hello from Third Button "+ count.incrementAndGet()));

    window.add(button3);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
