import java.util.ArrayList;
import java.util.Observable;


public class SkillList extends Observable {

	public SkillList()
	{
		super();
		this.skills = new ArrayList<SkillType>();
		
		add(SkillType.FEAR_EFFECT);
		for(int i = 0; i < 3; i++) {
			add(SkillType.random());
		}
		
	}
	
	public Menu getMenu() {
		menu = new Menu(skills, "Choose a skill", "1234567890");
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
		setChanged();
	}
	
	public boolean add(SkillType skill) {
		if(!skills.contains(skill) && skill != SkillType.MELEE) {
			skills.add(skill);
			setChanged();
			return true;
		}
		return false;
	}
	
	public void remove(SkillType skill) {
		skills.remove(skill);
		setChanged();
	}
	
	public SkillType get(int index) {
		return skills.get(index);
	}
		
	public ArrayList<SkillType> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<SkillType> skills) {
		this.skills = skills;
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
	private ArrayList<SkillType> skills;
}
