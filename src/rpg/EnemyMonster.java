package rpg;

import java.util.Random;

public class EnemyMonster extends Monster{
	public EnemyMonster(String name, int hp, int maxHp, int attackPower, int defencePower) {
		super(name, hp, maxHp, attackPower, defencePower);
	}

	@Override
	public void attack(Monster m) {
		// 具体的なダメージ計算式は議論の余地あり
		Random rand = new Random();
		double randNum = 0.15 * rand.nextDouble() + 0.85; // 0.85～1の乱数を生成
		int damage = (int)(randNum * 10 * this.attackPower / m.getDefencePower());

		m.setHp(m.getHp() - damage);
		System.out.println(m.getName() + " に " + damage + " ダメージ！");
	}

}
