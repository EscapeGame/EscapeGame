import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * Class to create panel to display inventory
 * @author Tatiana Braginets
 *
 */
public class InventoryPanel extends JPanel implements Observer
{

	/**
	 * Create new inventory panel
	 * @param p player object
	 */
	public InventoryPanel(Player p)
	{
		super(new BorderLayout());
		this.setBackground(Color.BLACK);
		player = p;
		menu = player.getInventoryMenu();
		this.add(menu, BorderLayout.WEST);
	}
	
	public void paintComponent(Graphics g)
	{
      super.paintComponent(g);
	}
	
	public void update(Observable obj, Object o) 
	{
		this.remove(menu);
		menu = player.getInventoryMenu();
		this.add(menu, BorderLayout.WEST);
		repaint();	
	}


	private Player player;
	private Menu menu;
}
