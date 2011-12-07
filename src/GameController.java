import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import rlforj.los.PrecisePermissive;
import rlforj.math.Point2I;

public class GameController implements KeyListener  {
	
	public GameController(Map map, Player player, EscapeGameFrame frame)
	{
		this.map = map;
		this.player = player;
		this.frame = frame;
		view = new PrecisePermissive();
		view.visitFieldOfView(map, map.getPlayerLocation().x, 
				map.getPlayerLocation().y, DISTANCE);
	}
	
	/*@Override
	public void visitFieldOfView(ILosBoard b, int x, int y, int distance) {
		for(int i = (x - distance); i <= (x + distance); i++)
			for(int j = (y - distance); j <= (y + distance); j++)
				b.visit(i, j);
	}*/
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(choosingDirection == false) {
			frame.printMessage("");
			int key = e.getKeyCode();
			int x = (int) map.getPlayerLocation().getX();
			int y = (int) map.getPlayerLocation().getY();
			switch(key) {
			case KeyEvent.VK_UP:
				--y;
				break;
			case KeyEvent.VK_DOWN:
				++y;
				break;
			case KeyEvent.VK_LEFT:
				--x;
				break;
			case KeyEvent.VK_RIGHT:
				++x;
				break;
			default:
				return;
			}
			if(!map.isObstacle(x, y)) {
				//visitFieldOfView(map, x, y, 9);
				view.visitFieldOfView(map, x, y, DISTANCE);
				map.setPlayerLocation(new Point2I(x, y));
			}
			else if(map.getMapObject(x, y) instanceof Monster) {
				String message = "";
				AttackAction attack;
				Monster monster = (Monster) map.getMapObject(x, y);
				attack = (AttackAction) SkillType.MELEE.getAction(player);
				message += attack.execute(player, monster);
				frame.printMonsterStatus(monster);
    			if(monster.getHp() <= 0) {
    				message += " " + monster.getName() + " dies! You gain " + monster.getExp() + " xp.";
    				player.setExperience(player.getExperience() + monster.getExp());
    				monster = (Monster) map.removeObject(x, y);
    				MapObject item = (MapObject) monster.getItem();
    				map.placeMapObject(x, y, item);
    			}
    			else {
					attack = (AttackAction) SkillType.MELEE.getAction(monster);
					message += " " + attack.execute(monster, player);
					player.checkStatus();
	    			if(player.getHp() <= 0) {
	    				message += " You die! Game over.";
	    				frame.removeKeyListener(this);
	    			}
    			}
    			frame.printMessage(message);
			}
			else if(map.getMapObject(x, y) instanceof Item) {
				Item item = (Item) map.getMapObject(x, y);
                                Inventory inventory = player.getInventory();
				boolean addSuc = inventory.add(item);
                                if (addSuc == true)
                                {
                                frame.printMessage("You pick " + inventory.getItem(inventory.getlistItem().indexOf(item)).getName());
                                }
                                else
                                {
                                frame.printMessage("Your method don't work");
                                }
				map.removeObject(x, y);
				map.setPlayerLocation(new Point2I(x,y));
			}
			moveVisibleMonsters(x, y, DISTANCE);
		}
		else {
			choosingDirection = false; // reset
		}
		player.checkStatus();
		player.decrementSkillCounter();
	}

	private void moveVisibleMonsters(int x, int y, int distance)
	{
		for(int i = x - distance + 3; i < x + distance - 3; i++)
			for (int j = y - distance + 3; j < y + distance - 3; j++)
			{
				if (map.contains(i, j) && map.isObstacle(i, j) 
						&& (map.getMapObject(i, j) != null) 
						&&  (map.getMapObject(i, j) instanceof Monster) 
						&& view.existsLineOfSight(map, x, y, i, j, true))
				{
					List<Point2I> path = view.getProjectPath();
					int nextX = path.get(path.size() - 1).x;
					int nextY = path.get(path.size() - 1).y;
					if (nextX == map.getPlayerLocation().x && nextY == map.getPlayerLocation().y) 
					{
						String message = "";
						Monster monster = (Monster) map.getMapObject(i, j);
						AttackAction attack = (AttackAction) SkillType.MELEE.getAction(monster);
						message += attack.execute(monster, player);
						frame.printMonsterStatus(monster);
						player.checkStatus();
		    			if(player.getHp() <= 0) {
		    				message += " You die! Game over.";
		    				frame.removeKeyListener(this);
		    			}
		    			frame.printMessage(message);
					}
					else
					{
						if(map.contains(nextX, nextY) && !map.isObstacle(nextX, nextY)) {
							Monster m = (Monster) map.removeObject(i, j);
							map.placeMapObject(nextX, nextY, m);
						}
					}
					
				}
			}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {

		char key = e.getKeyChar();
		try {
			int index = Integer.parseInt((new Character(key)).toString());
	
			if(index >= 1 && index <= 9) {
				SkillAction skill = (SkillAction) player.getSkill(index - 1);
				if(skill instanceof AttackAction) {
					final AttackAction attack = (AttackAction) skill;
					if(attack.getRange() == RangeType.CLOSE_ALL) { // Affects a range immediately around the player.
						int x = (int) map.getPlayerLocation().getX();
						int y = (int) map.getPlayerLocation().getY();
						String message = "";
						ArrayList<MapObject> targets = new ArrayList<MapObject>();
						for(int i = x - 1; i <= x + 1; i++)
							for(int j = y - 1; j <= y + 1; j++)
								if(map.contains(i, j) && map.isObstacle(i, j) && (map.getMapObject(i, j) != null) 
									&& (map.getMapObject(i, j) instanceof Monster)) {
									Monster monster = (Monster) map.getMapObject(i, j);
									monster.addObserver(frame.getStatusBar());
									targets.add(monster);
								}
						message = attack.execute(player, targets);
						for(MapObject obj : targets) {
							Monster m = (Monster) obj;
							m.checkStatus();
			    			if(m.getHp() <= 0) {
			    				message += " " + m.getName() + " dies! You gain " + m.getExp() + " xp.";
			    				player.setExperience(player.getExperience() + m.getExp());
			    				map.removeObject((int) m.getLocation().getX(), (int) m.getLocation().getY());
			    			}
						}
						frame.printMessage(message);
					}
					else if(attack.getRange() == RangeType.LINE) {  // Affects monsters in front of player, up to (level) squares away.
						frame.printMessage("Choose a direction.");
						choosingDirection = true;
						frame.removeKeyListener(this);
						frame.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent e) {
								int x = (int) map.getPlayerLocation().getX();
								int y = (int) map.getPlayerLocation().getY();
								int direction = e.getKeyCode();
								String message = "";
								ArrayList<MapObject> targets = new ArrayList<MapObject>();
								switch(direction) {
									case KeyEvent.VK_UP: 
										for(int j = y - 1; j >= y - player.getLevel(); j--)
											if(map.contains(x, j) && map.isObstacle(x, j) && (map.getMapObject(x, j) != null) 
												&& (map.getMapObject(x, j) instanceof Monster)) {
												Monster monster = (Monster) map.getMapObject(x, j);
												monster.addObserver(frame.getStatusBar());
												targets.add(monster);
											}
										break;
									case KeyEvent.VK_DOWN:
										for(int j = y + 1; j <= y + player.getLevel(); j++)
											if(map.contains(x, j) && map.isObstacle(x, j) && (map.getMapObject(x, j) != null) 
												&& (map.getMapObject(x, j) instanceof Monster)) {
												Monster monster = (Monster) map.getMapObject(x, j);
												monster.addObserver(frame.getStatusBar());
												targets.add(monster);
											}
										break;
									case KeyEvent.VK_LEFT:
										for(int i = x - 1; i >= x - player.getLevel(); i--)
											if(map.contains(i, y) && map.isObstacle(i, y) && (map.getMapObject(i, y) != null) 
												&& (map.getMapObject(i, y) instanceof Monster)) {
												Monster monster = (Monster) map.getMapObject(i, y);
												monster.addObserver(frame.getStatusBar());
												targets.add(monster);
											}
										break;
									case KeyEvent.VK_RIGHT:
										for(int i = x + 1; i <= x + player.getLevel(); i++)
											if(map.contains(i, y) && map.isObstacle(i, y) && (map.getMapObject(i, y) != null) 
												&& (map.getMapObject(i, y) instanceof Monster)) {
												Monster monster = (Monster) map.getMapObject(i, y);
												monster.addObserver(frame.getStatusBar());
												targets.add(monster);
											}
										break;
								}
	
								message = attack.execute(player, targets);
								for(MapObject obj : targets) {
									Monster m = (Monster) obj;
									m.checkStatus();
					    			if(m.getHp() <= 0) {
					    				message += " " + m.getName() + " dies! You gain " + m.getExp() + " xp.";
					    				player.setExperience(player.getExperience() + m.getExp());
					    				map.removeObject((int) m.getLocation().getX(), (int) m.getLocation().getY());
					    			}
								}
								frame.printMessage(message);
								frame.removeKeyListener(this);
							}
						});
						frame.addKeyListener(this);
					}
					else { // RangeType.CLOSE_SINGLE - Affects monster in front of player, indicated by direction.
						frame.printMessage("Choose a direction.");
						choosingDirection = true;
						frame.removeKeyListener(this);
						frame.addKeyListener(new KeyAdapter() {
							@Override
							public void keyPressed(KeyEvent e) {
								int x = (int) map.getPlayerLocation().getX();
								int y = (int) map.getPlayerLocation().getY();
								int direction = e.getKeyCode();
								switch(direction) {
									case KeyEvent.VK_UP:
										--y;
										break;
									case KeyEvent.VK_DOWN:
										++y;
										break;
									case KeyEvent.VK_LEFT:
										--x;
										break;
									case KeyEvent.VK_RIGHT:
										++x;
										break;
								}
								if(map.contains(x, y) && map.isObstacle(x, y) && (map.getMapObject(x, y) != null) 
									&& (map.getMapObject(x, y) instanceof Monster)) {
									String message = "";
									Monster monster = (Monster) map.getMapObject(x, y);
									monster.addObserver(frame.getStatusBar());
									message += attack.execute(player, monster);
									monster.checkStatus();
					    			if(monster.getHp() <= 0) {
					    				message += " " + monster.getName() + " dies! You gain " + monster.getExp() + " xp.";
					    				player.setExperience(player.getExperience() + monster.getExp());
					    				map.removeObject(x, y);
					    			}
					    			frame.printMessage(message);
									frame.removeKeyListener(this);
								}
							}
						});
						frame.addKeyListener(this);
					}
				}
				else if(skill instanceof SelfAction) {
					SelfAction self = (SelfAction) skill;
					frame.printMessage(self.execute(player));
				}
			}			
			player.checkStatus();
		} catch(NumberFormatException nfe) {
			// do nothing
		}
	}
	
	private PrecisePermissive view;
	private Map map;
	private Player player;
	private EscapeGameFrame frame;
	private boolean choosingDirection = false;
	private static final int DISTANCE = 9;
}
