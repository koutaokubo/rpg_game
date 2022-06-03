package rpg;

public abstract class Monster {
<<<<<<< HEAD
  protected String name;
  protected int hp;
  protected int max_hp;
  protected int attack_power;
  protected int defense_power;
  protected boolean battle = false;

  public Monster(String name, int hp, int max_hp, int attack_power, int defense_power){
    this.name = name;
    this.hp = hp;
    this.max_hp = max_hp;
    this.attack_power = attack_power;
    this.defense_power = defense_power;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void setHp(int hp) {
    this.hp = hp;
  }
  public void setMaxHp(int max_hp) {
    this.max_hp = max_hp;
  }
  public void setAttackPower(int attack_power) {
    this.attack_power = attack_power;
  }
  public void setDefensPower(int defense_power) {
    this.defense_power = defense_power;
  }
  public void setBattle(){
    if (this.hp <= 0){
      battle = false;
    } else {
      battle = true;
    }
  }

  public String getName(){
    return this.name;
  }
  public int getHp(){
    return this.hp;
  }
  public int getMaxHp(){
    return this.max_hp;
  }
  public int getAttackPower(){
    return this.attack_power;
  }
  public int getDefensePower(){
    return this.defense_power;
  }
  public boolean getBattle(){
    return this.battle;
  }

  public abstract void Attack();

  public String toString() {
    return ("名前" + name + "残りHP" + hp);
  }
=======

	protected String name;
	protected int hp;
	protected int maxHp;
	protected int attackPower;
	protected int defencePower;
	protected boolean battle = true;

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
	public int getHp() {
		return this.hp;
	}
	public int getMaxHp() {
		return this.maxHp;
	}
	public int getAttackPower() {
		return this.attackPower;
	}
	public int getDefencePower() {
		return this.defencePower;
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
	public void setDecfencePower(int newDefencePower) {
		this.defencePower = newDefencePower;
	}
	private void setBattle() {
		this.battle = (this.hp > 0);
	}

	public abstract void attack(Monster m);
>>>>>>> origin/working/maeda
}
