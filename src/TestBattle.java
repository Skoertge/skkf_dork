
public class TestBattle {
	static CombatSystem combatSystem = new CombatSystem();
	//static Character enemy = new Character();
	static Enemy enemy = new Enemy();
	private static boolean fighting = true;

	public static void testBattle() throws InterruptedException {

		// Print which enemy the hero has encountered
		encounter();
		// Print battle options (i.e. attack, defend, etc.)
		CombatSystem.battleInput();

		// While the hero is battling an enemy...
		while (fighting) {
			// ....keep checking if the user/enemy reaches 0 HP...
			// ....if so, break the loop
			if (Game.hero.getHero().getHitPoints() <= 0 || enemy.getEnemy().getHitPoints() <= 0) {
				fighting = false;
				break;
			}
			// If user has not entered any input, print battle options...
			// ....and if input is 1 (attack), then proceed with battle
			if (Game.userInput.hasNextInt()) {
				int input = Game.userInput.nextInt();
				if (!(input == 1 || input == 2 || input == 3)) {
					CombatSystem.battleInput();
				}
				switch (input) {
				case 1:
					input = 1;
					// combatSystem.attack();
					break;
				case 2:
					input = 2;
					// combatSystem.useItem();
					break;
				case 3:
					input = 3;
					// combatSystem.escape();
					break;
				}
				if (!fighting) {
					// If the battle ends with the user having 0 HP, print
					// loss...
					// ....if the battle ends with the enemy having 0 HP, print
					// win
					if (Game.hero.getHero().getHitPoints() <= 0) {
						youLost();
					} else if (enemy.getEnemy().getHitPoints() <= 0) {
						youWon();
					}
				}
			}
		}
	}

	// Print encounter message
	public static void encounter() {
		System.out.println("You have encountered a " + enemy.getEnemy().name() + "!\n");
		Game.contDialogue();
	}

	// Print win message
	public static void youWon() {
		System.out.println("\nYou have slain the enemy " + enemy.getEnemy().name() + "!");
		Game.contDialogue();
	}

	// Print loss message
	public static void youLost() {
		System.out.println("\nYou were slain by the enemy " + enemy.getEnemy().name() + "!");
		Game.contDialogue();
	}
}
