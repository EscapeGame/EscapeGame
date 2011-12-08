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
		for (int i = 0; i < 25; i++)
		{
            		Potion potion1 = new Potion("Hp potion", "Heal 50 Hp", 1, ':', 50, 0);
            		Potion potion2 = new Potion("Mana potion", "Heal 50 Mana", 1,';', 0, 50);
			Monster fairy = new Monster("Fairy", 'f', 50, 50, Color.PINK, 5, 40, 20, 100);
			Monster goblin = new Monster("Goblin", 'g', 10, 10, Color.GREEN, 3, 20, 5, 50);
			Scroll scroll = new Scroll("Skill scroll", "Read to learn a random skill.", 1, '?', SkillType.random());

			goblin.setItem(potion1);
			fairy.setItem(potion2);

        		mapObjects.add(potion1);
        		mapObjects.add(potion2);
        		mapObjects.add(fairy);
			mapObjects.add(goblin);
			mapObjects.add(scroll);
		}
		for (int i = 0; i < 10; i++)
		{
			Armor armor = new Armor("Breastplate", "Okay protection.", 1, '[', 0, 0, 20, 0, 40);
			Weapon weapon = new Weapon("Short sword", "A simple weapon.", 1, '/', 0, 0, 25, 0, 10);
			Weapon staff = new Weapon("Mage staff", "A mage's weapon.", 1, '|', 0, 0, 0, 60, 0);
			Monster wraith = new Monster("Wraith", 'W', 300, 300, Color.BLUE, 7, 100, 120, 300);
			Armor armor2 = new Armor("Magic armor", "Better protection.", 1, '+', 0, 0, 40, 40, 80);
           		Potion potion3 = new Potion("High potion", "Heal 100 Hp", 1, '^', 100, 0);
			Weapon weapon2 = new Weapon("Quickblade", "Fast striking, defensive blade.", 1, '\\', 0, 0, 30, 0, 60);

			wraith.setItem(armor2);
			mapObjects.add(wraith);
			mapObjects.add(armor2);
			mapObjects.add(potion3);
        		mapObjects.add(weapon2);
			mapObjects.add(armor);
			mapObjects.add(weapon);
			mapObjects.add(staff);
			
		}
        	for (int i = 0; i < 5; i++)
        	{
            		Monster dragon = new Monster("Red Dragon", 'D', 2000, 2000, Color.RED, 5, 200, 250, 10000);
            		Potion potion4 = new Potion("Elixir", "Heal 500 hp and mana",1, '%', 500, 500);
            		dragon.setItem(potion4);
            		mapObjects.add(dragon);
            		mapObjects.add(potion4);
        	}
        	Armor armor1 = new Armor("Invincible Armor", "Ultima Armor", 1, '*', 0, 0, 0, 0, 1000);
        	Weapon sword3 = new Weapon("Excalibur", "", 1, '!', 0, 0, 1000, 100, 100);
        	mapObjects.add(armor1);
        	mapObjects.add(sword3);
                    
		player = new Player();
		map = new Map((FRAME_WIDTH - 50) / TILE_SIZE - 2, (FRAME_HEIGHT - 170) / TILE_SIZE- 2, mapObjects, player);
		//player.setLocation(2, 2);
		EscapeGameFrame frame = new EscapeGameFrame(FRAME_WIDTH, FRAME_HEIGHT, map, player);
		frame.setVisible(true);

	}
	
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 700;
	public static final int TILE_SIZE = 10;

}
