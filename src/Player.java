import java.awt.Color;

public class Player {
	
	public Player(){
		
	}
	//String hp, should it be int since you'll be adding hp later on when u lvl up 
	public Player(int hp, int strength, int intelligence, int dexterity,
			int mana) {
		this.hp = hp;
		this.strength = strength;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		this.mana = mana;
	}
	
	private int hp;
	private int strength;
	private int intelligence;
	private int dexterity;
	private int mana;
	private CharTile tile;
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
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
	

}
