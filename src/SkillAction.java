import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


/**
 * Class to create skill action
 * @author Sally Calpo
 * 
 */
public abstract class SkillAction implements Action {

	
	/**
	 * Constructor - creates new skill action
	 * @param name name of skill
	 * @param amount amount skill adds to targetStat
	 * @param cost mana cost 
	 * @param duration # of turns skill effect will last
	 * @param minReq amount of minStat needed to use skill
	 * @param minStat stat required to use skill
	 * @param targetStat stat affected by skill
	 * @param range range type (enum)
	 * @param message status message
	 */
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
				// check prereqs: get minStat's getter method
				Method getMinStat = new PropertyDescriptor(minStat, source.getClass()).getReadMethod();
				// check that player has minimum requirement to use skill
				if(minReq > (Integer) getMinStat.invoke(source))
					return "You need " + minReq + " " + minStat + " to use this skill.";
				Player player = (Player) source;
				// check mana cost
				if(cost > player.getMana())
					return "You do not have enough mana to use that skill.";
				else
					player.setMana(player.getMana() - cost); // subtract mana cost
				// if duration exists for player start counter - right now, can only have one effect at a time
				if(this instanceof SelfAction && duration > 0) {
					player.setSkillCounter(duration);
					if(player.getRevertSkill() != null) {
						SelfAction self = (SelfAction) player.getRevertSkill();
						self.execute(player);
					}
					player.setRevertSkill(new SelfAction("Revert", -amount, 0, 0, 0, minStat, targetStat, RangeType.SELF, name + " effect has ended. You lose " + amount + " " + targetStat));
				}
			}
			// execute action for all targets
			for(MapObject target : targets) {
				// get targetStat's getter and setter methods
				Method getTargetStat = new PropertyDescriptor(targetStat, target.getClass()).getReadMethod();
				Method setTargetStat = new PropertyDescriptor(targetStat, target.getClass()).getWriteMethod();
				// if duration exists start counter for monster - right now, can only have one effect at a time
				if(this instanceof AttackAction && target instanceof Monster) {
					if(duration > 0) {
						Monster monster = (Monster) target;
						monster.setSkillCounter(duration);
						if(monster.getRevertSkill() != null) {
							SelfAction self = (SelfAction) monster.getRevertSkill();
							self.execute(monster);
						}
						monster.setRevertSkill(new SelfAction("Revert", -amount, 0, 0, 0, minStat, targetStat, RangeType.SELF, name + " effect has ended. You gain " + amount + " " + targetStat));
					}
				}
				if(getTargetStat != null && setTargetStat != null) {
					int newVal = (Integer) getTargetStat.invoke(target);
					int maxVal;
					if(targetStat.equals("hp") || targetStat.equals("mana")) {
						if(targetStat.equals("hp")) {
							maxVal = (Integer) target.getClass().getMethod("getMaxHp").invoke(target);
							if(amount < 0) { // Damage skill
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
							}
							else // Heal skill, process amount as is
								adjusted = amount;
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

		message += total;
		if(!targetStat.equals("attackBonus") && !targetStat.equals("defenseBonus") &&
		   !targetStat.equals("attackValue") && !targetStat.equals("deffenseValue"))
			message += " " + targetStat;
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

	/**
	 * Getter for source
	 * @return map object initiating skill
	 */
	public MapObject getSource() {
		return source;
	}

	/**
	 * Setter for source
	 * @param source map object initiating skill
	 */
	public void setSource(MapObject source) {
		this.source = source;
	}

	/**
	 * Getter for target list
	 * @return array list of target map objects
	 */
	public ArrayList<MapObject> getTargets() {
		return targets;
	}

	/**
	 * Setter for target list
	 * @param targets list of target map objects
	 */
	public void setTargets(ArrayList<MapObject> targets) {
		this.targets = targets;
	}

	/**
	 * Getter for skill name
	 * @return skill name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for skill name
	 * @param name skill name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for amount skill adds to targetStat
	 * @return amount skill adds to targetStat
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Setter for amount skill adds to targetStat
	 * @param amount amount skill adds to targetStat
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * Getter for mana cost
	 * @return mana cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Setter for mana cost
	 * @param cost mana cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	/**
	 * Getter for # of turns
	 * @return # of turns skill effect will last
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Setter for # of turns
	 * @param duration # of turns skill effect will last
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Getter for amount of minStat needed
	 * @return amount of minStat needed to use skill
	 */
	public int getMinReq() {
		return minReq;
	}

	/**
	 * Setter for amount of minStat needed
	 * @param minReq amount of minStat needed to use skill
	 */
	public void setMinReq(int minReq) {
		this.minReq = minReq;
	}

	/**
	 * Getter for required stat
	 * @return stat required to use skill
	 */
	public String getMinStat() {
		return minStat;
	}

	/**
	 * Setter for required stat
	 * @param minStat stat required to use skill
	 */
	public void setMinStat(String minStat) {
		this.minStat = minStat;
	}

	/**
	 * Getter for stat affected by skill
	 * @return stat affected by skill
	 */
	public String getTargetStat() {
		return targetStat;
	}

	/**
	 * Setter for stat affected by skill
	 * @param targetStat stat affected by skill
	 */
	public void setTargetStat(String targetStat) {
		this.targetStat = targetStat;
	}

	/**
	 * Getter for status message 
	 * @return status message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter for status message
	 * @param message status message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Getter for range type
	 * @return range type
	 */
	public RangeType getRange() {
		return range;
	}

	/**
	 * Setter for range type
	 * @param range range type
	 */
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
