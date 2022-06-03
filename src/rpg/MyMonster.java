package rpg;

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

}
