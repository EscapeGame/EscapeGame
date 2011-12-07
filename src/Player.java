import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;

public class Player extends MobileObject {
	
	public Player(){
		gainLevel();
		skillList = new SkillActionList(this);
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
	private CharTile tile;
	private Inventory inventory;
	private SkillActionList skillList;
	private int skillCounter = 0; // for self-cast skills with duration
	private SelfAction revertSkill = null; // action to revert self-cast skill
        private Weapon currentWeapon;
        private Armor currentArmor;
	private Level[] levels = {new Level(0, 10, 10, 10, 10, 10, 10, 10), 
			new Level(100, 20, 20, 20, 20, 20, 20, 20)};
        
	
	private void gainLevel(){
		this.maxHp += levels[level].getMaxHp();
		this.hp = this.maxHp;
		this.attack += levels[level].getAttack();
		this.defense += levels[level].getDefense();
		this.strength += levels[level].getStrength();
		this.intelligence += levels[level].getIntelligence();
		this.dexterity += levels[level].getDexterity();
		this.maxMana += levels[level].getMaxMana();
		this.mana = this.maxMana;
		this.experience = 0;
		this.level++;
	}
	/*
	public void gainLevel(Color col){
		this.tile.setColor(col);
		gainLevel();
	}
         * 
         */
	
	public boolean isReadyForNextLevel(){
		return experience >= levels[level].getExperience(); 
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
                    setHp(getMaxHp() + currentArmor.getHP());
                }
                if (currentArmor.getMana() > 0)
                {
                    setMana(getMaxMana() + currentArmor.getMana());
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
        public void unequipedWeapon()
        {
            if(currentWeapon != null)
            {
                if (currentWeapon.getHP() > 0)
                {
                    setHp(getMaxHp() - currentWeapon.getHP());
                }
                if (currentWeapon.getMana() > 0)
                {
                    setMana(getMaxMana() - currentWeapon.getMana());
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
                    setHp(getMaxHp() + currentWeapon.getHP());
                }
                if (currentWeapon.getMana() > 0)
                {
                    setMana(getMaxMana() + currentWeapon.getMana());
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
                    setHp(getMaxHp() + currentArmor.getHP());
                }
                if (currentArmor.getMana() > 0)
                {
                    setMana(getMaxMana() + currentArmor.getMana());
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
        public EquipMenu getEquipMenu()
        {
            return inventory.getMenu();
        }
	
	public Menu getSkillMenu() {
		return skillList.getMenu();
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
			skillList = new SkillActionList(this); // update skills @todo should also incorporate new skills learned
			
                        notifyObservers();
			clearChanged();
		}
	}
        
	
}
