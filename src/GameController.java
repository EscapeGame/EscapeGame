import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import rlforj.los.IFovAlgorithm;
import rlforj.los.ILosBoard;
import rlforj.math.Point2I;

public class GameController implements IFovAlgorithm, KeyListener  {

	public void doNext()
	{
		nextAction.execute();
	}
	
	public GameController(Map map, Player player)
	{
		this.map = map;
		this.player = player;
		actions = new ArrayList<Action>();
		nextAction = null;
	}
	
	public void addAction(Action action)
	{
		actions.add(action);
	}
	
	private ArrayList<Action> actions;
	private Action nextAction;
	@Override
	public void visitFieldOfView(ILosBoard b, int x, int y, int distance) {
		for(int i = (x - distance); i <= (x + distance); i++)
			for(int j = (y - distance); j <= (y + distance); j++)
				b.visit(i, j);
	}
	
	Map map;
	Player player;
	
	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_KP_UP || key == KeyEvent.VK_KP_DOWN) {
			int x = (int) map.getPlayerLocation().getX();
			int y = (int) map.getPlayerLocation().getY();
			visitFieldOfView(map, x, y, 9);
			map.setPlayerLocation(new Point2I(++x, ++y));
		}
	}
}
