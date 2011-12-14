import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;


/**
 * Creates list of skills available to player
 * @author Sally Calpo
 *
 */
public class SkillList extends Observable {

	/**
	 * Constructor - generates default skill list
	 */
	public SkillList()
	{
		super();
		this.skills = new ArrayList<SkillType>();
		
		add(SkillType.DEFENSIVE);
		add(SkillType.DOUBLE_ATTACK);
		add(SkillType.ENERGY_BOLT);
		//add(SkillType.random());
		
	}
	
	/**
	 * Creates menu to pass to skill panel display
	 * @return skill menu
	 */
	public Menu getMenu() {
		menu = new Menu(skills, "Choose a skill", "1234567890");
		return menu;
	}

	/**
	 * Sets menu to pass to skill panel display
	 * @param menu
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
		setChanged();
	}
	
	/**
	 * Adds a new skill to the list
	 * @param skill
	 * @return status message
	 */
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
	
	/**
	 * Removes skill from the list
	 * @param skill
	 */
	public void remove(SkillType skill) {
		skills.remove(skill);
		setChanged();
	}
	
	/**
	 * Gets skill at specified index
	 * @param index
	 * @return skill
	 */
	public SkillType get(int index) {
		return skills.get(index);
	}
		
	/**
	 * Gets array of all skills in list
	 * @return array of skills
	 */
	public ArrayList<SkillType> getSkills() {
		return skills;
	}

	/**
	 * Sets array of all skills in list
	 * @param skills array of skills
	 */
	public void setSkills(ArrayList<SkillType> skills) {
		this.skills = skills;
	}

	/**
	 * Tests if skill list has changed and notifies observers if so
	 */
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
