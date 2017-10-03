import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("serial")
public class LootDrops {
	static Random r = new Random();
	public static String[] loot = new String[12];
	public static HashMap<String, Integer> lootMap = new HashMap<String, Integer>();

	public static void main(String[] args) {
		arena();
		lootPickup();
	}

	public static String[] arena() {
		ArrayList<String> monster = new ArrayList<String>();
		monster.add("rat");
		monster.add("skeleton");
		monster.add("zombie");
		String monstertype = "skeleton";
		int numdrop = monster.indexOf(monstertype) + 1;
		String[] drop = new String[] { "Metal Scraps", "Short Sword", "Broken Sword", "Cloth Helm", "Broken Bow",
				"Rubbish" };

		String[] uncommondrop = new String[] { "Steel Short Sword", "Leather Vest", "Steel Helm", "Iron Warhammer" };
		String[] raredrop = new String[] { "Diamond", "Ruby", "Large CoinPurse", "Bahamut's Sword of Slaying",
				"The Pick of Destiny" };
		String[] legdrop = new String[] { "John Cena", "Macho Man Randy Savage", "Captain Insano" };

		System.out.println("You recieve the following loot: ");
		int y = 0;
		int z = 0;
		for (int x = 0; x < numdrop; x++) {
			int itemroll = r.nextInt(101) - 1;
			if (itemroll >= 15) {
				int d = ThreadLocalRandom.current().nextInt(1, drop.length - 1);
				loot[y] = drop[d];
				lootMap.put(drop[d], (ThreadLocalRandom.current().nextInt(10)));
				y++;
				if (itemroll >= 45) {
					int e = ThreadLocalRandom.current().nextInt(1, uncommondrop.length - 1);
					loot[y] = uncommondrop[e] + "(UNCOMMON)";
					lootMap.put(uncommondrop[e], (ThreadLocalRandom.current().nextInt(40)));
					y++;
					if (itemroll >= 65) {
						int f = ThreadLocalRandom.current().nextInt(1, raredrop.length - 1);
						loot[y] = raredrop[f] + "(RARE)";
						lootMap.put(raredrop[f], (ThreadLocalRandom.current().nextInt(70)));
						y++;
					}
					if (itemroll >= 99) {
						int g = ThreadLocalRandom.current().nextInt(1, legdrop.length - 1);
						loot[y] = legdrop[g] + "(LEGENDARY)";
						lootMap.put(legdrop[g], (ThreadLocalRandom.current().nextInt(100)));
						y++;
					}
				}
			}
			for (int i = 0; i < loot.length; i++) {
				if (loot[i] != null) {
					System.out.print("+" + loot[i] + "+    ");
					z++;
					if (z % 3 == 0) {
						System.out.println("\n");
					}
				}
			}
		}
		return loot;
	}

	@SuppressWarnings("rawtypes")
	public static void lootPickup() {
		Set mapSet = (Set) lootMap.entrySet();
		Iterator mapIterator = mapSet.iterator();
		while (mapIterator.hasNext()) {
			Map.Entry mapEntry = (Map.Entry) mapIterator.next(); 
			String key = (String) mapEntry.getKey();
			Integer value = (Integer) mapEntry.getValue();
			Game.userHero.userBackpack.put(key, value);
		}
	}

	public static void equipItem() {

	}

}