/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Au
 */
public class Food extends ConsumableItem
{
    private String name;
    private String description;
    private int numItem;
    private int hp;
    private int mana;
    private int strength;
    private int intelligence;
    private int dexterity;
    
    public int getStrength()
    {
        return strength;
    }
    public void setStrength(int strength)
    {
        this.strength = strength;
    }
    public int getDexterity()
    {
        return dexterity;
    }
    public void setDexterity(int dexterity)
    {
        this.dexterity = dexterity;
    }
    public int getIntelligence()
    {
        return intelligence;
    }
    public void setIntelligence(int intelligence)
    {
        this.intelligence = intelligence;
    }
    public int getHP()
    {
        return hp;
    }
    public void setHp(int hp)
    {
        this.hp = hp;
    }
    public int getMana()
    {
        return mana;
    }
    public void setMana(int mana)
    {
        this.mana = mana;
    }
    
}
