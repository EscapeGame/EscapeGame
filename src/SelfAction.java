import java.util.ArrayList;



public class SelfAction extends SkillAction {

	public SelfAction(String name, int amount, int cost, int duration, int minReq, String minStat, String targetStat, RangeType range, String message)
	{
		super(name, amount, cost, duration, minReq, minStat, targetStat, RangeType.SELF, message);
	}
	
	public String execute(Player player) {
		ArrayList<MapObject> targets = new ArrayList<MapObject>();
		targets.add(player);
		
		setSource(player);
		setTargets(targets);
		return super.execute();
	}

}
