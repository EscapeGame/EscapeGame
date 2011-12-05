
public class Level {
	
	public Level(int experience, int maxHp, int attack, int defense, int strength,
			int intelligence, int dexterity, int maxMana) {
		super();
		this.maxHp = maxHp;
		this.attack = attack;
		this.defense = defense;
		this.strength = strength;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		this.maxMana = maxMana;
		this.experience = experience;
	}
	
	private int maxHp;
	private int attack;
	private int defense;
	private int strength;
	private int intelligence;
	private int dexterity;
	private int maxMana;
	private int experience;
	
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
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
	public int getMaxMana() {
		return maxMana;
	}
	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}

}
