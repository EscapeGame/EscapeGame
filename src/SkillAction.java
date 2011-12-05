
public abstract class SkillAction implements Action {

	public SkillAction(String name)
	{
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	private String name;
}
