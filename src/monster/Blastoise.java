package monster;

public class Blastoise extends Monster{
	protected boolean recharge = false;

	public Blastoise(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 5;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "カメックス";
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
    		if(!isRecharge()) {
    			pp--;
    			int enemyHp = enemyMonster.getHp();
    			int damage = (int)(3.2 * calcDamage(this, enemyMonster));
    			enemyHp -= damage;
    			enemyMonster.setHp(enemyHp);
    			if(enemyHp < 0){
    				enemyHp = 0;
    			}

    			// 次の番は攻撃ができない
    			setRecharge(true);

    			System.out.println(this.getName() + " の ハイドロカノン！");
    			System.out.println(enemyMonster.name + "へ" + damage + "のダメージ！残り体力は" + enemyHp);
    		}else {
    			System.out.println(getName() + "は反動で動けない！");
    			setRecharge(false);
    		}
    	}else {
    			System.out.println("ハイドロカノンのPPが足りない！");
    			super.attack(enemyMonster);
    	}
    }

    @Override
    public void attack(Monster enemyMonster) {
    	if(!isRecharge()) {
    		super.attack(enemyMonster);
    	}else {
			setRecharge(false);
    		if(getAsleep() > 1) {
    			setAsleep(getAsleep() - 1);
    			System.out.println(getName() + "は眠っている・・・。");
    		}else{
    			if(getAsleep() == 1) {
    				setAsleep(getAsleep() - 1);
    				System.out.println(getName() + "が眠りから覚めた！");
    			}
				System.out.println(getName() + "は反動で動けない！");
    		}
    	}
    }


	public boolean isRecharge() {
		return recharge;
	}

	public void setRecharge(boolean recharge) {
		this.recharge = recharge;
	}

}
