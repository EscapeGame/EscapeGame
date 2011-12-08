import java.util.Random;


public enum SkillType {
	
	MELEE {
		private String name = "Melee Attack";
		private int amount;
		private int cost = 0;
		private int duration = 0;
		private int minReq = 0;
		private String minStat = "strength";
		private String targetStat = "hp";
		private RangeType range = RangeType.CLOSE_SINGLE;
		private String message;
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getAttack();
				message = "You attack your foe, causing ";
			}
			else { // monster
				Monster monster = (Monster) mobile;
				amount = -monster.getAttackValue();
				message = monster.getName() + " attacks you, causing ";
			}
			return new AttackAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	DOUBLE_ATTACK {
		private String name = "Double Attack";
		private int amount;
		private int cost = 5;
		private int duration = 0;
		private int minReq = 30;
		private String minStat = "dexterity";
		private String targetStat = "hp";
		private RangeType range = RangeType.CLOSE_SINGLE;
		private String message = "You move swiftly, attacking twice! Your foe takes ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getAttack() * 2;
			}
			else { // monster
				Monster monster = (Monster) mobile;
				amount = -monster.getAttackValue() * 2;
			}
			return new AttackAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	WHIRLWIND {
		private String name = "Whirlwind Attack";
		private int amount;
		private int cost = 50;
		private int duration = 0;
		private int minReq = 200;
		private String minStat = "dexterity";
		private String targetStat = "hp";
		private RangeType range = RangeType.CLOSE_ALL;
		private String message = "You weave a whirlwind of steel through surrounding foes, inflicting a total of ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getAttack();
			}
			return new AttackAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	FIREBALL {
		private String name = "Fireball";
		private int amount;
		private int cost = 10;
		private int duration = 0;
		private int minReq = 10;
		private String minStat = "intelligence";
		private String targetStat = "hp";
		private RangeType range = RangeType.CLOSE_ALL;
		private String message = "You summon a fireball! Surrounding monsters take a total of ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getIntelligence() * 5;
			}
			else amount = 100;
			return new AttackAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	CYCLONE {
		private String name = "Cyclone";
		private int amount;
		private int cost = 40;
		private int duration = 0;
		private int minReq = 4;
		private String minStat = "level";
		private String targetStat = "hp";
		private RangeType range = RangeType.CLOSE_ALL;
		private String message = "You conjure a deadly cyclone that batters surrounding monsters, inflicting a total of ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getIntelligence() * 10;
			}
			else amount = 100;
			return new AttackAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	BANSHEE_WAIL {
		private String name = "Banshee Wail";
		private int amount;
		private int cost = 55;
		private int duration = 10;
		private int minReq = 7;
		private String minStat = "level";
		private String targetStat = "deffenseValue";
		private RangeType range = RangeType.CLOSE_ALL;
		private String message = "The horrible wail of a banshee terrifies your enemies! Surrounding monsters' defenses are weakened by ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getIntelligence() * (int) (player.getLevel() / 2);
			}
			return new AttackAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	FEAR_EFFECT {
		private String name = "Fear Effect";
		private int amount;
		private int cost = 25;
		private int duration = 5;
		private int minReq = 60;
		private String minStat = "strength";
		private String targetStat = "deffenseValue";
		private RangeType range = RangeType.CLOSE_ALL;
		private String message = "You emanate an aura of menace! Surrounding monsters' attacks are weakened by ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getStrength() * player.getLevel();
			}
			return new AttackAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	LIGHTNING_BOLT {
		private String name = "Lightning Bolt";
		private int amount;
		private int cost = 15;
		private int duration = 0;
		private int minReq = 30;
		private String minStat = "intelligence";
		private String targetStat = "hp";
		private RangeType range = RangeType.LINE;
		private String message = "You hurl a lightning bolt! Monsters in front of you take a total of ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getIntelligence() * 10;
			}
			else amount = 200;
			return new AttackAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	ENERGY_BOLT {
		private String name = "Energy Bolt";
		private int amount;
		private int cost = 3;
		private int duration = 0;
		private int minReq = 10;
		private String minStat = "intelligence";
		private String targetStat = "hp";
		private RangeType range = RangeType.LINE;
		private String message = "A glowing bolt shoots from your palm! Monsters in front of you take a total of ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getIntelligence();
			}
			else amount = 200;
			return new AttackAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	DEATH_RAY {
		private String name = "Death Ray";
		private int amount;
		private int cost = 999;
		private int duration = 0;
		private int minReq = 10;
		private String minStat = "level";
		private String targetStat = "hp";
		private RangeType range = RangeType.LINE;
		private String message = "You summon a deathly dark ray, unmaking all in your path for a total of ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getIntelligence() * 666;
			}
			else amount = 200;
			return new AttackAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	HEALING {
		private String name = "Healing";
		private int amount;
		private int cost = 4;
		private int duration = 0;
		private int minReq = 10;
		private String minStat = "intelligence";
		private String targetStat = "hp";
		private RangeType range = RangeType.SELF;
		private String message = "You heal ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = player.getIntelligence() * player.getLevel();
			}
			else amount = 200;
			return new SelfAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	SUPER_HEALING {
		private String name = "Super Healing";
		private int amount;
		private int cost = 60;
		private int duration = 0;
		private int minReq = 300;
		private String minStat = "intelligence";
		private String targetStat = "hp";
		private RangeType range = RangeType.SELF;
		private String message = "You heal ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = player.getIntelligence() * 12 * player.getLevel();
			}
			else amount = 1000;
			return new SelfAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	DEFENSIVE {
		private String name = "Defensive Stance";
		private int amount;
		private int cost = 5;
		private int duration = 10;
		private int minReq = 10;
		private String minStat = "dexterity";
		private String targetStat = "defenseBonus";
		private RangeType range = RangeType.SELF;
		private String message = "For " + duration + " turns, your defense increases by ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = player.getDexterity() * player.getLevel();
			}
			else {
				amount = 30;
			}
			return new SelfAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	OFFENSIVE {
		private String name = "Offensive Stance";
		private int amount;
		private int cost = 5;
		private int duration = 10;
		private int minReq = 10;
		private String minStat = "strength";
		private String targetStat = "attackBonus";
		private RangeType range = RangeType.SELF;
		private String message = "For " + duration + " turns, your attack increases by ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = player.getStrength() * player.getLevel();
			}
			else {
				amount = 30;
			}
			return new SelfAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	POWER_SURGE {
		private String name = "Power Surge";
		private int amount;
		private int cost = 30;
		private int duration = 3;
		private int minReq = 5;
		private String minStat = "level";
		private String targetStat = "strength";
		private RangeType range = RangeType.SELF;
		private String message = "Adrenaline burns through your veins! For " + duration + " turns you gain ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = player.getStrength() * player.getLevel();
			}
			return new SelfAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	MAGIC_SURGE {
		private String name = "Magic Surge";
		private int amount;
		private int cost = 30;
		private int duration = 3;
		private int minReq = 5;
		private String minStat = "level";
		private String targetStat = "intelligence";
		private RangeType range = RangeType.SELF;
		private String message = "The secrets of the arcane are revealed to you! For " + duration + " turns you gain ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = player.getIntelligence() * player.getLevel();
			}
			return new SelfAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	WEAKEN {
		private String name = "Weaken Monster";
		private int amount;
		private int cost = 10;
		private int duration = 5;
		private int minReq = 1;
		private String minStat = "level";
		private String targetStat = "attackValue";
		private RangeType range = RangeType.CLOSE_SINGLE;
		private String message = "You curse the monster with weakness, reducing its attack by ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getIntelligence() * player.getLevel();
			}
			return new AttackAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	SHATTER {
		private String name = "Shatter Defense";
		private int amount;
		private int cost = 25;
		private int duration = 5;
		private int minReq = 3;
		private String minStat = "level";
		private String targetStat = "deffenseValue";
		private RangeType range = RangeType.CLOSE_SINGLE;
		private String message = "You shatter the monster's defenses, reducing it by ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getIntelligence() * player.getLevel() * 2;
			}
			return new AttackAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	},
	
	TRIPLE_ATTACK {
		private String name = "Triple Attack";
		private int amount;
		private int cost = 10;
		private int duration = 0;
		private int minReq = 100;
		private String minStat = "dexterity";
		private String targetStat = "hp";
		private RangeType range = RangeType.CLOSE_SINGLE;
		private String message = "You unleash a flurry of three attacks! Your foe takes ";
		
		@Override
		public SkillAction getAction(MobileObject mobile) {
			if(mobile instanceof Player) {
				Player player = (Player) mobile;
				amount = -player.getAttack() * 3;
			}
			else { // monster
				Monster monster = (Monster) mobile;
				amount = -monster.getAttackValue() * 3;
			}
			return new AttackAction(name, amount, cost, duration, minReq, minStat, targetStat, range, message);
		}

		@Override
		public String toString() {
			return name + " (" + cost + ")";
		}
	};
	
	public static SkillType random() {
		SkillType[] skillTypes = SkillType.values();
		int index = new Random().nextInt(skillTypes.length);
		return skillTypes[index];
	}
	
	public abstract SkillAction getAction(MobileObject mobile);
	public abstract String toString();

}
