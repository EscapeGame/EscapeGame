/**
 * Class to manage player levels
 * @author Carlos Castro 
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

	/**
     * Method to get experience
     * @return value of experience
     */
	public int getExperience() {
		return experience;
	}
	/**
     * Method to set experience
     * @param value of experience
     */
	public void setExperience(int experience) {
		this.experience = experience;
	}
	/**
     * Method to get strength
     * @return value of strength
     */
	public int getStrength() {
		return strength;
	}
	/**
     * Method to set strength
     * @param value of strength
     */
	public void setStrength(int strength) {
		this.strength = strength;
	}
	/**
     * Method to get intelligence
     * @return value of intelligence
     */
	public int getIntelligence() {
		return intelligence;
	}
	/**
     * Method to set intelligence
     * @param value of intelligence
     */
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	/**
     * Method to get dexterity
     * @return value of dexterity
     */
	public int getDexterity() {
		return dexterity;
	}
	/**
     * Method to set dexterity
     * @param value of dexterity
     */
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	
	private int strength;
	private int intelligence;
	private int dexterity;
	private int experience;

}
