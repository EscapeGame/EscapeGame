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
public class Menu extends JPanel implements KeyListener {
	
	public Menu(ArrayList<?> choices) 
	{
		this.choices = choices;
		
	      setSize(200, 200);
	      setBackground(Color.BLACK);
	      setLayout(new GridLayout(10, 1));
	      setBorder(BorderFactory.createLineBorder(Color.WHITE));
	      JLabel title = new JLabel("Choose a skill.");
	      title.setOpaque(true);
	      add(title);
	      
	      for(int i = 0; i < choices.size(); i++)
	      {
	    	  JLabel label = new JLabel("[" + (i+1) +  "] " + choices.get(i).toString());
	    	  label.setForeground(Color.WHITE);
	    	  add(label);
	      }
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		switch(key) {
		case '1':
			setChoice(choices.get(0));
			break;
		case '2':
			setChoice(choices.get(1));
			break;
		}
	}
	
	public Object getChoice() {
		return choice;
	}

	public void setChoice(Object choice) {
		this.choice = choice;
	}

	private ArrayList<?> choices;
	private Object choice;
}
