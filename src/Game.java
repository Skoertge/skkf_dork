
import java.util.Scanner;

public class Game {

	public static Scanner userInput = new Scanner(System.in);
	public static PlayerChar userHero = new PlayerChar();

	void run() throws InterruptedException {

		// Begin instruction
		System.out.println("Welcome to Dork, a text-based adventure game.");
		contDialogue();
		System.out.print("\"What is your name, warrior?\"\n>> ");
		userHero.setName(userInput.next());
		System.out.println("\n\"Greetings, " + userHero.getName() + ". Let's take a look at your inventory.\"");
		System.out.println("\nArmor: " + userHero.getUserArmor() + "\nWeapons: " + userHero.getUserWeapons());
		userHero.updateInv();
		System.out.println("\n\"Your armor rating is " + userHero.getDefense() + "...but your base damage is "
				+ userHero.getAttPower() + "!\"");
		contDialogue();
		System.out.println("\n\n\"It's dangerous to go alone! Here, take this Short Sword.\"");
		userHero.userWeapons.put("Short Sword", 3);
		userHero.updateInv();
		System.out.println("<<Short Sword was added to your inventory.>>");
		contDialogue();
		userHero.getAttPower();
		System.out.println("\n\n\"Now let's take a look... Aha! Now your base damage is " + userHero.getAttPower()
				+ ". \nNow you have enough here to take care of yourself!\"");
		contDialogue();
		System.out.println("\n\n\"You're going to start off at level " + userHero.getLevel()
				+ ", of course. Your total HP is " + userHero.getHealth() + ". Here are your stats...\"");
		System.out.println("Strength: " + userHero.getStr() + "\nDexterity: " + userHero.getDex());
		contDialogue();
		System.out.println(
				"\n\n\"Okay, " + userHero.getName() + ". Let's get through the basics, with your first battle!\"");
		contDialogue();
		Tutorial.tutorial();
	}

	public static void contDialogue() throws InterruptedException {
		System.out.println("\nPress [ENTER] to continue...");
		userInput.nextLine();
	}

}
