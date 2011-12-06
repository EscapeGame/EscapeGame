import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public abstract class SkillAction implements Action {

	public SkillAction(String name, int amount, int cost, int duration, int minReq, String minStat, String targetStat, RangeType range, String message)
	{
		this.name = name;
		this.amount = amount;
		this.cost = cost;
		this.duration = duration;
		this.minReq = minReq;
		this.minStat = minStat;
		this.targetStat = targetStat;
		this.range = range;
		this.message = message;
	}
	
	@Override
	public String execute() {

		int total = 0, adjusted = 0;
		try {
			// check cost, duration and prereqs if source object is player
			if(source instanceof Player) {
				Player player = (Player) source;
				// check mana cost
				if(cost > player.getMana())
					return "You do not have enough mana to use that skill.";
				else
					player.setMana(player.getMana() - cost); // subtract mana cost
				// if duration exists start counter - right now, can only have one effect at a time
				if(duration > 0) {
					player.setSkillCounter(duration);
					if(player.getRevertSkill() != null) {
						SelfAction self = (SelfAction) player.getRevertSkill();
						self.execute(player);
					}
					player.setRevertSkill(new SelfAction("Revert", -amount, 0, 0, 0, minStat, targetStat, RangeType.SELF, name + " effect has ended. You lose " + amount + " " + targetStat));
				}
				// check prereqs: get minStat's getter method
				Method getMinStat = new PropertyDescriptor(minStat, source.getClass()).getReadMethod();
				// check that player has minimum requirement to use skill
				if(minReq > (Integer) getMinStat.invoke(source))
					return "You need " + minReq + " " + minStat + " to use this skill.";
			}
			// execute action for all targets
			for(MapObject target : targets) {
				// get targetStat's getter and setter methods
				Method getTargetStat = new PropertyDescriptor(targetStat, target.getClass()).getReadMethod();
				Method setTargetStat = new PropertyDescriptor(targetStat, target.getClass()).getWriteMethod();
				if(getTargetStat != null && setTargetStat != null) {
					int newVal = (Integer) getTargetStat.invoke(target);
					int maxVal;
					if(targetStat.equals("hp") || targetStat.equals("mana")) {
						if(targetStat.equals("hp")) {
							maxVal = (Integer) target.getClass().getMethod("getMaxHp").invoke(target);
							// Player defense
							if(target instanceof Player) {
								Player player = (Player) target;
								if(amount + player.getDefense() < 0)
									adjusted = amount + player.getDefense();
								else
									adjusted = 0;
							}
							// Monster defense
							else if(target instanceof Monster) {
								Monster monster = (Monster) target;
								if(amount + monster.getDeffenseValue() < 0)
									adjusted = amount + monster.getDeffenseValue();
								else
									adjusted = 0;
							}
							newVal += adjusted;
						}
						else { // (targetStat.equals("mana"))
							maxVal = (Integer) target.getClass().getMethod("getMaxMana").invoke(target);
						}
						if(newVal > maxVal) // cannot exceed maxval
							setTargetStat.invoke(target, maxVal);
						else
							setTargetStat.invoke(target, newVal);
					}
					else { // any other targetStat but hp or mana
						adjusted = amount;
						newVal += adjusted;
						setTargetStat.invoke(target, newVal);
					}
					total += adjusted;
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		message += total + " " + targetStat;
		if(targetStat.equals("hp"))
			message += " damage.";
		else
			message += ".";
		return message;
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

	public ArrayList<MapObject> getTargets() {
		return targets;
	}

	public void setTargets(ArrayList<MapObject> targets) {
		this.targets = targets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getMinReq() {
		return minReq;
	}

	public void setMinReq(int minReq) {
		this.minReq = minReq;
	}

	public String getMinStat() {
		return minStat;
	}

	public void setMinStat(String minStat) {
		this.minStat = minStat;
	}

	public String getTargetStat() {
		return targetStat;
	}

	public void setTargetStat(String targetStat) {
		this.targetStat = targetStat;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RangeType getRange() {
		return range;
	}

	public void setRange(RangeType range) {
		this.range = range;
	}

	private MapObject source;
	private ArrayList<MapObject> targets;
	
	private String name;
	private int amount;
	private int cost;
	private int duration;
	private int minReq;
	private String minStat;
	private String targetStat;
	private RangeType range;

	private String message;
}
