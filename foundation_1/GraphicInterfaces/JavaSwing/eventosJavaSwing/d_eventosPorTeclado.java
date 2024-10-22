package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 -> Para leer del teclado es necesario registrar un objeto (listener)que se encargue de escuchar si una tecla es
 presionada. Para escuchar este tipo de eventos JAVA nos ofrece la interfaz KeyListener.

 @Metodos
 -> keyPressed(KeyEvent e) -> se invoca cuando se presiona una tecla cualquiera.
 -> keyReleased(KeyEvent e) -> se invoca cuando se suelta una tecla.
 -> keyTyped(KeyEvent e) -> se invoca cuando una tecla escriba un carácter unicode, no se invoca con caracteres
    espaciales, por ejemplo la tecla Ctrl

 Para añadir el KeyListener se hace a través del método addKeyListener() -> recibe como parámetro una instancia de un
 objeto que implementa la interfaz KeyListener. -> no es una interfaz funcional (tiene tres métodos) por tanto el uso
 de una lamda no es permitido. -> El orden de los eventos importa (keyPressed -> keyTyped -> keyReleased) este es el
 orden de ejecución.
 */
public class d_eventosPorTeclado {

	public static void main(String[] args){
		JFrame window = new JFrame();
		window.setSize(400,200);

		window.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e){
				System.out.println("You have written something "+ e.getKeyChar());
			}

			@Override
			public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) System.out.println("You have pressed the key -> ");
				if(e.getKeyCode() == KeyEvent.VK_LEFT) System.out.println("You have pressed the key <- ");
				if(e.getKeyCode() == KeyEvent.VK_DOWN) System.out.println("You have pressed the key ↓ ");
				if(e.getKeyCode() == KeyEvent.VK_UP) System.out.println("You have pressed the key ↑");
			}

			@Override
			public void keyReleased(KeyEvent e){
				System.out.println("You haves released the key "+e.getKeyChar());
			}
		});

		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
