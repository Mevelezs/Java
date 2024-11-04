package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Existen varios tipos de ventanas emergentes para ineractuar con el usuario
 *
 * @JOptionPane -> Permite mostrar un mensaje, un icono y un conjunto de botones al usuario -> hay varios tipos que
 * mostraran ventanas diferentes.
 * -> showMessageDialog( Componente parentComponent, Object message) -> muestra un mensaje al usuario y puede ser
 * solo texto -> hereda las caracteristicas del padre (iconos) y se centra en el tambuen se puede hacer con el
 * padre null.
 * -> showConfirmDialog( Componente parentComponent, Object message ) -> muestra mensaje y botones para que el
 * usuario confirme o niegue -> devuelve un entero según la respuesta.
 * -> showInputDialog( Componente parentComponent, Object message ) -> muestra mensaje y proporciona un campo de
 * entrada para que el usurario introduzca datos.
 * -> showOptionDialog( Componente parentComponent, Object message, String title, int optionType, int messageType,
 * Icon icon, Object[] options,, Object initiaValue ) -> Proporciona una ventana emergente personalizable que
 * puede incluir, un mensaje, un icono y una serie de botones que se especifican en el parámetro options.
 * @JDialog -> Es una ventana emergente que puede contener cualquier tipo de componente de JavaSwing -> Es personalizable -> puede hacer
 * que sea modal o no (bloquea o no la ejecución)
 * @JPopupMenu -> Se usa para proporcionar un menú al usuario cuando se hace una acción como click derecho en el mouse -> puede contener
 * cualquier componente de Java Swing -> pero generalmente son JMenuItem -> son basicamente botones.
 */
public class j_eventos_JSwing_ventanasEmergentes {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_PURPLE = "\u001B[34m";
    private static final String ANSI_BLUE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private static Color currentColor = Color.BLACK; // Declaración como atributo de clase
    private static final int diameter = 200;

    public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "Information message", "Info", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "Error message", "Error", JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(null, "Warning message", "Warning", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null, "¿Are you sure?", "Question", JOptionPane.QUESTION_MESSAGE);
//**********************************************************************************************************
    	// Enetrada de datos
		String name = JOptionPane.showInputDialog("Write your name");
		if(name != null) System.out.println("Welcome "+name+"!");

		// generando conjunto de opciones para que el usuario elija
		int answer = JOptionPane.showConfirmDialog(null, "Do you want to continue?");
		if(answer == JOptionPane.YES_NO_OPTION) System.out.println( "You have chosen "+ANSI_GREEN+ " YES"+ ANSI_RESET);
		else if (answer == JOptionPane.NO_OPTION) System.out.println("You have chosen "+ANSI_RED+ " NO"+ ANSI_RESET);
		else System.out.println(ANSI_PURPLE+" You have not chosen any option!");

//**********************************************************************************************************
		//Conjunto de opciones para que el usuario elija

		Object[] options = {"White", "Red", "Green", "Yellow", "Blue", "Purple", "Cyan", "Black"};
		int selection = JOptionPane.showOptionDialog(null, "Select Color", "Colors", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, options, options[0] );

		switch (selection){
			case 0 -> System.out.println("You have selected the color " + ANSI_WHITE + options[selection] + ANSI_RESET);
			case 1 -> System.out.println("You have selected the color " + ANSI_RED + options[selection] + ANSI_RESET);
			case 2 -> System.out.println("You have selected the color " + ANSI_GREEN + options[selection] + ANSI_RESET);
			case 3 -> System.out.println("You have selected the color " + ANSI_YELLOW + options[selection] + ANSI_RESET);
			case 4 -> System.out.println("You have selected the color " + ANSI_PURPLE + options[selection] + ANSI_RESET);
			case 5 -> System.out.println("You have selected the color " + ANSI_CYAN + options[selection] + ANSI_RESET);
			case 6 -> System.out.println("You have selected the color " + ANSI_BLACK + options[selection] + ANSI_RESET);
			case 7 -> System.out.println("You have selected the color " + ANSI_BLUE + options[selection] + ANSI_RESET);
			default -> System.out.println("You have not selected any color");
		}
//*******************************************************************************************************
		JFrame window = new JFrame("Principal window");
		window.setSize(400, 400);
		window.setLayout(new FlowLayout());

		JDialog dialog = new JDialog();
		dialog.setTitle("Simple Dialog");
		dialog.setLayout(new FlowLayout());
		dialog.setSize(500,200);
		dialog.add(new JLabel("This is a simple JDialog and modal"));
		dialog.setLocationRelativeTo(window); //  centra el JDialog

		JButton okButton = new JButton("OK");
		JButton cancelButton = new JButton("Cancel");

		okButton.addActionListener(e -> System.out.println("You pressed 'OK'"));
		cancelButton.addActionListener(e -> {
			System.out.println("You pressed 'Cancel'");
			dialog.dispose(); // cierra la ventana
		});

		okButton.setFocusable(false);
		cancelButton.setFocusable(false);

		dialog.add(okButton);
		dialog.add(cancelButton);
        dialog.setModal(true);// lo convierte en una modal

		window.setVisible(true); // estas posiciones son importantes para que se muestren los dos -> LAs dos ventanas son independientes,
		// no se puede agregar el JDialog en un JFrame
		dialog.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//*******************************************************************************************************************
        // Creando un PopupMenu con las opciones de colores

        JFrame window2 = new JFrame("JPopupMenu colors");
        window2.setSize(400, 400);
        window2.setLocationRelativeTo(null); // centra el JFrame a la pantalla

        JPopupMenu colorMenu = new JPopupMenu();

        JMenuItem red = new JMenuItem("RED");
        red.addActionListener(e -> {
            currentColor = Color.RED;
            window2.repaint();
        });
        JMenuItem green = new JMenuItem("GREEN");
        green.addActionListener(e -> {
            currentColor = Color.GREEN;
            window2.repaint();
        });

        JMenuItem blue = new JMenuItem("BLUE");
        blue.addActionListener(e -> {
            currentColor = Color.BLUE;
            window2.repaint();
        });

        colorMenu.add(red);
        colorMenu.add(green);
        colorMenu.add(blue);


        // Crear el panel de dibujo
        window2.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(currentColor);
                g.fillOval((getWidth() - diameter) / 2, (getHeight() - diameter) / 2, diameter, diameter);
            }
        });

        // Agregar escuchador de ratón para el menú emergente
        window2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    colorMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    colorMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        window2.setVisible(true);
        window2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}