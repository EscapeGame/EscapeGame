import java.awt.Color;

import rlforj.ui.ascii.CharVisual;

/**
 * Class to create player
 * @author Carlos Castro
 *
 */
public class Player extends MobileObject {
	
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
	
	private int attackBonus = 0;
	private int defenseBonus = 0;
	
	private CharVisual tile;
	private Inventory inventory;
	private SkillList skillList;
	private int skillCounter = 0; // for self-cast skills with duration
	private SelfAction revertSkill = null; // action to revert self-cast skill
        private Weapon currentWeapon;
        private Armor currentArmor;
	private Level[] levels = {new Level(0, 10, 10, 10), 
			new Level(200, 10, 10, 10),
			new Level(800, 10, 10, 10),
			new Level(1600, 10, 10, 10),
			new Level(3200, 10, 10, 10),
			new Level(6400, 15, 15, 15),
			new Level(12800, 15, 15, 15),
			new Level(25600, 15, 15, 15),
			new Level(51200, 15, 15, 15),
			new Level(102400, 15, 15, 15),
			new Level(204800, 20, 20, 20)};
        
	/**
	 * Constructs a new player
	 */
	public Player(){
		gainLevel();
		skillList = new SkillList();
        inventory = new Inventory(5);
		this.tile = new CharVisual('@', Color.RED);
		//inventory = new Inventory(5);
	}
	
	/**
	 * Takes player to the next player by setting stats values
	 */
	public void gainLevel(){
		if(this.experience >= levels[level].getExperience()) {
			// Set base stats
			this.strength += levels[level].getStrength();
			this.intelligence += levels[level].getIntelligence();
			this.dexterity += levels[level].getDexterity();
			
			// Set derived stats
			calculateDerivedStats();
	
			// autoheal at level gain
			this.hp = this.maxHp;
			this.mana = this.maxMana;
			this.level++;
		}
	}

	/**
	 * Calculates stats values
	 */
	private void calculateDerivedStats() {
		
		// Set derived stats
		this.maxHp = strength * 3;
		this.maxMana = intelligence * 2;
		this.attack = strength + attackBonus;
		this.defense = dexterity + defenseBonus;
		
		/*if(oldMaxHp != this.maxHp && oldMaxHp > 0)
			this.hp = this.maxHp * (int)(this.hp / oldMaxHp);
		if(oldMaxMana != this.maxMana && oldMaxMana > 0)
			this.mana = this.maxMana * (int)(this.mana / oldMaxMana);*/
		
		// preserve hp and mana max
		if(this.hp > this.maxHp)
			this.hp = this.maxHp;
		if(this.mana > this.maxMana)
			this.mana = this.maxMana;
	}

	/**
	 * Determines if player is ready for the next level
	 * @return true if player is ready, false otherwise
	 */
	public boolean isReadyForNextLevel(){
		if(level < levels.length) {  // only check until max level
			return experience >= levels[level].getExperience();
		}
		return false;
	}

	/**
     * Method to get the current weapon
     * @return the current weapon
     */
	public Weapon getCurrentWeapon()
	{
		return currentWeapon;
	}
	/**
     * Method to get the current armor
     * @return the current armor
     */
	public Armor getCurrentArmor()
	{
		return currentArmor;
	}
	/**
     * Method to set the current weapon
     * @param the current weapon
     */
	public void setCurrentWeapon(Weapon weapon)
	{
		currentWeapon = weapon;
	}
	/**
     * Method to set the current armor
     * @param the current armor
     */
	public void setCurrentArmor(Armor armor)
	{
		currentArmor = armor;
	}
	
	
	/**
     * Method to take off current armor from Player
     */
	public void unequipedArmor()
	{
		if(currentArmor != null)
		{
			if (currentArmor.getHP() > 0)
			{
				setMaxHp(getMaxHp() - currentArmor.getHP());
			}
			if (currentArmor.getMana() > 0)
			{
				setMaxMana(getMaxMana() - currentArmor.getMana());
			}
			if (currentArmor.getStrength() > 0)
			{
				setStrength(getStrength() - currentArmor.getStrength());
			}
			if  (currentArmor.getDexterity() > 0)
			{
				setDexterity(getDexterity() - currentArmor.getDexterity());
			}
			if (currentArmor.getIntelligence() > 0)
			{
				setIntelligence(getIntelligence() - currentArmor.getIntelligence());
			}
			currentArmor = null;
		}
            
	}
	/**
     * Method to take off current weapon from Player
     */
	public void unequipedWeapon()
	{
		if(currentWeapon != null)
		{
			if (currentWeapon.getHP() > 0)
			{
				setMaxHp(getMaxHp() - currentWeapon.getHP());
			}
			if (currentWeapon.getMana() > 0)
			{
				setMaxMana(getMaxMana() - currentWeapon.getMana());
			}
			if (currentWeapon.getStrength() > 0)
			{
				setStrength(getStrength() - currentWeapon.getStrength());
			}
			if  (currentWeapon.getDexterity() > 0)
			{
				setDexterity(getDexterity() - currentWeapon.getDexterity());
			}
			if (currentWeapon.getIntelligence() > 0)
			{
				setIntelligence(getIntelligence() - currentWeapon.getIntelligence());
			}
			currentWeapon = null;
		}
            
            
	}
	/**
     * Method to equip Player with current weapon
     */
	public void equipWeapon()
	{
		if(currentWeapon != null)
		{
			if (currentWeapon.getHP() > 0)
			{
				setMaxHp(getMaxHp() + currentWeapon.getHP());
			}
			if (currentWeapon.getMana() > 0)
			{
				setMaxMana(getMaxMana() + currentWeapon.getMana());
			}
			if (currentWeapon.getStrength() > 0)
			{
				setStrength(getStrength() + currentWeapon.getStrength());
			}
			if  (currentWeapon.getDexterity() > 0)
			{
				setDexterity(getDexterity() + currentWeapon.getDexterity());
			}
			if (currentWeapon.getIntelligence() > 0)
			{
				setIntelligence(getIntelligence() + currentWeapon.getIntelligence());
			}
		}
            
	}
	/**
     * Method to equip Player with current armor
     */
	public void equipArmor()
	{
		if(currentArmor != null)
		{
			if (currentArmor.getHP() > 0)
			{
				setMaxHp(getMaxHp() + currentArmor.getHP());
			}
			if (currentArmor.getMana() > 0)
			{
				setMaxMana(getMaxMana() + currentArmor.getMana());
			}
			if (currentArmor.getStrength() > 0)
			{
				setStrength(getStrength() + currentArmor.getStrength());
			}
			if  (currentArmor.getDexterity() > 0)
			{
				setDexterity(getDexterity() + currentArmor.getDexterity());
			}
			if (currentArmor.getIntelligence() > 0)
			{
				setIntelligence(getIntelligence() + currentArmor.getIntelligence());
			}
		}
            
	}
	/**
     * Method to determine if Player has weapon equipped
     * @return boolean
     */
	public boolean isWeaponEquiped()
	{
		if (currentWeapon == null)
		{
			return false;
		}
		return true;
            
	}
	/**
     * Method to determine if Player has armor equipped
     * @return boolean
     */
	public boolean isArmorEquiped()
	{
		if (currentArmor == null)
		{
			return false;
		}
		return true;
            
	}
	
	/**
     * Method to apply food in Player
     * @param food
     */
	public void usedFood(Food food)
	{
		setMaxHp(food.getHP() + getMaxHp());
		setMaxMana(getMaxMana() + food.getMana());
		setStrength(getStrength() + food.getStrength());
		setDexterity(getDexterity() + food.getDexterity());
		setIntelligence(getIntelligence() + food.getIntelligence());
            
	}
	
	/**
     * Method to apply potion in Player without going beyond the maximum hit point
     * @param potion
     */
	public void usedPotion(Potion potion)
	{
		if (potion.getHP() >0)
		{
			if(getHp() < getMaxHp())
			{
				if (getHp() + potion.getHP() >= getMaxHp())
				{
					setHp(getMaxHp());
				}
				else
				{
					setHp(getHp() + potion.getHP());
				}
                        
			}
		}
		else if (potion.getMana() > 0)
		{
			if(getMana() < getMaxMana())
			{
				if (getMana() + potion.getMana() >= getMaxMana())
				{
					setMana(getMaxMana());
				}
				else
				{
					setMana(getMana() + potion.getMana());
				}
                        
			}
                
		}
	}
        
	/**
    * Method to add the skill provided by the Scroll
    * @param scroll
    */
	public String usedScroll(Scroll scroll) {
    	return skillList.add(scroll.getSkillType());
    }

    /**
     * Method to get hit point
     * @return value of hit point
     */
	public int getHp() {
		return hp;
	}


    /**
     * Method to set hit point
     * @param value of hit point
     */
	public void setHp(int hp) {
		this.hp = hp;
		setChanged();
	}
	
	// Derived stat has no mutator
	/**
     * Method to get maximum hit point
     * @return value of maximum hit point
     */
	public int getMaxHp() {
		return maxHp;
	}


	// Derived stat has no mutator
	/**
     * Method to get attack
     * @return value of attack
     */
	public int getAttack() {
		return attack;
	}

	// Derived stat has no mutator
	/**
     * Method to get defense
     * @return value of defense
     */
	public int getDefense() {
		return defense;
	}


	/**
     * Method to get value of action to strength
     * @return value of strength
     */
	public int getStrength() {
		return strength;
	}


	/**
     * Method to set strength
     * @param value of strength
     */
	public void setStrength(int strength) {
		this.strength = strength;
		setChanged();
	}


	/**
     * Method to get level
     * @return value of level
     */
	public int getLevel() {
		return level;
	}


	/**
     * Method to set level
     * @param value of level
     */
	public void setLevel(int level) {
		this.level = level;
		setChanged();
	}


	/**
     * Method to get intelligence
     * @return value of intelligence
     */
	public int getIntelligence() {
		return intelligence;
	}


	/**
     * Method to set intelligence
     * @param value of intelligence
     */
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
		//System.out.println("This happened");
		setChanged();
	}


	/**
     * Method to get dexterity
     * @return value of dexterity
     */
	public int getDexterity() {
		return dexterity;
	}


	/**
     * Method to set dexterity
     * @param value of dexterity
     */
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
		setChanged();
	}


	/**
     * Method to get experience
     * @return value of experience
     */
	public int getExperience() {
		return experience;
	}


	/**
     * Method to set experience
     * @param value of experience
     */
	public void setExperience(int experience) {
		this.experience = experience;
		setChanged();
	}


	/**
     * Method to get mana
     * @return value of mana
     */
	public int getMana() {
		return mana;
	}

	// Derived stat has no mutator
	/**
     * Method to set mana
     * @param value of mana
     */
	public void setMana(int mana) {
		this.mana = mana;
		setChanged();
	}
	
	/**
     * Method to set maximum mana
     * @param value of maximum mana
     */
	public void setMaxMana(int maxMana)
    {
    	this.maxMana = maxMana;
        setChanged();
    }
	/**
     * Method to set maximum hit point
     * @param value of maximum hit point
     */
	public void setMaxHp(int maxHp)
    {
    	this.maxHp = maxHp;
        setChanged();
    }

	/**
     * Method to get maximum mana
     * @return value of maximum mana
     */
	public int getMaxMana() {
		return maxMana;
	}


	/**
     * Method to get attackBonus
     * @return value of attackBonus
     */
	public int getAttackBonus() {
		return attackBonus;
	}

	/**
     * Method to set attackBonus
     * @param value of attackBonus
     */
	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
		setChanged();
	}

	/**
     * Method to get defenseBonus
     * @return value of defenseBonus
     */
	public int getDefenseBonus() {
		return defenseBonus;
	}

	/**
     * Method to set defenseBonus
     * @param value of defenseBonus
     */
	public void setDefenseBonus(int defenseBonus) {
		this.defenseBonus = defenseBonus;
		setChanged();
	}

	/**
     * Method to get tile
     * @return value of tile
     */
	public CharVisual getTile() {
		return tile;
	}
	
	/**
     * Method to set tile
     * @param value of tile
     */
	public void setTile(CharVisual tile) {
		this.tile = tile;
	}
	


	/**
     * Method to get inventory
     * @return value of inventory
     */
	public Inventory getInventory() {
		return inventory;
	}


	/**
     * Method to set inventory
     * @param value of inventory
     */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}


	/**
     * Method to get skillList
     * @return value of skillList
     */
	public SkillList getSkillList() {
		return skillList;
	}


	/**
     * Method to set skillList
     * @param value of skillList
     */
	public void setSkillList(SkillList skillList) {
		this.skillList = skillList;
	}
	
	/**
     * Method to add a skillType
     * @param the skillType to be added
     */
	public void addSkillType(SkillType skill) {
		skillList.add(skill);
	}
	
	/**
     * Method to remove a skillType
     * @param the skillType to be removed
     */
	public void removeSkillType(SkillType s) {
		skillList.remove(s);
	}
	
	/**
     * Method to get a skill by index
     * @param index
     * @return the skill
     */
	public SkillAction getSkill(int index) {
		return skillList.get(index).getAction(this);
	}
	
	/**
     * Method to get the equipment menu
     * @return the equipment menu
     */
	public Menu getEquipMenu()
    {
        return inventory.getMenu();
    }

    /**
     * Method to get the skill menu
     * @return the skill menu
     */
	public Menu getSkillMenu() {
	return skillList.getMenu();
	}

	/**
     * Method to get the inventory menu
     * @return the inventory menu
     */
	public Menu getInventoryMenu() {
		return inventory.getMenu();
	}
	
	/**
     * Method to get counter of skill
     * @return value of skill counter
     */
	public int getSkillCounter() {
		return skillCounter;
	}

	/**
     * Method to set counter of skill
     * @param value of skill counter
     */
	public void setSkillCounter(int skillCounter) {
		this.skillCounter = skillCounter;
	}

	/**
     * Method to increment counter of skill by 1 unit
     */
	public void incrementSkillCounter() {
		skillCounter++;
	}

	/**
     * Method to decrement counter of skill by 1 unit
     */
	public void decrementSkillCounter() {
		if(skillCounter > 0)
			skillCounter--;
		if(skillCounter == 0 && revertSkill != null) {
			revertSkill.execute(this);
			revertSkill = null;
		}
	}

	/**
     * Method to get value of action to revert self-cast skill
     * @return value of revert skill
     */
	public SelfAction getRevertSkill() {
		return revertSkill;
	}

	/**
     * Method to set value of action to revert self-cast skill
     * @param value of revert skill
     */
	public void setRevertSkill(SelfAction revertSkill) {
		this.revertSkill = revertSkill;
	}
	
	/**
     * Checks if status has changed
     */
	public void checkStatus()
	{
		if(hasChanged()) 
		{
			calculateDerivedStats();
            notifyObservers();
			clearChanged();
		}
	}
        
	
}
