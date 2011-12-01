/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Au
 */
public class ConsumableItem implements Item
{
    private String name;
    private String description;
    private int numItem;
    private char symbol;

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
    public void displayItem()
    {
        System.out.println("Name = " + name + " ,Number Item = " + numItem);
    }
    @Override
    public String toString()
    {
        return "Name = " + getName() + " number item = " + getNumberItem();
    }
    
}
