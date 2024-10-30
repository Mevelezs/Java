package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class repaintHour extends JPanel {

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		LocalDateTime currentlyHour = LocalDateTime.now();

		DateTimeFormatter formattingHour = DateTimeFormatter.ofPattern("HH:mm:ss");
		String textHour = currentlyHour.format(formattingHour);

		g.setFont(new Font("Arial", Font.BOLD, 18));
		g.setColor(Color.BLUE);
		g.drawString("Hello world the hour is "+textHour, 50, 50);

	}


}
