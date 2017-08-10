
import java.util.Scanner;

public class Game {

	public static Scanner userInput = new Scanner(System.in);
	public static PlayerChar userHero = new PlayerChar();

	void run() throws InterruptedException {

		// Begin instruction
		System.out.println("Welcome to Dork, a text-based adventure game.");
		contDialogue();
		System.out.println("\"What is your name, warrior?\"");
		userHero.setName(userInput.nextLine());
		System.out.println("\"Greetings, " + userHero.getName() + ". Let's take a look at your inventory.\"");
		System.out.println("Armor: " + userHero.getUserArmor() + " || Weapons: " + userHero.getUserWeapons());
		userHero.updateInv();
		System.out.println(
				"Your attack is " + userHero.getAttPower() + " and your defense is " + userHero.getDefense() + ".");
		contDialogue();
		System.out.println("It's dangerous to go alone! Here, take this Short Sword.");
		userHero.userWeapons.put("Short Sword", 3);
		userHero.updateInv();
		System.out.println("<<Short Sword was added to your inventory.>>");
		contDialogue();
		System.out.println(
				"Now you have enough here to take care of yourself! What are your attack and defense ratings?");
		userHero.getAttPower();
		System.out.println("Looks like your attack is " + userHero.getAttPower() + " and your defense is "
				+ userHero.getDefense() + ".");
		contDialogue();
		System.out.println("You're going to start off at level " + userHero.getLevel()
				+ ", of course. Your total HP is " + userHero.getHealth() + ".");
		contDialogue();
		System.out.println("Okay, " + userHero.getName() + ". Let's get through the basics, with your first battle!");
		contDialogue();
		Tutorial.tutorial();
	}

	public static void contDialogue() {
		System.out.println("\nPress [ENTER] to continue...");
		userInput.nextLine();
	}

}
