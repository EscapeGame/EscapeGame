
public class AttackAction extends SkillAction {
	
	public AttackAction(String name, int amount, int cost, int duration, int minReq, String minStat, String targetStat, RangeType range, String message)
	{
		super(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
	}
	
	public String execute(MapObject source, MapObject target)
	{
		setSource(source);
		setTarget(target);
		return super.execute();
	}

}
