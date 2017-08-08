
import java.util.*;

public class CombatSystem {

	static List<BareBones> enemies;

	public static void battleInput() {
		System.out.println("\n1 = Attack");
	}

	public void battle() throws InterruptedException {
		System.out.println("\nYou attack the enemy!");
		System.out.println("\nYour attack does " + Game.userHero.getAttPower() + " damage to the enemy!");
		Tutorial.enemy0.setHealth(Tutorial.enemy0.getHealth() - Game.userHero.getAttPower());
		enemyStatus();
		Thread.sleep(2000);
		enemyAttack();
		playerStatus();
	}

	private void enemyStatus() {
		System.out.println("\n------------------------------------------");
		System.out.print("The enemy has " + Tutorial.enemy0.getHealth() + " HP remaining.");
		System.out.println("\n------------------------------------------");
	}

	private void enemyAttack() {
		System.out.println("\nThe enemy attacks!");
		System.out.println("\nThe enemy's attack does " + Tutorial.enemy0.getAttPower() + " damage!");
		Game.userHero.setHealth(Game.userHero.getHealth() - Tutorial.enemy0.getAttPower());
	}

	private void playerStatus() {
		System.out.println("\n------------------------------------------");
		System.out.print("You have " + Game.userHero.getHealth() + " HP remaining.");
		System.out.println("\n------------------------------------------");
	}

}
