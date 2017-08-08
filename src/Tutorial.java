import java.util.ArrayList;

public class Tutorial {
	static CombatSystem combatSystem = new CombatSystem();
	static Enemy0 enemy0 = new Enemy0();
	private static boolean fighting = true;

	public static void tutorial() throws InterruptedException {

		System.out.println("\n1 = Attack");

		while (fighting) {
			if (Game.userHero.getHealth() <= 0 || enemy0.getHealth() <= 0) {
				fighting = false;
				break;
			}
			if (Game.userInput.hasNextInt()) {
				int input = Game.userInput.nextInt();
				if (!(input == 1 || input == 2 || input == 3 || input == 4)) {
					CombatSystem.battleInput();
				} else if (input == 1) {
					combatSystem.battle();
				}
			}
		}
		if (!fighting) {
			if (Game.userHero.getHealth() <= 0) {
				youLost();
			} else if (enemy0.getHealth() <= 0) {
				youWon();
				LootDrops.arena();
			}
		}
	}

	public static void youWon() {
		System.out.println("\nYou have defeated the enemy!");
		Game.contDialogue();
		Game.userInput.nextLine();
	}

	public static void youLost() {
		System.out.println("\nYou have lost!");
	}
}
