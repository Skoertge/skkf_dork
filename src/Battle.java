import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battle {

	public static void enemies(String location) {

		HashMap<String, Integer> enemies = new HashMap<String, Integer>();

		// Populate HashMap with enemies based on location
		if (location == "cemetery") {
			enemies.clear();
			// Add rat with HP of 3
			enemies.put("rat", 3);
			// Add skeleton with HP of 8
			enemies.put("skeleton", 8);
			// Add zombie with HP of 12
			enemies.put("zombie", 12);

			List<String> keysList = new ArrayList<String>(enemies.keySet());
			int r = new Random().nextInt(keysList.size());
			String randomEnemy = keysList.get(r);
			Integer enemyHP = enemies.get(randomEnemy);

			System.out.println("You have encountered a " + randomEnemy + "!");
			System.out.println("The " + randomEnemy + " has " + enemyHP + " HP! \nWhat will you do?");
			encounter(location, randomEnemy, enemyHP);

		} else if (location == "cave") {
			enemies.clear();
			// Add rat with HP of 3
			enemies.put("rat", 3);
			// Add bat with HP of 6
			enemies.put("bat", 6);
			// Add something with HP of 8
			enemies.put("beggar", 8);

			List<String> keysList = new ArrayList<String>(enemies.keySet());
			int r = new Random().nextInt(keysList.size());
			String randomEnemy = keysList.get(r);
			Integer enemyHP = enemies.get(randomEnemy);

			System.out.println("You have encountered a " + randomEnemy + "!");
			System.out.println("The " + randomEnemy + " has " + enemyHP + " HP! \nWhat will you do?");
			encounter(location, randomEnemy, enemyHP);
		}
	}

	@SuppressWarnings({ "resource", "serial" })
	private static void encounter(String location, String randomEnemy, Integer enemyHP) {
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
			attack(PlayerStats.pDamage(), randomEnemy, enemyHP);
		} else if (choice.equalsIgnoreCase("Defend") || (choice == "2")) {
			defend(PlayerStats.pArmor(), randomEnemy);
		} else if (choice.equalsIgnoreCase("Use Item") || (choice == "3")) {
			useItem(pHP);
		} else if (choice.equalsIgnoreCase("Escape") || (choice == "4")) {
			PlayerStats.pArmor();
			escape(PlayerStats.pArmor(), randomEnemy);
		}
	}

	private static void attack(float pDamage, String randomEnemy, Integer enemyHP) {
		// Pull weapon damage from player's inventory
		// Randomize a number +/-2 from the weapon damage
		while (enemyHP > 0) {
			
			enemyTurn(randomEnemy);
		}
		enemyDeath(randomEnemy);
	}

	private static void defend(float pArmor, String randomEnemy) {
		// Pull armor from player's inventory
		// Randomize a number +/- 2 from the armor rating
		while (pHP > 0) {
			
			enemyTurn(randomEnemy);
		}
		playerDeath();
	}

	private static void useItem(Integer pHP) {
		// Pull player's inventory
		// Provide an arraylist of options for player
	}

	private static void escape(float pArmor, String randomEnemy) {
		// Pull player's speed stat
		// If player's speed stat meets x, escape
		// If player's speed stat does not meet x, move to enemy's turn
		Random r = new Random();
		int escapeChance = r.nextInt(100);

		if (pArmor >= escapeChance) {
			System.out.println("You have escaped!");
		} else if (pArmor < escapeChance) {
			System.out.println("You cannot escape!");
			enemyTurn(randomEnemy);
		}
	}

	private static void enemyTurn(String randomEnemy) {

	}

	private static void enemyDeath(String randomEnemy) {
		System.out.println("You have slain the " + randomEnemy + "!");
	}
	
	private static void playerDeath() {
		System.out.println("You have been slain!");
	}

}