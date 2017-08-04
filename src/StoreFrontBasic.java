import java.util.Random;
import java.util.Scanner;

public class StoreFrontBasic {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] items = { 0, 0, 0 };
		String choice = "";
		while (choice != "6") {
			System.out.println("Hello!  Welcome to my shop!\nWhat can I do for you?");
			System.out.println(
					"1. Purchase items\n2. Remove items\n3. View current order\n4. Complete purchase\n5. Make conversation\n6. Exit\n\n");
			System.out.print("So, what will it be:  ");
			choice = s.next();
			if (choice.equals("1")) {
				purchase(items);
			} else if (choice.equals("2")) {	//Trying to go back to the main screen from any of these fucks it up too.
				remove(items);
			} else if (choice.equals("3")) {
				order(items);
			} else if (choice.equals("4")) {
				view(items);
			} else if (choice.equals("5")) {
				conversation();
			} else if (choice.equals("6")) {
				break;
			}
		}
		s.close();
	}

	public static int[] purchase(int items[]) {
		Scanner s = new Scanner(System.in);
		int amount = 0;
		String choice1 = "";
		while (choice1 != "4") {
			System.out.println("What would you like to purchase?\n1. Armor\n2. Weapons\n3. Potions\n4. Exit\n\n");
			choice1 = s.next();
			if (choice1.equals("1")) {
				System.out.println("How many:  ");
				amount = s.nextInt();
				items[0] = amount;
				System.out.println("You have purchased " + items[0] + " pieces of armor.");
			} else if (choice1.equals("2")) {
				System.out.println("How many:  ");
				amount = s.nextInt();
				items[1] = amount;
				System.out.println("You have purchased " + items[1] + " Weapons.");
			} else if (choice1.equals("3")) {
				System.out.println("How many:  ");
				amount = s.nextInt();
				items[2] = amount;
				System.out.println("You have purchased " + items[2] + " potions.");
			} else if (choice1.equals("4")) {
				break;
			}
		}
		s.close();
		return items;
	}

	public static int[] remove(int items[]) {
		Scanner s = new Scanner(System.in);
		int amount = 0;
		String chc = "";
		while (chc != "4") {
			System.out.println("What would you like to remove?\n1. Armor\n2. Weapons\n3. Potions\n4. Exit\n\n");
			chc = s.next();
			if (chc.equals("1")) {
				System.out.println("How many:");
				amount = s.nextInt();
				items[0] = items[0] - amount;
			} else if (chc.equals("2")) {
				System.out.println("How many:");
				amount = s.nextInt();
				items[1] = items[1] - amount;
			} else if (chc.equals("3")) {
				System.out.println("How many:");
				amount = s.nextInt();
				items[2] = items[2] - amount;
			} else if (chc.equals("4")) {
				break;
			}
		}
		s.close();
		return items;
	}

	public static String order(int items[]) {
		String order = "";
		order = "your order consists of the following:\n" + items[0] + " pieces of armor\n" + items[1] + " weapons\n"
				+ items[2] + " potions";
		return order;
	}

	public static String view(int items[]) {
		String order = "";
		int total, tax = 5, a = 15, b = 50, c = 15;
		total = (items[0] * a) + (items[1] * b) + (items[2] * c) + tax;
		order = "Your total after tax to the King comes to " + total + "gp.";
		return order;
	}

	public static String conversation() {
		Scanner s = new Scanner(System.in);
		int i = 0, x = 0;
		String answer = "I have nothing left to tell you.";
		String chc = "";
		Random r = new Random();
		int[] said = new int[5];
		String[] responses = { "I hear tell of some dangerous creatures attacking villages to the East",
				"Have you heard of the old Priests of Skarnn?  Rumor has it They founded this township.",
				"I once had in my possession an artifact of great power. Now if only I knew where it was collecting dust...",
				"Nice weather these days isn't it?",
				"Have you ever had the brews at the local tavern?  They are to die for!" };

		System.out.println("Will you ask the shopkeep a question?\n1. Yes\n2. No");
		chc = s.next();

		
		//Somthing is totally broke in here and I cant find it.
		while (chc != "2") {
			System.out.println("You ask the shopkeep if he has heard anything interesting.");
			i = r.nextInt(responses.length - 1);
			for (int p = 0; p <= said.length; p++) {
				if (said[p] == i) {
					i = r.nextInt(responses.length - 1);
				} else {
					said[x] = i;
					x++;
					if (x == said.length - 1) {
						break;
					}
					System.out.println(
							responses[i] + "The shopkeep says\n\n\nWill you ask another question?\n1. Yes\n2. No");
					chc = s.next();
				}
			}
		}

		s.close();

		return answer;
	}
}