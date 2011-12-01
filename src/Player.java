import java.awt.Color;
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


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}


	public int getAttack() {
		return attack;
	}


	public void setAttack(int attack) {
		this.attack = attack;
	}


	public int getDefense() {
		return defense;
	}


	public void setDefense(int defense) {
		this.defense = defense;
	}


	public int getStrength() {
		return strength;
	}


	public void setStrength(int strength) {
		this.strength = strength;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getIntelligence() {
		return intelligence;
	}


	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}


	public int getDexterity() {
		return dexterity;
	}


	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public int getMana() {
		return mana;
	}


	public void setMana(int mana) {
		this.mana = mana;
	}
	public CharTile getTile() {
		return new CharTile('@', Color.RED);
	}
	public void setTile(CharTile tile) {
		this.tile = tile;
	}
	


	public Inventory getInventory() {
		return inventory;
	}


	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	
	
}
