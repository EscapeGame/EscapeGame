import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;


public class MapPanel extends JPanel
{

	public MapPanel(Map map, Player p)
	{
		super(new GridBagLayout());
		this.setBackground(Color.BLACK);
		this.map = map;
		player = p;
	    requestFocus(true);
	}
	
	public void paintComponent(Graphics g)
	{
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      for (int j = 0; j < EscapeGame.FRAME_HEIGHT / EscapeGame.TILE_SIZE; j++)
      {
    	  for (int i = 0; i < EscapeGame.FRAME_WIDTH / EscapeGame.TILE_SIZE; i++)
    	  {
    		  CharTile tile = new CharTile(' ', Color.BLACK);
    		  if (!map.visited(i, j))
    		  {
    			  // do nothing
    		  }
    		  if (player.getLocation().getX() == i 
    				  && player.getLocation().getY() == j)
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
    	Called when the data in the model is changed.
    	@param e the event representing the change
	 */
	public void stateChanged(ChangeEvent e)
	{
		repaint();
	}
	
	private Map map;
	Player player;
	public static final CharTile floor = new CharTile('.', Color.WHITE);
	public static final CharTile wall = new CharTile('#', Color.WHITE);
}
