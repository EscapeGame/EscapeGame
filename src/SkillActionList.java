import java.util.ArrayList;


public class SkillActionList extends ArrayList<SkillAction> {

	public SkillActionList()
	{
		super();
		
		// Add default skills
		add(new AttackAction("Fireball", 200));
		add(new SelfAction("Healing", 10, "hp", "You have healed"));
	}
	
	public Menu getMenu() {
		menu = new Menu(this);
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	private Menu menu;
}
