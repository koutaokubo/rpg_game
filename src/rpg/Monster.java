package rpg;

public abstract class Monster {

	protected String name;
	protected int hp;
	protected int maxHp;
	protected int attackPower;
	protected int defensePower;
	protected boolean battle = true;

	public Monster(String name, int hp, int maxHp, int attackPower, int defensePower) {
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.attackPower = attackPower;
		this.defensePower = defensePower;
	}

	public String toString() {
		return ("名前： " + name + ", 残りHP： " + hp);
	}

	public String getName () {
		return this.name;
	}
	public int getHp() {
		return this.hp;
	}
	public int getMaxHp() {
		return this.maxHp;
	}
	public int getAttackPower() {
		return this.attackPower;
	}
	public int getDefensePower() {
		return this.defensePower;
	}
	public boolean getBattle() {
		return this.battle;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	public void setHp(int newHp) {
		if(newHp > 0) {
			this.hp = newHp;
		}else {
			this.hp = 0;
		}
		this.setBattle();
	}
	public void setMaxHp(int newMaxHp) {
		this.maxHp = newMaxHp;
	}
	public void setAttackPower(int newAttackPower) {
		this.attackPower = newAttackPower;
	}
	public void setDefensePower(int newDefensePower) {
		this.defensePower = newDefensePower;
	}
	private void setBattle() {
		this.battle = (this.hp > 0);
	}

	public abstract void attack(Monster m);
}
