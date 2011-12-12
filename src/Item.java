
/**
 * Interface for creating items
 * @author Thanh Au
 */
public interface Item {
	/**
	 * Method to get item name
	 * @return name
	 */
    public String getName();
    
    /**
     * Sets item name
     * @param name name of item
     */
    public void setName(String name);
    
    /**
     * Method to get item description
     * @return item description
     */
    public String getDescription();
    
    /**
     * Sets item description
     * @param description
     */
    public void setDescription(String description);
    
    /**
     * Method to get number of items
     * @return number of items
     */
    public int getNumberItem();
    
    /**
     * Sets number of items
     * @param numItem number of items
     */
    public void setNumberItem(int numItem);
    
    /**
     * Method to get character representation of item
     * @return character that represents
     */
    public char getSymbol();
    
    /**
     * Sets character representation of item
     * @param character that represents item
     */
    public void setSymbol(char symbol);
    
    /**
     * Displays item info
     */
    public void displayItem();
    
}
