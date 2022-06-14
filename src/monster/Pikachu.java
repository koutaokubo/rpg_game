package monster;

public class Pikachu extends Monster{

	public Pikachu(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 5;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "ピカチュウ";
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
            int damage = (int)(1.5 * calcDamage(this, enemyMonster));
            enemyHp -= damage;
            enemyMonster.setHp(enemyHp);
            if(enemyHp < 0){
              enemyHp = 0;
            }
            System.out.println(this.getName() + " の 10まんボルト！");
            System.out.println(enemyMonster.name + "へ" + damage + "のダメージ！残り体力は" + enemyHp);
    	}else {
    		System.out.println("10まんボルトのPPが足りない！");
    		attack(enemyMonster);
    	}
    }

}
