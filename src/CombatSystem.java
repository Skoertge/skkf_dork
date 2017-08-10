import java.util.concurrent.ThreadLocalRandom;

public class CombatSystem {

	public static void battleInput() {
		System.out.println("What would you like to do? \n1: Attack \n2: Defend \n3: Use Item \n4. Escape");
	}

	public void battle() throws InterruptedException {
		System.out.println("\nYou attack the enemy " + Tutorial.enemy0.getName() + "!");

		// Set damage range to +/-2 of the hero's attack power
		int min = Game.userHero.getAttPower() - 2;
		int max = Game.userHero.getAttPower() + 2;
		int dmg = ThreadLocalRandom.current().nextInt(min, max + 1);

		System.out.println("\nYour attack does " + dmg + " damage to the enemy " + Tutorial.enemy0.getName() + "!");

		// Subtract the damage dealt from the enemy's HP
		Tutorial.enemy0.setHealth(Tutorial.enemy0.getHealth() - dmg);

		// Check enemy's status
		enemyStatus();
		Thread.sleep(2000);

		// If enemy still has HP...
		if (Tutorial.enemy0.getHealth() > 0) {
			// ....then it's the enemy's turn to attack
			enemyAttack();

			// Check player's status
			playerStatus();

			// Give battle options
			battleInput();
		}
	}

	private void enemyStatus() {
		// If enemy has HP, print how much...
		// ....if not, print 0 HP
		if (Tutorial.enemy0.getHealth() > 0) {
			System.out.println("\n------------------------------------------");
			System.out.print("The enemy " + Tutorial.enemy0.getName() + " has " + Tutorial.enemy0.getHealth()
					+ " HP remaining.");
			System.out.println("\n------------------------------------------");
		} else {
			System.out.println("\n------------------------------------------");
			System.out.print("The enemy " + Tutorial.enemy0.getName() + " has 0 HP remaining.");
			System.out.println("\n------------------------------------------");
		}
	}

	private void enemyAttack() {
		System.out.println("\nThe enemy " + Tutorial.enemy0.getName() + " attacks!");

		// Set damage range to +/-2 of the enemy's attack power
		int min = Tutorial.enemy0.getAttPower() - 2;
		int max = Tutorial.enemy0.getAttPower() + 2;
		int dmg = ThreadLocalRandom.current().nextInt(min, max + 1);

		System.out.println("\nThe enemy " + Tutorial.enemy0.getName() + "'s attack does " + dmg + " damage!");

		// Subtract damage dealt from hero's health
		Game.userHero.setHealth(Game.userHero.getHealth() - dmg);
	}

	private void playerStatus() {
		// If user has HP, print how much...
		// ....if not, print 0 HP
		if (Game.userHero.getHealth() > 0) {
			System.out.println("\n------------------------------------------");
			System.out.print("You have " + Game.userHero.getHealth() + " HP remaining.");
			System.out.println("\n------------------------------------------");
		} else {
			System.out.println("\n------------------------------------------");
			System.out.print("You have 0 HP remaining.");
			System.out.println("\n------------------------------------------");
		}
	}

}
