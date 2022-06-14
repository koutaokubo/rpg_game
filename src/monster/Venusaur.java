package monster;

public class Venusaur extends Monster{

	public Venusaur(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 5;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "フシギバナ";
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
			int enemyHp = enemyMonster.getHp();
			int damage = (int)(1.1 * calcDamage(this, enemyMonster));
			enemyHp -= damage;
			enemyMonster.setHp(enemyHp);
			if (enemyHp < 0) {
				enemyHp = 0;
			}
			// 与えたダメージの半分だけ自分のHPを回復
			setHp(getHp() + damage / 2);

			System.out.println(getName() + "の メガドレイン！");
			System.out.println(enemyMonster.getName() + "からHPを吸収した！残り体力は" + getHp());
			System.out.println(enemyMonster.name + "へ" + damage + "のダメージ！残り体力は" + enemyHp);
    	}else {
    		System.out.println("メガドレインのPPが足りない！");
    		attack(enemyMonster);
    	}
    }

}
