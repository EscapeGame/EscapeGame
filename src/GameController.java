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
		this.monster = null;
		this.menu = null;
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
		}
		if(!map.isObstacle(x, y)) {
			//visitFieldOfView(map, x, y, 9);
			view.visitFieldOfView(map, x, y, DISTANCE);
			map.setPlayerLocation(new Point2I(x, y));
			moveVisibleMonsters(x, y, DISTANCE);
		}
		else if(map.getMapObject(x, y) instanceof Monster) {
			monster = (Monster) map.getMapObject(x, y);
			AttackAction attack = (AttackAction) SkillType.MELEE.getAction(player);
			frame.printMessage(attack.execute(player, monster));
			frame.printMonsterStatus(monster);
			moveVisibleMonsters(x, y, DISTANCE);
		}
		else if(map.getMapObject(x, y) instanceof Item) {
			// TODO
		}
		else {
			moveVisibleMonsters(x, y, DISTANCE);
		}
		player.checkStatus();
		player.decrementSkillCounter();
	}

	private void moveVisibleMonsters(int x, int y, int distance)
	{
		for(int i = x - distance; i < x + distance; i++)
			for (int j = y - distance; j < y + distance; j++)
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
						
					}
					else
					{
						Monster m = (Monster) map.removeObject(i, j);
						map.placeMapObject(nextX, nextY, m);
					}
					
				}
			}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {

		char key = e.getKeyChar();
		int index = Integer.parseInt((new Character(key)).toString());
		if(index >= 1 && index <= 9) {
			SkillAction skill = (SkillAction) player.getSkill(index - 1);
			if(skill instanceof AttackAction) {
				final AttackAction attack = (AttackAction) skill;
				if(attack.getRange() == RangeType.CLOSE_ALL) {
					int x = (int) map.getPlayerLocation().getX();
					int y = (int) map.getPlayerLocation().getY();
					for(int i = x - 1; i <= x + 1; i++)
						for(int j = y - 1; j <= y + 1; j++)
							if(map.contains(i, j) && map.isObstacle(i, j) && (map.getMapObject(i, j) != null) 
								&& (map.getMapObject(i, j) instanceof Monster)) {
								Monster monster = (Monster) map.getMapObject(i, j);
								monster.addObserver(frame.getStatusBar());
								attack.execute(player, monster);
							}
					frame.printMessage(attack.getMessage());
				}
				else { // RangeType.CLOSE_SINGLE
					frame.printMessage("Choose a direction.");
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
								Monster monster = (Monster) map.getMapObject(x, y);
								monster.addObserver(frame.getStatusBar());
								frame.printMessage(attack.execute(player, monster));
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
	}
	
	private PrecisePermissive view;
	private Map map;
	private Player player;
	private Monster monster;
	private Menu menu;
	private EscapeGameFrame frame;
	private static final int DISTANCE = 9;
}
