package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.swing.*;
import java.awt.*;

public class b_eventosJSwing_label {

	public static void main(String[] args){
		JFrame window = new JFrame("Label Window");

		JLabel label = new JLabel("try to press the button");
		JButton button = new JButton("is here");

		button.addActionListener(e -> label.setText("Congratulations... "));

		window.setLayout(new FlowLayout());
		window.setSize(400, 200);
		window.setVisible(true);

		window.add(label);
		window.add(button);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
