import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;


public class SkillList extends Observable {

	public SkillList()
	{
		super();
		this.skills = new ArrayList<SkillType>();
		
		add(SkillType.DEFENSIVE);
		add(SkillType.DOUBLE_ATTACK);
		add(SkillType.ENERGY_BOLT);
		//add(SkillType.random());
		
	}
	
	public Menu getMenu() {
		menu = new Menu(skills, "Choose a skill", "1234567890");
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
		setChanged();
	}
	
	public String add(SkillType skill) {
		if(!skills.contains(skill) && skill != SkillType.MELEE && skills.size() <= 10) {
			skills.add(skill);
			setChanged();
			return "You learned " + skill.toString() + ".";
		}
		else if(skills.size() > 10)
			return "You cannot learn any more skills.";
		else
			return "You already know the skill on this scroll."; 
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
