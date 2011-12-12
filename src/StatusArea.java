import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;

/**
 * Class to create status area
 * @author Sally Calpo
 *
 */
public class StatusArea extends JTextArea {

	/**
	 * Constructs new status area
	 * @param w status area width
	 * @param h status area height
	 */
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
