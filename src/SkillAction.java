
public class SkillAction implements Action {

	public SkillAction(String name)
	{
		this.name = name;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return name;
	}

	private String name;
}
