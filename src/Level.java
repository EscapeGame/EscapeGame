/**
 * Class to manage player levels
 * @author 
 *
 */
public class Level {
	
	/**
	 * Constructs new level
	 * @param experience 
	 * @param strength
	 * @param intelligence
	 * @param dexterity
	 */
	public Level(int experience, int strength, int intelligence, int dexterity) {
		super();

		this.experience = experience;
		this.strength = strength;
		this.intelligence = intelligence;
		this.dexterity = dexterity;
	}

	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	
	private int strength;
	private int intelligence;
	private int dexterity;
	private int experience;

}
