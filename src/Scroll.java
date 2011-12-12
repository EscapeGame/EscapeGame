
/**
 *Class to create scroll
 * @author Thanh Au
 */
public class Scroll extends ConsumableItem
{    
    /**
     * Constructs new scroll
     * @param name scroll name
     * @param description scroll description
     * @param numItem number of objects for this scroll
     * @param symbol character that will be displayed on map for this scroll
     * @param skillType skill type
     */
	public Scroll(String name, String description, int numItem,char symbol, SkillType skillType) {
        super(name, description, numItem, symbol);
        this.skillType = skillType;
    }
    
	/**
	 * Gets skill type
	 * @return skill type
	 */
	public SkillType getSkillType() {
		return skillType;
	}
	
	/**
	 * Sets skill type
	 * @param skillType skill type
	 */
	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

    private SkillType skillType;
}
