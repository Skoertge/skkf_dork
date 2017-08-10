import java.util.ArrayList;
import java.util.Random;

public class Enemy0 extends BareBones {

	// Default constructor with preset values
	@SuppressWarnings("serial")
	public Enemy0() {
		ArrayList<String> enemies = new ArrayList<String>() {
			{
				add("Rat");
				// add("Skeleton");
				// add("Zombie");
			}
		};

		Random r = new Random();
		int i = r.nextInt(enemies.size());

		this.name = enemies.get(i);

		if (name.equals("Rat")) {
			this.health = 20;
			this.attPower = 3;
			this.xpMod = 10;
		} else if (name.equals("Skeleton")) {
			this.health = 50;
			this.attPower = 15;
			this.xpMod = 50;
		} else if (name.equals("Zombie")) {
			this.health = 80;
			this.attPower = 7;
			this.xpMod = 30;
		}

		this.id = id++;
	}
}
