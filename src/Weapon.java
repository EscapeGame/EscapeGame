/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Au
 */
public class Weapon extends EquippableItem
{
    private String name;
    private String description;
    private int numItem;
    private int hp;
    private int mana;
    private int strength;
    private int intelligence;
    private int dexterity;
    
    public Weapon()
    {
        super();
        hp = 0;
        mana =0;
        strength = 0;
        intelligence = 0;
        dexterity = 0;
    }
            
    public Weapon(String name, String description, int numItem, char symbol, int hp, int mana, int strength, int intelligence, int dexterity) 
    {
        super(name, description, numItem, symbol);
        this.hp = hp;
        this.mana = mana;
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
    }
    
    /*
     * This method is get Strength
     * @return value of strength
     */
    public int getStrength()
    {
        return strength;
    }
    
    /*
     * This method is set Strength
     * @param value of strength
     */
    public void setStrength(int strength)
    {
        this.strength = strength;
    }
    /*
     * This method is get dexterity
     * @return value of dextertiy
     */
    public int getDexterity()
    {
        return dexterity;
    }
    
    /*
     * This method is set dexterity
     * @param value of dexterity
     */
    public void setDexterity(int dexterity)
    {
        this.dexterity = dexterity;
    }
    
    /*
     * This method is get intelligence
     * @return value of intelligence
     */
    public int getIntelligence()
    {
        return intelligence;
    }
    
    /*
     * This method is set intelligence
     * @param value of intelligence
     */
    public void setIntelligence(int intelligence)
    {
        this.intelligence = intelligence;
    }
    
    /*
     * This method is get hit point
     * @return value of hit point
     */
    public int getHP()
    {
        return hp;
    }
    
    /*
     * This method is set hit point
     * @param value of hit point
     */
    public void setHp(int hp)
    {
        this.hp = hp;
    }
    
    /*
     * This method is get mana
     * @return value of mana
     */
    public int getMana()
    {
        return mana;
    }
    /*
     * This method is set mana
     * @param value of mana
     */
    public void setMana(int mana)
    {
        this.mana = mana;
    }
    
            
}