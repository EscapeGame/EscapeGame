import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import rlforj.los.ILosBoard;
import rlforj.math.Point2I;

/**
 * Class that creates a new map
 * @author Tatiana Braginets
 *
 */
public class Map implements ILosBoard
{
	/**
	 * Constructs an empty map.
	 * @param w map width
	 * @param h map height
	 */
	public Map(int w, int h, Inventory inv, ArrayList<Monster> mons)
	{
		width = w;
		height= h;
		visited = new boolean[width][height];
		objects = new HashMap<Point2I, Object>();
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
			{
				visited[i][j] = false;
				obstacles[i][j] = false;
			}
		
		// TODO place monsters and items
	}
	
	/**
	 * Checks if location is on the map
	 */
	public boolean contains(int x, int y) 
	{
		return x >= 0 && y >= 0 && x < width && y < height;
	}

	/**
	 * Checks if location is an obstacle (can be wall, item or monster)
	 */
	public boolean isObstacle(int x, int y) 
	{
		return obstacles[x][y];
	}

	/**
	 * Sets location as visited
	 */
	public void visit(int x, int y) 
	{
		if (contains(x, y) && !obstacles[x][y])
		{
			visited[x][y] = true;
			moveVisibleMonsters(x, y);
		}
	}
	
	/**
	 * Checks if there is a monster at requested location
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isMonster(int x, int y)
	{
		Object o = objects.get(new Point2I(x, y));
		if (o != null && o instanceof Monster)
			return true;
		return false;
	}
	
	/**
	 * Checks if there is an item at current location
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isItem(int x, int y)
	{
		Object o = objects.get(new Point2I(x, y));
		if (o != null && o instanceof Item)
			return true;
		return false;
	}
	
	/**
	 * Method to get a monster that is at requested location (if any)
	 * @param x
	 * @param y
	 * @return monster that is at requested location or null if none
	 */
	public Monster getMonster(int x, int y)
	{
		if (isMonster(x, y))
			return (Monster) objects.get(new Point2I(x, y));
		return null;
	}
	
	/**
	 * Method to get an item that at requested location (if any)
	 * @param x
	 * @param y
	 * @return item that is at requested location or null if none
	 */
	public Item getItem(int x, int y)
	{
		if (isItem(x, y))
			return (Item) objects.get(new Point2I(x, y));
		return null;
	}
	
	/**
	 * Finds shortest path between 2 points
	 * @param p1
	 * @param p2
	 * @return
	 */
	public ArrayList<Point2I> findPath(Point2I p1, Point2I p2)
	{
		//TODO
		return null;
	}
	
	/**
	 * Removes object from map
	 * @param x
	 * @param y
	 */
	public void removeObject(int x, int y)
	{
		Object o = objects.get(new Point2I(x, y));
		if (o == null)
		{
			// do nothing
		}
		else if (o instanceof Monster)
		{
			Monster m = (Monster) o;
			Item i = m.getItem();
			objects.put(new Point2I(x, y), i);
		}
		else
		{
			objects.put(new Point2I(x, y), null);
		}		
	}
	
	public void moveVisibleMonsters(int playerX, int playerY)
	{
		// TODO
	}
	
	/**
	 * Displays map
	 * @param playerX 
	 * @param playerY
	 * @param playerT player's tile
	 */
	public void display(Tile playerT) 
	{
		for (int j = 0; j < height; j++) 
		{
			for (int i = 0; i < width; i++) 
			{
				Object o = objects.get(new Point2I(i, j));
				if(o != null && o instanceof Monster)
				{
					Monster m = (Monster) o;
					m.getTile().display();
				}
				if(o != null && o instanceof Item)
				{
					Item i = (Item) o;
					i.getTile().display();
				}
				else
					if(i == playerY && j == playerX)
						playerT.display();
					else if (visited[i][j])
						visibleFloor.display();
					else
						invisibleTile.display();
			}
			System.out.println();
		}
	}
	
	private int width, height;
	private int playerX, playerY;
	private boolean[][] visited;
	private boolean[][] obstacles;
	HashMap<Point2I, Object> objects;
	
	
	public static final Tile visibleFloor = new CharTile('.', Color.WHITE);
	public static final Tile wall = new CharTile('#', Color.WHITE);
	public static final Tile invisibleTile = new CharTile(' ', Color.WHITE);
	
}
