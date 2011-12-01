import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;


public class MapPanel extends JPanel implements Observer
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
	
	public void update(Observable map, Object o) 
	{
		repaint();
	}
	private Map map;
	Player player;
	//GameController controller;
	public static final CharTile floor = new CharTile('.', Color.WHITE);
	public static final CharTile wall = new CharTile('#', Color.WHITE);

}
