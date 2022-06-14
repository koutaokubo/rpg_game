package monster;

public class Electrode extends Monster{

	public Electrode(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 2;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "マルマイン";
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
            int damage = 6 * calcDamage(this, enemyMonster);
            enemyHp -= damage;
            enemyMonster.setHp(enemyHp);
            if(enemyHp < 0){
              enemyHp = 0;
            }

            // 大ダメージの代わりに自分も戦闘不能になる
            setHp(0);

            System.out.println(this.getName() + " の だいばくはつ！");
            System.out.println(this.getName() + " は 身を削って大ダメージを与えた！");
            System.out.println(this.getName() + " は倒れてしまった・・・");
            System.out.println(enemyMonster.name + "へ" + damage + "のダメージ！残り体力は" + enemyHp);
    	}else {
    		System.out.println("だいばくはつのPPが足りない！");
    		attack(enemyMonster);
    	}
    }

}
