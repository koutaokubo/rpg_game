package monster;

public class Onix extends Monster{

	public Onix(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 5;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "イワーク";
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
			int damage = calcDamage(this, enemyMonster);
			enemyHp -= damage;
			enemyMonster.setHp(enemyHp);
			if (enemyHp < 0) {
				enemyHp = 0;
			}
			// 相手の素早さを下げる
			enemyMonster.setAgilityRise(enemyMonster.getAgilityRise() * 0.67);

			System.out.println(getName() + "の がんせきふうじ！");
			System.out.println(enemyMonster.getName() + "の素早さが下がった！");
			System.out.println(enemyMonster.name + "へ" + damage + "のダメージ！残り体力は" + enemyHp);
    	}else {
    		System.out.println("がんせきふうじのPPが足りない！");
    		attack(enemyMonster);
    	}
    }

}
