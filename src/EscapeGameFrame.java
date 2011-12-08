import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Class that creates a new game frame
 * @author Tatiana Braginets, Sally Calpo
 *
 */
public class EscapeGameFrame extends JFrame
{
	

	public EscapeGameFrame(int w, int h, Map map, Player p)
	{
		player = p;
		
		setSize(w + (2 * STATUS_WIDTH), h + MESSAGE_HEIGHT);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setBackground(Color.BLACK);
	    this.setLayout(new BorderLayout());
	    
	    /* Create MapPanel */
	    MapPanel panel = new MapPanel(map, p);
	    panel.setSize(w, h);
	    map.addObserver(panel);
	   
	    /* Create skill panel */
	    skillPanel = new SkillPanel(p);    
	    p.getSkillList().addObserver(skillPanel);
	    skillPanel.setSize(STATUS_WIDTH, h);
            
        /*pane1 = new JLayeredPane();
        pane1.setLayout(new FlowLayout(FlowLayout.LEFT));        
        pane1.add(p.getEquipMenu());
        pane1.setSize(STATUS_WIDTH, h * 2);*/
	    inventoryPanel = new InventoryPanel(p);
	    p.getInventory().addObserver(inventoryPanel);
	    p.addObserver(inventoryPanel);
	    
	    /* Create MessageBar - display status messages */
	    messageBar = new MessageBar(w, MESSAGE_HEIGHT, "Welcome to EscapeGame!");
	    
	    /* Create StatusBar - display player (and monster, if encountered) stats */
	    statusBar = new StatusBar(STATUS_WIDTH, h, p);
	    p.addObserver(statusBar);
            
	    //equipMenu = new EquipMenu(p.getInventory().getlistItem());
            //p.getInventory().addObserver(equipMenu);
		
	    // Add panel and bars to frame's BorderLayout
	    this.add(messageBar, BorderLayout.NORTH);
		this.add(statusBar, BorderLayout.WEST);
		this.add(panel, BorderLayout.CENTER);
		this.add(skillPanel, BorderLayout.EAST);
		this.add(inventoryPanel, BorderLayout.SOUTH);
        //this.add(pane1, BorderLayout.SOUTH);
		
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
	
	public StatusBar getStatusBar()
	{
		return statusBar;
	}

	private MessageBar messageBar;
	private StatusBar statusBar;
	private InventoryPanel inventoryPanel;
	private SkillPanel skillPanel;
	private Player player;
	private static final int STATUS_WIDTH = 120;
	private static final int MESSAGE_HEIGHT = 30;
	
}
