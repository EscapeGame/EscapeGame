
public enum SkillActionType {
	FIREBALL {
		public SkillAction getAction(Player player) {
			int amount = -player.getIntelligence() * 5;
			return new AttackAction("Fireball", amount, "hp", "You hurl a fiery ball of flame at ");
		}
	},
	
	HEALING {
		public SkillAction getAction(Player player) {
			int amount = player.getIntelligence();
			return new SelfAction("Healing", amount, "hp", "You heal");
		}
	};
	
	public abstract SkillAction getAction(Player player);

}
