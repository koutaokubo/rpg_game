package rpg;

<<<<<<< HEAD
import java.util.Random;

public class EnemyMonster extends Monster{
	public EnemyMonster(String name, int hp, int maxHp, int attackPower, int defensePower) {
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

  public EnemyMonster(String name, int hp, int max_hp, int attack_power, int defense_power, int agility){
    super(name, hp, max_hp, attack_power, defense_power, agility);
  }
>>>>>>> origin/develop
}
