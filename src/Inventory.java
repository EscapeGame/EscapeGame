
import java.util.ArrayList;
import java.util.Observable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Au
 */
public class Inventory extends Observable
{
    private Weapon[] listWeapon;
    Armor [] listArmor;
    Scroll [] listScroll;
    Food[] listFood;
    Potion[] listPotion;
    private Menu menu;
    private ArrayList<Item>  list;
    Weapon sword1 = new Weapon("Rusty sword", "", 1, '/', 0, 0, 5, 5, 5);
    Weapon sword2 = new Weapon("Good sword", "", 1, '/', 0, 0, 50, 50, 50);
    Weapon sword3 = new Weapon("Excalabur", "", 1, '/', 0, 0, 100, 100, 100);
    Potion potion1 = new Potion("Hp potion", "Heal 50 Hp", 0, ',', 50, 0);
    Potion potion2 = new Potion("Mana potion", "Heal 50 Mana", 0,',', 0, 50);
    Food food1 = new Food("Apple of Intelligence", "Increase your intelligence", 0, ',', 0, 0, 0, 1, 0);
    Weapon currentWeapon;
    Armor currentArmor;
    
        public Inventory(int max)
        {
            list = new ArrayList<Item>(max);
            listWeapon = new Weapon[max];
            listArmor = new Armor[max];
            listPotion = new Potion[max];
            listFood = new Food[max];
            listScroll = new Scroll[max];
            list.add(sword1);
            list.add(sword2);
            list.add(sword3);
            list.add(potion1);
            menu = getMenu();
            
	}
        /*public Inventory()
        {
            listWeapon = new Weapon[5];
            listArmor = new Armor[5];
            listPotion = new Potion[5];
            listFood = new Food[5];
            listScroll = new Scroll[5];
            add(sword1);
            //list.add("1" + getWeapon(0).getName());
            //list.add("2");
            menu = new EquipMenu(list);
            
	}*/
        public ArrayList<Item> getlistItem()
        {
            return list;
        }
        public void setListItem(ArrayList<Item> listItem)
        {
            list = listItem;
        }
        public Item getItem(int index)
        {
            return list.get(index);
        }
        public boolean add(Item item)
        {
            boolean isAdd = false;
            System.out.println("Size = " + list.size());
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
                for (int i = 0; i <= list.size(); i++)
                {
                   
                   if(list.get(i) == item)
                   {
                       System.out.println("Increase the number");
                        isAdd = true;
                        list.get(i).setNumberItem(list.get(i).getNumberItem() + 1);
                        setChanged();
                        notifyObservers(list);
                        return isAdd;
                   }
                   else
                   {
                       System.out.println("Add success");
                       isAdd= true;
                       list.add(item);
                       setChanged();
                       notifyObservers(list);
                       return isAdd;
                   }
                }
            }
            return isAdd;
        }
        
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
        public boolean isFull(){
		int size = 0;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i) != null)
				size++;
		}
		return size == list.size();
	}
	
	public boolean contains(Item item) {
		for (Item i : list){
			if (i == item)
                            return true;
		}
		return false;
	}
        /*
        public Weapon[] getListWeapon() 
        {
            return listWeapon; 
        }
        public Armor[] getListArmor()
        {
            return listArmor;
        }
        public Scroll[] getListScroll()
        {
            return listScroll;
        }
        public Food[] getListFood()
        {
            return listFood;
        }
        public Potion[] getListPotion()
        {
            return listPotion;
        }
        public Weapon getWeapon(int i)
        {
            return listWeapon[i];
        }
        public Armor getAmor(int i)
        {
            return listArmor[i];
        }
        public Scroll getScroll(int i)
        {
            return listScroll[i];
        }
        public Food getFood(int i)
        {
            return listFood[i];
        }
        public Potion getPotion(int i)
        {
            return listPotion[i];
        }
	
	
	public boolean add (Item item)
        {
            boolean isAdd = false;
            if (item instanceof Weapon)
            {
                Weapon newWeapon = (Weapon) item;
                for (int i = 0; i < listWeapon.length; i++)
                {
                    if (listWeapon[i] == null)
                    {
                        isAdd = true;
                        listWeapon[i] = newWeapon;
                        return true;
                    }
                    else if (listWeapon[i].getName().equalsIgnoreCase(newWeapon.getName()))
                    {
                        isAdd = true;
                        listWeapon[i].setNumberItem(listWeapon[i].getNumberItem() + 1);
                        return true;
                    }
                }
            }
            else if (item instanceof Armor)
            {
                Armor newArmor = (Armor) item;
                for (int i = 0; i < listArmor.length; i++)
                {
                    if (listArmor[i] == null)
                    {
                        isAdd = true;
                        listArmor[i] = newArmor;
                        return isAdd;
                    }
                    else if (listArmor[i].getName().equalsIgnoreCase(newArmor.getName()))
                    {
                        isAdd = true;
                        listArmor[i].setNumberItem(listArmor[i].getNumberItem() + 1);
                        return isAdd;
                    }
                }
                
            }
            else if (item instanceof Potion)
            {
                Potion newPotion =(Potion) item;
                for (int i = 0; i < listPotion.length; i++)
                {
                    if (listPotion[i] == null)
                    {
                        isAdd = true;
                        listPotion[i] = newPotion;
                        return isAdd;
                    }
                    else if (listPotion[i].getName().equalsIgnoreCase(newPotion.getName()))
                    {
                        isAdd = true;
                        listPotion[i].setNumberItem(listPotion[i].getNumberItem() + 1);
                        return isAdd;
                    }
                        
                }
            }
            else if (item instanceof Scroll)
            {
                Scroll newScroll =(Scroll) item;
                for (int i = 0; i < listScroll.length; i++)
                {
                    if (listScroll[i] == null)
                    {
                        isAdd = true;
                        listScroll[i] = newScroll;
                        return isAdd;
                    }
                    else if (listScroll[i].getName().equalsIgnoreCase(newScroll.getName()))
                    {
                        isAdd = true;
                        listScroll[i].setNumberItem(listScroll[i].getNumberItem() + 1);
                        return isAdd;
                    }
                        
                }
                
            }
            else if (item instanceof Food)
            {
                Food newFood =(Food) item;
                for (int i = 0; i < listFood.length; i++)
                {
                    if (listFood[i] == null)
                    {
                        isAdd = true;
                        listFood[i] = newFood;
                        return isAdd;
                    }
                    else if (listFood[i].getName().equalsIgnoreCase(newFood.getName()))
                    {
                        isAdd = true;
                        listFood[i].setNumberItem(listFood[i].getNumberItem() + 1);
                        return isAdd;
                    }
                        
                }
                
            }
            return isAdd;
                    
        }

	public boolean remove(Item item){
		boolean isRemove = false;
            if (item instanceof Weapon)
            {
                Weapon newWeapon = (Weapon) item;
                for (int i = 0; i < listWeapon.length; i++)
                {
                    if (listWeapon[i] == null)
                    {
                        continue;
                    }
                    else if (listWeapon[i].getName().equalsIgnoreCase(newWeapon.getName()))
                    {
                        isRemove = true;
                        if (listWeapon[i].getNumberItem() > 1)
                        {
                            
                            listWeapon[i].setNumberItem(listWeapon[i].getNumberItem() -1);
                            return isRemove;
                        }
                        else
                        {
                            listWeapon[i] = null;
                            return isRemove;
                        }
                    }
                }
            }
            else if (item instanceof Armor)
            {
                Armor newArmor = (Armor) item;
                for (int i = 0; i < listArmor.length; i++)
                {
                    if (listArmor[i] == null)
                    {
                        continue;
                    }
                    else if (listArmor[i].getName().equalsIgnoreCase(newArmor.getName()))
                    {
                        isRemove = true;
                        if (listArmor[i].getNumberItem() > 1)
                        {
                            
                            listArmor[i].setNumberItem(listArmor[i].getNumberItem() - 1);
                            return isRemove;
                        }
                        else
                        {
                            listArmor[i] = null;
                            return isRemove;
                        }
                    }
                }
                
            }
            else if (item instanceof Potion)
            {
                Potion newPotion =(Potion) item;
                for (int i = 0; i < listPotion.length; i++)
                {
                    if (listPotion[i] == null)
                    {
                        continue;
                    }
                    else if (listPotion[i].getName().equalsIgnoreCase(newPotion.getName()))
                    {
                        isRemove = true;
                        if (listPotion[i].getNumberItem() > 1)
                        {
                            
                            listPotion[i].setNumberItem(listPotion[i].getNumberItem() - 1);
                            return isRemove;
                            
                        }
                        else
                        {
                            listPotion[i] = null;
                            return isRemove;
                        }
                        
                        
                    }
                        
                }
            }
            else if (item instanceof Scroll)
            {
                Scroll newScroll =(Scroll) item;
                for (int i = 0; i < listScroll.length; i++)
                {
                    if (listScroll[i] == null)
                    {
                       continue;
                    }
                    else if (listScroll[i].getName().equalsIgnoreCase(newScroll.getName()))
                    {
                        isRemove = true;
                        if(listScroll[i].getNumberItem() > 1)
                        {
                        
                        listScroll[i].setNumberItem(listScroll[i].getNumberItem() -1);
                        return isRemove;
                        }
                        else
                        {
                            listScroll[i] = null;
                            return isRemove;
                        }
                    }
                        
                }
                
            }
            else if (item instanceof Food)
            {
                Food newFood =(Food) item;
                for (int i = 0; i < listFood.length; i++)
                {
                    if (listFood[i] == null)
                    {
                        continue;
                    }
                    else if (listFood[i].getName().equalsIgnoreCase(newFood.getName()))
                    {
                        isRemove = true;
                        if (listFood[i].getNumberItem() > 1)
                        {
                            listFood[i].setNumberItem(listFood[i].getNumberItem() - 1);
                            return isRemove;
                            
                        }
                        else
                        {
                            listFood[i] = null;
                            return isRemove;
                        }
                        
                        
                    }
                        
                }
                
            }
            return isRemove;
	}

	public boolean contains(Item item) 
        {
            if (item instanceof Weapon)
            {
                Weapon weapon = (Weapon) item;
                for (Weapon i : listWeapon)
                {
                    if (i == weapon)
                        return true;
                }
            }
            else if (item instanceof Armor)
            {
                Armor armor = (Armor) item;
                for (Armor i : listArmor)
                {
                    if (i == armor)
                    {
                        return true;
                    }
                }
            }
            else if (item instanceof Potion)
            {
                Potion potion = (Potion) item;
                for (Potion i : listPotion)
                {
                    if (i == potion)
                    {
                        return true;
                    }
                }
            }
            else if (item instanceof Scroll )
            {
                Scroll scroll = (Scroll) item;
                for (Scroll i : listScroll)
                {
                    if (i == scroll)
                    {
                        return true;
                    }
                }
            }
            return false;
	
         * 
         */
        /*
        public String toString()
        {
            String result = "";
            for (int i = 0; i < listWeapon.length; i++)
            {
                if (listWeapon[i] != null)
                {
                    result = result + listWeapon[i].toString() + "\n";
                }
                else
                {
                    continue;
                }
                
            }
            for (int i = 0; i < listArmor.length; i++)
            {
                if (listArmor[i] != null)
                {
                    result = result + listArmor[i].toString() + "\n";
                }
                else
                {
                    continue;
                }
                
            }
            for (int i = 0; i < listPotion.length; i++)
            {
                if (listFood != null)
                {
                    result = result + listArmor[i].toString() + "\n";
                }
                else
                {
                    continue;
                }
            }
            for (int i = 0; i < listScroll.length; i++)
            {
                if (listScroll != null)
                {
                    result = result + listScroll[i].toString() + "\n";
                }
                else
                {
                    continue;
                }
            }
            for (int i = 0; i < listFood.length; i++)
            {
                if (listFood != null)
                {
                    result = result + listFood[i].toString() + "\n";
                }
                else
                {
                    continue;
                }
            }
            return result;
            
        }
        public String displayWeapon()
        {
            String result = "";
            for (int i = 0; i < listWeapon.length; i++)
            {
                if (listWeapon[i] != null)
                {
                    result = result + listWeapon[i].toString() + "\n";
                }
                else
                {
                    continue;
                }
                
            }
            return result;
        }
        public String displayArmor()
        {
            String result = "";
            for (int i = 0; i < listArmor.length; i++)
            {
                if (listArmor[i] != null)
                {
                    result = result + listArmor[i].toString() + "\n";
                }
                else
                {
                    continue;
                }
                
            }
            return result;
        }
        public String displayPotion()
        {
            String result = "";
            for (int i = 0; i < listPotion.length; i++)
            {
                if (listFood != null)
                {
                    result = result + listArmor[i].toString() + "\n";
                }
                else
                {
                    continue;
                }
            }
            return result;
            
        }
        public String displayScroll()
        {
            String result = "";
            for (int i = 0; i < listScroll.length; i++)
            {
                if (listScroll != null)
                {
                    result = result + listScroll[i].toString() + "\n";
                }
                else
                {
                    continue;
                }
            }
            return result;
        }
        public String displayFood()
        {
            String result = "";
            for (int i = 0; i < listFood.length; i++)
            {
                if (listFood != null)
                {
                    result = result + listFood[i].toString() + "\n";
                }
                else
                {
                    continue;
                }
            }
            return result;
        }
         * 
         */
    public Menu getMenu() {
		return new Menu(list, "Items in your inventory.", "abcdefghijklmnopqrstuvwxyz");
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public void checkStatus()
	{
		if(hasChanged()) 
		{
            notifyObservers();
			clearChanged();
		}
	}
}
