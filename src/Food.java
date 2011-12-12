/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class to create food objects
 * @author Thanh Au
 */
public class Food extends ConsumableItem
{
    private int hp;
    private int mana;
    private int strength;
    private int intelligence;
    private int dexterity;
    
    /**
     * Constructs new food object
     * @param name food name
     * @param description food description
     * @param numItem number of objects for this food
     * @param symbol character that will be displayed on map for this food
     * @param hp how much will be added to player hp
     * @param mana how much will be added to player mana
     * @param strength how much will be added to player strength
     * @param intelligence how much will be added to player intelligence
     * @param dexterity how much will be added to player dexterity
     */
    public Food(String name, String description, int numItem, char symbol, int hp, int mana, int strength, int intelligence, int dexterity) 
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
    
}
