
public abstract class BareBones {

	private static int idCounter = 1;

	protected int health;
	protected int attPower;
	protected int id;
	private String name;

	public int getId() {
		return id;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttPower() {
		return attPower;
	}

	public void setAttPower(int attPower) {
		this.attPower = attPower;
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

}
