import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class Player extends MobileObject {
	
	public Player(){
		gainLevel(levels[0]);
		skillList = new SkillActionList(this);
	}
	
	private int hp = 0;
	private int maxHp = 0;
	private int attack = 0;
	private int defense = 0;
	private int strength = 0;
	private int level = 0;
	private int intelligence = 0;
	private int dexterity = 0;
	private int experience = 0;
	private int mana = 0;
	private int maxMana = 0;
	private CharTile tile;
	private Inventory inventory;
	private SkillActionList skillList;
	private Level[] levels = {new Level(0, 10, 10, 10, 10, 10, 10, 10), 
			new Level(100, 20, 20, 20, 20, 20, 20, 20)};
	
	public void gainLevel(Level level){
		this.maxHp += level.getMaxHp();
		this.hp = this.maxHp;
		this.attack += level.getAttack();
		this.defense += level.getDefense();
		this.strength += level.getStrength();
		this.intelligence += level.getIntelligence();
		this.dexterity += level.getDexterity();
		this.maxMana += level.getMaxMana();
		this.mana = this.maxMana;
		this.experience = 0;
		this.level++;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
		setChanged();
	}
	

	public int getMaxHp() {
		return maxHp;
	}


	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
		setChanged();
	}


	public int getAttack() {
		return attack;
	}


	public void setAttack(int attack) {
		this.attack = attack;
		setChanged();
	}


	public int getDefense() {
		return defense;
	}


	public void setDefense(int defense) {
		this.defense = defense;
		setChanged();
	}


	public int getStrength() {
		return strength;
	}


	public void setStrength(int strength) {
		this.strength = strength;
		setChanged();
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
		setChanged();
	}


	public int getIntelligence() {
		return intelligence;
	}


	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
		System.out.println("This happened");
		setChanged();
	}


	public int getDexterity() {
		return dexterity;
	}


	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
		setChanged();
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
		setChanged();
	}


	public int getMana() {
		return mana;
	}


	public void setMana(int mana) {
		this.mana = mana;
		setChanged();
	}
	
	
	
	public int getMaxMana() {
		return maxMana;
	}


	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
		setChanged();
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


	public SkillActionList getSkillList() {
		return skillList;
	}


	public void setSkillList(SkillActionList skillList) {
		this.skillList = skillList;
	}
	
	public void addSkill(SkillAction s) {
		skillList.add(s);
	}
	
	public SkillAction getSkill(int index) {
		return skillList.get(index);
	}
	
	public void removeSkill(SkillAction s) {
		skillList.remove(s);
	}
	
	public Menu getSkillMenu() {
		return skillList.getMenu();
	}
	
}
