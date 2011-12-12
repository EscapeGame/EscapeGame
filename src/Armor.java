
/**
 * Class to create armor objects
 * @author Thanh Au
 */
public class Armor extends EquippableItem 
{
    private int hp;
    private int mana;
    private int strength;
    private int intelligence;
    private int dexterity;

    /**
     * Constructs new armor object
     * @param name armor name
     * @param description armor description
     * @param numItem number of objects for this armor
     * @param symbol character that will be displayed on map for this armor
     * @param hp how much will be added to player hp
     * @param mana how much will be added to player mana
     * @param strength how much will be added to player strength
     * @param intelligence how much will be added to player intelligence
     * @param dexterity how much will be added to player dexterity
     */
    public Armor(String name, String description, int numItem, char symbol, int hp, int mana, int strength, int intelligence, int dexterity) 
    {
        super(name, description, numItem, symbol);
        this.hp = hp;
        this.mana = mana;
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
    }
    
    /**
     * Method to get Strength
     * @return value of strength
     */
    public int getStrength()
    {
        return strength;
    }
    
    /**
     * Method to set Strength
     * @param value of strength
     */
    public void setStrength(int strength)
    {
        this.strength = strength;
    }
    
    /**
     * Method to get dexterity
     * @return value of dexterity
     */
    public int getDexterity()
    {
        return dexterity;
    }
    
    /**
     * Method to set dexterity
     * @param value of dexterity
     */
    public void setDexterity(int dexterity)
    {
        this.dexterity = dexterity;
    }
    
    /**
     * Method to get intelligence
     * @return value of intelligence
     */
    public int getIntelligence()
    {
        return intelligence;
    }
    
    /**
     * Method to set intelligence
     * @param value of intelligence
     */
    public void setIntelligence(int intelligence)
    {
        this.intelligence = intelligence;
    }
    
    /**
     * Method to get hit point
     * @return value of hit point
     */
    public int getHP()
    {
        return hp;
    }
    
    /**
     * Method to set hit point
     * @param value of hit point
     */
    public void setHp(int hp)
    {
        this.hp = hp;
    }
    
    /**
     * Method to get mana
     * @return value of mana
     */
    public int getMana()
    {
        return mana;
    }
    
    /**
     * Method to set mana
     * @param value of mana
     */
    public void setMana(int mana)
    {
        this.mana = mana;
    }

    /**
     * Displays short information about armor
     */
    public void display ()
    {
        System.out.println("Name = " + getName() + " number item = " + getNumberItem());
    }
    
    /**
     * Displays full information about armor
     */
    public void displayFullInformation()
    {
        System.out.println("Name = " + getName());
        System.out.println("Decription" + getDescription());
        System.out.println("Hp = " + getHP() + " Mana = " + getMana() + " Str = " 
                + getStrength() + " Dex = " + getDexterity() + " Int = " + getIntelligence());
    }
    /*
    @Override
    public String toString()
    {
        return "Name = " + getName() + " number item = " + getNumberItem();
    }
     */
    
}
