package monster;

public class Lapras extends Monster{

	public Lapras(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 2;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "ラプラス";
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
    		this.setHp(this.getMaxHp());
			System.out.println(this.getName() + "の ねむる！");
			System.out.println(this.getName() + " のHPが回復した！");
    	}else {
    		System.out.println("ねむるのPPが足りない！");
    		attack(enemyMonster);
    	}
    }

}
