
import java.awt.Color;

import rlforj.ui.ascii.CharVisual;

/**
 * Class to create consumable item
 * @author Thanh Au
 */
public class ConsumableItem implements Item, MapObject
{
	private String name;
    private String description;
    private int numItem;
    private char symbol;

    /**
     * Constructs a new consumable item
     * @param name item name
     * @param description item description
     * @param numItem number of objects for this item
     * @param symbol character that will be displayed on map for this armor
     */
    public ConsumableItem(String name, String description, int numItem, char symbol) 
    {
        this.name = name;
        this.description = description;
        this.numItem = numItem;
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
    public void setNumberItem(int numItem) {
        this.numItem = numItem;
        
    }
    
    @Override
    public char getSymbol() {
		return symbol;
	}

    /*
     * This method is set symbol
     */
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
    
    public void displayItem()
    {
        System.out.println("Name = " + name + " ,Number Item = " + numItem);
    }
    
    /*
     * This method is display name and number of item
     * @return string of infomation
     */
    @Override
    public String toString()
    {
    	return getName() + " (" + numItem + ")";
    }
    
    public CharVisual getTile() {
    	return new CharVisual(symbol, Color.CYAN);
    }
    
}
