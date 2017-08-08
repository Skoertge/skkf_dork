
import java.util.Scanner;

public class Game {

	public static Scanner userInput = new Scanner(System.in);
	public static PlayerChar userHero = new PlayerChar();

	void run() throws InterruptedException {
		// Set player stats
		userHero.setHealth(100);
		userHero.setAttPower(10);

		// Begin instruction
		System.out.println("Welcome to Dork, a text-based adventure game.");
		contDialogue();
		System.out.println("What is your name, warrior?");
		userHero.setName(userInput.nextLine());
		System.out.println("Okay, " + userHero.getName() + ". Let's get through the basics, with your first battle!");
		contDialogue();
		Tutorial.tutorial();
	}

	public static void contDialogue() {
		System.out.println("\nPress [ENTER] to continue...");
		userInput.nextLine();
	}

}
