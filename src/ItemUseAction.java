
public class ItemUseAction implements Action {

	public ItemUseAction(){}
	
	@Override
	public String execute(Player player, MapObject mapObj) {
		Item item = (Item) mapObj;
		// needs ConsumableItem to have some sort of Use method which passes a player stat and a value
		return null;
	}
	
	@Override
	public String toString() {
		return name;
	}

	private String name;
}
