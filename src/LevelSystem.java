import java.util.Random;

public class LevelSystem extends BareBones {

	public static Random r = new Random();

	public static void main(String[] args) {
		xpGain();
		levelUp();
	}

	public static void xpGain() {
		int xpRoll = r.nextInt(Tutorial.enemy0.xpMod + 1);
		int prevXP = Game.userHero.getExp();
		System.out.println("\nYou have gained " + xpRoll + " experience!");
		Game.userHero.exp = prevXP + xpRoll;

	}

	public static void levelUp() {
		if (Game.userHero.exp >= 300) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 1);
			Game.userHero.setStr(Game.userHero.getDex() + 1);
		} else if (Game.userHero.exp >= 900) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 1);
			Game.userHero.setStr(Game.userHero.getDex() + 1);
		} else if (Game.userHero.exp >= 2700) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 1);
			Game.userHero.setStr(Game.userHero.getDex() + 1);
		} else if (Game.userHero.exp >= 6500) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 2);
			Game.userHero.setStr(Game.userHero.getDex() + 1);
		} else if (Game.userHero.exp >= 14000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 1);
			Game.userHero.setStr(Game.userHero.getDex() + 2);
		} else if (Game.userHero.exp >= 23000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 2);
			Game.userHero.setStr(Game.userHero.getDex() + 1);
		} else if (Game.userHero.exp >= 34000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 1);
			Game.userHero.setStr(Game.userHero.getDex() + 2);
		} else if (Game.userHero.exp >= 48000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 2);
			Game.userHero.setStr(Game.userHero.getDex() + 2);
		} else if (Game.userHero.exp >= 64000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 2);
			Game.userHero.setStr(Game.userHero.getDex() + 2);
		} else if (Game.userHero.exp >= 85000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 2);
			Game.userHero.setStr(Game.userHero.getDex() + 2);
		} else if (Game.userHero.exp >= 100000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 2);
			Game.userHero.setStr(Game.userHero.getDex() + 2);
		} else if (Game.userHero.exp >= 120000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 3);
			Game.userHero.setStr(Game.userHero.getDex() + 2);
		} else if (Game.userHero.exp >= 140000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 2);
			Game.userHero.setStr(Game.userHero.getDex() + 3);
		} else if (Game.userHero.exp >= 165000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 3);
			Game.userHero.setStr(Game.userHero.getDex() + 2);
		} else if (Game.userHero.exp >= 195000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 2);
			Game.userHero.setStr(Game.userHero.getDex() + 3);
		} else if (Game.userHero.exp >= 225000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 3);
			Game.userHero.setStr(Game.userHero.getDex() + 3);
		} else if (Game.userHero.exp >= 265000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 3);
			Game.userHero.setStr(Game.userHero.getDex() + 3);
		} else if (Game.userHero.exp >= 305000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 3);
			Game.userHero.setStr(Game.userHero.getDex() + 3);
		} else if (Game.userHero.exp >= 335000) {
			Game.userHero.level++;
			System.out.println("\nYou have leveled up! You are now level " + Game.userHero.level + ".");
			Game.userHero.setStr(Game.userHero.getStr() + 3);
			Game.userHero.setStr(Game.userHero.getDex() + 3);
		}
	}
}
