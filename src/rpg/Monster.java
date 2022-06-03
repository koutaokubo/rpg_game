package rpg;

public abstract class Monster {
  protected String name;
  protected int hp;
  protected int max_hp;
  protected int attack_power;
  protected int defense_power;
  protected int agility;
  protected boolean battle = false;

  public Monster(String name, int hp, int max_hp, int attack_power, int defense_power, int agility){
    this.name = name;
    this.hp = hp;
    this.max_hp = max_hp;
    this.attack_power = attack_power;
    this.agility = agility;
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
  public void setAgility(int agility) {
    this.agility = agility;
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
  public int getAgility() {
    return this.agility;
  }
  public boolean getBattle(){
    return this.battle;
  }

  public abstract void attack(Monster myMonster, Monster enemyMonster);

  public String toString() {
    return ("名前" + name + "残りHP" + hp);
  }
}
