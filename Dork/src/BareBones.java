import java.util.HashMap;

public abstract class BareBones {

	protected int level;
	protected int meleeDamage;
	protected int rangedDamage;
	protected int strength;
	protected int armorClass;
	protected int experience;
	protected int proficiencyPoints;
	protected int xpMod;
	protected int difficultyClass;
	protected int enemyHP;
	protected int id;
	protected String name;
	protected String userClass;
	protected Object meleeWeapon;
	protected Object rangedWeapon;
	protected HashMap<String, Integer> userArmor;
	protected HashMap<String, Integer> userWeapons;
	protected HashMap<String, Integer> userMisc;
	protected HashMap<String, Integer> userSpells;

	public int getId() {
		return id;
	}

	public int getMeleeDamage() {
		return meleeDamage;
	}

	public void setMeleeDamage(int meleeDamage) {
		this.meleeDamage = meleeDamage;
	}

	protected int getRangedDamage() {
		return rangedDamage;
	}

	protected void setRangedDamage(int rangedDamage) {
		this.rangedDamage = rangedDamage;
	}

	protected int getArmorClass() {
		return armorClass;
	}

	protected void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	void adjustHitPointsBy(int amount) {
		Game.userHero.getCharacter().hitPoints += amount;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getUserClass() {
		return userClass;
	}

	protected void setUserClass(String userClass) {
		this.userClass = userClass;
	}

	protected Object getMeleeWeapon() {
		return meleeWeapon;
	}

	protected void setMeleeWeapon(Object meleeWeapon) {
		this.meleeWeapon = meleeWeapon;
	}

	protected Object getRangedWeapon() {
		return rangedWeapon;
	}

	protected void setRangedWeapon(Object rangedWeapon) {
		this.rangedWeapon = rangedWeapon;
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
	
	protected HashMap<String, Integer> getUserMisc() {
		return userMisc;
	}

	protected void setUserMisc (HashMap<String, Integer> userMisc) {
		this.userMisc= userMisc;
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
		return experience;
	}

	protected void setExp(int exp) {
		this.experience = exp;
	}

	protected int getEscapeDC() {
		return difficultyClass;
	}

	protected void setEscapeDC(int difficultyClass) {
		this.difficultyClass = difficultyClass;
	}

	protected int getProficiencyPoints() {
		return proficiencyPoints;
	}

	protected void setProficiencyPoints(int proficiencyPoints) {
		this.proficiencyPoints = proficiencyPoints;
	}

	protected int getEnemyHP() {
		return enemyHP;
	}

	protected void setEnemyHP(int enemyHP) {
		this.enemyHP = enemyHP;
	}

	protected int getStrength() {
		return strength;
	}

	protected void setStrength(int strength) {
		this.strength = strength;
	}
}
