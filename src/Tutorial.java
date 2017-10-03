
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
			if (Game.userHero.getCharacter().getHitPoints() <= 0 || enemy0.getEnemyHP() <= 0) {
				fighting = false;
				break;
			}
			// If user has not entered any input, print battle options...
			// ....and if input is 1 (attack), then proceed with battle
			if (Game.userInput.hasNextInt()) {
				int input = Game.userInput.nextInt();
				if (!(input == 1 || input == 2 || input == 3 || input == 4)) {
					CombatSystem.battleInput();
				}
				if ((Game.userHero.getUserClass().equals("Cleric"))) {
					switch (input) {
					case 1:
						input = 1;
						combatSystem.clericChooseSpell();
						break;
					case 2:
						input = 2;
						combatSystem.meleeAttack();
						break;
					case 3:
						input = 3;
						combatSystem.useItem();
						break;
					case 4:
						input = 4;
						combatSystem.escape();
						break;
					}
				} else if ((Game.userHero.getUserClass().equals("Wizard"))) {
					switch (input) {
					case 1:
						input = 1;
						combatSystem.wizardChooseSpell();
						break;
					case 2:
						input = 2;
						combatSystem.meleeAttack();
						break;
					case 3:
						input = 3;
						combatSystem.useItem();
						break;
					case 4:
						input = 4;
						combatSystem.escape();
						break;
					}
				} else {
					switch (input) {
					case 1:
						input = 1;
						combatSystem.meleeAttack();
						break;
					case 2:
						input = 2;
						combatSystem.rangedAttack();
						break;
					case 3:
						input = 3;
						combatSystem.useItem();
						break;
					case 4:
						input = 4;
						combatSystem.escape();
						break;
					}
				}
			}
			if (!fighting) {
				// If the battle ends with the user having 0 HP, print loss...
				// ....if the battle ends with the enemy having 0 HP, print win
				if (Game.userHero.getCharacter().getHitPoints() <= 0) {
					youLost();
				} else if (enemy0.getEnemyHP() <= 0) {
					youWon();
				}
			}
		}
	}

	// Print encounter message
	public static void encounter() {
		System.out.println("You have encountered a " + Tutorial.enemy0.getName() + "!\n");
	}

	// Print win message
	public static void youWon() throws InterruptedException {
		System.out.println("\nYou have slain the enemy " + Tutorial.enemy0.getName() + "!");
		Game.contDialogue();
		Game.userInput.nextLine();
		LevelSystem.main(null);
		Game.contDialogue();
	}

	// Print loss message
	public static void youLost() throws InterruptedException {
		System.out.println("\nYou were slain by the enemy " + Tutorial.enemy0.getName() + "!");
		Game.contDialogue();
	}
}
