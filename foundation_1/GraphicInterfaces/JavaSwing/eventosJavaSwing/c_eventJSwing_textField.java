package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.swing.*;
import java.awt.*;

public class c_eventJSwing_textField {

	public static void main(String[] args){
		JFrame window = new JFrame("Text Fied Window");
		window.setSize(400,200);
		window.setLayout(new FlowLayout());

		JTextField textField = new JTextField(20); // ancho o num de col
		JButton button = new JButton("Get text by console");

		button.addActionListener(e -> System.out.println(textField.getText()));

		window.add(textField);
		window.add(button);

		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
