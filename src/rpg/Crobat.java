package rpg;

import java.util.Random;

public class Crobat extends Monster2{

	public Crobat(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 5;
	}


    @Override
	public String getSpeciesName() {
		return "クロバット";
	}

    @Override
    public void attack(Monster2 enemyMonster, Monster2 myMonster) {
        int enemyHp = enemyMonster.getHp();
        int damage = ((myMonster.attack_power + myMonster.attack_rise) / 2)
        		- ((enemyMonster.defense_power + enemyMonster.defense_rise) / 4);
        enemyHp -= damage;
        enemyMonster.setHp(enemyHp);
        if(enemyHp < 0){
          enemyHp = 0;
        }
        System.out.println(enemyMonster.name + "へ" + damage + "のダメージ。残り体力は" + enemyHp);
    }

    public void specialAttack(Monster2 enemyMonster, Monster2 myMonster) {
    	if(pp <= max_pp) {
    		pp++;
            int enemyHp = enemyMonster.getHp();
            double rand = new Random().nextDouble();
            int critical = (rand > 0.5) ? 2 : 1;
            int damage = critical * ((myMonster.attack_power + myMonster.attack_rise) / 2
            		- ((enemyMonster.defense_power + enemyMonster.defense_rise) / 4));
            enemyHp -= damage;
            enemyMonster.setHp(enemyHp);
            if(enemyHp < 0){
              enemyHp = 0;
            }

            System.out.println(myMonster.getName() + " の クロスポイズン！");
            // ２分の１で大ダメージが出る
            if(critical == 2) {
            	System.out.println("大ダメージ！");
            }
            System.out.println(enemyMonster.name + "へ" + damage + "のダメージ！残り体力は" + enemyHp);
    	}else {
    		System.out.println("クロスポイズンのPPが足りない！");
    	}
    }

}
