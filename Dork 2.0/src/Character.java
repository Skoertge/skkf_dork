
public class Character {

	String name;
	int baseDamage;
	int armorClass;
	int level = 1;
	int experience = 0;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	private MyHero hero;
	
	public MyHero getHero() {
		return this.hero;
	}

	public enum MyHero {
		CLERIC(13, 10, 14, 12, 15, 8, 8), FIGHTER(15, 13, 14, 10, 8, 12, 10), ROGUE(12, 15, 10, 13, 8, 14, 8), WIZARD(8,
				13, 14, 15, 12, 10, 6);
		
		int strength;
		int dexterity;
		int constitution;
		int intelligence;
		int wisdom;
		int charisma;
		int hitPoints;

		private MyHero(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma,
				int hitPoints) {
			this.strength = strength;
			this.dexterity = dexterity;
			this.constitution = constitution;
			this.intelligence = intelligence;
			this.wisdom = wisdom;
			this.charisma = charisma;
			this.hitPoints = hitPoints;
		}

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
		
		public int getHitPoints() {
			return hitPoints;
		}
		
		public void setHitPoints(int hitPoints) {
			this.hitPoints = hitPoints;
		}
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
					this.hero = MyHero.CLERIC;
					break;
				case 2:
					this.hero = MyHero.FIGHTER;
					break;
				case 3:
					this.hero = MyHero.ROGUE;
					break;
				case 4:
					this.hero = MyHero.WIZARD;
					break;
				}
				showCharacter();
			}
		}
	}

	public void showCharacter() {
		System.out.println("---------------------------------------------");
		System.out.println("| Name: " + Game.hero.getName() + "\n| Level: " + Game.hero.getLevel()
				+ "\n| Experience: " + Game.hero.getExperience() + "/" + LevelSystem.levels[LevelSystem.i]
				+ "\n| Hit Points: " + Game.hero.getHero().getHitPoints());
		System.out.println("|\n| Strength: " + Game.hero.getHero().getStrength() + "\n| Dexterity: " + Game.hero.getHero().getDexterity()
				+ "\n| Intelligence: " + Game.hero.getHero().getIntelligence() + "\n| Wisdom: " + Game.hero.getHero().getWisdom()
				+ "\n| Charisma: " + Game.hero.getHero().getCharisma());
		System.out.println(
				"|\n| Base Damage: " + Game.hero.getBaseDamage() + "\n| Armor Class: " + Game.hero.getArmorClass());
		System.out.println("---------------------------------------------");
	}

}