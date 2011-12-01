import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Au
 */
public class Armor extends EquippableItem 
{
    private String name;
    private String description;
    private int numItem;
    private int hp;
    private int mana;
    private int strength;
    private int intelligence;
    private int dexterity;

    public Armor(String name, String description,char symbol, int numItem, int hp, int mana, int strength, int intelligence, int dexterity) 
    {
        super(name, description, numItem, symbol);
        this.hp = hp;
        this.mana = mana;
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
    }
    
    
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
