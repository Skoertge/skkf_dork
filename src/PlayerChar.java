
public class PlayerChar extends BareBones {

	// Default constructor with preset values
	public PlayerChar() {
		this.health = 100;
		this.attPower = 10;
		id = 0;
	}

	// Alternative customizable constructor
	PlayerChar(int health, int attPower) {
		this.health = health;
		this.attPower = attPower;
		id = 0;
	}

}
