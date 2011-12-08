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
            Potion potion1 = new Potion("Hp potion", "Heal 50 Hp", 1, ':', 50, 0);
			Monster goblin = new Monster("Goblin", 'g', 10, 10, Color.GREEN, 4, 20, 5, 50);
			goblin.setItem(potion1);
    		mapObjects.add(potion1);
    		mapObjects.add(goblin);
		}
			
		for (int i = 0; i < 20; i++)
		{
            Potion potion2 = new Potion("Mana potion", "Heal 50 Mana", 1,';', 0, 50);
			Monster fairy = new Monster("Fairy", 'f', 50, 50, Color.PINK, 5, 40, 20, 100);
			Scroll scroll = new Scroll("Skill scroll", "Read to learn a random skill.", 1, '?', SkillType.random());
			Weapon weapon = new Weapon("Short sword", "A simple weapon.", 1, '/', 0, 0, 20, 0, 10);
			Armor armor = new Armor ("Leather armor", "Not very protective.", 1, ']', 0, 0, 0, 0, 20);
			fairy.setItem(potion2);
    		mapObjects.add(potion2);
    		mapObjects.add(fairy);
			mapObjects.add(scroll);
			mapObjects.add(weapon);
			mapObjects.add(armor);
		}
		for (int i = 0; i < 10; i++)
		{
			Armor armor2 = new Armor("Breastplate", "Decent protection.", 1, '[', 0, 0, 20, 0, 50);
			Weapon staff = new Weapon("Mage staff", "A mage's weapon.", 1, '|', 0, 0, 0, 60, 0);
		    Weapon weapon2 = new Weapon("Magic sword", "", 1, '/', 0, 0, 40, 20, 20);
		    Monster wraith = new Monster("Wraith", 'W', 500, 500, Color.BLUE, 7, 100, 120, 500);
		    Monster fiend = new Monster("Pit Fiend", 'F', 200, 200, Color.ORANGE, 6, 75, 50, 300);
			Potion potion3 = new Potion("High potion", "Heal 100 Hp", 1, ':', 100, 0);
			wraith.setItem(armor2);
			fiend.setItem(potion3);
			mapObjects.add(wraith);
			mapObjects.add(fiend);
			mapObjects.add(armor2);
			mapObjects.add(potion3);
        	mapObjects.add(weapon2);
			mapObjects.add(staff);
			
		}
        	for (int i = 0; i < 5; i++)
        	{
    			Armor armor3 = new Armor("Magic armor", "Better protection with some magic power.", 1, '+', 0, 0, 40, 40, 80);
    			Weapon weapon3 = new Weapon("Quickblade", "Fast striking, defensive blade.", 1, '\\', 0, 0, 30, 0, 60);
            		Monster dragon = new Monster("Red Dragon", 'D', 2000, 2000, Color.RED, 6, 200, 250, 10000);
            		Potion potion4 = new Potion("Elixir", "Heal 500 hp and mana",1, '^', 500, 500);
        			Food food1 = new Food("Apple of Intelligence", "Increase your intelligence", 0, '%', 0, 0, 0, 5, 0);
        			Food food2 = new Food("Meat of Power", "Increase your strength", 0, '%', 0, 0, 5, 0, 0);
        			Food food3 = new Food("Milk of Speed", "Increase your dexterity", 0, '%', 0, 0, 0, 0, 5);
            		dragon.setItem(potion4);
            		mapObjects.add(dragon);
            		mapObjects.add(potion4);
            		mapObjects.add(food3);
            		mapObjects.add(weapon3);
            		mapObjects.add(armor3);
                	mapObjects.add(food1);
                	mapObjects.add(food2);
                	mapObjects.add(food3);
        	}
        	Armor armor1 = new Armor("Invincible Armor", "Ultima Armor", 1, '*', 0, 0, 0, 0, 1000);
        	Weapon sword3 = new Weapon("Excalibur", "", 1, '!', 0, 0, 1000, 100, 100);
			Food food4 = new Food("Ambrosia", "Increase all stats", 0, '&', 0, 0, 50, 50, 50);
        	mapObjects.add(armor1);
        	mapObjects.add(sword3);
        	mapObjects.add(food4);
                    
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
