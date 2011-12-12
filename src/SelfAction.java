import java.util.ArrayList;

/**
 * Class to create self-action
 * @author Sally Calpo
 *
 */
public class SelfAction extends SkillAction {

	/**
	 * Constructs new self-action
	 * @param name
	 * @param amount
	 * @param cost
	 * @param duration
	 * @param minReq
	 * @param minStat
	 * @param targetStat
	 * @param range
	 * @param message
	 */
	public SelfAction(String name, int amount, int cost, int duration, int minReq, String minStat, String targetStat, RangeType range, String message)
	{
		super(name, amount, cost, duration, minReq, minStat, targetStat, RangeType.SELF, message);
	}
	
	/**
	 * Executes action
	 * @param object which is target and source of an action
	 * @return String to describe action
	 */
	public String execute(MobileObject mobile) {
		ArrayList<MapObject> targets = new ArrayList<MapObject>();
		targets.add(mobile);
		
		setSource(mobile);
		setTargets(targets);
		return super.execute();
	}

}
