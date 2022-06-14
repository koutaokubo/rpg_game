package monster;

import java.util.Random;

public class Crobat extends Monster{

	public Crobat(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 10;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "クロバット";
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
            double rand = new Random().nextDouble();
            int critical = (rand > 0.5) ? 3 : 1;
            int damage = critical * calcDamage(this, enemyMonster);
			enemyHp -= damage;
            enemyMonster.setHp(enemyHp);
            if(enemyHp < 0){
              enemyHp = 0;
            }

            System.out.println(this.getName() + " の クロスポイズン！");
            // 50%の確率で３倍のダメージが出る
            if(rand > 0.5) {
            	System.out.println("大ダメージ！");
            }
            System.out.println(enemyMonster.name + "へ" + damage + "のダメージ！残り体力は" + enemyHp);
    	}else {
    		System.out.println("クロスポイズンのPPが足りない！");
    		attack(enemyMonster);
    	}
    }

}
