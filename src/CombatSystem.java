import java.util.*;

public class CombatSystem {

	public static void battleInput() {
		System.out.println("\nWhat would you like to do? \n1: Attack \n2: Use Item \n3: Escape \n>>");
	}

	public void attack() throws InterruptedException {
		System.out.println("\nYou attack the enemy " + Tutorial.enemy0.getName() + "!");

		Random r = new Random();
		// Roll for attack.
		int d20 = (r.nextInt(20) + 1);
		// Initialize dmg variable as 0.
		int dmg = 0;

		// If the hero rolls a 1, the attack automatically misses.
		if (d20 == 1) {
			System.out.println("\nYour attack missed!");

			// If the hero rolls 1-19, add base attack and strength modifiers to
			// the roll.
		} else if ((d20 > 1) && (d20 < 20)) {
			dmg = (d20 + Game.userHero.getAttPower() + Game.userHero.getStr());

			// If the total of the 1) roll, 2) base attack modifier, and 3)
			// strength modifier is less than or equal to than the enemy's AC,
			// the enemy blocks the attack.
			if (dmg <= Tutorial.enemy0.getDefense()) {
				System.out.println("\nThe enemy " + Tutorial.enemy0.getName() + " has blocked your attack!");

				// If the total of the roll and modifiers is greater than the
				// enemy's AC, the attack hits.
			} else if (dmg > Tutorial.enemy0.getDefense()) {
				System.out.println(
						"\nYour attack dealt " + dmg + " damage to the enemy " + Tutorial.enemy0.getName() + "!");
				Tutorial.enemy0.setHealth(Tutorial.enemy0.getHealth() - dmg);
			}

			// If the hero rolls a 20, the attack is a critical hit.
		} else if (d20 >= 20) {
			Random rr = new Random();
			// Roll a second die to determine extra damage.
			int critRoll = (rr.nextInt(20) + 1);
			// Add second roll to the first roll to determine critical hit
			// damage.
			int critDmg = d20 + critRoll;
			// Add critical hit damage to base damage to get total damage.
			int totalDmg = dmg + critDmg;

			System.out.println("\n>>CRITICAL HIT!<< \nYou have dealt " + totalDmg + " damage to the enemy "
					+ Tutorial.enemy0.getName() + "!");

			// Subtract total damage from enemy's HP.
			Tutorial.enemy0.setHealth(Tutorial.enemy0.getHealth() - totalDmg);
		}

		// Check enemy status.
		enemyStatus();
		Thread.sleep(2000);

		// Check if the enemy still has health.
		if (Tutorial.enemy0.getHealth() > 0) {
			// Enemy's turn.
			enemyAttack();
			// Check player's HP.
			playerStatus();
			// Print battle options.
			battleInput();
		} else if (Tutorial.enemy0.getHealth() <= 0) {
			Tutorial.youWon();
		}
	}

	public void useItem() throws InterruptedException {
		// Add 20 HP to the player's HP.
		Game.userHero.setHealth(Game.userHero.getHealth() + 20);
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
		int escChance = escRoll + Game.userHero.getDex();
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
		if (Tutorial.enemy0.getHealth() > 0) {
			System.out.println("\n------------------------------------------");
			System.out.print("The enemy " + Tutorial.enemy0.getName() + " has " + Tutorial.enemy0.getHealth()
					+ " HP remaining.");
			System.out.println("\n------------------------------------------");

			// If enemy has 0 HP, print it.
		} else {
			System.out.println("\n------------------------------------------");
			System.out.print("The enemy " + Tutorial.enemy0.getName() + " has 0 HP remaining.");
			System.out.println("\n------------------------------------------");
		}
	}

	private void enemyAttack() {
		System.out.println("\nThe enemy " + Tutorial.enemy0.getName() + " attacks!");

		Random r = new Random();
		// Roll for attack.
		int d20 = (r.nextInt(20) + 1);
		// Initialize dmg variable as 0.
		int dmg = 0;

		// If the hero rolls a 1, the attack automatically misses.
		if (d20 == 1) {
			System.out.println("\nThe enemy " + Tutorial.enemy0.getName() + "'s attack missed!");

			// If the hero rolls 1-19, add base attack and strength modifiers to
			// the roll.
		} else if ((d20 > 1) && (d20 < 20)) {
			dmg = (d20 + Tutorial.enemy0.getAttPower());

			// If the total of the 1) roll, 2) base attack modifier, and 3)
			// strength modifier is less than or equal to than the enemy's AC,
			// the enemy blocks the attack.
			if (dmg <= Game.userHero.getDefense()) {
				System.out.println("\nYou have blocked the enemy " + Tutorial.enemy0.getName() + "'s attack!");
			}

			// If the total of the roll and modifiers is greater than the
			// enemy's AC, the attack hits.
			System.out.println("\nThe enemy " + Tutorial.enemy0.getName() + "'s attack does " + dmg + " damage!");
			// Subtract enemy attack damage from player's HP.
			Game.userHero.setHealth(Game.userHero.getHealth() - dmg);

			// If the hero rolls a 20, the attack is a critical hit.
		} else if (d20 >= 20) {
			Random rr = new Random();
			// Roll a second die to determine extra damage.
			int critRoll = (rr.nextInt(20) + 1);
			// Add second roll to the first roll to determine critical hit
			// damage.
			int critDmg = d20 + critRoll;
			// Add critical hit damage to base damage to get total damage.
			int totalDmg = dmg + critDmg;

			System.out.println(
					">>CRITICAL HIT!<< \nThe enemy " + Tutorial.enemy0.getName() + "'s attack does " + totalDmg + "!");
			// Subtract enemy's total damage from the player's HP.
			Game.userHero.setHealth(Game.userHero.getHealth() - totalDmg);
		}
	}

	private void playerStatus() {
		// If the user still has HP, print how much.
		if (Game.userHero.getHealth() > 0) {
			System.out.println("\n------------------------------------------");
			System.out.print("You have " + Game.userHero.getHealth() + " HP remaining.");
			System.out.println("\n------------------------------------------");

			// If the user has 0 HP, print it.
		} else {
			System.out.println("\n------------------------------------------");
			System.out.print("You have 0 HP remaining.");
			System.out.println("\n------------------------------------------");
		}
	}

}
