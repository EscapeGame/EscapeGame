import java.util.Observable;

import rlforj.math.Point2I;

/**
 * 
 * @author Tatiana Braginets
 *
 */
public abstract class MobileObject extends Observable implements MapObject
{
	
	public MobileObject()
	{
		x = 0;
		y = 0;
		visible = false;
	}
	
    public void setVisible(boolean on)
    {
    	visible = on;
    }
	
	public boolean isVisible()
	{
		return visible;
		
	}
	
	public Point2I getLocation()
	{
		return new Point2I(x, y);
	}
	
	public void setLocation(int x2, int y2) 
	{
		x = x2;
		y = y2;	
	}
	
	public abstract void checkStatus();
	
	private int x;
	private int y;
	private boolean visible;

}
