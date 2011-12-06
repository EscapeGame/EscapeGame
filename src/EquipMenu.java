
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
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
public class EquipMenu extends JPanel
{
    public EquipMenu (ArrayList<?> choices)
    {
        
        setSize(500, 500);
        setBackground(Color.BLACK);
        setLayout(new GridLayout(10, 1));
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        JLabel title = new JLabel("List of item.");
        title.setOpaque(true);
        add(title);

        for(int i = 0; i < choices.size(); i++)
        {
            JLabel label = new JLabel("[" + (i+1) +  "] " + choices.get(i).toString());
            label.setForeground(Color.WHITE);
            add(label);
        }
    }
    
}
