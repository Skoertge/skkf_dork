import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TownsfolkItems {
	static Random r = new Random();

	public static void main(String[] args) {

	}

	public static HashMap bsinventory() {
		HashMap<String, Integer> bsinventory = new HashMap<String, Integer>() {
			{
				put("Short Sword", 2);
				put("Long Sword", 3);
				put("Mace", 3);
				put("Club", 3);
				put("Heml", 1);
				put("Breastplate", 3);
				put("Gold Ring", 0);
				put("Silver Ring", 0);
				put("Iron shoes", -3);
				put("Metal Collar", 6);
			}
		};
		ArrayList<String> bskeys = new ArrayList<String>(bsinventory.keySet());

		HashMap<String, Integer> bsinv1 = new HashMap<String, Integer>();

		for (int x = 0; x <= 4; x++) {
			String item = bskeys.get(r.nextInt(bskeys.size()));
			int val = bsinventory.get(item);
			bsinv1.put(item, val);

		}
		return bsinv1;

	}
}