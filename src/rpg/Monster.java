package rpg;

public abstract class Monster {

	protected String name;
	protected int hp;
	protected int maxHp;
	protected int attackPower;
	protected int defencePower;
	protected boolean knockedOut;

	public Monster(String name, int hp, int maxHp, int attackPower, int defencePower) {
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.attackPower = attackPower;
		this.defencePower = defencePower;
	}

	public String toString() {
		return ("名前： " + name + ", 残りHP： " + hp);
	}

	public String getName () {
		return this.name;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int newHp) {
		this.hp = newHp;
	}
	public int getMaxHp() {
		return this.maxHp;
	}
	public void setMaxHp(int newMaxHp) {
		this.maxHp = newMaxHp;
	}
	public int getAttackPower() {
		return this.attackPower;
	}
	public void setAttackPower(int newAttackPower) {
		this.attackPower = newAttackPower;
	}
	public int getDefencePower() {
		return this.defencePower;
	}
	public void setDecfencePower(int newDefencePower) {
		this.defencePower = newDefencePower;
	}

	public abstract void attack(Monster m);
}
