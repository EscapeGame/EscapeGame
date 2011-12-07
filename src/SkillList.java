import java.util.ArrayList;
import java.util.Observable;


public class SkillList extends Observable {

	public SkillList(Player player)
	{
		super();
		this.player = player;
		this.skills = new ArrayList<SkillAction>();
		
		// Add default skills
		addAction(SkillType.DOUBLE_ATTACK);
		addAction(SkillType.FIREBALL);
		addAction(SkillType.LIGHTNING_BOLT);
		addAction(SkillType.HEALING);
		addAction(SkillType.POWER_SURGE);
	}
	
	public Menu getMenu() {
		menu = new Menu(skills, "Choose a skill", "1234567890");
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
		setChanged();
	}
	
	public void add(SkillAction skill) {
		skills.add(skill);
	}
	
	public void remove(SkillAction skill) {
		skills.remove(skill);
	}
	
	public SkillAction get(int index) {
		return skills.get(index);
	}
	
	public void removeAction(SkillType type) {
		skills.remove(type.getAction(player));
		setChanged();
	}

	public void addAction(SkillType type) {
		skills.add(type.getAction(player));
		setChanged();
	}
	
	public void checkStatus()
	{
		if(hasChanged()) 
		{
            notifyObservers();
			clearChanged();
		}
	}
	
	private Menu menu;
	private Player player;
	private ArrayList<SkillAction> skills;
}
