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
		ArrayList<MapObject> mapObjects = new ArrayList<MapObject>();
		for (int i = 0; i < 20; i++)
		{
            Potion potion1 = new Potion("Hp potion", "Heal 50 Hp", 1, ':', 50, 0);
            Potion potion2 = new Potion("Mana potion", "Heal 50 Mana", 1,';', 0, 50);
			Monster goblin = new Monster("Goblin", 'g', 10, 10, Color.GREEN, 4, 20, 5, 30);
			Monster imp = new Monster("Imp", 'm', 30, 30, Color.MAGENTA, 4, 30, 30, 50);
			Scroll scroll = new Scroll("Skill scroll", "Read to learn a random skill.", 1, '?', SkillType.random());
			goblin.setItem(potion1);
			imp.setItem(potion2);
    		mapObjects.add(potion1);
    		mapObjects.add(goblin);
    		mapObjects.add(imp);
			mapObjects.add(scroll);
		}
			
		for (int i = 0; i < 12; i++)
		{
			Monster sorceress = new Monster("Sorceress", 's', 60, 60, Color.PINK, 5, 60, 40, 80);
			Monster knight = new Monster("Black Knight", 'k', 100, 100, Color.DARK_GRAY, 5, 75, 100, 120);
			Weapon weapon = new Weapon("Short sword", "A simple weapon.", 1, '/', 0, 0, 20, 0, 10);
			Armor armor = new Armor ("Leather armor", "Not very protective.", 1, ']', 0, 0, 0, 0, 20);
			Weapon staff = new Weapon("Apprentice staff", "A simple staff.", 1, '|', 0, 0, 0, 20, 0);
			Armor robe = new Armor("Arcane robe", "Robe for a magic user.", 1, '[', 0, 0, 0, 40, 10);
			Armor plate = new Armor("Heavy plate", "Heavy plate armor.", 1, '{', 0, 0, 30, 0, 60);
			sorceress.setItem(robe);
			knight.setItem(plate);
    		mapObjects.add(sorceress);
    		mapObjects.add(knight);
			mapObjects.add(weapon);
			mapObjects.add(armor);
			mapObjects.add(staff);
		}
		for (int i = 0; i < 8; i++)
		{
		    Weapon weapon2 = new Weapon("Magic sword", "", 1, '/', 0, 0, 40, 20, 20);
			Armor armor2 = new Armor("Breastplate", "Decent protection.", 1, '=', 0, 0, 20, 0, 50);
			Armor armor3 = new Armor("Magic armor", "Better protection with some magic power.", 1, '+', 0, 0, 40, 40, 80);
			Weapon staff2 = new Weapon("Magic staff", "A mage's weapon.", 1, '|', 0, 0, 0, 60, 0);
			Weapon club = new Weapon("Ogre club", "Very strong but not much else.", 1, '(', 0, 0, 100, 0, -0);
		    Monster wraith = new Monster("Wraith", 'W', 300, 300, Color.BLUE, 7, 120, 150, 300);
		    Monster ogre = new Monster("Ogre", 'O', 500, 500, Color.ORANGE, 4, 200, 200, 500);
		    Monster naga = new Monster("Naga", 'N', 200, 200, Color.LIGHT_GRAY, 6, 100, 80, 200);
			Potion potion3 = new Potion("High potion", "Heal 100 Hp", 1, ':', 100, 0);
			wraith.setItem(armor3);
			ogre.setItem(club);
			naga.setItem(staff2);
			mapObjects.add(naga);
			mapObjects.add(wraith);
			mapObjects.add(ogre);
			mapObjects.add(potion3);
			mapObjects.add(armor2);
			mapObjects.add(weapon2);
			
		}
		for (int i = 0; i < 5; i++)
		{
			Monster dragon = new Monster("Red Dragon", 'D', 2000, 2000, Color.RED, 6, 300, 350, 10000);
			Potion potion4 = new Potion("Elixir", "Heal 500 hp and mana",1, '^', 500, 500);
			Food food1 = new Food("Apple of Intelligence", "Increase your intelligence", 1, '%', 0, 0, 0, 5, 0);
			Food food2 = new Food("Meat of Power", "Increase your strength", 1, '%', 0, 0, 5, 0, 0);
			Food food3 = new Food("Milk of Speed", "Increase your dexterity", 1, '%', 0, 0, 0, 0, 5);
			dragon.setItem(potion4);
			mapObjects.add(dragon);
			mapObjects.add(potion4);
			mapObjects.add(food1);
			mapObjects.add(food2);
			mapObjects.add(food3);
		}
		Armor armor1 = new Armor("Invincible Armor", "Ultima Armor", 1, '*', 0, 0, 0, 0, 1000);
		Weapon spear = new Weapon("Holy Lance", "A magical spear.", 1, '|', 0, 0, 100, 50, 100);
		Weapon blade = new Weapon("Quickblade", "Fast striking, defensive blade.", 1, '\\', 0, 0, 30, 0, 60);
		Weapon sword3 = new Weapon("Excalibur", "", 1, '!', 0, 0, 1000, 100, 100);
		Food food4 = new Food("Ambrosia", "Increase all stats", 1, '&', 0, 0, 50, 50, 50);
		mapObjects.add(armor1);
		mapObjects.add(sword3);
		mapObjects.add(blade);
		mapObjects.add(spear);
		mapObjects.add(food4);
                    
		player = new Player();
		map = new Map((FRAME_WIDTH - 50) / TILE_SIZE - 2, 
				(FRAME_HEIGHT - 170) / TILE_SIZE- 2, mapObjects, player);
		EscapeGameFrame frame = new EscapeGameFrame(FRAME_WIDTH, FRAME_HEIGHT, map, player);
		frame.setVisible(true);

	}
	
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 700;
	public static final int TILE_SIZE = 10;

}
