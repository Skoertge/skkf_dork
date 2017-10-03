import java.util.Random;

public class CombatSystem {
	public static void battleInput() {
		System.out.println("\nWhat would you like to do? \n1: Melee Attack \n2. Use Item \n4: Escape \n>> ");
	}

	public void attackRoll() {
		System.out.println("\nYou attack the enemy " + TestBattle.enemy.getEnemy().getName() + ".");

		Random r = new Random();
		int d20 = (r.nextInt(20) + 1);

		if (d20 == 1) {
			System.out.println("\nYour attack missed!");
		} else if ((d20 > 1) && (d20 < 20)) {
			attackHit();
		} else if (d20 == 20) {
			criticalHit();
		}
	}

	public int damage() {
		Random r = new Random();
		int damageRoll = (r.nextInt(Game.hero.getBaseDamage()));
		int damage = (damageRoll + Game.hero.getHero().getStrength());
		return damage;
	}
	
	public int criticalDamage() {
		Random r = new Random();
		int criticalRoll = (r.nextInt(Game.hero.getBaseDamage()));
		int criticalDamage = (damage() + criticalRoll);
		return criticalDamage;
	}

	public void attackHit() {
		if (damage() <= TestBattle.enemy.getEnemy().getArmorClass()) {
			System.out.println("\nThe enemy " + TestBattle.enemy.getEnemy().getName() + " blocked the attack!");
		} else {
			System.out
					.println("\nYou have dealt " + damage() + " damage to the enemy " + TestBattle.enemy.getEnemy().getName() + "!");
			TestBattle.enemy.getEnemy().setHitPoints(TestBattle.enemy.getEnemy().getHitPoints() - damage());
		}
	}
	
	public void criticalHit() {
		System.out.println("\n>>CRITICAL HIT!<< \nYou have dealt " + criticalDamage() + " damage to the enemy "
					+ TestBattle.enemy.getEnemy().getName() + "!");
		TestBattle.enemy.getEnemy().setHitPoints(TestBattle.enemy.getEnemy().getHitPoints() - criticalDamage());
	}
	
}
