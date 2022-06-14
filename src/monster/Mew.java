package monster;

public class Mew extends Monster{

	public Mew(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 5;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "ミュウ";
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
            int damage = (int)(1.2 * calcDamage(this, enemyMonster));
            enemyHp -= damage;
            enemyMonster.setHp(enemyHp);
            if(enemyHp < 0){
              enemyHp = 0;
            }

            // 相手の特殊技のPPを減らす
            if(enemyMonster.getPp() > 0) {
            	enemyMonster.setPp(enemyMonster.getPp() - 1);
            }

            System.out.println(this.getName() + " の サイコキネシス！");
            System.out.println(enemyMonster.getName() + " の特殊技のPPが1減らされた！");
            System.out.println(enemyMonster.name + "へ" + damage + "のダメージ！残り体力は" + enemyHp);
    	}else {
    		System.out.println("サイコキネシスのPPが足りない！");
    		attack(enemyMonster);
    	}
    }

}
