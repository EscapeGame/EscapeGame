import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
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
public class Map implements ILosBoard
{
	/**
	 * Constructs an empty map.
	 * @param w map width
	 * @param h map height
	 */
	public Map(int w, int h, Inventory inv, ArrayList<MapObject> mapObjects)
	{
		width = w;
		height= h;
		visited = new boolean[width][height];
		obstacles = new boolean[width][height];
		objectsLocations = new HashMap<Point2I, MapObject>();
		objectsList = mapObjects;
		
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
			{
				visited[i][j] = true;
				obstacles[i][j] = false;
			}
		
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
			if (!obstacles[x][y])
			{
				MapObject o = randomizedObjects.get(i);
				objectsLocations.put(new Point2I(x, y), o);
				if (o instanceof MobileObject)
					((MobileObject) o).setLocation(x, y);
				obstacles[x][y] = true;
			}
		}
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
		if (contains(x, y))
		{
			visited[x][y] = true;
			MapObject o = getMapObject(x, y);
			if (o != null && o instanceof MobileObject)
			{
				((MobileObject) o).setVisible(true);
			}
		}
		notifyListeners();
	}
	
	/**
	 * Method to check if location was visited
	 * @param x
	 * @param y
	 * @return true if location was visited
	 */
	public boolean visited(int x, int y)
	{
		return visited[x][y];
	}
	
	/**
	 * Method to get an object that is at requested location (if any)
	 * @param x
	 * @param y
	 * @return MapObject that is at requested location or null if none
	 */
	public MapObject getMapObject(int x, int y)
	{
		return objectsLocations.get(new Point2I(x, y));
	}
	
	/**
	 * Method to place a MapObject that is at requested location
	 * @param x
	 * @param y
	 */
	public void placeMapObject(int x, int y, MapObject o)
	{
		objectsList.add(o);
		objectsLocations.put(new Point2I(x, y), o);
		if (o != null)
			notifyListeners();
	}
	
	/**
	 * Removes MapObject that is at requested location (if any) from map 
	 * @param x
	 * @param y
	 */
	public void removeObject(int x, int y)
	{
		MapObject o = objectsLocations.get(new Point2I(x, y));
		objectsList.remove(o);
		objectsLocations.put(new Point2I(x, y), null);
		if (o != null)
			notifyListeners();
	}
	/**
	 * Finds shortest path between 2 points
	 * @param p1
	 * @param p2
	 * @return
	 */
	public ArrayList<Point2I> findPath(Point2I p1, Point2I p2)
	{
		return null;
	}
	
	/**
    	Attach a listener to the Map
    	@param c the listener
	 */
	public void attach(ChangeListener c)
	{
		listeners.add(c);
	}

	/**
    	Notify listeners that map has changed
	 */
	private void notifyListeners()
	{
		for (ChangeListener l : listeners)
		{
			l.stateChanged(new ChangeEvent(this));
		}
	}

	private int width, height;
	private boolean[][] visited;
	private boolean[][] obstacles;
	HashMap<Point2I, MapObject> objectsLocations;
	ArrayList<MapObject> objectsList;
	ArrayList<ChangeListener> listeners;
	
}
