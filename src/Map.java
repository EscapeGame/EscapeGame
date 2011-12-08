import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import rlforj.los.IFovAlgorithm;
import rlforj.los.ILosBoard;
import rlforj.math.Permutation;
import rlforj.math.Point2I;

/**
 * Class that creates a new map
 * @author Tatiana Braginets
 *
 */
public class Map extends Observable implements ILosBoard
{
	/**
	 * Constructs an empty map.
	 * @param w map width
	 * @param h map height
	 */
	public Map(int w, int h, ArrayList<MapObject> mapObjects, Player p)
	{
		// initialize everything
		width = w;
		height= h;
		visited = new boolean[width][height];
		obstacles = new boolean[width][height];
		objectsLocations = new HashMap<Point2I, MapObject>();

		objectsList = mapObjects;
		
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
			{
				visited[i][j] = false;
				obstacles[i][j] = false;
			}
		
		// set player's location
		pLocation = new Point2I(2, 2);
		/*for (int i = (int) pLocation.getX() - 5; i < 10; i++)
			for (int j = (int) pLocation.getX() - 5; j < 10; j++)
			{
				visit(i, j);
			}*/
		
		
		// create walls
		createWalls();
		
		// place MapObjects on map
		ArrayList<MapObject> randomizedObjects = new ArrayList();
		int[] permutation = Permutation.randomPermutation(mapObjects.size());
		for (int i = 0; i < permutation.length; i++)
		{
			randomizedObjects.add(mapObjects.get(permutation[i]));
		}
		//int[] permutationX = Permutation.randomPermutation(width);
		//int[] permutationY = Permutation.randomPermutation(height);
		Random rand = new Random();
		for (int i = 0; i < permutation.length; i++)
		{
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);
			MapObject o = randomizedObjects.get(i);
			if (obstacles[x][y] || (x < pLocation.x + width / 7  && y < pLocation.y + height / 7))
			{
				i--;
				
			}
			else if (!obstacles[x][y] && (x < width / 7 + width / 3 && y > height / 5)
					&& o instanceof Monster && ((Monster)o).getHp() > p.getHp())
			{
				i--;
			}
                        //Test 
                        else if(!obstacles[x][y] && (x < width / 7 + width / 3 && y > height / 5)
					&& o instanceof Weapon && ((Weapon)o).getStrength() > p.getStrength())
                        {
                                i--;
                        }
                        else if(!obstacles[x][y] && (x < width / 7 + width / 3 && y > height / 5)
					&& o instanceof Armor && ((Armor)o).getDexterity() > p.getDexterity())
                        {
                                i--;
                        }
			else
			{
				objectsLocations.put(new Point2I(x, y), o);
				if (o instanceof MobileObject)
					((MobileObject) o).setLocation(x, y);
				obstacles[x][y] = true;
			}
				
		}
		
	}
	
	/**
	 * Checks if location is on the map
	 * 
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
		if (contains(x, y))
			return obstacles[x][y];
		return true;
	}

	/**
	 * Sets location as visited
	 */
	public void visit(int x, int y) 
	{
		if (contains(x, y))
		{
			visited[x][y] = true;
			MapObject o = getMapObject(x, y);
			if (o != null && o instanceof MobileObject)
			{
				((MobileObject) o).setVisible(true);
			}
			changed();
		}
	}
	
	/**
	 * Method to check if location was visited
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return true if location was visited
	 */
	public boolean visited(int x, int y)
	{
		if (contains(x, y))
			return visited[x][y];
		return false;
	}
	
	/**
	 * Method to get an object that is at requested location (if any)
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return MapObject that is at requested location or null if none
	 */
	public MapObject getMapObject(int x, int y)
	{
		return objectsLocations.get(new Point2I(x, y));
	}
	
	/**
	 * Method to place a MapObject that is at requested location
	 * @param x x cordinate
	 * @param y y coordinate
	 */
	public void placeMapObject(int x, int y, MapObject o)
	{
		if (!contains(x,y) || o == null)
			return;
		objectsList.add(o);
		objectsLocations.put(new Point2I(x, y), o);
		obstacles[x][y] = true;
		if(o instanceof MobileObject) {
			MobileObject mobile = (MobileObject) o;
			mobile.setLocation(x, y);
		}
		changed();
	}
	
	/**
	 * Removes MapObject that is at requested location (if any) from map 
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return MapObject that was removed or null if none
	 */
	public MapObject removeObject(int x, int y)
	{
		if (!contains(x,y))
			return null;
		MapObject o = objectsLocations.get(new Point2I(x, y));
		objectsList.remove(o);
		objectsLocations.put(new Point2I(x, y), null);
		if (o != null)
		{
			obstacles[x][y] = false;
			changed();	
		}
		return o;
	}

	/**
	 * Getter for player location
	 * @return location of the player
	 */
	public Point2I getPlayerLocation() 
	{
		return pLocation;
	}
	
	/**
	 * Setter for player location
	 * @param p new location for the player
	 */
	public void setPlayerLocation(Point2I p) 
	{
		if (contains(p.x, p.y) && !obstacles[p.x][p.y])
		{
			pLocation = p;
			changed();
		}
	}
	
	/**
	 * Notifies observers
	 */
	private void changed()
	{

		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	/**
	 * Creates walls
	 */
	private void createWalls()
	{
		// frame
		verticalWall(new Point2I(0, 0), height - 1); // left
		horizontalWall(new Point2I(0, 1), width - 1); // top
		verticalWall(new Point2I(width - 1, 0), height); // right
		horizontalWall(new Point2I(0, height - 1), width - 5); // bottom
		//verticalWall();
		for (int i = width - 1; i > width - 10; i--)
			for (int j = height - 1; j > height - 10; j--)
			{
				visit(i, j);
			}
		//System.out.print();
		verticalWall(new Point2I(width / 7, 0), height / 5);
		horizontalWall(new Point2I(width / 7, height / 5), width / 3);
		verticalWall(new Point2I(width / 7 + width / 3, height / 5), 2 * height / 3);
		horizontalWall(new Point2I(width / 7, height / 5 +  2 * height / 3), width / 3);
		
		horizontalWall(new Point2I(0, height / 2), width / 3);
		//horizontalWall(new Point2I(5, 40), 30);
		horizontalWall(new Point2I(width / 5, height / 8), 2 * width / 3);
		
		verticalWall(new Point2I(2 * width / 3, height / 8), height - height / 8);
		
		horizontalWall(new Point2I(2 * width / 3, height / 2), width / 4);
	}
	
	/**
	 * Creates horizontal wall
	 * @param loc starting location of the wall
	 * @param length wall length
	 */
	private void horizontalWall(Point2I loc, int length)
	{
		for (int i = 0; i < length; i++)
		{
			if (contains((int) loc.getX() + i,(int) (loc.getY())))
				obstacles[(int) loc.getX() + i][(int) (loc.getY())] = true;
		}
	}
	
	/**
	 * Creates vertical wall
	 * @param loc starting location of the wall
	 * @param length wall length
	 */
	private void verticalWall(Point2I loc, int length)
	{
		for (int j = 0; j < length; j++)
		{
			if (contains((int) loc.getX(),(int) (loc.getY() + j)))
				obstacles[(int) loc.getX()][(int) (loc.getY() + j)] = true;
		}
	}
	
	private Point2I pLocation;
	private int width, height;
	private boolean[][] visited;
	private boolean[][] obstacles;
	private HashMap<Point2I, MapObject> objectsLocations;
	private ArrayList<MapObject> objectsList;
	
}
