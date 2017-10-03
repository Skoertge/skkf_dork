import java.util.Scanner;

public class Game {

	public static Scanner userInput = new Scanner(System.in);
	public static Character hero = new Character();

	void run() throws InterruptedException {
		// Begin instruction
		System.out.println("Welcome to Dork, a text-based adventure game.");
		contDialogue();
		System.out.print("\"Greetings, adventurer. What is your name?\"\n>> ");
		hero.setName(userInput.nextLine());
		System.out.println("\n\n\"Pleasure to make your acquaintance, " + hero.getName() + ".\"");
		hero.chooseClass();
		System.out.println("\n\n\"Let's start off with a quick battle!\"");
		TestBattle.testBattle();
	}

	public static void contDialogue() {
		System.out.println("\nPress [ENTER] to continue...");
		userInput.nextLine();
	}
}