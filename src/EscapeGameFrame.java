import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class that creates a new game frame
 * @author Tatiana Braginets
 *
 */
public class EscapeGameFrame extends JFrame
{
	

	public EscapeGameFrame(int w, int h, Map map, Player p)
	{
		setSize(w, h);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    MapPanel panel = new MapPanel(map, p);
	    panel.addKeyListener(new GameController(map, p));
	    this.add(panel);
	    map.addObserver(panel);
	}

	
}
