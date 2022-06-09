package rpg;

public abstract class Monster2 {
  protected String name;
  protected int hp;
  protected int max_hp;
  protected int attack_power;
  protected int defense_power;
  protected int agility;
//  protected int level;
  protected boolean battle = true;
  protected int level;

  protected int exp;

  // 戦闘中の能力値の変化を保存
  // 戦闘終了時にクリアされる
  protected int attack_rise;
  protected int defense_rise;
  protected int agility_rise;

  protected int pp;
  protected int max_pp;

  public Monster2(String name, int max_hp, int attack_power, int defense_power, int agility, int level){
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
    this.setBattle();
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
  public void setBattle(){
    this.battle = this.hp > 0;
  }
  public void setAttackRise(int attack_rise) {
	  this.attack_rise = attack_rise;
  }
  public void setDefenseRise(int defense_rise) {
	  this.defense_rise = defense_rise;
  }
  public void setAgilityRise(int agility_rise) {
	  this.agility_rise = agility_rise;
  }

  public void setPP(int pp) {
  	this.pp = pp;
  }
  public void setMaxPP(int max_pp) {
  	this.max_pp = max_pp;
  }
//  public void setLevel(int level){
//    this.level = level;
//  }

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
  public int getLevel(){
    return this.level;
  }
  public int getAttackRise() {
	  return this.attack_rise;
  }
  public int getDefenseRise() {
	  return this.defense_rise;
  }
  public int getAgilityRise() {
	  return this.agility_rise;
  }
  public int getPP() {
  	return this.pp;
  }
  public int getMaxPP() {
  	return this.max_pp;
  }


  // MyMonsterからコピー
  public void setExp(int exp) {
    this.exp = exp;
  }

  public int getExp() {
    return this.exp;
  }

  public void gainExp(int exp){
    setExp(getExp()+exp);
    if(getExp() > (getLevel() * 100)){
      levelUp();
    }
  }

  public void levelUp(){
	setLevel(getLevel()+1);
    setHp(getHp()+1);
    setMaxHp(getMaxHp()+1);
    setAttackPower(getAttackPower()+1);
    setDefensePower(getDefensePower()+1);
    setAgility(getAgility()+1);
  }

  public void clearStatusRise() {
	  setAttackRise(0);
	  setDefenseRise(0);
	  setAgilityRise(0);
  }

  public abstract void attack(Monster2 myMonster, Monster2 enemyMonster);

  public abstract String getSpeciesName();

  public String toString() {
    return ("名前" + name + "残りHP" + hp);
  }


  // TeamMemberに書く
//  public void clearChangesInBattle() {
//  	for(int i = 0; i < myMonsters.size(); i++) {
//  		myMonsters.get(i).clearStatusRise();
//  		myMonsters.get(i)setPP(myMonster.getMaxPP());
//  	}
//  }

}