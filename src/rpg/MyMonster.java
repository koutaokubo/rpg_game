package rpg;

public class MyMonster extends Monster{
  @Override
  public void attack(Monster enemyMonster, Monster myMonster) {
    int enemyHp = enemyMonster.getHp();
    int damage = (myMonster.attack_power / 2) - (enemyMonster.defense_power / 4);
    enemyHp -= damage;
    enemyMonster.setHp(enemyHp);
    System.out.println(enemyMonster.name + "へ" + attack_power + "のダメージ。残り体力は" + enemyHp);
  }

  public MyMonster(String name, int hp, int max_hp, int attack_power, int defense_power, int agility){
    super(name,hp,max_hp,attack_power,defense_power,agility);
  }
}
