public class Player {
	
	public Player(){
		
	}
	//String hp, should it be int since you'll be adding hp later on when u lvl up 
	public Player(String hp, int strength, int intelligence, int dexterity,
			int mana) {
		this.hp = hp;
		this.strength = strength;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
		this.mana = mana;
	}
	
	private String hp;
	private int strength;
	private int intelligence;
	private int dexterity;
	private int mana;
	
	
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
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

}
