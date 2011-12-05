import java.lang.reflect.InvocationTargetException;
import java.beans.*;


public class SelfAction extends SkillAction {

	public SelfAction(String name, int amount, String statName, String message)
	{
		super(name);
		this.amount = amount;
		this.statName = statName;
		this.message = message;
	}
	
	@Override
	public String execute(Player player, MapObject mapObj)
	{
		return execute(player);
	}
	
	public String execute(Player player) {
		try {
			// search for player field name = statName and invoke its setter (uses beans)
			for(PropertyDescriptor pd : Introspector.getBeanInfo(player.getClass()).getPropertyDescriptors())
				if(pd.getWriteMethod() != null && statName.equals(pd.getName()))
					pd.getWriteMethod().invoke(player, (Integer) pd.getReadMethod().invoke(player) + amount);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return message + " " + amount + " " + statName;
	}

	private int amount;
	private String statName;
	private String message;
}
