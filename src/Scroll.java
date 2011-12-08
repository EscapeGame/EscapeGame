import java.util.ArrayList;



public class SelfAction extends SkillAction {

	public SelfAction(String name, int amount, int cost, int duration, int minReq, String minStat, String targetStat, RangeType range, String message)
	{
		super(name, amount, cost, duration, minReq, minStat, targetStat, RangeType.SELF, message);
	}
	
	public String execute(MobileObject mobile) {
		ArrayList<MapObject> targets = new ArrayList<MapObject>();
		targets.add(mobile);
		
		setSource(mobile);
		setTargets(targets);
		return super.execute();
	}

}
