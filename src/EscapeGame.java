import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


/**
 * Class that creates a new game
 * @author Tatiana Braginets
 * @version 1.1
 */

public class EscapeGame
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Player player;
		Map map;
		Inventory inventory = new Inventory();
		ArrayList<MapObject> mapObjects = new ArrayList<MapObject>();
		for (int i = 0; i < 30; i++)
		{
			Armor item = new Armor("Badass Armor", "Very spiky and awesome", 1, 'E', 100, 100, 100, 100, 100);
			Monster m = new Monster("Red Dragon", 'D', 2000, 5000, Color.RED, 6, 200, 250, 10000);
			mapObjects.add(m);
			mapObjects.add(item);
		}
		player = new Player();
		map = new Map(FRAME_WIDTH / TILE_SIZE - 2, FRAME_HEIGHT / TILE_SIZE - 2, inventory, mapObjects);
		//player.setLocation(2, 2);
		EscapeGameFrame frame = new EscapeGameFrame(FRAME_WIDTH, FRAME_HEIGHT, map, player);
		frame.setVisible(true);

	}
	
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 800;
	public static final int TILE_SIZE = 10;

}
