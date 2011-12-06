import java.util.ArrayList;


public class SkillActionList extends ArrayList<SkillAction> {

	public SkillActionList(Player player)
	{
		super();
		this.player = player;
		
		// Add default skills
		addAction(SkillType.DOUBLE_ATTACK);
		addAction(SkillType.FIREBALL);
		addAction(SkillType.LIGHTNING_BOLT);
		addAction(SkillType.HEALING);
		addAction(SkillType.INC_STRENGTH);
	}
	
	public Menu getMenu() {
		menu = new Menu(this);
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public void removeAction(SkillType type) {
		remove(type.getAction(player));
	}

	public void addAction(SkillType type) {
		add(type.getAction(player));
	}
	
	private Menu menu;
	private Player player;
}
