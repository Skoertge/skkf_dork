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

		System.out.println(options);

		Scanner s = new Scanner(System.in);
		String choice = s.next();

		if (choice.equalsIgnoreCase("Attack") || (choice == "1")) {
			attack();
		} else if (choice.equalsIgnoreCase("Defend") || (choice == "2")) {
			defend();
		} else if (choice.equalsIgnoreCase("Use Item") || (choice == "3")) {
			useItem();
		} else if (choice.equalsIgnoreCase("Escape") || (choice == "4")) {
			escape();
		}
	}

	private static void attack() {
		// TODO Auto-generated method stub

	}

	private static void defend() {
		// TODO Auto-generated method stub

	}

	private static void useItem() {
		// TODO Auto-generated method stub

	}

	private static void escape() {
		// TODO Auto-generated method stub

	}

}