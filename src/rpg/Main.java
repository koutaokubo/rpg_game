package rpg;

public class Main {

	public static void main(String[] args) {
		System.out.println("==========冒険スタート！==========");

		// 味方と敵のモンスターオブジェクトを生成
		MyMonster myMonster = new MyMonster("勇者", 100, 100, 30, 25);
		EnemyMonster enemyMonster = new EnemyMonster("スライム", 70, 70, 5, 80);

		// 味方のステータスを表示
		System.out.println(myMonster);

		// 戦闘開始
		System.out.print(enemyMonster.getName() + " があらわれた！");
		System.out.println("HP: " + enemyMonster.getHp());

		// 戦闘処理
		// どちらかが戦闘不能になったらループを抜ける
		while(true) {
			// 味方の攻撃
			System.out.println("===" + myMonster.getName() + " の攻撃！===");
			myMonster.attack(enemyMonster);
			System.out.println("残りHP： " + enemyMonster.getHp());

			// 戦闘終了（味方の勝利）
			if(!myMonster.getBattle()  || !enemyMonster.getBattle()) {
				System.out.println(enemyMonster.getName() + " を倒した！");
				break;
			}


			// 敵の攻撃
			System.out.println("===" + enemyMonster.getName() + " の攻撃！===");
			enemyMonster.attack(myMonster);
			System.out.println("残りHP： " + myMonster.getHp());

			// 戦闘終了（敵の勝利）
			if(!myMonster.getBattle()  || !enemyMonster.getBattle()) {
				System.out.println(myMonster.getName() + " は倒されてしまった・・・");
				break;
			}
		}
	}

}
