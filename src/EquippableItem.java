import java.awt.Color;

import rlforj.ui.ascii.CharVisual;


/**
 * Class to create equipable item
 * @author Thanh Au
 */
public class EquippableItem implements Item, MapObject
{
    private String name;
    private String description;
    private int numItem;
    private char symbol;

    /**
     * Constructs a new equippable item
     * @param name item name
     * @param description item description
     * @param numItem number of objects for this item
     * @param symbol character that will be displayed on map for this armor
     */
    public EquippableItem(String name, String description, int numItem, char symbol) {
        this.name = name;
        this.description = description;
        this.numItem = numItem;
        this.symbol = symbol;
    }

    /**
     * Constructs a new equippable item
     */
    public EquippableItem()
    {
    	name = "Equip Item";
    	description = "";
    	numItem = 1;
    	symbol = '!';
    }
   
    @Override
    public char getSymbol()
    {
        return symbol;
    }
    
    @Override
    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }

    @Override
    public String getName() 
    {
        return name;
    }
    
    @Override
    public void setName(String name) 
    {
        this.name = name;
    }
    
    @Override
    public String getDescription() 
    {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getNumberItem() {
        return numItem;
    }

    @Override
    public void setNumberItem(int numItem) 
    {
        this.numItem = numItem;
        
    }
    
    @Override
    public void displayItem()
    {
        System.out.println("Name = " + name + " ,Number Item = " + numItem);
    }
    
    @Override
    public CharVisual getTile() 
    {
    	return new CharVisual(symbol, Color.YELLOW);
    }
    
    @Override
    public String toString()
    {
        return getName();
    }
    
}
