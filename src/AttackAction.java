import java.util.ArrayList;


public class AttackAction extends SkillAction {
	
	public AttackAction(String name, int amount, int cost, int duration, int minReq, String minStat, String targetStat, RangeType range, String message)
	{
		super(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
	}
	
	public String execute(MapObject source, MapObject target)
	{
		ArrayList<MapObject> targets = new ArrayList<MapObject>();
		targets.add(target);
		
		setSource(source);
		setTargets(targets);
		return super.execute();
	}

	public String execute(MapObject source, ArrayList<MapObject> targets)
	{
		setSource(source);
		setTargets(targets);
		return super.execute();
	}
}
