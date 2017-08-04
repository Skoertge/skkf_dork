import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Battle {

	public static void enemies(String location) {

		HashMap<String, Integer> enemies = new HashMap<String, Integer>();

		// Populate HashMap with enemies based on location
		if (location == "cemetery") {
			// Add rat with HP of 3
			enemies.put("rat", 8);
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

		} else if (location == "cave") {
			// Add rat with HP of 3
			enemies.put("rat", 12);
			// Add bat with HP of 6
			enemies.put("bat", 16);

			List<String> keysList = new ArrayList<String>(enemies.keySet());
			int r = new Random().nextInt(keysList.size());
			String randomEnemy = keysList.get(r);
			Integer enemyHP = enemies.get(randomEnemy);

			System.out.println("You have encountered a " + randomEnemy + "!");
			System.out.println("The " + randomEnemy + " has " + enemyHP + " HP! \nWhat will you do?");
		}
	}

	public static void encounter(String location, HashMap enemies) {

	}

}