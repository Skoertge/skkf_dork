import java.util.*;

public class CombatSystem {

	public static void battleInput() {
		if ((Game.userHero.getUserClass().equals("Cleric")) || (Game.userHero.getUserClass().equals("Wizard"))) {
			System.out.print(
					"\nWhat would you like to do? \n1: Use Spell \n2: Melee Attack \n3. Use Item \n4: Escape \n>> ");
		} else {
			System.out.print(
					"\nWhat would you like to do? \n1: Melee Attack \n2: Ranged Attack \n3: Use Item \n4: Escape \n>> ");
		}
	}

	public void meleeAttack() throws InterruptedException {
		System.out.println("\nYou attack the enemy " + Tutorial.enemy0.getName() + "!");

		Random r = new Random();
		// Roll for attack.
		int d20 = (r.nextInt(20) + 1);
		// Initialize dmg variable as 0.
		int dmgRoll = (r.nextInt(Game.userHero.getMeleeDamage() + 1));
		int dmg = (dmgRoll + Game.userHero.getCharacter().getStrength());

		// If the hero rolls a 1, the attack automatically misses.
		if (d20 == 1) {
			System.out.println("\nYour attack missed!");

			// If the hero rolls 1-19, add base attack and strength modifiers to
			// the roll.
		} else if ((d20 > 1) && (d20 < 20)) {
			// If the total of the 1) roll, 2) base attack modifier, and 3)
			// strength modifier is less than or equal to than the enemy's AC,
			// the enemy blocks the attack.
			if (dmg <= Game.userHero.getArmorClass()) {
				System.out.println("\nThe enemy " + Tutorial.enemy0.getName() + " blocked your attack!");
			} else {
				// If the total of the roll and modifiers is greater than the
				// enemy's AC, the attack hits.
				System.out
						.println("\nYou have dealt " + dmg + " damage to the enemy " + Tutorial.enemy0.getName() + "!");
				// Subtract enemy attack damage from player's HP.
				Tutorial.enemy0.setEnemyHP(Tutorial.enemy0.getEnemyHP() - dmg);
			}

			// If the hero rolls a 20, the attack is a critical hit.
		} else if (d20 == 20) {
			int critRoll = (r.nextInt(Game.userHero.getMeleeDamage()) + 1);
			int totalDmg = dmg + critRoll;

			System.out.println("\n>>CRITICAL HIT!<< \nYou have dealt " + totalDmg + " damage to the enemy "
					+ Tutorial.enemy0.getName() + "!");

			// Subtract total damage from enemy's HP.
			Tutorial.enemy0.setEnemyHP(Tutorial.enemy0.getEnemyHP() - totalDmg);
		}

		// If the hero rolls a 20, the attack is a critical hit

		// Check enemy status.
		enemyStatus();
		Thread.sleep(2000);

		// Check if the enemy still has health.
		if (Tutorial.enemy0.getEnemyHP() > 0)

		{
			// Enemy's turn.
			enemyAttack();
			// Check player's HP.
			playerStatus();
			// Print battle options.
			battleInput();
		} else if (Tutorial.enemy0.getEnemyHP() <= 0) {
			Tutorial.youWon();
		}
	}

	public void rangedAttack() throws InterruptedException {
		System.out.println("\nYou attack the enemy " + Tutorial.enemy0.getName() + "!");

		Random r = new Random();
		// Roll for attack.
		int d20 = (r.nextInt(20) + 1);
		// Initialize dmg variable as 0.
		int dmgRoll = (r.nextInt(Game.userHero.getRangedDamage() + 1));
		int dmg = (dmgRoll + Game.userHero.getCharacter().getDexterity());

		// If the hero rolls a 1, the attack automatically misses.
		if (d20 == 1) {
			System.out.println("\nYour attack missed!");

			// If the hero rolls 1-19, add base attack and strength modifiers to
			// the roll.
		} else if ((d20 > 1) && (d20 < 20)) {
			// If the total of the 1) roll, 2) base attack modifier, and 3)
			// strength modifier is less than or equal to than the enemy's AC,
			// the enemy blocks the attack.
			if (dmg <= Game.userHero.getArmorClass()) {
				System.out.println("\nThe enemy " + Tutorial.enemy0.getName() + " blocked your attack!");
			} else {
				// If the total of the roll and modifiers is greater than the
				// enemy's AC, the attack hits.
				System.out
						.println("\nYou have dealt " + dmg + " damage to the enemy " + Tutorial.enemy0.getName() + "!");
				// Subtract enemy attack damage from player's HP.
				Tutorial.enemy0.setEnemyHP(Tutorial.enemy0.getEnemyHP() - dmg);
			}

			// If the hero rolls a 20, the attack is a critical hit.
		} else if (d20 == 20) {
			int critRoll = (r.nextInt(Game.userHero.getRangedDamage()) + 1);
			int totalDmg = dmg + critRoll;

			System.out.println("\n>>CRITICAL HIT!<< \nYou have dealt " + totalDmg + " damage to the enemy "
					+ Tutorial.enemy0.getName() + "!");

			// Subtract total damage from enemy's HP.
			Tutorial.enemy0.setEnemyHP(Tutorial.enemy0.getEnemyHP() - totalDmg);
		}

		// If the hero rolls a 20, the attack is a critical hit

		// Check enemy status.
		enemyStatus();
		Thread.sleep(2000);

		// Check if the enemy still has health.
		if (Tutorial.enemy0.getEnemyHP() > 0)

		{
			// Enemy's turn.
			enemyAttack();
			// Check player's HP.
			playerStatus();
			// Print battle options.
			battleInput();
		} else if (Tutorial.enemy0.getEnemyHP() <= 0) {
			Tutorial.youWon();
		}
	}

	public void clericChooseSpell() throws InterruptedException {		
		System.out.print("\nWhich spell would you like to use? \n1. Guiding Bolt \n2. Inflict Wounds \n3. Sacred Flame \n>> ");
		if (Game.userInput.hasNextInt()) {
			Random r = new Random();
			int spellDamage = 0;
			int spellRoll = 0;
			int input = Game.userInput.nextInt();
			if (!(input == 1 || input == 2 || input == 3)) {
				clericChooseSpell();
			}
			switch (input) {
			case 1:
				input = 1;
				spellDamage = Game.userHero.userSpells.get("Guiding Bolt");
				spellRoll = ((r.nextInt(spellDamage) + 1) * 4);
				clericSpellAttack(spellDamage, spellRoll);
				break;
			case 2:
				input = 2;
				spellDamage = Game.userHero.userSpells.get("Inflict Wounds");
				spellRoll = ((r.nextInt(spellDamage) + 1) * 3);
				clericSpellAttack(spellDamage, spellRoll);
				break;
			case 3:
				input = 3;
				spellDamage = Game.userHero.userSpells.get("Sacred Flame");
				spellRoll = (r.nextInt(spellDamage) + 1);
				clericSpellAttack(spellDamage, spellRoll);
				break;
			}
		}
	}

	public void clericSpellAttack(int spellDamage, int spellRoll) throws InterruptedException {
		System.out.println("\nYou attack the enemy " + Tutorial.enemy0.getName() + "!");

		Random r = new Random();
		// Roll for attack.
		int d20 = (r.nextInt(20) + 1);
		// Initialize dmg variable as 0.
		int dmg = (spellRoll + Game.userHero.getCharacter().getWisdom());

		// If the hero rolls a 1, the attack automatically misses.
		if (d20 == 1) {
			System.out.println("\nYour attack missed!");

			// If the hero rolls 1-19, add base attack and strength modifiers to
			// the roll.
		} else if ((d20 > 1) && (d20 < 20)) {
			// If the total of the 1) roll, 2) base attack modifier, and 3)
			// strength modifier is less than or equal to than the enemy's AC,
			// the enemy blocks the attack.
			if (dmg <= Game.userHero.getArmorClass()) {
				System.out.println("\nThe enemy " + Tutorial.enemy0.getName() + " blocked your attack!");
			} else {
				// If the total of the roll and modifiers is greater than the
				// enemy's AC, the attack hits.
				System.out
						.println("\nYou have dealt " + dmg + " damage to the enemy " + Tutorial.enemy0.getName() + "!");
				// Subtract enemy attack damage from player's HP.
				Tutorial.enemy0.setEnemyHP(Tutorial.enemy0.getEnemyHP() - dmg);
			}

			// If the hero rolls a 20, the attack is a critical hit.
		} else if (d20 == 20) {
			int critRoll = (r.nextInt(spellDamage) + 1);
			int totalDmg = dmg + critRoll;

			System.out.println("\n>>CRITICAL HIT!<< \nYou have dealt " + totalDmg + " damage to the enemy "
					+ Tutorial.enemy0.getName() + "!");

			// Subtract total damage from enemy's HP.
			Tutorial.enemy0.setEnemyHP(Tutorial.enemy0.getEnemyHP() - totalDmg);
		}

		// If the hero rolls a 20, the attack is a critical hit

		// Check enemy status.
		enemyStatus();
		Thread.sleep(2000);

		// Check if the enemy still has health.
		if (Tutorial.enemy0.getEnemyHP() > 0)

		{
			// Enemy's turn.
			enemyAttack();
			// Check player's HP.
			playerStatus();
			// Print battle options.
			battleInput();
		} else if (Tutorial.enemy0.getEnemyHP() <= 0) {
			Tutorial.youWon();
		}
	}

	public void wizardChooseSpell() throws InterruptedException {	
		System.out.println("\nWhich spell would you like to use? \n1. Acid Splash \n2. Fire Bolt \n3. Ray of Frost \n>> ");
		if (Game.userInput.hasNextInt()) {
			Random r = new Random();
			int spellDamage = 0;
			int spellRoll = 0;
			int input = Game.userInput.nextInt();
			if (!(input == 1 || input == 2 || input == 3)) {
				wizardChooseSpell();
			}
			switch (input) {
			case 1:
				input = 1;
				spellDamage = Game.userHero.userSpells.get("Acid Splash");
				spellRoll = (r.nextInt(spellDamage) + 1);
				wizardSpellAttack(spellDamage, spellRoll);
				break;
			case 2:
				input = 2;
				spellDamage = Game.userHero.userSpells.get("Fire Bolt");
				spellRoll = (r.nextInt(spellDamage) + 1);
				wizardSpellAttack(spellDamage, spellRoll);
				break;
			case 3:
				input = 3;
				spellDamage = Game.userHero.userSpells.get("Ray of Frost");
				spellRoll = (r.nextInt(spellDamage) + 1);
				wizardSpellAttack(spellDamage, spellRoll);
				break;
			}
		}
	}
	
	public void wizardSpellAttack(int spellDamage, int spellRoll) throws InterruptedException {
		System.out.println("\nYou attack the enemy " + Tutorial.enemy0.getName() + "!");

		Random r = new Random();
		// Roll for attack.
		int d20 = (r.nextInt(20) + 1);
		// Initialize dmg variable as 0.
		int dmg = (spellRoll + Game.userHero.getCharacter().getIntelligence());

		// If the hero rolls a 1, the attack automatically misses.
		if (d20 == 1) {
			System.out.println("\nYour attack missed!");

			// If the hero rolls 1-19, add base attack and strength modifiers to
			// the roll.
		} else if ((d20 > 1) && (d20 < 20)) {
			// If the total of the 1) roll, 2) base attack modifier, and 3)
			// strength modifier is less than or equal to than the enemy's AC,
			// the enemy blocks the attack.
			if (dmg <= Game.userHero.getArmorClass()) {
				System.out.println("\nThe enemy " + Tutorial.enemy0.getName() + " blocked your attack!");
			} else {
				// If the total of the roll and modifiers is greater than the
				// enemy's AC, the attack hits.
				System.out
						.println("\nYou have dealt " + dmg + " damage to the enemy " + Tutorial.enemy0.getName() + "!");
				// Subtract enemy attack damage from player's HP.
				Tutorial.enemy0.setEnemyHP(Tutorial.enemy0.getEnemyHP() - dmg);
			}

			// If the hero rolls a 20, the attack is a critical hit.
		} else if (d20 == 20) {
			int critRoll = (r.nextInt(spellDamage) + 1);
			int totalDmg = dmg + critRoll;

			System.out.println("\n>>CRITICAL HIT!<< \nYou have dealt " + totalDmg + " damage to the enemy "
					+ Tutorial.enemy0.getName() + "!");

			// Subtract total damage from enemy's HP.
			Tutorial.enemy0.setEnemyHP(Tutorial.enemy0.getEnemyHP() - totalDmg);
		}

		// If the hero rolls a 20, the attack is a critical hit

		// Check enemy status.
		enemyStatus();
		Thread.sleep(2000);

		// Check if the enemy still has health.
		if (Tutorial.enemy0.getEnemyHP() > 0)

		{
			// Enemy's turn.
			enemyAttack();
			// Check player's HP.
			playerStatus();
			// Print battle options.
			battleInput();
		} else if (Tutorial.enemy0.getEnemyHP() <= 0) {
			Tutorial.youWon();
		}
	}

	public void useItem() throws InterruptedException {
		// Add 20 HP to the player's HP.
		Game.userHero.getCharacter().setHitPoints(Game.userHero.getEnemyHP() + 20);
		System.out.println("\nYou have used a potion. \nYour health has increased by 20!");
		// Check player's HP.
		playerStatus();
		Thread.sleep(2000);
		// Enemy's turn.
		enemyAttack();
		// Check player's HP.
		playerStatus();
		// Print battle options.
		battleInput();
	}

	public void escape() throws InterruptedException {
		Random roll = new Random();
		int escRoll = roll.nextInt(20) + 1;
		int escChance = escRoll + Game.userHero.getCharacter().getDexterity();
		if (escChance <= Tutorial.enemy0.getEscapeDC()) {
			System.out.println("You cannot escape!");
			Thread.sleep(2000);
			// Enemy's turn.
			enemyAttack();
			// Check player's HP.
			playerStatus();
			// Print battle options.
			battleInput();
		} else if (escChance > Tutorial.enemy0.getEscapeDC()) {
			System.out.println("You have successfully avoided the enemy " + Tutorial.enemy0.getName() + "!");
		}
	}

	private void enemyStatus() {
		// If enemy still has HP, print how much.
		if (Tutorial.enemy0.getEnemyHP() > 0) {
			System.out.println("\n------------------------------------------");
			System.out.print("The enemy " + Tutorial.enemy0.getName() + " has " + Tutorial.enemy0.getEnemyHP()
					+ " HP remaining.");
			System.out.println("\n------------------------------------------");

			// If enemy has 0 HP, print it.
		} else {
			System.out.println("\n------------------------------------------");
			System.out.print("The enemy " + Tutorial.enemy0.getName() + " has 0 HP remaining.");
			System.out.println("\n------------------------------------------");
		}
	}

	private void enemyAttack() throws InterruptedException {
		System.out.println("\nThe enemy " + Tutorial.enemy0.getName() + " attacks!");

		Random r = new Random();
		// Roll for attack.
		int d20 = (r.nextInt(20) + 1);
		// Initialize dmg variable as 0.
		int dmg = (r.nextInt(Tutorial.enemy0.getMeleeDamage()) + 1);

		// If the hero rolls a 1, the attack automatically misses.
		if (d20 == 1) {
			System.out.println("\nThe enemy " + Tutorial.enemy0.getName() + "'s attack missed!");

			// If the hero rolls 1-19, add base attack and strength modifiers to
			// the roll.
		} else if ((d20 > 1) && (d20 < 20)) {
			// If the total of the 1) roll, 2) base attack modifier, and 3)
			// strength modifier is less than or equal to than the enemy's AC,
			// the enemy blocks the attack.
			if (d20 <= Game.userHero.getArmorClass()) {
				System.out.println("\nYou have blocked the enemy " + Tutorial.enemy0.getName() + "'s attack!");
			}

			// If the total of the roll and modifiers is greater than the
			// enemy's AC, the attack hits.
			System.out.println("\nThe enemy " + Tutorial.enemy0.getName() + "'s attack does " + dmg + " damage!");
			// Subtract enemy attack damage from player's HP.
			Game.userHero.getCharacter().setHitPoints(Game.userHero.getCharacter().getHitPoints() - dmg);

			// If the hero rolls a 20, the attack is a critical hit.
		} else if (d20 >= 20) {
			int critDmg = r.nextInt(Tutorial.enemy0.getMeleeDamage()) + 1;
			int totalDmg = dmg + critDmg;

			System.out.println(
					">>CRITICAL HIT!<< \nThe enemy " + Tutorial.enemy0.getName() + "'s attack does " + totalDmg + "!");
			// Subtract enemy's total damage from the player's HP.
			Game.userHero.getCharacter().setHitPoints(Game.userHero.getCharacter().getHitPoints() - totalDmg);
		}
		if (Game.userHero.getCharacter().hitPoints <= 0) {
			Tutorial.youLost();
		}
	}

	private void playerStatus() {
		// If the user still has HP, print how much.
		if (Game.userHero.getCharacter().hitPoints > 0) {
			System.out.println("\n------------------------------------------");
			System.out.print("You have " + Game.userHero.getCharacter().getHitPoints() + " HP remaining.");
			System.out.println("\n------------------------------------------");

			// If the user has 0 HP, print it.
		} else {
			System.out.println("\n------------------------------------------");
			System.out.print("You have 0 HP remaining.");
			System.out.println("\n------------------------------------------");
		}
	}

}
