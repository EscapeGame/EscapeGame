import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;


public class StatusArea extends JTextArea {

	public StatusArea(int w, int h)
	{
		setForeground(Color.WHITE);
		setPreferredSize(new Dimension(w, h));
		setEditable(false);
		setCursor(null);
		setOpaque(false);
		setFocusable(false);
	}
}
