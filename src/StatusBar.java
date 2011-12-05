import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class StatusBar extends JPanel implements Observer {

	public StatusBar(int w, int h, Player p) 
	{
		this.player = p;
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setPreferredSize(new Dimension(w, h));
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		playerStatus = new StatusArea(w, h/3);
		monsterStatus = new StatusArea(w, h/3);
		add(playerStatus);
		add(monsterStatus);
		printPlayerStatus();
		printMonsterStatus(null);
	}
	
	public void printPlayerStatus()
	{
		playerStatus.setText(
			"PLAYER\n\n" +
			"Level: " + player.getLevel() + "\n" +
			"XP: " + player.getExperience() + "\n\n" +
			"HP: " + player.getHp() + "/" + player.getMaxHp() + "\n" +
			"Mana: " + player.getMana() + "/" + player.getMaxMana() + "\n\n" +
			"Atk: " + player.getAttack() + "\n" +
			"Def: " + player.getDefense() + "\n\n" +
			"Str: " + player.getStrength() + "\n" +
			"Dex: " + player.getDexterity() + "\n" +
			"Int: " + player.getIntelligence() + "\n"
		);
	}
	
	public void printMonsterStatus(Monster monster)
	{
		String status = "MONSTER\n\n";
		
		if(monster != null) {
			status += 
				monster.getName() + "\n" +
				"HP: " + monster.getHp() + "/" + monster.getMaxHp() + "\n" +
				"Atk: " + monster.getAttackValue() + "\n" +
				"Def: " + monster.getDeffenseValue() + "\n";
		}
		else
			status += "None";
		
		monsterStatus.setText(status);
	}
	
	@Override
	public void update(Observable mobile, Object o) {
		
		if(mobile instanceof Player)
			printPlayerStatus();
	}
	
	Player player;
	StatusArea playerStatus;
	StatusArea monsterStatus;
}
