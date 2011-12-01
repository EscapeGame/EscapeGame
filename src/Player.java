import java.util.ArrayList;

public class Player {
	
	public Player(){
		gainLevel(levels[0]);
	}
	
	private int hp = 0;
	private int attack = 0;
	private int defense = 0;
	private int strength = 0;
	private int level = 0;
	private int intelligence = 0;
	private int dexterity = 0;
	private int experience = 0;
	private int mana = 0;
	private Inventory inventory;
	private Level[] levels = {new Level(0, 10, 10, 10, 10, 10, 10, 10), 
			new Level(100, 20, 20, 20, 20, 20, 20, 20)};
	
	
	public void gainLevel(Level level){
		this.hp += level.getHp();
		this.attack += level.getAttack();
		this.defense += level.getDefense();
		this.strength += level.getStrength();
		this.intelligence += level.getIntelligence();
		this.dexterity += level.getDexterity();
		this.mana += level.getMana();
		this.experience = 0;
		this.level++;
	}
	
	
	
}
