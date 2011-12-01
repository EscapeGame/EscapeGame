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
