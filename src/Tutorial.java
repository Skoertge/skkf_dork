
public class Tutorial {
	static CombatSystem combatSystem = new CombatSystem();
	static Enemy0 enemy0 = new Enemy0();
	private static boolean fighting = true;

	public static void tutorial() throws InterruptedException {

		// Print which enemy the hero has encountered
		encounter();
		// Print battle options (i.e. attack, defend, etc.)
		CombatSystem.battleInput();

		// While the hero is battling an enemy...
		while (fighting) {
			// ....keep checking if the user/enemy reaches 0 HP...
			// ....if so, break the loop
			if (Game.userHero.getHealth() <= 0 || enemy0.getHealth() <= 0) {
				fighting = false;
				break;
			}
			// If user has not entered any input, print battle options...
			// ....and if input is 1 (attack), then proceed with battle
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
			// If the battle ends with the user having 0 HP, print loss...
			// ....if the battle ends with the enemy having 0 HP, print win
			if (Game.userHero.getHealth() <= 0) {
				youLost();
			} else if (enemy0.getHealth() <= 0) {
				youWon();
				LootDrops.main(null);
				LevelSystem.main(null);

			}
		}
	}

	// Print encounter message
	public static void encounter() {
		System.out.println("You have encountered a " + Tutorial.enemy0.getName() + "!\n");
	}

	// Print win message
	public static void youWon() {
		System.out.println("\nYou have slain the enemy " + Tutorial.enemy0.getName() + "!");
		Game.contDialogue();
		Game.userInput.nextLine();
	}

	// Print loss message
	public static void youLost() {
		System.out.println("\nYou were slain by the enemy " + Tutorial.enemy0.getName() + "!");
	}
}
