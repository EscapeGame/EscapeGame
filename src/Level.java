
public class Level {
	
	public Level(int experience, int hp, int attack, int defense, int strength,
			int intelligence, int dexterity, int mana) {
		super();
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.strength = strength;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		this.mana = mana;
		this.experience = experience;
	}
	
	private int hp;
	private int attack;
	private int defense;
	private int strength;
	private int intelligence;
	private int dexterity;
	private int mana;
	private int experience;
	
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
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}

}
