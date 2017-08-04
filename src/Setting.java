import java.util.Scanner;

public class Setting {

	public static void town(String location) {
		location = "town";
		Scanner s = new Scanner(System.in);

		System.out.println("You have arrived at town.\n\n");
		System.out.println("Where would you like to go?\n 1. Blacksmith\n 2. Inn\n 3. Leave town");
		String townChoice = s.next();

		if (townChoice.equalsIgnoreCase("Blacksmith")) {

		} else if (townChoice.equalsIgnoreCase("Inn")) {
			System.out.println("You push open the door to the inn. The bards are singing and the ale is flowing.");
			System.out.println("What would you like to do?\n 1. Drink ale\n 2. Buy a whore\n 3. Rest");
			String innChoice = s.next();
			if (innChoice.equalsIgnoreCase("Drink ale") || (innChoice == "1")) {
				System.out.println("You approach the bartender and request his finest ale.");
			} else if (innChoice.equalsIgnoreCase("Buy a whore") || (innChoice == "2")) {
				System.out.println("You find the most attractive whore who was not already spoken for.");
			} else if (innChoice.equalsIgnoreCase("Rest") || (innChoice == "3")) {
				System.out.println("You take a seat by the comforting warmth of the fire.");
			}
		} else if (townChoice.equalsIgnoreCase("Leave town")) {
			System.out
					.println("In which direction would you like to travel?\n 1. North\n 2. South\n 3. East\n 4. West");
		}

	}

	public static void cave(String location) {
		location = "cave";
	}

	public static void cemetery(String location) {
		location = "cemetery";
	}

}
