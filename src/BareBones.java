import java.util.HashMap;

public abstract class BareBones {

	protected int level;
	protected int health;
	protected int attPower;
	protected int defense;
	protected int exp;
	protected int xpMod;
	protected int id;
	protected String name;
	protected HashMap<String, Integer> userArmor;
	protected HashMap<String, Integer> userWeapons;
	protected HashMap<String, Integer> userBackpack;

	public int getId() {
		return id;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (health < 0) {
			this.health = 0;
		} else {
			this.health = health;
		}
	}

	public int getAttPower() {
		return attPower;
	}

	public void setAttPower(int attPower) {
		this.attPower = attPower;
	}

	protected int getDefense() {
		return defense;
	}

	protected void setDefense(int defense) {
		this.defense = defense;
	}

	void adjustHealthBy(int amount) {
		health += amount;
	}

	@Override
	public String toString() {
		return getId() + "[hp: " + getHealth() + ", attack: " + getAttPower() + "]";
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected HashMap<String, Integer> getUserArmor() {
		return userArmor;
	}

	protected void setUserArmor(HashMap<String, Integer> userArmor) {
		this.userArmor = userArmor;
	}

	protected HashMap<String, Integer> getUserWeapons() {
		return userWeapons;
	}

	protected void setUserWeapons(HashMap<String, Integer> userWeapons) {
		this.userWeapons = userWeapons;
	}

	protected int getLevel() {
		return level;
	}

	protected void setLevel(int level) {
		this.level = level;
	}

	protected int getXpMod() {
		return xpMod;
	}

	protected void setXpGain(int xpMod) {
		this.xpMod = xpMod;
	}

	protected int getExp() {
		return exp;
	}

	protected void setExp(int exp) {
		this.exp = exp;
	}
}
