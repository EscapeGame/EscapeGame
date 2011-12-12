import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import rlforj.ui.ascii.CharVisual;

/**
 * Class that displays map
 * @author Tatiana Braginets
 *
 */
public class MapPanel extends JPanel implements Observer
{

	/**
	 * Constructs a panel
	 * @param map map to display
	 * @param p player object
	 */
	public MapPanel(Map map, Player p)
	{
		super(new GridBagLayout());
		this.setBackground(Color.BLACK);
		this.map = map;
		player = p;
	    //requestFocus(true);
	}
	
	/**
	 * Paints the panel
	 */
	public void paintComponent(Graphics g)
	{
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      for (int j = 0; j < EscapeGame.FRAME_HEIGHT / EscapeGame.TILE_SIZE; j++)
      {
    	  for (int i = 0; i < EscapeGame.FRAME_WIDTH / EscapeGame.TILE_SIZE; i++)
    	  {
    		  CharVisual tile = new CharVisual(' ', Color.BLACK);
    		  if (!map.visited(i, j))
    		  {
    			  // do nothing
    		  }
    		  if (map.getPlayerLocation().getX() == i 
    				  && map.getPlayerLocation().getY() == j)
    			  tile = player.getTile();
    		  else if (map.visited(i,j) && map.isObstacle(i, j))
    		  {
    			  MapObject o = map.getMapObject(i, j);
    			  if (o == null)
    				  tile = wall;
    			  else
    				  tile = o.getTile();
    		  }
    		  else if (map.visited(i,j))
    		  {
    			  tile = floor;
    		  }
    		  g2.setColor(tile.col);
    		  
    		  g2.drawString("" + tile.disp, i * EscapeGame.TILE_SIZE, j * EscapeGame.TILE_SIZE);
    	  }
      }
	}
	
	/**
	 * Updates panel if map changes
	 */
	public void update(Observable map, Object o) 
	{
		repaint();
	}
	
	private Map map;
	private Player player;
	public static final CharVisual floor = new CharVisual('.', Color.WHITE);
	public static final CharVisual wall = new CharVisual('#', Color.WHITE);

}
