
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
		public SkillAction getAction(MobileObject mobile) {
			int amount;
			String targetStat = "hp";
			String message;
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getAttack();
				message = "You attack your foe, causing " + amount + " " + targetStat + " of damage.";
			}
			else { // monster
				Monster monster = (Monster) mobile;
				amount = -monster.getAttackValue();
				message = monster.getName() + " attacks you, causing " + amount + " " + targetStat + " of damage.";
			}
			return new AttackAction("Melee", amount, 0, 0, 0, "strength", targetStat, RangeType.CLOSE_SINGLE, message);
		}
	},
	
	DOUBLE_ATTACK {
		public SkillAction getAction(MobileObject mobile) {
			int amount;
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getAttack() * 2;
			}
			else { // monster
				Monster monster = (Monster) mobile;
				amount = -monster.getAttackValue() * 2;
			}
			String targetStat = "hp";
			return new AttackAction("Double Attack", amount, 2, 0, 10, "dexterity", targetStat, RangeType.CLOSE_SINGLE, "You move swiftly, attacking twice! Your foe takes " + amount + " " + targetStat + " damage.");
		}
	},
	
	FIREBALL {
		public SkillAction getAction(MobileObject mobile) {
			int amount;
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getIntelligence() * 3;
			}
			else amount = 100;
			String targetStat = "hp";
			return new AttackAction("Fireball", amount, 10, 0, 10, "intelligence", targetStat, RangeType.CLOSE_ALL, "You summon a fireball, inflicting " + amount + " " + targetStat + " on all surrounding monsters!");
		}
	},
	
	LIGHTNING_BOLT {
		public SkillAction getAction(MobileObject mobile) {
			int amount;
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getIntelligence() * 6;
			}
			else amount = 200;
			String targetStat = "hp";
			return new AttackAction("Lightning Bolt", amount, 15, 0, 30, "intelligence", targetStat, RangeType.LINE, "You hurl a lightning bolt, inflicting " + amount + " " + targetStat + " on all monsters in front of you!");
		}
	},
	
	HEALING {
		public SkillAction getAction(MobileObject mobile) {
			int amount;
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getIntelligence();
			}
			else amount = 200;
			String targetStat = "hp";
			return new SelfAction("Healing", amount, 4, 0, 10, "intelligence", targetStat, RangeType.SELF, "You heal " + amount + " " + targetStat + ".");
		}
	},
	
	INC_STRENGTH {
		public SkillAction getAction(MobileObject mobile) {
			int amount;
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getLevel() * 5;
			}
			else {
				amount = 20;
			}
			int duration = 5;
			return new SelfAction("Increase Strength", amount, 5, duration, 1, "level", "strength", RangeType.SELF, "Your strength increases by " + amount + "! The effect will fade in " + duration + " turns.");
		}
	};
	
	public abstract SkillAction getAction(MobileObject mobile);

}
