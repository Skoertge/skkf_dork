import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battle {

	@SuppressWarnings({ "resource", "serial" })
	public static void main(String enemy, Integer enemyHP, float pHP, float pArmor, float pDamage) {

		ArrayList<String> options = new ArrayList<String>() {
			{
				add("1. Attack");
				add("2. Defend");
				add("3. Use Item");
				add("4. Escape");
			}
		};

		System.out.print(options);

		Scanner s = new Scanner(System.in);
		String choice = s.next();

		if (choice.equalsIgnoreCase("Attack") || (choice == "1")) {
			attack(pDamage, enemy, enemyHP, pDamage);
		} else if (choice.equalsIgnoreCase("Defend") || (choice == "2")) {
			defend(pArmor, pHP, enemy);
		} else if (choice.equalsIgnoreCase("Use Item") || (choice == "3")) {
			useItem();
		} else if (choice.equalsIgnoreCase("Escape") || (choice == "4")) {
			escape(pArmor);
		}
	}

	private void attack(float pDamage, String enemy, Integer enemyHP, float pHP) {
		// Pull weapon damage from player's inventory
		// Randomize a number +/-2 from the weapon damage
		while (enemyHP >= 0) {
			System.out.println("You attack with " + pDamage + " damage!");
			enemyTurn(enemy, pHP);
		}
		enemyDeath(enemy);
	}

	private void defend(float pArmor, float pHP, String enemy) {
		// Pull armor from player's inventory
		// Randomize a number +/- 2 from the armor rating
		while (pHP > 0) {

			enemyTurn(enemy, pHP);
		}
		playerDeath();
	}

	private void useItem() {
		// Pull player's inventory
		// Provide an arraylist of options for player
	}

	private void escape(float pArmor) {
		// Pull player's speed stat
		// If player's speed stat meets x, escape
		// If player's speed stat does not meet x, move to enemy's turn
		Random r = new Random();
		int escapeChance = r.nextInt(100);

		if (pArmor >= escapeChance) {
			System.out.println("You have escaped!");
		} else if (pArmor < escapeChance) {
			System.out.println("You cannot escape!");
			enemyTurn(pArmor);
		}
	}

	private void statusUpdate() {
		System.out.println("\n------------------------------");
		System.out.println("You now have " + );
	}
	
	private void enemyTurn(String enemy, float pHP) {
		Random r = new Random();
		int dmg = r.nextInt(5);
		System.out.println(enemy + " attacks and deals " + dmg + " damage.");
		pHP = pHP - dmg;
	}

	private void enemyDeath(String enemy) {
		System.out.println("You have slain the " + enemy + "!");
	}

	private void playerDeath() {
		System.out.println("You have been slain! GAME OVER!");
	}

}