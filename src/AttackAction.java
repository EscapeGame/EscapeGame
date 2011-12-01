
public class AttackAction implements Action {
	
	public AttackAction(Player player, Monster monster)
	{
		this.player = player;
		this.monster = monster;
		this.name = "Attack monster";
	}
	
	@Override
	public String execute()
	{
		// from player's stats/equipment, and monster's stats, determine outcome of action
		monster.setHp(monster.getHp() - player.getStrength());
		return "You hit " + monster.getName() + " for " + player.getStrength() + "HP!"
				+ " The " + monster.getName() + " has " + monster.getHp() + "HP remaining.";
	}
	
	public String toString() {
		return name;
	}

	private Player player;
	private Monster monster;
	private String name;
}
