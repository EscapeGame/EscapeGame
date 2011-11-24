import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController extends ActionController implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// depending on key pressed, saves appropriate nextAction or passes null
		// (if null, Game will say, "Invalid input" or something like that)
	}
}
