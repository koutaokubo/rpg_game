package monster;

import java.util.Random;

public class Greninja extends Monster{

	public Greninja(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 5;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "ゲッコウガ";
	}

    @Override
    public void specialAttack(Monster enemyMonster) {
    	if(getAsleep() > 1) {
    		setAsleep(getAsleep() - 1);
  		    System.out.println(getName() + "は眠っている・・・。");
    	}else if(pp > 0) {
    		if(getAsleep() == 1) {
        		setAsleep(getAsleep() - 1);
        		System.out.println(getName() + "が眠りから覚めた！");
    		}
    		pp--;

    		// ２～５回連続攻撃
    		int attackNum = new Random().nextInt(4) + 2;

			System.out.println(getName() + "の みずしゅりけん！");

			for(int i = 0; i < attackNum; i++) {
				int enemyHp = enemyMonster.getHp();
				int damage = (int)(0.5 * calcDamage(this, enemyMonster));
				enemyHp -= damage;
				enemyMonster.setHp(enemyHp);
				if (enemyHp < 0) {
					enemyHp = 0;
				}
				System.out.println(enemyMonster.name + "へ" + damage + "のダメージ！残り体力は" + enemyHp);

				if(enemyHp == 0) {
					break;
				}
			}
    	}else {
    		System.out.println("みずしゅりけんのPPが足りない！");
    		attack(enemyMonster);
    	}
    }

}
