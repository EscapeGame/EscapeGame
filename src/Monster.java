import java.awt.Color;


public class Monster 
{
  //some kindah world e.g 3d dimentional world
	
	public int x; //coordinate
	public int y;
	public int z;
	
	//stats
	private String name; //monster name
	private char symbol; //monster symbol e.g Dragon = "D"
	private int hp;      //monster HitPoints
	private int maxHp;   //monster maxHp
	private Color mcolor;//monster color
	
	//vision
	private int visionRadius;
	
	//attack & Deffense
	private int attackValue;
	private int deffenseValue;
	
	
	//constructor
	//public Monster(World world, char )
	
	//stats
	public char getSymbol(){return symbol;}
	public int  getHp(){return hp;}
	public int getMaxHp(){return maxHp;}
	public Color getMcolor(){return mcolor;}
	
	//vision
	public int visionRadius(){return visionRadius;}
	
	//attack
	public int getAttackValue(){return attackValue;}
	public void modifyAttackValue(int addDamage)
		{
			attackValue += addDamage;
		}
	
	//deffense
	public int getDeffenseValue(){return deffenseValue;}
	public void modifyDeffenseValue(int addDeffense)
	{
		deffenseValue += addDeffense;
	}
	
}