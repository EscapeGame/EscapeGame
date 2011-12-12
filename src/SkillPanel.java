import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * Class to create panel to display skills
 * @author Sally Calpo
 *
 */
public class SkillPanel extends JPanel implements Observer
{
	/**
	 * Constructs new skill panel
	 * @param p player object
	 */
	public SkillPanel(Player p)
	{
		super(new FlowLayout());
		this.setBackground(Color.BLACK);
		player = p;
		menu = player.getSkillMenu();
		this.add(menu);
	}
	
	public void update(Observable obj, Object o) 
	{
		this.remove(menu);
		menu = player.getSkillMenu();
		this.add(menu);
	}
	
	private Player player;
	private Menu menu;
}
