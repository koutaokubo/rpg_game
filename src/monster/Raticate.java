package monster;

public class Raticate extends Monster{

	public Raticate(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 5;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "ラッタ";
	}

    @Override
    public void specialAttack(Monster enemyMonster) {
    	if(pp > 1) {
    		if(getAsleep() == 1) {
        		setAsleep(getAsleep() - 1);
        		System.out.println(getName() + "が眠りから覚めた！");
    		}
    		pp--;
			int enemyHp = enemyMonster.getHp();
			enemyHp = (int)(Math.ceil(enemyHp / 2));
			enemyMonster.setHp(enemyHp);

			System.out.println(getName() + "の いかりのまえば！");
			System.out.println(enemyMonster.getName() + "のHPを半分にした！残り体力は" + enemyHp);
    	}else {
    		System.out.println("いかりのまえばのPPが足りない！");
    		attack(enemyMonster);
    	}
    }
}
