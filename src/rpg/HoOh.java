package rpg;

public class HoOh extends Monster2{

	public HoOh(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 3;
	}


    @Override
	public String getSpeciesName() {
		return "ホウオウ";
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
			int enemyHp = enemyMonster.getHp();
			int damage = (int) (1.2 * ((myMonster.attack_power + myMonster.attack_rise) / 2
					- ((enemyMonster.defense_power + enemyMonster.defense_rise) / 4)));
			enemyHp -= damage;
			enemyMonster.setHp(enemyHp);
			if (enemyHp < 0) {
				enemyHp = 0;
			}
			// 相手の攻撃力を下げる
			enemyMonster.setAttackRise(enemyMonster.getAttackRise() - 5);

			System.out.println("ホウオウの せいなるほのお！");
			System.out.println(enemyMonster.name + "へ" + damage + "のダメージ！残り体力は" + enemyHp);
    	}else {
    		System.out.println("せいなるほのおのPPが足りない！");
    	}
    }

}
