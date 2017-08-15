import java.util.*;

public class PlayerChar extends BareBones {

	private MyCharacter character;

	// Default constructor with preset values
	public PlayerChar() {
		this.level = 1;
		this.experience = 0;
		id = 0;

		this.userArmor = new LinkedHashMap<String, Integer>();
		this.userWeapons = new LinkedHashMap<String, Integer>();
		this.userMisc = new LinkedHashMap<String, Integer>();
	}

	public void chooseClass() throws InterruptedException {
		System.out.print("\n1. Cleric \n2. Fighter \n3. Rogue \n4. Wizard\n>> ");
		if (Game.userInput.hasNextInt()) {
			int input = Game.userInput.nextInt();
			if (!(input == 1 || input == 2 || input == 3 || input == 4)) {
				chooseClass();
			} else {
				switch (input) {
				case 1:
					Game.userHero.setUserClass("Cleric");
					this.character = MyCharacter.CLERIC;
					System.out.println("\n\n\"Let's choose your equipment.\"");
					Game.contDialogue();
					Game.userInput.nextLine();
					System.out.println("\n\n\"Would you prefer a mace or a warhammer?\"");
					chooseEquipmentCleric();
					break;
				case 2:
					Game.userHero.setUserClass("Fighter");
					this.character = MyCharacter.FIGHTER;
					System.out.println("\n\n\"Let's choose your equipment.\"");
					Game.contDialogue();
					Game.userInput.nextLine();
					System.out.println("\n\n\"Would you prefer chain mail or leather armor?\"");
					chooseEquipmentFighter();
					break;
				case 3:
					Game.userHero.setUserClass("Rogue");
					this.character = MyCharacter.ROGUE;
					System.out.println("\n\n\"Let's choose your equipment.\"");
					Game.contDialogue();
					Game.userInput.nextLine();
					System.out.println("\n\n\"Would you prefer a rapier or a shortsword?\"");
					chooseEquipmentRogue();
					break;
				case 4:
					Game.userHero.setUserClass("Wizard");
					this.character = MyCharacter.WIZARD;
					System.out.println("\n\n\"Let's choose your equipment.\"");
					Game.contDialogue();
					Game.userInput.nextLine();
					System.out.println("\n\n\"Would you prefer a quarterstaff or a dagger?\"");
					chooseEquipmentWizard();
					break;
				}
				Random r = new Random();
				this.character.setHitPoints(r.nextInt(this.character.getHitDie()) + this.character.getConstitution());
			}
		}
	}

	public void chooseEquipmentCleric() {
		System.out.print("\n1. Mace [6] \n2. Warhammer [8]\n>> ");
		if (Game.userInput.hasNextInt()) {
			int input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				this.setMeleeWeapon("Mace");
				this.setMeleeDamage(6);
				System.out.println("<<Mace>> has been added to your inventory.");
				break;
			case 2:
				this.setMeleeWeapon("Warhammer");
				this.setMeleeDamage(8);
				System.out.println("<<Warhammer>> has been added to your inventory.");
				break;
			}
			System.out.println("\n\n\"Would you prefer scale mail, leather armor, or chain mail?\"");
			System.out.print("\n1. Scale Mail [14] \n2. Leather Armor [11] \n3. Chain Mail [16]\n>> ");
			input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				this.userArmor.put("Scale Mail", 14);
				System.out.println("<<Scale Mail>> has been added to your inventory.");
				break;
			case 2:
				this.userArmor.put("Leather Armor", 11);
				System.out.println("<<Leather Armor>> has been added to your inventory.");
				break;
			case 3:
				this.userArmor.put("Chain Mail", 16);
				System.out.println("<<Chain Mail>> has been added to your inventory.");
				break;
			}
			System.out.println("\n\n\"Would you prefer a light crossbow or a spear?\"");
			System.out.print("\n1. Light Crossbow [8] \n2. Spear [6]\n>> ");
			input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				this.setRangedWeapon("Light Crossbow");
				this.setRangedDamage(8);
				System.out.println("<<Light Crossbow>> has been added to your inventory.");
				break;
			case 2:
				this.setRangedWeapon("Spear");
				this.setRangedDamage(6);
				System.out.println("<<Spear>> has been added to your inventory.");
				break;
			}
			System.out.println("\n\n\"Would you prefer a priest's pack or an explorer's pack?\"");
			System.out.print("\n1. Priest's Pack \n2. Explorer's Pack\n>> ");
			input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				break;
			case 2:
				break;
			}
			System.out.println("\n\n\"Since you are a cleric, you will also receive a shield and a holy symbol.\"");
			this.userArmor.put("Shield", 2);
			System.out.println("<<Shield>> has been added to your inventory.");
			this.userMisc.put("Holy Symbol", 0);
			System.out.println("<<Holy Symbol>> has been added to your inventory.");
		}
	}

	public void chooseEquipmentFighter() {
		System.out.print("\n1. Chain Mail [16] \n2. Leather Armor [11]\n>> ");
		if (Game.userInput.hasNextInt()) {
			int input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				this.userArmor.put("Chain Mail", 16);
				System.out.println("<<Chain Mail>> has been added to your inventory.");
				break;
			case 2:
				System.out.println("\n\n\"Since you chose the leather armor, you will also receive a longbow.\"");
				this.userArmor.put("Leather Armor", 11);
				System.out.println("<<Leather Armor>> has been added to your inventory.");
				this.setRangedWeapon("Longbow");
				this.setRangedDamage(8);
				System.out.println("<<Longbow>> has been added to your inventory.");
				break;
			}
			System.out.println("\n\n\"Would you prefer weapon and shield or dual-wield?\"");
			System.out.print("\n1. Lance [12] and Shield [2] \n2. Two Battleaxes [8 each]\n>> ");
			input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				this.setMeleeWeapon("Lance");
				this.setMeleeDamage(12);
				System.out.println("<<Lance>> has been added to your inventory.");
				this.userArmor.put("Shield", 2);
				System.out.println("<<Shield>> has been added to your inventory.");
				break;
			case 2:
				this.setMeleeWeapon("Dual-Wield: Battleaxes");
				this.setMeleeDamage(16);
				System.out.println("<<Battleaxe>> has been added to your inventory.");
				System.out.println("<<Battleaxe>> has been added to your inventory.");
				break;
			}
			System.out.println("\n\n\"Would you prefer a light crossbow or two handaxes?\"");
			System.out.print("\n1. Light Crossbow [8] \n2. Two Handaxes [6 each]\n>> ");
			input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				this.setRangedWeapon("Light Crossbow");
				this.setRangedDamage(8);
				System.out.println("<<Light Crossbow>> has been added to your inventory.");
				break;
			case 2:
				this.setRangedWeapon("Handaxe");
				this.setRangedDamage(6);
				System.out.println("<<Handaxe>> has been added to your inventory.");
				System.out.println("<<Handaxe>> has been added to your inventory.");
				break;
			}
			System.out.println("\n\n\"Would you prefer a dungeoneer's pack or an explorer's pack?\"");
			System.out.print("\n1. Dungeoneer's Pack \n2. Explorer's Pack\n>> ");
			input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				break;
			case 2:
				break;
			}
		}
	}

	public void chooseEquipmentRogue() {
		System.out.print("\n1. Rapier [8] \n2. Shortsword [6]\n>> ");
		if (Game.userInput.hasNextInt()) {
			int input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				this.setMeleeWeapon("Rapier");
				this.setMeleeDamage(8);
				System.out.println("<<Rapier>> has been added to your inventory.");
				break;
			case 2:
				this.setMeleeWeapon("Shortsword");
				this.setMeleeDamage(6);
				System.out.println("<<Shortsword>> has been added to your inventory.");
				break;
			}
			System.out.println("\n\n\"Would you prefer a shortbow or dual-wield shortswords?\"");
			System.out.print("\n1. Shortbow [6] \n2. Shortsword [6]\n>> ");
			input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				this.setRangedWeapon("Shortbow");
				this.setRangedDamage(6);
				System.out.println("<<Shortbow>> has been added to your inventory.");
				break;
			case 2:
				this.setMeleeWeapon("Dual-Wield: " + this.getMeleeWeapon() + " and Shortsword");
				this.setMeleeDamage(this.getMeleeDamage() + 6);
				System.out.println("<<Shortsword>> has been added to your inventory.");
				break;
			}
			System.out
					.println("\n\n\"Would you prefer a burglar's pack, a dungeoneer's pack, or an explorer's pack?\"");
			System.out.print("\n1. Burglar's Pack \n2. Dungeoneer's Pack \n3. Explorer's Pack\n>> ");
			input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			}
			System.out.println(
					"\n\n\"Since you're a rogue, you also receive leather armor, two daggers, and thieves' tools.\"");
			this.userArmor.put("Leather Armor", 11);
			System.out.println("<<Leather Armor>> has been added to your inventory.");
			this.userWeapons.put("Dagger", 4);
			System.out.println("<<Dagger>> has been added to your inventory.");
			this.userWeapons.put("Dagger", 4);
			System.out.println("<<Dagger>> has been added to your inventory.");
			this.userMisc.put("Thieves' Tools", 0);
			System.out.println("<<Thieves' Tools>> has been added to your inventory.");
		}
	}

	public void chooseEquipmentWizard() {
		System.out.print("\n1. Quarterstaff [0] \n2. Dagger [4]\n>> ");
		if (Game.userInput.hasNextInt()) {
			int input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				this.userWeapons.put("Quarterstaff", 0);
				System.out.println("<<Quarterstaff>> has been added to your inventory.");
				break;
			case 2:
				this.setMeleeWeapon("Dagger");
				this.setMeleeDamage(4);
				System.out.println("<<Dagger>> has been added to your inventory.");
				break;
			}
			System.out.println("\n\n\"Would you prefer a component pouch or an arcane focus?\"");
			System.out.print("\n1. Component Pouch \n2. Arcane Focus\n>> ");
			input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				this.userMisc.put("Component Pouch", 0);
				System.out.println("<<Component Pouch>> has been added to your inventory.");
				break;
			case 2:
				this.userMisc.put("Arcane Focus", 0);
				System.out.println("<<Arcane Focus>> has been added to your inventory.");
				break;
			}
			System.out.println("\n\n\"Would you prefer a scholar's pack or an explorer's pack?\"");
			System.out.print("\n1. Scholar's Pack \n2. Explorer's Pack\n>> ");
			input = Game.userInput.nextInt();
			switch (input) {
			case 1:
				break;
			case 2:
				break;
			}
			System.out.println("\n\n\"Since you're a wizard, you also receive a spellbook.\"");
		}
	}

	public void setSpells() {
		if (Game.userHero.getUserClass().equals("Cleric")) {
			this.userSpells = new LinkedHashMap<String, Integer>() {
				{
					put("Guidance", 0);
					put("Light", 0);
					put("Resistance", 0);
					put("Sacred Flame", 0);
					put("Spare the Dying", 0);
					put("Thaumaturgy", 0);
				}
			};
		} else if (Game.userHero.getUserClass().equals("Wizard")) {
			this.userSpells = new LinkedHashMap<String, Integer>() {
				{
					put("Acid Splash", 0);
					put("Dancing Lights", 0);
					put("Fire Bolt", 0);
					put("Light", 0);
					put("Mage Hand", 0);
					put("Minor Illusion", 0);
					put("Poison Spray", 0);
					put("Prestidigitation", 0);
					put("Ray of Frost", 0);
					put("Shocking Grasp", 0);
				}
			};
		}
	}

	public MyCharacter getCharacter() {
		return this.character;
	}

	public enum MyCharacter {

		CLERIC(13, 10, 14, 12, 15, 8, 8, 1, 8), FIGHTER(15, 13, 14, 10, 8, 12, 10, 1, 10), ROGUE(12, 15, 10, 13, 8, 14,
				8, 1, 8), WIZARD(8, 13, 14, 15, 12, 10, 6, 1, 6);

		public int getStrength() {
			return strength;
		}

		public void setStrength(int strength) {
			this.strength = strength;
		}

		public int getDexterity() {
			return dexterity;
		}

		public void setDexterity(int dexterity) {
			this.dexterity = dexterity;
		}

		public int getConstitution() {
			return constitution;
		}

		public void setConstitution(int constitution) {
			this.constitution = constitution;
		}

		public int getIntelligence() {
			return intelligence;
		}

		public void setIntelligence(int intelligence) {
			this.intelligence = intelligence;
		}

		public int getWisdom() {
			return wisdom;
		}

		public void setWisdom(int wisdom) {
			this.wisdom = wisdom;
		}

		public int getCharisma() {
			return charisma;
		}

		public void setCharisma(int charisma) {
			this.charisma = charisma;
		}

		public int getHitDie() {
			return hitDie;
		}

		public void setHitDie(int hitDie) {
			this.hitDie = hitDie;
		}

		public int getHitDiceCount() {
			return hitDiceCount;
		}

		public void setHitDiceCount(int hitDiceCount) {
			this.hitDiceCount = hitDiceCount;
		}

		public int getHitPoints() {
			return hitPoints;
		}

		public void setHitPoints(int hitPoints) {
			if (hitPoints <= 0) {
				this.hitPoints = 0;
			} else {
				this.hitPoints = hitPoints;
			}
		}

		int strength;
		int dexterity;
		int constitution;
		int intelligence;
		int wisdom;
		int charisma;
		int hitDie;
		int hitDiceCount;
		int hitPoints;

		private MyCharacter(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma,
				int hitDie, int hitDiceCount, int hitPoints) {
			this.strength = strength;
			this.dexterity = dexterity;
			this.constitution = constitution;
			this.intelligence = intelligence;
			this.wisdom = wisdom;
			this.charisma = charisma;
			this.hitDie = hitDie;
			this.hitDiceCount = hitDiceCount;
			this.hitPoints = hitPoints;
		}
	}

	public void showCharacter() {
		updateInv();
		System.out.println("---------------------------------------------");
		System.out.println("| Name: " + Game.userHero.getName() + "\n| Class: " + Game.userHero.getUserClass()
				+ "\n| Level: " + Game.userHero.getLevel() + "\n| Experience: " + Game.userHero.getExp() + "/"
				+ LevelSystem.levels[LevelSystem.i] + "\n| Hit Points: " + this.character.getHitPoints());
		System.out.println("|\n| Strength: " + this.character.getStrength() + "\n| Dexterity: "
				+ this.character.getDexterity() + "\n| Intelligence: " + this.character.getIntelligence()
				+ "\n| Wisdom: " + this.character.getWisdom() + "\n| Charisma: " + this.character.getCharisma());
		System.out.println("|\n| Melee Weapon: " + Game.userHero.getMeleeWeapon() + "\n| Melee Damage: "
				+ Game.userHero.getMeleeDamage() + "\n| Ranged Weapon: " + Game.userHero.getRangedWeapon()
				+ "\n| Ranged Damage: " + Game.userHero.getRangedDamage() + "\n| Armor Class: "
				+ Game.userHero.getArmorClass());
		System.out.println("|\n| Hit Die: 1d" + this.character.getHitDie() + "\n| Hit Dice Count: "
				+ this.character.getHitDiceCount());
		System.out.println("---------------------------------------------");
	}

	// Alternative customizable constructor
	public void updateInv() {
		int calcDefense = 0;
		List<String> keysList = new ArrayList<String>(userArmor.keySet());
		for (int r = 0; r < (keysList.size()); r++) {
			String armorItem = keysList.get(r);
			Integer armor = userArmor.get(armorItem);
			calcDefense += armor;
		}
		this.armorClass = calcDefense;
	}

}
