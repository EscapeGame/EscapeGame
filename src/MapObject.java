import rlforj.ui.ascii.CharVisual;


/**
 * Interface for creating a map object
 * @author Tatiana Braginets
 *
 */
public interface MapObject
{
	/**
	 * Gets char representation of object to display on map
	 * @return
	 */
	CharVisual getTile();
	
}
