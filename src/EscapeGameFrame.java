import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 * Class that creates a new game frame
 * @author Tatiana Braginets, Sally Calpo
 *
 */
public class EscapeGameFrame extends JFrame
{
	

	public EscapeGameFrame(int w, int h, Map map, Player p)
	{
		setSize(w + (2 * STATUS_WIDTH), h + MESSAGE_HEIGHT);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setBackground(Color.BLACK);
	    
	    /* Create MapPanel */
	    MapPanel panel = new MapPanel(map, p);
	    panel.setSize(w, h);
	    map.addObserver(panel);
	   
	    /* Create LayeredPane - allows popup menus to overlay map */
	    pane = new JLayeredPane();
	    pane.setLayout(new FlowLayout(FlowLayout.LEFT));
	    //pane.add(panel, JLayeredPane.DEFAULT_LAYER);
	    pane.add(p.getSkillMenu());
	    pane.setSize(STATUS_WIDTH, h);
	    
	    /* Create MessageBar - display status messages */
	    messageBar = new MessageBar(w, MESSAGE_HEIGHT, "Welcome to EscapeGame!");
	    
	    /* Create StatusBar - display player (and monster, if encountered) stats */
	    statusBar = new StatusBar(STATUS_WIDTH, h, p);
	    p.addObserver(statusBar);
		
	    // Add panel and bars to frame's BorderLayout
	    this.add(messageBar, BorderLayout.NORTH);
		this.add(statusBar, BorderLayout.WEST);
		this.add(panel, BorderLayout.CENTER);
		this.add(pane, BorderLayout.EAST);
		
		// Add controller
	    this.addKeyListener(new GameController(map, p, this));
	}
	
	public void printMessage(String message)
	{
		messageBar.printMessage(message);
	}
	
	public void printMonsterStatus(Monster monster)
	{
		statusBar.printMonsterStatus(monster);
	}
	
	public void addMenu(Menu menu)
	{
		this.menu = menu;
		pane.add(menu, JLayeredPane.POPUP_LAYER);
	}
	
	public void removeMenu()
	{
		if(menu != null) {
			pane.remove(menu);
			menu = null;
		}
	}
	
	public StatusBar getStatusBar()
	{
		return statusBar;
	}

	private MessageBar messageBar;
	private StatusBar statusBar;
	private JLayeredPane pane;
	private Menu menu;
	private static final int STATUS_WIDTH = 120;
	private static final int MESSAGE_HEIGHT = 30;
	
}
