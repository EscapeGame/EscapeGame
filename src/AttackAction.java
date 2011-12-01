
public class AttackAction implements Action {
	
	public AttackAction(Player player, Monster monster)
	{
		this.player = player;
		this.monster = monster;
		this.name = "Attack monster";
	}
	
	@Override
	public void execute()
	{
		// from player's stats/equipment, and monster's stats, determine outcome of action
	}
	
	public String toString() {
		return name;
	}

	private Player player;
	private Monster monster;
	private String name;
}
