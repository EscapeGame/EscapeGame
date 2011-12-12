/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class to create potion object
 * @author Thanh Au
 */
public class Potion extends ConsumableItem
{

    private int hp;
    private int mana;

    /**
     * Constructs new portion object
     * @param name potion name
     * @param description potion description
     * @param numItem number of objects for this potion
     * @param symbol character that will be displayed on map for this potion
     * @param hp how much will be added to player hp
     * @param mana how much will be added to player mana
     */
    public Potion(String name, String description, int numItem,char symbol, int hp, int mana) {
        super(name, description, numItem, symbol);
        
        this.hp = hp;
        this.mana = mana;
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
    
    
}
