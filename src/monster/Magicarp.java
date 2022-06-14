package monster;

import java.util.Random;

public class Magicarp extends Monster{

	public Magicarp(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 20;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "コイキング";
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
			System.out.println(getName() + "の はねる！");

    		// 低確率で奇跡が起きる
    		double rand = new Random().nextDouble();
    		if(rand < 0.01) {
    			enemyMonster.setHp(0);
    			setHp(getMaxHp());
    			setAttackRise(getAttackRise() * 10);
    			setDefenseRise(getDefenseRise() * 10);
    			setAgilityRise(getAgilityRise() * 10);

    			System.out.println("これは・・・・・・・・・？");
    			System.out.println(getName() + "が奇跡を起こした！！！");
    			System.out.println(enemyMonster.getName() + "を一撃で倒した！");
    			System.out.println(getName() + "の攻撃力が１０倍になった！");
    			System.out.println(getName() + "の防御力が１０倍になった！");
    			System.out.println(getName() + "の素早さが１０倍になった！");
    			System.out.println(getName() + "のHPが全回復した！");
    			System.out.println("うわーーーーー！！！！！！！！");
    		}else {
    			System.out.println("しかしなにもおこらない");
    		}

    	}else {
    		System.out.println("はねるのPPが足りない！");
    		attack(enemyMonster);
    	}
    }

}
