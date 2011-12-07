
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Au
 */
public class EquipMenu extends JPanel implements Observer
{
    public EquipMenu (ArrayList<?> choices)
    {
        
        setSize(500, 500);
        setBackground(Color.BLACK);
        setLayout(new GridLayout(10, 1));
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        JLabel title = new JLabel("Items in your inventory.");
        title.setOpaque(true);
        add(title);

        char c = 'a';
        for(int i = 0; i < choices.size(); i++)
        {
            JLabel label = new JLabel("[" + ((char)(i+c)) +  "] " + choices.get(i).toString());
            label.setForeground(Color.WHITE);
            add(label);
        }
    }

    @Override
    public void update(Observable inventory, Object arg) {
        ArrayList<Item> listItem = (ArrayList<Item>) arg;
        //p.getInventory().setListItem(listItem);
        
    }
    Inventory nInventory;
    Player p;
}
