import java.util.ArrayList;

public abstract class ActionController {

	public void doNext()
	{
		nextAction.execute();
	}
	
	public ActionController()
	{
		actions = new ArrayList<Action>();
		nextAction = null;
	}
	
	public void addAction(Action action)
	{
		actions.add(action);
	}
	
	private ArrayList<Action> actions;
	private Action nextAction;
}
