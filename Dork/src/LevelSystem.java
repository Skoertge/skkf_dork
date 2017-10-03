import java.util.Random;

public class LevelSystem extends BareBones {

	public static Random r = new Random();
	public static int[] levels = { 300, 900, 2700, 6500, 14000, 23000, 34000, 48000, 64000, 85000, 100000, 120000,
			140000, 165000, 195000, 225000, 265000, 305000, 335000 };
	public static int i;

	public static void main(String[] args) {
		xpGain();
		levelUp();
	}

	public static void xpGain() {
		int xpRoll = r.nextInt(Tutorial.enemy0.xpMod + 1);
		System.out.println("\nYou have gained " + xpRoll + " experience!");
		Game.userHero.experience += xpRoll;

	}

	public static void levelUp() {
		for (int j = 0; j < levels.length; j++) {
			if (Game.userHero.experience >= levels[j]) {
				Game.userHero.level++;
				i = j + 1;
				if ((Game.userHero.level > 1) && (Game.userHero.level < 5)) {
					Game.userHero.setProficiencyPoints(Game.userHero.getProficiencyPoints() + 2);
				} else if ((Game.userHero.level > 4) && (Game.userHero.level < 9)) {
					Game.userHero.setProficiencyPoints(Game.userHero.getProficiencyPoints() + 3);
				} else if ((Game.userHero.level > 8) && (Game.userHero.level < 13)) {
					Game.userHero.setProficiencyPoints(Game.userHero.getProficiencyPoints() + 4);
				} else if ((Game.userHero.level > 12) && (Game.userHero.level < 17)) {
					Game.userHero.setProficiencyPoints(Game.userHero.getProficiencyPoints() + 5);
				} else if ((Game.userHero.level > 16) && (Game.userHero.level < 20)) {
					Game.userHero.setProficiencyPoints(Game.userHero.getProficiencyPoints() + 6);
				}
				Game.userHero.getCharacter()
						.setHitPoints(Game.userHero.getCharacter().getHitPoints() + (Game.userHero.level * 10));
				System.out.println("You have leveled up! You are now level " + Game.userHero.level + ".\n");
				Game.userHero.showCharacter();
			}
		}
	}
}
