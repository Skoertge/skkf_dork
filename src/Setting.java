import java.util.Scanner;

public class Setting {

	public static void town(String location) {
		System.out.println("You have arrived at town.\n\n");
		System.out.println("Where would you like to go?\n 1. Blacksmith\n 2. Inn\n 3. Arena\n 4. Leave town");
		Scanner s = new Scanner(System.in);
		String townChoice = s.nextLine();
		if (townChoice.equalsIgnoreCase("Blacksmith") || (townChoice.equals("1"))) {
			Blacksmith.main(null);
		} else if (townChoice.equalsIgnoreCase("Inn") || (townChoice.equals("2"))) {
			inn(s, location);
		} else if (townChoice.equalsIgnoreCase("Arena") || (townChoice.equals("3"))) {
			arena(s, location);
		} else if (townChoice.equalsIgnoreCase("Leave town") || (townChoice.equals("4"))) {
			leaveTown(s, location);
		}
	}

	public static void inn(Scanner s, String location) {
		System.out.println("You push open the door to the inn. The bards are singing and the ale is flowing.");
		System.out.println("What would you like to do?\n 1. Drink ale\n 2. Buy a whore\n 3. Rest\n 4. Leave");
		String innChoice = s.next();
		if (innChoice.equalsIgnoreCase("Drink ale") || (innChoice.equals("1"))) {
			System.out.println("You approach the bartender and request his finest ale.");
		} else if (innChoice.equalsIgnoreCase("Buy a whore") || (innChoice.equals("2"))) {
			System.out.println("You find the most attractive whore who was not already spoken for.");
		} else if (innChoice.equalsIgnoreCase("Rest") || (innChoice.equals("3"))) {
			System.out.println("You take a seat by the comforting warmth of the fire.\n You have regained your HP.");
		} else if (innChoice.equalsIgnoreCase("Leave") || (innChoice.equals("4"))) {
			System.out.println("You leave the inn. Where would you like to go?\n");
		}
	}

	public static void arena(Scanner s, String location) {
		System.out.println("You push open the door to the inn. The bards are singing and the ale is flowing.");
		System.out.println("What would you like to do?\n 1. Fight\n 2. Leave");
		String innChoice = s.next();
		if (innChoice.equalsIgnoreCase("Fight") || (innChoice.equals("1"))) {
			Battle.encounter(randomEnemy, enemyHP);
		} else if (innChoice.equalsIgnoreCase("Leave") || (innChoice.equals("2"))) {
			Setting.main(null, location);
		}
	}

	public static void leaveTown(Scanner s, String location) {
		System.out.println("In which direction would you like to travel?\n 1. North\n 2. East\n 3. West\n 4. South\n");
		String leaveChoice = s.next();
		if (leaveChoice.equalsIgnoreCase("North") || (leaveChoice.equals("1"))) {
			location = "cemetery";
		} else if (leaveChoice.equalsIgnoreCase("East") || (leaveChoice.equals("2"))) {
			location = "cave";
		} else if (leaveChoice.equalsIgnoreCase("West") || (leaveChoice.equals("3"))) {
			location = "cave";
		} else if (leaveChoice.equalsIgnoreCase("South") || (leaveChoice.equals("4"))) {
			location = "cave";
		}
	}

	public static void cave(String location) {
		location = "cave";
	}

	public static void cemetery(String location) {
		location = "cemetery";
	}

}
