package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrettingButton implements ActionListener {
	int counter = 0;
	@Override
	public void actionPerformed(ActionEvent e){

		System.out.println("Hello from first button "+ ++counter);
	}


}
