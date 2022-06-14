package monster;

import java.util.Random;

public class Parasect extends Monster{

	public Parasect(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 3;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "パラセクト";
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

    		System.out.println(getName() + "の キノコのほうし！");

    		// 眠りターンは３～５（実質２～４）ターン
    		if(enemyMonster.getAsleep() > 0) {
    			System.out.println(enemyMonster.getName() + "はすでに眠っていた！");
    		}else {
    			int sleepingTurn = new Random().nextInt(3) + 3;
    			enemyMonster.setAsleep(sleepingTurn);
    			System.out.println(enemyMonster.getName() + "は眠ってしまった！");
    		}
    	}else {
    		System.out.println("キノコのほうしのPPが足りない！");
    		attack(enemyMonster);
    	}
    }

}
