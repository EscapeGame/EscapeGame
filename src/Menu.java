import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Popup menu.
public class Menu extends JPanel implements KeyListener {
	
	public Menu(ArrayList<?> choices) 
	{
	      setPreferredSize(new Dimension(200, 200));
	      setLayout(new GridLayout(10, 1));
	      add(new JLabel("Choose a skill."));
	      
	      for(int i = 0; i < choices.size(); i++)
	      {
	    	  add(new JLabel("[" + (i+1) +  "] " + choices.get(i).toString()));
	      }
	}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
