package rpg;

public class EnemyMonster extends Monster{
  public void attack(Monster myMonster, Monster enemyMonster){
    int myHp = myMonster.getHp();
    // myHp -= this.attack_power;
    int damage = (enemyMonster.attack_power / 2) - (myMonster.defense_power / 4);
    myHp -= damage;
    myMonster.setHp(myHp);
    if (myHp < 0 ){
      myHp = 0;
    }
    System.out.println(myMonster.name + "へ" + damage + "のダメージ。残り体力は" + myHp);
  }

  public EnemyMonster(String name, int hp, int max_hp, int attack_power, int defense_power, int agility, int level){
    super(name, hp, max_hp, attack_power, defense_power, agility, level);
  }
}
