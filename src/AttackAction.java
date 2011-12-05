
public class AttackAction extends SkillAction {
	
	public AttackAction(String name, int damage)
	{
		super(name);
		this.damage = damage;
	}
	
	@Override
	public String execute(Player player, MapObject mapObj)
	{
		Monster monster = (Monster) mapObj;
		
		// from player's stats/equipment, and monster's stats, determine outcome of action
		monster.setHp(monster.getHp() - damage);
		return "You hit " + monster.getName() + " for " + damage + "HP!"
				+ " The " + monster.getName() + " has " + monster.getHp() + "HP remaining.";
	}

	private int damage;
}
