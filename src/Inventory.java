
import java.util.ArrayList;
import java.util.Observable;

/**
 * Class to create inventory
 * @author Thanh Au
 */
public class Inventory extends Observable
{
    Armor [] listArmor;
    Scroll [] listScroll;
    Food[] listFood;
    Potion[] listPotion;
    private ArrayList<Item>  list;
    Weapon sword1 = new Weapon("Rusty sword", "", 1, '|', 0, 0, 10, 0, 5);
    Potion potion1 = new Potion("Hp potion", "Heal 50 Hp", 1, ',', 50, 0);
    Potion potion2 = new Potion("Mana potion", "Heal 50 Mana", 1,',', 0, 50);
	Scroll scroll = new Scroll("Skill scroll", "Read to learn a random skill.", 1, '?', SkillType.random());
    Weapon currentWeapon;
    Armor currentArmor;
    
    /**
     * Creates new inventory
     * @param max maximum number of items in inventory
     */
    public Inventory(int max)
    {
    	list = new ArrayList<Item>(max);
    	listArmor = new Armor[max];
    	listPotion = new Potion[max];
    	listFood = new Food[max];
    	listScroll = new Scroll[max];
    	list.add(sword1);
    	list.add(potion1);
    	list.add(potion2);
    	list.add(scroll);
	}

    /**
     * Gets inventory list
     * @return inventory list
     */
    public ArrayList<Item> getlistItem()
    {
    	return list;
    }
    
    /**
     * Sets new inventory list
     * @param listItem inventory list
     */
    public void setListItem(ArrayList<Item> listItem)
    {
    	list = listItem;
    }
    
    /**
     * Gets item from inventory at specified index
     * @param index index of item
     * @return item
     */
    public Item getItem(int index)
    {
    	return list.get(index);
    }
    
    /**
     * Adds item to inventory
     * @param item item to add
     * @return true if item was added, false otherwise
     */
    public boolean add(Item item)
    {
    	boolean isAdd = false;
    	//System.out.println("Size = " + list.size());
    	if (list.isEmpty())
    	{
    		System.out.println("Empty");
    		list.add(item);
    		setChanged();
    		notifyObservers(list);
    		return true;
    	}
    	else
    	{
    		int index = -1;
    		for (int i = 0; i < list.size(); i++)
    		{
    			if (item.getName().equals(list.get(i).getName()))
    				index = i;
    		}
    		
    		if(index != -1)
    		{
    			//System.out.println("Increase the number");
    			isAdd = true;
    			list.get(index).setNumberItem(list.get(index).getNumberItem() + 1);
    			setChanged();
    			notifyObservers(list);
    			//return isAdd;
    		}
    		else
    		{
    			//System.out.println("Add success");
    			isAdd= true;
    			list.add(item);
    			setChanged();
    			notifyObservers(list);
    			//return isAdd;
    		}
                
    	}
    	return isAdd;
    }
    
    /**
     * Removes item from inventory
     * @param item item to remove
     * @return true if item was removed, false otherwise
     */
    public boolean remove(Item item)
    {
    	boolean isRemove = false;
    	if (list.isEmpty())
    	{
    		return false;
    	}
    	else
    	{
    		for (int i = 0; i < list.size(); i++)
    		{
    			if (list.get(i) == null)
    			{
    				continue;
    			}
    			else if (list.get(i) == item)
    			{
    				isRemove = true;
    				if (list.get(i).getNumberItem() > 1)
    				{
    					list.get(i).setNumberItem(list.get(i).getNumberItem() -1);
    					setChanged();
    					notifyObservers(list);
    					return isRemove;
    				}
    				else
    				{
    					list.remove(i);
    					setChanged();
    					notifyObservers(list);
    					return isRemove;
    				}

    			}
    		}
    	}
    	return isRemove;
    }
    
    /**
     * Check if inventory is full
     * @return true if full, false otherwise
     */
    public boolean isFull()
    {
    	int size = 0;
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) != null)
				size++;
		}
		return size == list.size();
	}
	
    /**
     * Check if item is in inventory    
     * @param item item
     * @return true if item is in inventory, false otherwise
     */
	public boolean contains(Item item) 
	{
		if (list.isEmpty())
		{
			return false;
		}
		else
		{
			for (int i = 0; i < list.size(); i++)
			{
				if (list.get(i) == null)
				{
					continue;
				}
				else if (list.get(i).getName().equals(item.getName()))
				{
					//isRemove = true;
					return true;

				}
			}
                
		}
		return false;
		
	}

	/**
	 * Gets menu for current inventory
	 * @return inventory menu
	 */
    public Menu getMenu() {
		return new Menu(list, "Items in your inventory.", "abcdefghijklmnopqrstuvwxyz");
	}

    /**
     * Notifies observers if the object has changed
     */
	public void checkStatus()
	{
		if(hasChanged()) 
		{
            notifyObservers();
			clearChanged();
		}
	}
}
