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
		Inventory inventory = new Inventory();
		// TODO add items to inventory
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		// TODO add monsters to array
		map = new Map(MAP_WIDTH, MAP_HEIGHT, inventory, monsters);
		player = new Player();
		pController = new PlayerController(map);
		map.display(0, 0, player.getTile());
	}
	
	private static Player player;
	private static Map map;
	private static PlayerController pController;
	public static final int MAP_WIDTH = 100;
	public static final int MAP_HEIGHT = 100;

}
