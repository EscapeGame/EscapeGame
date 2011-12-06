
public class AttackAction extends SkillAction {
	
	public AttackAction(String name, int amount, String targetStat, String message)
	{
		super(name, amount, targetStat, message);
	}
	
	public String execute(MapObject source, MapObject target)
	{
		setSource(source);
		setTarget(target);
		return super.execute();
	}

}
