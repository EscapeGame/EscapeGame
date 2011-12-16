import java.awt.Color;

import rlforj.ui.ascii.CharVisual;

/**
 * Class to create monsters
 * @author Marvin Caragay
 *
 */
public class Monster extends MobileObject
{	
	//stats
	private String name; //monster name
	private char symbol; //monster symbol e.g Dragon = "D"
	private int hp;      //monster HitPoints
	private int maxHp;   //monster maxHp
	private Color mcolor;//monster color
	private int exp;
	
	//attack & Deffense
	private int attackValue;
	private int deffenseValue;
	
	private int skillCounter = 0; // for self-cast skills with duration
	private SelfAction revertSkill = null; // action to revert self-cast skill
	
	// item
	Item item;
	//constructor
	public Monster() {}
	
	/**
	 * Constructor
	 * 
	 * /
	public Monster(String name, char symbol, int hp, int maxHp, Color mcolor, int visionRadius, int attackValue, int deffenseValue, int exp)
	{
		this.name = name;
		this.symbol = symbol;
		this.hp = hp;
		this.maxHp= maxHp;
		this.mcolor = mcolor;
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
	
	/**
	 * Value to get monsetr attack
	 * @return int
	 * 
	 * /
	public int getAttackValue(){return attackValue;}
	
	
	/**
	 * method to increase or decrease monster damage
	 * @param int 
	 * /
	public void modifyAttackValue(int addDamage)
		{
			attackValue += addDamage;
			setChanged();
		}
	
	
	/**
	 * Value to get monsetr deffense
	 * @return int
	 * 
	 * /
	public int getDeffenseValue(){return deffenseValue;}
	
	/**
	 * method to increase or deffense monster deffense
	 * @param int 
	 * /
	public void modifyDeffenseValue(int addDeffense)
	{
		deffenseValue += addDeffense;
		setChanged();
	}
	
	
	 /**
	 * Value to get monsetr experience
	 * @return int
	 * 
	 * /
	public int getExp(){return exp;}
	
	/**
	 * method to assign monster experience
	 * @param int 
	 * /
	public void modifyExp(int addExp)
	{
		exp += addExp;
	}

	/**
	 * method to assign monster item drop
	 * @param item
	 * /
	public void setItem(Item i)
	{
		item = i;
	}
	
	 /**
	 * Value to get monsetr item
	 * @return item
	 * 
	 * /
	public Item getItem()
	{
		return item;
	}
	
	/**
	 * Value to get monsetr number of item
	 * @return int
	 * 
	 * /
	public int getSkillCounter()
	{
		return skillCounter;
	}


	/**
	 * method to assign monster skill counter
	 * @param int
	 * /
	public void setSkillCounter(int skillCounter)
	{
		this.skillCounter = skillCounter;
	}

	/**
	 * method to increment monster skill counter
	 * 
	 * /
	public void incrementSkillCounter()
	{
		skillCounter++;
	}


	/**
	 * method to decrement monster skill counter
	 * 
	 * /
	public void decrementSkillCounter() 
	{
		if(skillCounter > 0)
			skillCounter--;
		if(skillCounter == 0 && revertSkill != null) 
		{
			revertSkill.execute(this);
			revertSkill = null;
		}
	}

	/**
	 * method an action for monster
	 * @return skill
	 * /
	public SelfAction getRevertSkill()
	{
		return revertSkill;
	}

	/**
	 * method to set monster action
	 * @param SelfAction
	 * 
	 * /
	public void setRevertSkill(SelfAction revertSkill) 
	{
		this.revertSkill = revertSkill;
	}
	
	/**
	 * method to assign monster attack value
	 * @param int 
	 * /
	public void setAttackValue(int attackValue) 
	{
		this.attackValue = attackValue;
		setChanged();
	}
	
	/**
	 * method to assign monster deffense value
	 * @param int 
	 * /
	public void setDeffenseValue(int deffenseValue) 
	{
		this.deffenseValue = deffenseValue;
		setChanged();
	}

	/**
	 * method to get monster location on the map
	 * @return new location
	 * /
	@Override
	public CharVisual getTile() 
	{
		return new CharVisual(symbol, mcolor);
	}
	
		
	/**
	 * method to check status monster
	 * 
	 * /
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
