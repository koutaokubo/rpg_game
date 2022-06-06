package rpg;

<<<<<<< HEAD
import java.util.Random;

public class MyMonster extends Monster{
	public MyMonster(String name, int hp, int maxHp, int attackPower, int defensePower) {
		super(name, hp, maxHp, attackPower, defensePower);
	}

	@Override
	public void attack(Monster m) {
		// 具体的なダメージ計算式は議論の余地あり
		Random rand = new Random();
		double randNum = 0.15 * rand.nextDouble() + 0.85; // 0.85～1の乱数を生成
		int damage = (int)(randNum * 10 * this.getAttackPower() / m.getDefensePower());

		m.setHp(m.getHp() - damage);
		System.out.println(m.getName() + " に " + damage + " ダメージ！");
	}

=======
public class MyMonster extends Monster{
  @Override
  public void attack(Monster enemyMonster, Monster myMonster) {
    int enemyHp = enemyMonster.getHp();
    int damage = (myMonster.attack_power / 2) - (enemyMonster.defense_power / 4);
    enemyHp -= damage;
    enemyMonster.setHp(enemyHp);
    System.out.println(enemyMonster.name + "へ" + damage + "のダメージ。残り体力は" + enemyHp);
  }

  public MyMonster(String name, int hp, int max_hp, int attack_power, int defense_power, int agility){
    super(name,hp,max_hp,attack_power,defense_power,agility);
  }
>>>>>>> origin/develop
}
