import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;


public class InventoryPanel extends JPanel implements Observer
{

	public InventoryPanel(Player p)
	{
		super(new BorderLayout());
		this.setBackground(Color.BLACK);
		player = p;
		inventory = player.getInventory();
		menu = inventory.getMenu();
		this.add(menu, BorderLayout.WEST);
		/*this.add(new JPanel(){
				public void paintComponent(Graphics g)
				{
					Graphics2D g2 = (Graphics2D) g;
					g2.setColor(Color.WHITE);
				    g2.drawString("Current armor: ", 40, 20);
				}
				}
		);*/
	    //requestFocus(true);
	}
	
	public void paintComponent(Graphics g)
	{
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.WHITE);
	    g2.drawString("Current armor: ", 200, 20);
	    g2.drawString("Current weapon: ", 200, 50);
	}
	
	public void update(Observable obj, Object o) 
	{
		this.remove(menu);
		menu = inventory.getMenu();
		this.add(menu, BorderLayout.WEST);
		repaint();	
	}

	private Inventory inventory;
	private Player player;
	private Menu menu;
	private Armor currArmor;
	private Weapon currWeapon;
}
