import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

// Popup menu.
public class Menu extends JPanel {
	
	private final static String CHOICE = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int current = 0;
	
	public Menu(ArrayList<?> choices, String title) 
	{
		/*this.choice = null;
		this.choices = choices;*/
		
	      setSize(500, 500);
	      setBackground(Color.BLACK);
	      setLayout(new GridLayout(10, 1));
	      setBorder(BorderFactory.createLineBorder(Color.WHITE));
	      JLabel header = new JLabel(title);
	      header.setOpaque(true);
	      add(header);
	      
	      for(int i = 0; i < choices.size(); i++)
	      {
	    	  JLabel label = new JLabel("[" + (CHOICE.charAt(i)) +  "] " + choices.get(i).toString());
	    	  label.setForeground(Color.WHITE);
	    	  add(label);
	    	  current = i;
	      }
	}

	/*@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		int index = Integer.parseInt((new Character(key)).toString());
		System.out.println(index);
		setChoice(choices.get(index));
		
	}
	
	public Object getChoice() {
		return choice;
	}

	public void setChoice(Object choice) {
		this.choice = choice;
	}

	private ArrayList<?> choices;
	private Object choice;*/
}
