import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class Player extends MobileObject {
	
	public Player(){
		gainLevel();
		skillList = new SkillList();
        inventory = new Inventory(5);
		this.tile = new CharTile('@', Color.RED);
		//inventory = new Inventory(5);
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
	
	private int attackBonus = 0;
	private int defenseBonus = 0;
	
	private CharTile tile;
	private Inventory inventory;
	private SkillList skillList;
	private int skillCounter = 0; // for self-cast skills with duration
	private SelfAction revertSkill = null; // action to revert self-cast skill
        private Weapon currentWeapon;
        private Armor currentArmor;
	private Level[] levels = {new Level(0, 10, 10, 10), 
			new Level(200, 10, 10, 10),
			new Level(400, 10, 10, 10),
			new Level(800, 10, 10, 10),
			new Level(1600, 10, 10, 10),
			new Level(3200, 15, 15, 15),
			new Level(6400, 15, 15, 15),
			new Level(12800, 15, 15, 15),
			new Level(25600, 15, 15, 15),
			new Level(51200, 15, 15, 15),
			new Level(102400, 20, 20, 20)};
        
	
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

	private void calculateDerivedStats() {
    	int oldMaxHp = this.maxHp;
    	int oldMaxMana = this.maxMana;
		
		// Set derived stats
		this.maxHp = strength * 3;
		this.maxMana = intelligence * 2;
		this.attack = strength + attackBonus;
		this.defense = dexterity + defenseBonus;
		
		// truncate hp if it is above new max
		if(this.hp > this.maxHp)
			this.hp = this.maxHp;
		/*else 
			this.hp = this.maxHp * (this.hp / oldMaxHp);*/

		// truncate mana if it is above new max
		if(this.mana > this.maxMana)
			this.mana = this.maxMana;
		/*else 
			this.mana = this.maxMana * (this.mana / oldMaxMana);*/
	}

	
	public boolean isReadyForNextLevel(){
		if(level < levels.length) {  // only check until max level
			return experience >= levels[level].getExperience();
		}
		return false;
	}

        public Weapon getCurrentWeapon()
        {
            return currentWeapon;
        }
        public Armor getCurrentArmor()
        {
            return currentArmor;
        }
        public void setCurrentWeapon(Weapon weapon)
        {
            currentWeapon = weapon;
        }
        public void setCurrentArmor(Armor armor)
        {
            currentArmor = armor;
        }
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
        public boolean isWeaponEquiped()
        {
            if (currentWeapon == null)
            {
                return false;
            }
            return true;
            
        }
        public boolean isArmorEquiped()
        {
            if (currentArmor == null)
            {
                return false;
            }
            return true;
            
        }
        public void usedFood(Food food)
        {
            setMaxHp(food.getHP() + getMaxHp());
            setMaxMana(getMaxMana() + food.getMana());
            setStrength(getStrength() + food.getStrength());
            setDexterity(getDexterity() + food.getDexterity());
            setIntelligence(getIntelligence() + food.getIntelligence());
            
        }
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
        
    public boolean usedScroll(Scroll scroll) {
    	return skillList.add(scroll.getSkillType());
    }

    public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
		setChanged();
	}
	
	// Derived stat has no mutator
	public int getMaxHp() {
		return maxHp;
	}


	// Derived stat has no mutator
	public int getAttack() {
		return attack;
	}

	// Derived stat has no mutator
	public int getDefense() {
		return defense;
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
		//System.out.println("This happened");
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
	
        public void setMaxMana(int maxMana)
        {
            this.maxMana = maxMana;
        }
        public void setMaxHp(int maxHp)
        {
            this.maxHp = maxHp;
        }
	// Derived stat has no mutator
	public int getMaxMana() {
		return maxMana;
	}


	public int getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
		setChanged();
	}

	public int getDefenseBonus() {
		return defenseBonus;
	}

	public void setDefenseBonus(int defenseBonus) {
		this.defenseBonus = defenseBonus;
		setChanged();
	}

	public CharTile getTile() {
		return tile;
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


	public SkillList getSkillList() {
		return skillList;
	}


	public void setSkillList(SkillList skillList) {
		this.skillList = skillList;
	}
	
	public void addSkillType(SkillType skill) {
		skillList.add(skill);
	}
	
	public void removeSkillType(SkillType s) {
		skillList.remove(s);
	}
	
	public SkillAction getSkill(int index) {
		return skillList.get(index).getAction(this);
	}
	
        public Menu getEquipMenu()
        {
            return inventory.getMenu();
        }
	
	public Menu getSkillMenu() {
		return skillList.getMenu();
	}

	public Menu getInventoryMenu() {
		return inventory.getMenu();
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
