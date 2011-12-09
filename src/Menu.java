import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Menu extends JPanel {
	
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

	public String getIndices() {
		return indices;
	}



	public void setIndices(String indices) {
		this.indices = indices;
	}



	private String indices;
}
