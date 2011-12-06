
public enum SkillType {
	
	/*
	 * Order of parameters:
	 * Name of skill
	 * Amount skill will add to target stat (make negative for a damaging skill
	 * Mana cost of skill
	 * Duration of effect in number of turns - only has use for player, for now
	 * Minimum value of prerequisite stat
	 * Prerequisite stat (use name of stat as written in MapObject class)
	 * Target stat (use name of stat as written in MapObject class)
	 * Range type (see RangeType enum)
	 * Prefix to message string - will end in (amount) (targetStat)
	 */
	
	MELEE {
		public SkillAction getAction(Player player) {
			int amount = -player.getAttack();
			String targetStat = "hp";
			return new AttackAction("Melee", amount, 0, 0, 0, "strength", targetStat, RangeType.CLOSE_SINGLE, "You attack your foe, causing " + amount + " " + targetStat + " of damage.");
		}
	},
	
	DOUBLE_ATTACK {
		public SkillAction getAction(Player player) {
			int amount = -player.getAttack() * 2;
			String targetStat = "hp";
			return new AttackAction("Double Attack", amount, 0, 0, 10, "dexterity", targetStat, RangeType.CLOSE_SINGLE, "You move swiftly, attacking twice! Your foe takes " + amount + " " + targetStat + " damage.");
		}
	},
	
	FIREBALL {
		public SkillAction getAction(Player player) {
			int amount = -player.getIntelligence() * 5;
			String targetStat = "hp";
			return new AttackAction("Fireball", amount, 10, 0, 10, "intelligence", targetStat, RangeType.CLOSE_ALL, "You summon a fireball, inflicting " + amount + " " + targetStat + " on all surrounding monsters!");
		}
	},
	
	HEALING {
		public SkillAction getAction(Player player) {
			int amount = player.getIntelligence();
			String targetStat = "hp";
			return new SelfAction("Healing", amount, 4, 0, 10, "intelligence", targetStat, RangeType.SELF, "You heal " + amount + " " + targetStat + ".");
		}
	},
	
	INC_STRENGTH {
		public SkillAction getAction(Player player) {
			int amount = player.getLevel() * 5;
			int duration = 5;
			return new SelfAction("Increase Strength", amount, 5, duration, 1, "level", "strength", RangeType.SELF, "Your strength increases by " + amount + "! The effect will fade in " + duration + " turns.");
		}
	};
	
	public abstract SkillAction getAction(Player player);

}
