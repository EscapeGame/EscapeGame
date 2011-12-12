import java.util.ArrayList;

/**
 * Class to create attack
 * @author Sally Calpo
 *
 */
public class AttackAction extends SkillAction {
	
	/**
	 * Constructs new attack
	 * @param name attack name
	 * @param amount amount of damage to hp
	 * @param cost mana cost
	 * @param duration how many turns attack remains valid
	 * @param minReq 
	 * @param minStat
	 * @param targetStat
	 * @param range
	 * @param message
	 */
	public AttackAction(String name, int amount, int cost, int duration, int minReq, String minStat, String targetStat, RangeType range, String message)
	{
		super(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
	}
	
	/**
	 * Executes action
	 * @param source source of action
	 * @param target target of action
	 * @return String to describe action
	 */
	public String execute(MapObject source, MapObject target)
	{
		ArrayList<MapObject> targets = new ArrayList<MapObject>();
		targets.add(target);
		
		setSource(source);
		setTargets(targets);
		return super.execute();
	}

	/**
	 * Executes action on multiple objects
	 * @param source source of action
	 * @param targets targets of action
	 * @return String to describe action
	 */
	public String execute(MapObject source, ArrayList<MapObject> targets)
	{
		setSource(source);
		setTargets(targets);
		return super.execute();
	}
}
