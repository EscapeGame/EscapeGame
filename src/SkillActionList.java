import java.util.ArrayList;


public class SkillActionList extends ArrayList<SkillAction> {

	public SkillActionList(Player player)
	{
		super();
		this.player = player;
		
		// Add default skills
		addAction(SkillActionType.FIREBALL);
		addAction(SkillActionType.HEALING);
	}
	
	public Menu getMenu() {
		menu = new Menu(this);
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public void removeAction(SkillActionType type) {
		remove(type.getAction(player));
	}

	public void addAction(SkillActionType type) {
		add(type.getAction(player));
	}
	
	private Menu menu;
	private Player player;
}
