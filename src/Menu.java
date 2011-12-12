import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class to create menus
 * @author Sally Calpo
 *
 */
public class Menu extends JPanel {
	
	/**
	 * Constructs new menu
	 * @param choices ArrayList of menu choices
	 * @param title menu title
	 * @param indices menu indices
	 */
	public Menu(ArrayList<?> choices, String title, String indices) 
	{	
		this.indices = indices;
		
	      setSize(500, 500);
	      setBackground(Color.BLACK);
	      setLayout(new GridLayout(10, 1));
	      setBorder(BorderFactory.createLineBorder(Color.WHITE));
	      JLabel header = new JLabel(title);
	      header.setOpaque(true);
	      add(header);
	            
	      for(int i = 0; i < choices.size(); i++)
	      {
	    	  JLabel label = new JLabel("[" + (char)(indices.charAt(i)) +  "] " + choices.get(i).toString());
	    	  label.setForeground(Color.WHITE);
	    	  add(label);
	      }
	}

	/**
	 * Gets indices
	 * @return
	 */
	public String getIndices() {
		return indices;
	}

	/**
	 * Sets indices
	 * @param indices menu indices
	 */
	public void setIndices(String indices) {
		this.indices = indices;
	}

	private String indices;
}
