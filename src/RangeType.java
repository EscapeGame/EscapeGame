import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanh Au
 */
public class Scroll extends ConsumableItem
{    
    public Scroll(String name, String description, int numItem,char symbol, SkillType skillType) {
        super(name, description, numItem, symbol);
        this.skillType = skillType;
    }
    
	public SkillType getSkillType() {
		return skillType;
	}
	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

    private SkillType skillType;
}
