import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class to crate message bar
 * @author Sally Calpo
 *
 */
public class MessageBar extends JPanel {

	/**
	 * Constructs new message bar
	 * @param w bar width
	 * @param h bar height
	 * @param message message to print in the message bar
	 */
	public MessageBar(int w, int h, String message)
	{
		setPreferredSize(new Dimension(w, h));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(Color.BLACK);
		label = new JLabel(message);
		label.setForeground(Color.WHITE);
		add(label);
	}
	
	/**
	 * Prints message in the message bar
	 * @param text message to print
	 */
	public void printMessage(String text)
	{
		label.setText(text);
	}
	
	private JLabel label;
}
