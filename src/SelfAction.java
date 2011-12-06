import java.lang.reflect.InvocationTargetException;
import java.beans.*;


public class SelfAction extends SkillAction {

	public SelfAction(String name, int amount, String targetStat, String message)
	{
		super(name, amount, targetStat, message);
	}
	
	public String execute(Player player) {
		setSource(player);
		setTarget(player);
		return super.execute();
	}

}
