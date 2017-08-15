import java.util.Scanner;

public class Game {

	public static Scanner userInput = new Scanner(System.in);
	public static PlayerChar userHero = new PlayerChar();
	public static String location = "";

	void run() throws InterruptedException {

		// Begin instruction
		System.out.println("Welcome to Dork, a text-based adventure game.");
		contDialogue();
		System.out.print("\"Greetings, adventurer. What is your name?\"\n>> ");
		userHero.setName(userInput.nextLine());
		System.out.println(
				"\n\n\"Pleasure to make your acquaintance, " + userHero.getName() + ". What is your calling?\"");
		userHero.chooseClass();
		showInventory();
		userHero.showCharacter();
		contDialogue();
		userInput.nextLine();
		System.out.println(
				"\n\n\"Okay, " + userHero.getName() + ". Let's get through the basics, with your first battle!\"");
		contDialogue();
		Tutorial.tutorial();
	}

	public static void contDialogue() throws InterruptedException {
		System.out.println("\nPress [ENTER] to continue...");
		userInput.nextLine();
	}

	public static void showInventory() {
		System.out.println("\nArmor: " + userHero.getUserArmor() + "\nWeapons: " + userHero.getUserWeapons());
	}

}
