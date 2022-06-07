package rpg;

public class MyMonster extends Monster{
  protected int exp;

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
  
  @Override
  public void attack(Monster enemyMonster, Monster myMonster) {
    int enemyHp = enemyMonster.getHp();
    int damage = (myMonster.attack_power / 2) - (enemyMonster.defense_power / 4);
    enemyHp -= damage;
    enemyMonster.setHp(enemyHp);
    if(enemyHp < 0){
      enemyHp = 0;
    }
    System.out.println(enemyMonster.name + "へ" + damage + "のダメージ。残り体力は" + enemyHp);
  }

  public MyMonster(String name, int max_hp, int attack_power, int defense_power, int agility, int level){
    super(name,max_hp,attack_power,defense_power,agility,level);
  }
}
