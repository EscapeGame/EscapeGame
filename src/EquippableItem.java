import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Au
 */
public class EquippableItem implements Item, MapObject
{
    private String name;
    private String description;
    private int numItem;
    private char symbol;

    public EquippableItem(String name, String description, int numItem, char symbol) {
        this.name = name;
        this.description = description;
        this.numItem = numItem;
        this.symbol = symbol;
    }

   public EquippableItem()
   {
       name = "Equip Item";
       description = "";
       numItem = 0;
       symbol = '!';
   }
   
    public char getSymbol()
    {
        return symbol;
    }
    
    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }
     /*
     * This method is get name
     * @return name
     */
    @Override
    public String getName() 
    {
        return name;
    }
    
      /*
     * This method is set name
     * @param name change name
     */
    @Override
    public void setName(String name) 
    {
        this.name = name;
    }
    
     /*
     * This method is get description
     * @return description of item
     */
    @Override
    public String getDescription() 
    {
        return description;
    }

    /*
     * This method is set description
     * @param description description of item
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * This method is get number of item
     * @return number of item
     */
    @Override
    public int getNumberItem() {
        return numItem;
    }

    /*
     * This method is set number of item
     * @return number of item
     */
    @Override
    public void setNumberItem(int numItem) {
        this.numItem = numItem;
        
    }
    public void displayItem()
    {
        System.out.println("Name = " + name + " ,Number Item = " + numItem);
    }
    
    /*
     * This method get tite
     * @return tite in the map
     */
    public CharTile getTile() {
	return new CharTile(symbol, Color.PINK);
    }
    
    /*
     * This method is display name and number of item
     * @return string of infomation
     */
    @Override
    public String toString()
    {
        return "Name = " + getName() + " number item = " + getNumberItem();
    }
    
}
