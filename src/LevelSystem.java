import java.util.Random;

public class LevelSystem extends BareBones {

	public static Random r = new Random();

	public static void main(String[] args) {
		xpGain();
		levelUp();
	}

	public static void xpGain() {
		int xpRoll = r.nextInt(Tutorial.enemy0.xpMod);
		int prevXP = Game.userHero.getExp();
		System.out.println("You have gained " + xpRoll + " experience!");
		Game.userHero.exp = prevXP + xpRoll;

	}

	public static void levelUp() {
		if (Game.userHero.exp > r.nextInt(1)) {
			Game.userHero.level++;
			System.out.println("You have leveled up! You are now level " + Game.userHero.level + ".");
		} else {

		}
	}
}
