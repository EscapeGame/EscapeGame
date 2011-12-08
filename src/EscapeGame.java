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
		//Inventory inventory = new Inventory();
		ArrayList<MapObject> mapObjects = new ArrayList<MapObject>();
		for (int i = 0; i < 30; i++)
		{
			Armor armor = new Armor("Breastplate", "Good protection.", 1, '[', 0, 0, 10, 10, 10);
                        
			Weapon weapon = new Weapon("Short Sword", "A simple weapon.", 1, 'Z', 0, 0, 10, 10, 10);
			Weapon staff = new Weapon("Mage Staff", "A mage's weapon.", 1, '/', 10, 10, 10, 100, 10);
                        Potion potion1 = new Potion("Hp potion", "Heal 50 Hp", 1, ',', 50, 0);
                        Potion potion3 = new Potion("High potion", "Heal 100 Hp", 1, ',', 100, 0);
                        Potion potion2 = new Potion("Mana potion", "Heal 50 Mana", 1,',', 0, 50);
                        
			
			//Monster wraith = new Monster("Wraith", 'W', 500, 500, Color.BLUE, 8, 100, 120, 500);
			
			//Monster dragon = new Monster("Red Dragon", 'D', 2000, 2000, Color.RED, 5, 200, 250, 10000);
			Monster wraith = new Monster("Wraith", 'W', 500, 500, Color.BLUE, 8, 100, 120, 500);

			Monster goblin = new Monster("Goblin", 'g', 10, 10, Color.GREEN, 3, 25, 5, 50);
			Scroll scroll = new Scroll("Skill scroll", "Read to clear a random skill.", 1, '?', SkillType.random());
			//dragon.setItem(armor);
			goblin.setItem(weapon);
			

			//mapObjects.add(wraith)
                        mapObjects.add(potion1);
                        mapObjects.add(potion2);
                        mapObjects.add(potion3);
                        
			mapObjects.add(wraith);
                        
			mapObjects.add(goblin);
			mapObjects.add(armor);
			mapObjects.add(weapon);
			mapObjects.add(staff);
			mapObjects.add(scroll);
		}
                for (int i = 0; i < 5; i++)
                {
                    Monster dragon = new Monster("Red Dragon", 'D', 2000, 2000, Color.RED, 5, 200, 250, 10000);
                    mapObjects.add(dragon);
                    Potion potion4 = new Potion("Exilir", "Heal 500 hp and mana",1, ';', 500, 500);
                    mapObjects.add(potion4);
                }
                for(int i = 0; i < 1; i++)
                {
                    Armor armor1 = new Armor("Invincible Armor", "Ultima Armor", 1, '.', 0, 0, 0, 0, 1000);
                    Weapon sword3 = new Weapon("Excalabur", "", 1, '/', 0, 0, 1000, 100, 100);
                    mapObjects.add(armor1);
                    mapObjects.add(sword3);
                    
                }
		player = new Player();
		map = new Map(FRAME_WIDTH / TILE_SIZE - 2, FRAME_HEIGHT / TILE_SIZE - 2, mapObjects);
		//player.setLocation(2, 2);
		EscapeGameFrame frame = new EscapeGameFrame(FRAME_WIDTH, FRAME_HEIGHT, map, player);
		frame.setVisible(true);

	}
	
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 800;
	public static final int TILE_SIZE = 10;

}
