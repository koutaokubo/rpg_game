package monster;

import java.util.Random;

public abstract class Monster implements Cloneable{
  protected String name;
  protected int hp;
  protected int max_hp;
  protected int attack_power;
  protected int defense_power;
  protected int agility;
//  protected int level;
  protected boolean knockedOut = false;
  protected int level;

  protected int exp;

  // 戦闘中の能力値の変化を保存
  // 戦闘終了時にクリアされる
  protected double attack_rise = 1.0;
  protected double defense_rise = 1.0;
  protected double agility_rise = 1.0;

  protected int asleep = 0;


  protected int pp;
  protected int max_pp;

  public Monster(String name, int max_hp, int attack_power, int defense_power, int agility, int level){
    this.name = name;
    this.hp = max_hp;
    this.max_hp = max_hp;
    this.attack_power = attack_power;
    this.agility = agility;
    this.defense_power = defense_power;
    this.level = level;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void setHp(int hp) {
    this.hp = hp;
    this.setKnockedOut();
  }
  public void setMaxHp(int max_hp) {
    this.max_hp = max_hp;
  }
  public void setAttackPower(int attack_power) {
    this.attack_power = attack_power;
  }
  public void setDefensePower(int defense_power) {
    this.defense_power = defense_power;
  }
  public void setAgility(int agility) {
    this.agility = agility;
  }
  public void setLevel(int level){
    this.level = level;
  }
  public void setKnockedOut(){
    this.knockedOut = this.hp <= 0;
  }
  public void setAttackRise(double attack_rise) {
	  this.attack_rise = attack_rise;
  }
  public void setDefenseRise(double defense_rise) {
	  this.defense_rise = defense_rise;
  }
  public void setAgilityRise(double agility_rise) {
	  this.agility_rise = agility_rise;
  }

  public void setPp(int pp) {
  	this.pp = pp;
  }
  public void setMaxPp(int max_pp) {
  	this.max_pp = max_pp;
  }
  public void setAsleep(int asleep) {
    this.asleep = asleep;
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
  public boolean isKnockedOut(){
    return this.knockedOut;
  }
  public int getLevel(){
    return this.level;
  }
  public double getAttackRise() {
	  return this.attack_rise;
  }
  public double getDefenseRise() {
	  return this.defense_rise;
  }
  public double getAgilityRise() {
	  return this.agility_rise;
  }
  public int getPp() {
  	return this.pp;
  }
  public int getMaxPp() {
  	return this.max_pp;
  }
  public int getAsleep() {
	return asleep;
  }


  // MyMonsterからコピー
  public void setExp(int exp) {
    this.exp = exp;
  }

  public int getExp() {
    return this.exp;
  }

  public void gainExp(int exp){
    System.out.println(getName() + "は" + exp + "の経験値を得た！");

    setExp(getExp()+exp);
    // レベルが上がるごとに次のレベルまでに必要な経験値が増える
    while(getExp() > (getLevel() * getLevel() * 5)){
      levelUp();
    }
  }

  public void levelUp(){
    System.out.println(getName()+"はレベルアップした！ -> " + (getLevel()+1) );
    System.out.println("  最大HP: " + getMaxHp() + " -> " + (getMaxHp()+1));
    System.out.println("  攻撃力: " + getAttackPower() + " -> " + (getAttackPower()+1));
    System.out.println("  防御力: " + getDefensePower() + " -> " + (getDefensePower()+1));
    System.out.println("  素早さ: " + getAgility() + " -> " + (getAgility()+1));

	setLevel(getLevel()+1);
    setHp(getHp()+1);
    setMaxHp(getMaxHp()+1);
    setAttackPower(getAttackPower()+1);
    setDefensePower(getDefensePower()+1);
    setAgility(getAgility()+1);
  }

  public void clearStatusRise() {
	  setAttackRise(1.0);
	  setDefenseRise(1.0);
	  setAgilityRise(1.0);
  }

  public int calcDamage(Monster my, Monster enemy) {
	  int baseDamage = 3;
	  int myAttack = (int)(my.getAttackPower() * my.getAttackRise());
	  int enemyDefense = (int)(enemy.getDefensePower() * enemy.getDefenseRise());

	  double random = new Random().nextDouble();
	  random = 0.3 * random + 0.7; // 0.70～1.00の乱数を生成

	  return (int)(random * baseDamage * myAttack / enemyDefense);
  }

  public void attack(Monster enemyMonster) {
	  if(getAsleep() > 1) {
  		  setAsleep(getAsleep() - 1);
		  System.out.println(getName() + "は眠っている・・・。");
  	  }else{
  		  if(getAsleep() == 1) {
      		  setAsleep(getAsleep() - 1);
      		  System.out.println(getName() + "が眠りから覚めた！");
  		  }
	      int enemyHp = enemyMonster.getHp();
          int damage = calcDamage(this, enemyMonster);
          enemyHp -= damage;
          enemyMonster.setHp(enemyHp);
          if(enemyHp < 0){
              enemyHp = 0;
          }
          System.out.println(enemyMonster.name + "へ" + damage + "のダメージ。残り体力は" + enemyHp);
	  }
  }

  public abstract void specialAttack(Monster enemyMonster);
  public abstract String getSpeciesName();


  public String toString() {
    return ("名前" + name + "残りHP" + hp);
  }

  @Override
  public Monster clone() throws CloneNotSupportedException {
    Monster clone = (Monster) super.clone();
    return clone;
  }




}