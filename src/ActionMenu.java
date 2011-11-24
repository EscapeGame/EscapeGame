import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

// Popup menu.
public class ActionMenu extends JFrame implements KeyListener {
	
	public ActionMenu(ArrayList<Action> actions) 
	{
	      setSize(200, 200);
	      setLocationRelativeTo(null);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setLayout(new GridLayout(10, 1));
	      add(new JLabel("Choose a skill."));
	      
	      for(int i = 0; i < actions.size(); i++)
	      {
	    	  add(new JLabel("[" + (i+1) +  "] " + actions.get(i).getName()));
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
