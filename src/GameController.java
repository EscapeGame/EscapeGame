import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import rlforj.los.IFovAlgorithm;
import rlforj.los.ILosBoard;
import rlforj.math.Point2I;

public class GameController implements IFovAlgorithm, KeyListener  {
	
	public GameController(Map map, Player player, EscapeGameFrame frame)
	{
		this.map = map;
		this.player = player;
		this.frame = frame;
	}
	
	@Override
	public void visitFieldOfView(ILosBoard b, int x, int y, int distance) {
		for(int i = (x - distance); i <= (x + distance); i++)
			for(int j = (y - distance); j <= (y + distance); j++)
				b.visit(i, j);
	}
	
	Map map;
	Player player;
	EscapeGameFrame frame;
	
	@Override
	public void keyPressed(KeyEvent e) {
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
			visitFieldOfView(map, x, y, 9);
			map.setPlayerLocation(new Point2I(x, y));
		}
		else if(map.getMapObject(x, y) instanceof Monster) {
			Monster monster = (Monster) map.getMapObject(x, y);
			AttackAction attack = new AttackAction(player, monster);
			attack.execute();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		switch(key) {
		case 's':
			ArrayList<SkillAction> skills = new ArrayList<SkillAction>();
			skills.add(new SkillAction("Underwater basket weaving"));
			skills.add(new SkillAction("Super strong attack"));
			skills.add(new SkillAction("Indomitable will"));
			Menu menu = new Menu(skills);
			frame.add(menu);
			break;
		}
	}
}
