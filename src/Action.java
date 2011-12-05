
public interface Action {
	
	public String execute(Player player, MapObject mapObj);
	
	@Override
	public String toString();

}
