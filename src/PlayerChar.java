import java.util.*;

public class PlayerChar extends BareBones {

	// Default constructor with preset values
	@SuppressWarnings("serial")
	public PlayerChar() {
		this.level = 1;
		this.str = 3;
		this.dex = 3;
		this.health = 100;
		this.exp = 0;
		id = 0;

		this.userArmor = new LinkedHashMap<String, Integer>() {
			{
				put("Cloth Hat", 1);
				put("Cloth Shirt", 1);
				put("Cloth Pants", 1);
				put("Cloth Shoes", 1);
				put("Wooden Shield", 1);
			}
		};

		this.userWeapons = new LinkedHashMap<String, Integer>();
		this.userBackpack = new LinkedHashMap<String, Integer>();

	}

	// Alternative customizable constructor
	public void updateInv() {
		int calcDefense = 0;
		List<String> keysList = new ArrayList<String>(userArmor.keySet());
		for (int r = 0; r < (keysList.size()); r++) {
			String armorItem = keysList.get(r);
			Integer armor = userArmor.get(armorItem);
			calcDefense += armor;
		}
		this.defense = calcDefense;

		int calcAttack = 0;
		List<String> keysList1 = new ArrayList<String>(userWeapons.keySet());
		for (int r = 0; r < (keysList1.size()); r++) {
			String weaponItem = keysList1.get(r);
			Integer damage = userWeapons.get(weaponItem);
			calcAttack += damage;
		}
		this.attPower = calcAttack;
	}

}
