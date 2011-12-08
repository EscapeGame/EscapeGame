import java.awt.Color;


public class Monster extends MobileObject
{
	//some kindah world e.g 3d dimentional world
	
	public int x; //coordinate
	public int y;
	public int z;
	
	//stats
	private String name; //monster name
	private char symbol; //monster symbol e.g Dragon = "D"
	private int hp;      //monster HitPoints
	private int maxHp;   //monster maxHp
	private Color mcolor;//monster color
	private int exp;
	
	//vision
	private int visionRadius;
	
	//attack & Deffense
	private int attackValue;
	private int deffenseValue;
	
	private int skillCounter = 0; // for self-cast skills with duration
	private SelfAction revertSkill = null; // action to revert self-cast skill
	
	// item
	Item item;
	//constructor
	public Monster() {}
	
	//public Monster(World world, String...)
	public Monster(String name, char symbol, int hp, int maxHp, Color mcolor, int visionRadius, int attackValue, int deffenseValue, int exp)
	{
		this.name = name;
		this.symbol = symbol;
		this.hp = hp;
		this.maxHp= maxHp;
		this.mcolor = mcolor;
		this.visionRadius = 6;   //radius = 6;
		this.attackValue = attackValue;
		this.deffenseValue = deffenseValue;
		this.exp = exp;
		item = null;
		
	}
	
	//stats
	public String getName(){return name;}
	public char getSymbol(){return symbol;}
	public int  getHp(){return hp;}
	public int getMaxHp(){return maxHp;}
	public Color getMcolor(){return mcolor;}
	
	public void setHp(int hp) {
		this.hp = hp;
		setChanged();
	}
	
	//vision
	public int getVisionRadius(){return visionRadius;}
	public void modifyVisionRadius(int value)
	{
		visionRadius += value;
	}
	
	//attack
	public int getAttackValue(){return attackValue;}
	public void modifyAttackValue(int addDamage)
		{
			attackValue += addDamage;
			setChanged();
		}
	
	//deffense
	public int getDeffenseValue(){return deffenseValue;}
	public void modifyDeffenseValue(int addDeffense)
	{
		deffenseValue += addDeffense;
		setChanged();
	}
	
	public int getExp(){return exp;}
	public void modifyExp(int addExp)
	{
		exp += addExp;
	}

	public void setItem(Item i)
	{
		item = i;
	}
	
	public Item getItem()
	{
		return item;
	}
	
	public int getSkillCounter() {
		return skillCounter;
	}

	public void setSkillCounter(int skillCounter) {
		this.skillCounter = skillCounter;
	}

	public void incrementSkillCounter() {
		skillCounter++;
	}

	public void decrementSkillCounter() {
		if(skillCounter > 0)
			skillCounter--;
		if(skillCounter == 0 && revertSkill != null) {
			revertSkill.execute(this);
			revertSkill = null;
		}
	}

	public SelfAction getRevertSkill() {
		return revertSkill;
	}

	public void setRevertSkill(SelfAction revertSkill) {
		this.revertSkill = revertSkill;
	}
	
	public void setAttackValue(int attackValue) {
		this.attackValue = attackValue;
		setChanged();
	}

	public void setDeffenseValue(int deffenseValue) {
		this.deffenseValue = deffenseValue;
		setChanged();
	}

	@Override
	public CharTile getTile() 
	{
		return new CharTile(symbol, mcolor);
	}
	
	@Override
	public void checkStatus()
	{
		if(hasChanged()) 
		{
			notifyObservers(this);
			clearChanged();
		}
	}
}
