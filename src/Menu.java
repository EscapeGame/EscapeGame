import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MessageBar extends JPanel {

	public MessageBar(int w, int h, String message)
	{
		setPreferredSize(new Dimension(w, h));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(Color.BLACK);
		label = new JLabel(message);
		label.setForeground(Color.WHITE);
		add(label);
	}
	
	public void printMessage(String text)
	{
		label.setText(text);
	}
	
	private JLabel label;
}
