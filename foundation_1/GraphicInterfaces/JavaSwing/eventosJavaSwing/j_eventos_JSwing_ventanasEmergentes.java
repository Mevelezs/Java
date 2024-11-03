package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.swing.*;

/**
 Existen varios tipos de ventanas emergentes para ineractuar con el usuario
 @JOptionPane -> Permite mostrar un mensaje, un icono y un conjunto de botones al usuario -> hay varios tipos que
   mostraran ventanas diferentes.
   -> showMessageDialog( Componente parentComponent, Object message) -> muestra un mensaje al usuario y puede ser
         solo texto -> hereda las caracteristicas del padre (iconos) y se centra en el tambuen se puede hacer con el
         padre null.
   -> showConfirmDialog( Componente parentComponent, Object message ) -> muestra mensaje y botones para que el
         usuario confirme o niegue -> devuelve un entero según la respuesta.
   -> showInputDialog( Componente parentComponent, Object message ) -> muestra mensaje y proporciona un campo de
         entrada para que el usurario introduzca datos.
   -> showOptionDialog( Componente parentComponent, Object message, String title, int optionType, int messageType,
         Icon icon, Object[] options,, Object initiaValue ) -> Proporciona una ventana emergente personalizable que
         puede incluir, un mensaje, un icono y una serie de botones que se especifican en el parámetro options.

 @JDialog
 @JPopupMenu
 */
public class j_eventos_JSwing_ventanasEmergentes {

	public static void main(String[] args){
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_BLACK= "\u001B[30m";
		final String ANSI_RED= "\u001B[31m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_YELLOW= "\u001B[33m";
		final String ANSI_BLUE= "\u001B[34m";
		final String ANSI_PURPLE = "\u001B[35m";
		final String ANSI_CYAN= "\u001B[36m";
		final String ANSI_WHITE= "\u001B[37m";
		//
//		JOptionPane.showMessageDialog(null, "Information message", "Info", JOptionPane.INFORMATION_MESSAGE);
//		JOptionPane.showMessageDialog(null, "Error message", "Error", JOptionPane.ERROR_MESSAGE);
//		JOptionPane.showMessageDialog(null, "Warning message", "Warning", JOptionPane.WARNING_MESSAGE);
//		JOptionPane.showMessageDialog(null, "¿Are you sure?", "Question", JOptionPane.QUESTION_MESSAGE);

    // Enetrada de datos
//		String name = JOptionPane.showInputDialog("Write your name");
//		if(name != null) System.out.println("Welcome "+name+"!");

		// generando conjunto de opciones para que el usuario elija
		int answer = JOptionPane.showConfirmDialog(null, "Do you want to continue?");
		if(answer == JOptionPane.YES_NO_OPTION) System.out.println( "You have chosen "+ANSI_GREEN+ " YES"+ ANSI_RESET);
		else if (answer == JOptionPane.NO_OPTION) System.out.println("You have chosen "+ANSI_RED+ " NO"+ ANSI_RESET);
		else System.out.println(ANSI_PURPLE+" You have not chosen any option!");



	}
}
