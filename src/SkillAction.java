import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;


public abstract class SkillAction implements Action {

	public SkillAction(String name, int amount, String targetStat, String message)
	{
		this.name = name;
		this.amount = amount;
		this.targetStat = targetStat;
		this.message = message;
	}
	
	@Override
	public String execute() {
		try {
			// search for target's field name = statName and invoke its setter (uses beans)
			for(PropertyDescriptor pd : Introspector.getBeanInfo(target.getClass()).getPropertyDescriptors())
				if(pd.getWriteMethod() != null && targetStat.equals(pd.getName()))
					pd.getWriteMethod().invoke(target, (Integer) pd.getReadMethod().invoke(target) + amount);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return message + " " + amount + " " + targetStat;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public MapObject getSource() {
		return source;
	}

	public void setSource(MapObject source) {
		this.source = source;
	}

	public MapObject getTarget() {
		return target;
	}

	public void setTarget(MapObject target) {
		this.target = target;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTargetStat() {
		return targetStat;
	}

	public void targetStat(String targetStat) {
		this.targetStat = targetStat;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	private MapObject source;
	private MapObject target;
	
	private String name;
	private int amount;
	private String targetStat;
	private String message;
}
