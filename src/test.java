import java.util.ArrayList;

public class test {

	public static void main(String args[])
	{
		ArrayList<Action> actions = new ArrayList<Action>();
		actions.add(new SkillAction("Power Attack"));
		actions.add(new SkillAction("Double Attack"));
		ActionMenu am = new ActionMenu(actions);
		am.setVisible(true);
	}
}
