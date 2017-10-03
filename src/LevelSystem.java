import java.util.Random;

public class LevelSystem {

	public static Random r = new Random();
	public static int[] levels = { 300, 900, 2700, 6500, 14000, 23000, 34000, 48000, 64000, 85000, 100000, 120000,
			140000, 165000, 195000, 225000, 265000, 305000, 335000 };
	public static int i;

	public static void experienceGain() {
		int xpRoll = r.nextInt(0 + 1);
		System.out.println("\nYou have gained " + xpRoll + " experience!");
		Game.hero.experience += xpRoll;
	}

	public static void levelUp() {
		for (int j = 0; j < levels.length; j++) {
			if (Game.hero.experience >= levels[j]) {
				Game.hero.level++;
				i = j + 1;
				System.out.println("You have leveled up! You are now level " + Game.hero.level + ".\n");
			}
		}
	}
}
