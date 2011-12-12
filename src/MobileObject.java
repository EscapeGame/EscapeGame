import java.util.Observable;

import rlforj.math.Point2I;

/**
 * Abstract class for movable map objects
 * @author Tatiana Braginets
 *
 */
public abstract class MobileObject extends Observable implements MapObject
{
	/**
	 * Constructs new map object
	 */
	public MobileObject()
	{
		x = 0;
		y = 0;
	}
	
	/**
	 * Gets location of object
	 * @return point where object is located
	 */
	public Point2I getLocation()
	{
		return new Point2I(x, y);
	}
	
	/**
	 * Sets new location for object
	 * @param x2 x-coordinate
	 * @param y2 y-coordinate
	 */
	public void setLocation(int x2, int y2) 
	{
		x = x2;
		y = y2;	
	}
	
	/**
	 * Checks if object has changed
	 */
	public abstract void checkStatus();

	private int x;
	private int y;

}
