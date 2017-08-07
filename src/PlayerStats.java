import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PlayerStats {

	@SuppressWarnings("serial")
	public static float pArmor() {
		HashMap<String, Integer> pWear = new HashMap<String, Integer>() {
			{
				put("Iron-Studded Buttplug", 1);
				put("Loafers", 1);
			}
		};
		
		List<String> keysList = new ArrayList<String>(pWear.keySet());
		int r = new Random().nextInt(keysList.size());
		String pItem = keysList.get(r);
		float pArmor = 0;
		pArmor += pWear.get(pItem);
		System.out.println("Armor is " + pArmor);
		
		return pArmor;
	}

	@SuppressWarnings("serial")
	public static float pDamage() {
		HashMap<String, Integer> pWeapon = new HashMap<String, Integer>() {
			{
				put("Bronze Dildo", 1);
				put("Bronze Dildo", 1);
			}
		};
		
		List<String> keysList1 = new ArrayList<String>(pWeapon.keySet());
		int x = new Random().nextInt(keysList1.size());
		String pItem1 = keysList1.get(x);
		float pDamage = 0;
		pDamage += pWeapon.get(pItem1);
		
		return pDamage;
	}
}
