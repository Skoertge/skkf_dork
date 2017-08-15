import java.util.ArrayList;
import java.util.Random;

public class Enemy0 extends BareBones {

	// Default constructor with preset values
	@SuppressWarnings("serial")
	public Enemy0() {
		ArrayList<String> enemies = new ArrayList<String>() {
			{
				//add("Rat");
				add("Skeleton");
				add("Zombie");
			}
		};

		Random r = new Random();
		int i = r.nextInt(enemies.size());

		this.name = enemies.get(i);

		if (name.equals("Rat")) {
			this.enemyHP = (r.nextInt(8) + 1) % 4;
			this.meleeDamage = 3;
			this.armorClass = 14;
			this.xpMod = 50;
			this.setEscapeDC(10);
		} else if (name.equals("Skeleton")) {
			this.enemyHP = r.nextInt(12) + 1;
			this.meleeDamage = 6;
			this.armorClass = 15;
			this.xpMod = 100;
			this.setEscapeDC(15);
		} else if (name.equals("Zombie")) {
			this.enemyHP = ((r.nextInt(12) + 1) + (r.nextInt(12) + 1));
			this.meleeDamage = 8;
			this.armorClass = 11;
			this.xpMod = 100;
			this.setEscapeDC(5);
		}

		this.id = id++;
	}
}
