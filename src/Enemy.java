
public class Enemy {

	private MyEnemy enemy;

	public MyEnemy getEnemy() {
		return this.enemy;
	}

	public enum MyEnemy {
		RAT("Rat", 2, 14, 1, 50, 10), SKELETON("Skeleton", 6, 15, 12, 100, 15), ZOMBIE("Zombie", 8, 11, 24, 100, 5);

		String name;
		int baseDamage;
		int armorClass;
		int hitPoints;
		int experienceGranted;
		int difficultyClass;

		private MyEnemy(String name, int baseDamage, int armorClass, int hitPoints, int experienceGranted, int difficultyClass) {
			this.baseDamage = baseDamage;
			this.armorClass = armorClass;
			this.hitPoints = hitPoints;
			this.experienceGranted = experienceGranted;
			this.difficultyClass = difficultyClass;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getBaseDamage() {
			return baseDamage;
		}

		public void setBaseDamage(int baseDamage) {
			this.baseDamage = baseDamage;
		}

		public int getArmorClass() {
			return armorClass;
		}

		public void setArmorClass(int armorClass) {
			this.armorClass = armorClass;
		}

		public int getHitPoints() {
			return hitPoints;
		}

		public void setHitPoints(int hitPoints) {
			this.hitPoints = hitPoints;
		}
	}
}