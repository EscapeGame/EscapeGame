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
		int key = e.getKeyCode();
		int x = (int) map.getPlayerLocation().getX();
		int y = (int) map.getPlayerLocation().getY();
		int oldX = x;
		int oldY = y;
		switch(key) {
		case KeyEvent.VK_UP:
			--y;
			break;
		case KeyEvent.VK_DOWN:
			++y;
			player.setHp(player.getHp() - 1);
			break;
		case KeyEvent.VK_LEFT:
			--x;
			break;
		case KeyEvent.VK_RIGHT:
			++x;
			break;
		case KeyEvent.VK_ESCAPE:
			/* removes menu if it exists */
			frame.removeMenu();
			break;
		}
		if(!map.isObstacle(x, y)) {
			//visitFieldOfView(map, x, y, 9);
			view.visitFieldOfView(map, x, y, DISTANCE);
			map.setPlayerLocation(new Point2I(x, y));
			moveVisibleMonsters(x, y, DISTANCE);
		}
		else if(map.getMapObject(x, y) instanceof Monster) {
			Monster monster = (Monster) map.getMapObject(x, y);
			frame.printMonsterStatus(monster);
			AttackAction attack = new AttackAction("attack", player.getAttack());
			frame.printMessage(attack.execute(player, monster));
		}
		else if(map.getMapObject(x, y) instanceof Item) {
			// TODO
		}
		else {
			moveVisibleMonsters(x, y, DISTANCE);
		}
		player.checkStatus();
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
						//TODO attack player
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
		switch(key) {
		case 's': // Skill menu
			frame.removeMenu(); // only one menu at a time
			frame.addMenu(player.getSkillMenu());
			break;
		}
		player.checkStatus();
	}
	
	private PrecisePermissive view;
	private Map map;
	private Player player;
	private EscapeGameFrame frame;
	private static final int DISTANCE = 9;
}
