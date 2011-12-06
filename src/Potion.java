/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Au
 */
public class Potion extends ConsumableItem
{
    private String name;
    private String description;
    private int numItem;
    private int hp;
    private int mana;

    public Potion(String name, String description, int numItem,char symbol, int hp, int mana) {
        super(name, description, numItem, symbol);
        
        this.hp = hp;
        this.mana = mana;
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
