package rpg;

public class Mew extends Monster2{

	public Mew(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 3;
	}


    @Override
	public String getSpeciesName() {
		return "ミュウ";
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
            int damage = (int)(1.2 * ((myMonster.attack_power + myMonster.attack_rise) / 2
            		- ((enemyMonster.defense_power + enemyMonster.defense_rise) / 4)));
            enemyHp -= damage;
            enemyMonster.setHp(enemyHp);
            if(enemyHp < 0){
              enemyHp = 0;
            }

            // 相手の特殊技のPPを減らす
            if(enemyMonster.getPP() > 0) {
            	enemyMonster.setPP(enemyMonster.getPP() - 1);
            }

            System.out.println("ミュウの サイコキネシス！");
            System.out.println(enemyMonster.name + "へ" + damage + "のダメージ！残り体力は" + enemyHp);
    	}else {
    		System.out.println("サイコキネシスのPPが足りない！");
    	}
    }

}
