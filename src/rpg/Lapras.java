package rpg;

public class Lapras extends Monster2{

	public Lapras(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 2;
	}


    @Override
	public String getSpeciesName() {
		return "ラプラス";
	}

    @Override
    public void attack(Monster2 enemyMonster, Monster2 myMonster) {
        int enemyHp = enemyMonster.getHp();
        int damage = ((myMonster.attack_power + myMonster.attack_rise) / 2)
        		- ((enemyMonster.defense_power + enemyMonster.defense_rise) / 4);
        damage = Math.max(damage, 1);
        enemyHp -= damage;
        enemyMonster.setHp(enemyHp);
        if(enemyHp < 0){
          enemyHp = 0;
        }
        System.out.println(enemyMonster.name + "へ" + damage + "のダメージ。残り体力は" + enemyHp);
    }

    public void specialAttack(Monster2 enemyMonster, Monster2 myMonster) {
    	if(pp <= max_pp) {
    		myMonster.setHp(myMonster.getMaxHp());
			System.out.println(myMonster.getName() + "の ねむる！");
			System.out.println(myMonster.getName() + " のHPが回復した！");
    	}else {
    		System.out.println("ねむるのPPが足りない！");
    	}
    }

}
