

public class SelfAction extends SkillAction {

	public SelfAction(String name, int amount, int cost, int duration, int minReq, String minStat, String targetStat, RangeType range, String message)
	{
		super(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
	}
	
	public String execute(Player player) {
		setSource(player);
		setTarget(player);
		return super.execute();
	}

}
