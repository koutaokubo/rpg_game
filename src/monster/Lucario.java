package monster;

public class Lucario extends Monster{

	public Lucario(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 3;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "ルカリオ";
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
            int damage = 2 * calcDamage(this, enemyMonster);
            enemyHp -= damage;
            enemyMonster.setHp(enemyHp);
            if(enemyHp < 0){
              enemyHp = 0;
            }

            // 大ダメージの代わりに自分の防御が下がる
            this.setDefenseRise(this.getDefenseRise() * 0.67);

            System.out.println(this.getName() + " の インファイト！");
            System.out.println(this.getName() + " の防御力が下がった！");
            System.out.println(enemyMonster.name + "へ" + damage + "のダメージ！残り体力は" + enemyHp);
    	}else {
    		System.out.println("インファイトのPPが足りない！");
    		attack(enemyMonster);
    	}
    }

}
